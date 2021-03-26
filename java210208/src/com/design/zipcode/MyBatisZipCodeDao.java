package com.design.zipcode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;

public class MyBatisZipCodeDao {
	SqlSessionFactory	sqlSessionFactory	= null;
	public MyBatisZipCodeDao() {
		sqlSessionFactory = MyBatisCommonFactory.getInstance();
	}
	public List<ZipCodeVO> getZipCodeList(ZipCodeVO pzVO) {
		System.out.println("getZipCodeList 호출 성공"+pzVO);
		List<ZipCodeVO> zipcodeList = new ArrayList<>();
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			zipcodeList = sqlSession.selectList("refreshData",pzVO);
		} catch (Exception e) {
			System.out.println("[[Exception]] : "+e.toString());
		} finally {
			//사용한 자원 명시적으로 반납하기
			sqlSession.close();
		}
		return zipcodeList;
	}
	public static void main(String args[]) {
		MyBatisZipCodeDao zcd = new MyBatisZipCodeDao();
		List<ZipCodeVO> zipcodeList = new ArrayList<>();
		ZipCodeVO pzVO = new ZipCodeVO();
		pzVO.setDong("언양읍");
		zipcodeList=zcd.getZipCodeList(pzVO);
		for(ZipCodeVO rzVO:zipcodeList)
		System.out.println("rzVO:"+rzVO.getAddress()+", "+rzVO.getZipcode());
	}
}
