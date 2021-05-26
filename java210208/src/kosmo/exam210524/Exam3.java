package kosmo.exam210524;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Exam3 extends JFrame implements MouseListener, ItemListener, FocusListener, ActionListener {
	String zdo = null;
	String sigu = null;
	String dong = null;
	JPanel jp_north = new JPanel();
	String sigus[] = null;
	String dongs[] = null;
	String zdos3[] = null;
	String totals[] = { "전체" };
	Vector<String> vzdos = new Vector<>();
	JComboBox jcb_zdo = null;
	JComboBox jcb_sigu = null;
	JComboBox jcb_dong = null;
	JTextField jtf_search = new JTextField("", 20);
	JButton jbtn_search = new JButton("조회");
	String cols[] = { "ChkBox", "주소", "우편번호" };
	String data[][] = new String[0][3];
	DefaultTableModel dtm_zipcode = new DefaultTableModel(data, cols);
	JTable jtb_zipcode = new JTable(dtm_zipcode);
	JTableHeader jth = jtb_zipcode.getTableHeader();
	JScrollPane jsp_zipcode = new JScrollPane(jtb_zipcode, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	MemberShip memberShip = null;
	DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Exam3() {
		zdos3 = getZDOList();
		jcb_zdo = new JComboBox(zdos3);
		jcb_sigu = new JComboBox(totals);
		jcb_dong = new JComboBox(totals);
	}

	public String[] getSiguList(String pzdo) {
		System.out.println("getSiguList 호출 성공");
		String sigus[] = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT '전체' sigu FROM dual      ");
		sb.append("UNION ALL                        ");
		sb.append("SELECT sigu                       ");
		sb.append("  FROM (                         ");
		sb.append("        SELECT distinct(sigu) sigu ");
		sb.append("          FROM zipcode_t         ");
		sb.append("         WHERE zdo=?         ");
		sb.append("        ORDER BY sigu asc         ");
		sb.append("       )                         ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, pzdo);
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while (rs.next()) {
				String sigu = rs.getString("sigu");
				v.add(sigu);
			}
			sigus = new String[v.size()];
			v.copyInto(sigus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sigus;
	}

	public String[] getDongList(String psigu) {
		System.out.println("getDongList 호출 성공");
		String dongs[] = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT '전체' dong FROM dual      ");
		sb.append("UNION ALL                        ");
		sb.append("SELECT dong                       ");
		sb.append("  FROM (                         ");
		sb.append("        SELECT distinct(dong) dong ");
		sb.append("          FROM zipcode_t         ");
		sb.append("         WHERE sigu=?         ");
		sb.append("        ORDER BY dong asc         ");
		sb.append("       )                         ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, psigu);
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			while (rs.next()) {
				String dong = rs.getString("dong");
				v.add(dong);
			}
			dongs = new String[v.size()];
			v.copyInto(dongs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dongs;
	}

	public Exam3(MemberShip memberShip) {
		this();
		this.memberShip = memberShip;
	}

	public void initDisplay() {
		jtb_zipcode.getColumn("ChkBox").setCellRenderer(dcr);
		JCheckBox box = new JCheckBox();
		box.setHorizontalAlignment(JLabel.CENTER);
		jtb_zipcode.getColumn("ChkBox").setCellEditor(new DefaultCellEditor(box));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		jth.setBackground(Color.orange);
		jth.setFont(new Font("맑은고딕", Font.BOLD, 20));
		jtb_zipcode.setGridColor(Color.red);
		jtb_zipcode.getColumnModel().getColumn(0).setPreferredWidth(100);
		jtb_zipcode.getColumnModel().getColumn(1).setPreferredWidth(300);
		jtb_zipcode.requestFocus();
		jtb_zipcode.addMouseListener(this);
		jbtn_search.addActionListener(this);
		jtf_search.addFocusListener(this);
		jtf_search.addActionListener(this);
		jp_north.setLayout(new FlowLayout());
		for (String s : vzdos) {
			System.out.println("s===>" + s);
		}
		jcb_sigu.addItemListener(this);
		jcb_dong.addItemListener(this);
		jcb_zdo.addItemListener(this);
		jp_north.add(jcb_zdo);
		jp_north.add(jcb_sigu);
		jp_north.add(jcb_dong);
		jp_north.add(jtf_search);
		jp_north.add(jbtn_search);
		this.add("North", jp_north);
		this.add("Center", jsp_zipcode);
		this.setTitle("우편번호 검색");
		this.setSize(630, 400);
		this.setVisible(true);
	}

	public String[] getZDOList() {
		String zdos[] = null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT '전체' zdo FROM dual      ");
		sb.append("UNION ALL                        ");
		sb.append("SELECT zdo                       ");
		sb.append("  FROM (                         ");
		sb.append("        SELECT distinct(zdo) zdo ");
		sb.append("          FROM zipcode_t         ");
		sb.append("        ORDER BY zdo asc         ");
		sb.append("       )                         ");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			Vector<String> v = new Vector<>();
			List<String> v2 = new Vector<>();
			while (rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zdos;
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		Exam3 zcs = new Exam3();
		zcs.initDisplay();
	}

	@Override
	public void focusGained(FocusEvent e) {
		System.out.println("focusGained 호출 성공");
		if (e.getSource() == jtf_search) {
			jtf_search.setText("");
		}

	}

	@Override
	public void focusLost(FocusEvent e) {

	}

	public void refreshData(String zdo, String dong) {
		System.out.println("zdo:" + zdo + ", dong:" + dong);

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT 'false' ChkBox,  address, zipcode");
		sql.append("  FROM zipcode_t");
		sql.append(" WHERE 1=1");
		if (zdo != null && zdo.length() > 0) {
			sql.append(" AND zdo=?");
		}
		if (dong != null && dong.length() > 0) {
			sql.append(" AND dong LIKE '%'||?||'%'");
		}
		int i = 1;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			if (zdo != null && zdo.length() > 0) {
				pstmt.setString(i++, zdo);
			}
			if (dong != null && dong.length() > 0) {
				pstmt.setString(i++, dong);
			}
			rs = pstmt.executeQuery();
			Vector<ZipCodeVO> v = new Vector<>();
			ZipCodeVO[] zVOS = null;
			ZipCodeVO zVO = null;
			while (rs.next()) {
				zVO = new ZipCodeVO();
				Boolean chkBox = Boolean.parseBoolean(rs.getString("ChkBox"));
				zVO.setChkBox(chkBox);
				zVO.setAddress(rs.getString("address"));
				zVO.setZipcode(rs.getInt("zipcode"));
				v.add(zVO);
			}
			zVOS = new ZipCodeVO[v.size()];
			v.copyInto(zVOS);
			if (v.size() > 0) {
				while (dtm_zipcode.getRowCount() > 0) {
					dtm_zipcode.removeRow(0);
				}
				for (int x = 0; x < v.size(); x++) {
					Vector<Object> oneRow = new Vector<>();
					oneRow.add(0, zVOS[x].getChkBox());
					oneRow.add(1, zVOS[x].getAddress());
					oneRow.add(2, zVOS[x].getZipcode());
					dtm_zipcode.addRow(oneRow);
				}
			}
		} catch (SQLException se) {
			System.out.println("[[ query ]]" + sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_search || obj == jtf_search) {
			String myDong = jtf_search.getText();
			refreshData(zdo, myDong);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		if (obj == jcb_zdo) {
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				System.out.println("선택한 ZDO ===> " + zdos3[jcb_zdo.getSelectedIndex()]);
				zdo = zdos3[jcb_zdo.getSelectedIndex()];
				sigus = getSiguList(zdo);
				jcb_sigu.removeAllItems();
				for (int i = 0; i < sigus.length; i++) {
					jcb_sigu.addItem(sigus[i]);
				}
			}
		}
		if (obj == jcb_sigu) {
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				System.out.println("선택한 SIGU ===> " + sigus[jcb_sigu.getSelectedIndex()]);
				sigu = sigus[jcb_sigu.getSelectedIndex()];
				dongs = getDongList(sigu);
				jcb_dong.removeAllItems();
				for (int i = 0; i < dongs.length; i++) {
					jcb_dong.addItem(dongs[i]);
				}
			}
		}
		if (obj == jcb_dong) {
			if (ie.getStateChange() == ItemEvent.SELECTED) {
				System.out.println("선택한 DONG ===> " + dongs[jcb_dong.getSelectedIndex()]);
				dong = dongs[jcb_dong.getSelectedIndex()];
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			System.out.println("더블 클릭 한거야");
			int index[] = jtb_zipcode.getSelectedRows();
			for (int i = 0; i < dtm_zipcode.getRowCount(); i++) {
				if (jtb_zipcode.isRowSelected(i)) {
					String address = dtm_zipcode.getValueAt(i, 2).toString();
					memberShip.jtf_zipcode.setText(String.valueOf(dtm_zipcode.getValueAt(i, 1)));
					memberShip.jtf_address.setText(address);
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	DefaultTableCellRenderer dcr = new DefaultTableCellRenderer() {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JCheckBox box = new JCheckBox();
			box.setSelected(((Boolean) value).booleanValue());
			box.setHorizontalAlignment(JLabel.CENTER);
			return box;
		}
	};

}