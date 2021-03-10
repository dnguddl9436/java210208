package com.design.zipcode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * A a = new A();
 * A a = null;
 * a = new A();
 * 
 * A a = A.getInstance();
 */
import com.util.DBConnectionMgr;

public class ZipCodeDao {
	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	DBConnectionMgr		dbMgr	= null;
	public ZipCodeDao() {
		dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();
		} catch (Exception e) {
			System.out.println("오라클 서버 연결 실패");
		}
	}
	//클래스 쪼개기에서 초급자가 항상 염두에 둘 사항은 배달사고임.
	public ArrayList<ZipCodeVO> getZipCodeList(String dong) {
		System.out.println("getZipCodeList 호출 성공"+dong);
		ArrayList zipcodeList = null;
		return zipcodeList;
	}
}
