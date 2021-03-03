package book.ch5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;

public class AddressBook2 implements ActionListener{
	//선언부
	JFrame 			jf 			= null;
	JMenuBar 		jbm 		= new JMenuBar();
	JMenu 			jm_file 	= new JMenu("File");
	JMenu 			jm_oracle 	= new JMenu("DB연동");
	JMenuItem 		jmi_dbTest	= new JMenuItem("오라클연결");
	JMenuItem 		jmi_sel 	= new JMenuItem("상세조회");
	JMenuItem 		jmi_selALL 	= new JMenuItem("전체조회");
	JMenuItem 		jmi_ins 	= new JMenuItem("입력");
	JMenuItem 		jmi_upd		= new JMenuItem("수정");
	JMenuItem 		jmi_del 	= new JMenuItem("삭제");
	AddressDialog2 	aDia 		= new AddressDialog2();
	DeptVO 			dVO			= new DeptVO();
	static AddressBook2 aBook 	= null;
	String 			cols[] 		= {"부서번호","부서명","지역"};
	String 			data[][] 	= new String[0][3];
	//데이터셋을 담을 수 있는 클래스 생성하기
	//첫번째 data, 두번째 컬럼
	DefaultTableModel 	dtm_dept = new DefaultTableModel(data,cols);
	JTable 				jtb_dept = new JTable(dtm_dept);
	JScrollPane 		jsp_dept = new JScrollPane(jtb_dept);
	//생성자
	public AddressBook2() {
		//initDisplay();
	}
	//주소 목록 조회 - 새로고침 처리
	public void refresh() {
		System.out.println("refresh 호출 성공");
	}
	//화면처리부
	public void initDisplay() {
		jf = new JFrame();
		//이벤트 소스와 이벤트 핸들러 연결하기
		jmi_ins.addActionListener(this);
		jmi_sel.addActionListener(this);
		jmi_selALL.addActionListener(this);
		jmi_upd.addActionListener(this);
		jmi_del.addActionListener(this);
		jmi_dbTest.addActionListener(this);
		jm_file.add(jmi_selALL);
		jm_file.add(jmi_sel);
		jm_file.add(jmi_ins);
		jm_file.add(jmi_upd);
		jm_file.add(jmi_del);
		jm_oracle.add(jmi_dbTest);
		jbm.add(jm_file);
		jbm.add(jm_oracle);
		jf.setJMenuBar(jbm);
		jf.setTitle("주소록-Ver1.0");
		jf.add("Center",jsp_dept);
		jf.setSize(500, 400);
		jf.setVisible(true);
	}
	public static void main(String[] args) {
		aBook = new AddressBook2();
		aBook.initDisplay();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == jmi_selALL) {
			DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			///////////////////[[ 조회결과를 처리 ]]//////////////////
			String sql = "SELECT deptno, dname, loc FROM dept";
			DeptVO dVOS[] = null;
			try {
				//연결통로확보하기
				System.out.println("con before");
				con = dbMgr.getConnection();
				//오라클 서버에 select문을 전달할 전령 객체 생성
				System.out.println("pstmt before");
				pstmt = con.prepareStatement(sql);
				System.out.println("pstmt after");
				//오라클에 살고 있는 커서 조작 위해서 자바가 제공하는 객체 생성
				System.out.println("rs before");
				rs = pstmt.executeQuery();
				System.out.println("rs after");
				dVO = null;
				Vector<DeptVO> al = new Vector<DeptVO>();
				while(rs.next()) {
					dVO = new DeptVO();
					dVO.setDeptno(rs.getInt("deptno"));
					dVO.setDname(rs.getString("dname"));
					dVO.setLoc(rs.getString("loc"));
					al.add(dVO);
				}
				System.out.println("al.size():"+al.size());
				dVOS = new DeptVO[al.size()];
				//벡터에 담긴 정보를 꺼내서 객체 배열에 초기화 하기
				al.copyInto(dVOS);
				//주의 : 앞에 조회된 결과가 계속 남아있는상태에서 전체 조회를 누를때 마다 조회된 값이 자꾸만 쌓여갑니다.
	            //이것을 삭제하고 나서 새로 붓도록 해보자.
	            while(dtm_dept.getRowCount()>0) {
	               dtm_dept.removeRow(0);
	            }
				for(int i=0;i<dVOS.length;i++) {
					Vector oneRow = new Vector();
					oneRow.add(dVOS[i].getDeptno());
					oneRow.add(dVOS[i].getDname());
					oneRow.add(dVOS[i].getLoc());
					dtm_dept.addRow(oneRow);
				}
			} catch (SQLException se) {
				//부적합한 식별자 입니다.
				System.out.println("SQLException:"+se.getMessage());//좀 더 구체적인 예외처리 클래스 정보를 알 수 있다.
				
			}
			///////////////////[[ 조회결과를 처리 ]]//////////////////
			if(con != null) {
				JOptionPane.showMessageDialog(jf, "오라클 서버 연결 성공");
				return;
			}else {
				JOptionPane.showMessageDialog(jf, "오라클 서버 연결 실패");
				return;
			}
		}
		else if(obj == jmi_dbTest) {
			DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
			Connection con = dbMgr.getConnection();
			if(con != null) {
				JOptionPane.showMessageDialog(jf, "오라클 서버 연결 성공");
				return;
			}else {
				JOptionPane.showMessageDialog(jf, "오라클 서버 연결 실패");
				return;
			}
		}
		else if(obj == jmi_ins) {
			aDia.set("입력", null, aBook);
			aDia.setVisible(true);
		}
		else if(obj == jmi_sel) {
			aDia.set("상세조회", dVO, aBook);
			aDia.setTitle("상세조회");
			aDia.setVisible(true);
		}
		else if(obj == jmi_upd) {
			aDia.set("수정", dVO, aBook);
			aDia.setTitle("수정");
			aDia.setVisible(true);
		}
		else if(obj == jmi_del) {
			//삭제 처리는 화면 목록에서 직접 처리하기로 함.
		}
	}

}
