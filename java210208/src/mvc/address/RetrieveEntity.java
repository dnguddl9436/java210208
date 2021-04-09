package mvc.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.util.DBConnectionMgr;

public class RetrieveEntity {
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	ResultSet			rs		= null;
//오버로딩에 리턴타입은 영향이 없다.
	/**************************************************************
	 * 
	 * @param pavo - vo.getId();
	 * @return AddressVO (or Map)
	   SELECT
    			id, name, address, telephone, gender
    		  , relationship, birthday, comments, registedate
    	 FROM mkaddrtb
   		WHERE id=:x
	 **************************************************************/
	public AddressVO select(AddressVO pavo) {//무조건 1개 로우만 가능함
		System.out.println("RetrieveEntity select(pavo) 호출 성공");
		return null;
	}
	public Map<String,Object> selectMap(AddressVO vo) {//무조건 1개 로우만 가능함
		System.out.println("RetrieveEntity select(vo) 호출 성공");
		return null;
	}
	public AddressVO[] select() {//n개 로우 가능함.
		System.out.println("RetrieveEntity select() 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT                                           ");
		sql.append("	id, name, address, telephone, gender         ");
		sql.append("  , relationship, birthday, comments, registedate");
		sql.append("  FROM mkaddrtb                                  ");
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		Vector<AddressVO> v = new Vector<>();
		AddressVO[] aVOS = null;
		try {
			con = dbMgr.getConnection();
//			pstmt = con.prepareStatement(sql.toString());
			pstmt = con.prepareStatement(String.valueOf(sql));
			rs = pstmt.executeQuery();
			AddressVO aVO = null;
			while(rs.next()) {
				aVO = new AddressVO();
				aVO.setId(rs.getInt("id"));
				aVO.setName(rs.getString("name"));
				aVO.setAddress(rs.getString("address"));
				aVO.setTelephone(rs.getString("telephone"));
				aVO.setGender(rs.getString("gender"));
				aVO.setRelationship(rs.getString("relationship"));
				aVO.setBirthday(rs.getString("birthday"));
				aVO.setComments(rs.getString("comments"));
				aVO.setRegistedate(rs.getString("registedate"));
				v.add(aVO);
			}
			aVOS = new AddressVO[v.size()];
			v.copyInto(aVOS);
		} catch (SQLException se) {
			// TODO: handle exception
		} finally {
			dbMgr.freeConnection(con, pstmt, rs);
		}
		return aVOS;
	}
	/**************************************************************
	 * 
	 * @param vo
	 * @return
	 **************************************************************/
	public List<AddressVO> selectList(AddressVO vo) {//n개 로우 가능함.
		System.out.println("RetrieveEntity selectList(vo) 호출 성공");
		return null;
	}

}
