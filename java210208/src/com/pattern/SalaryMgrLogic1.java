package com.pattern;

import java.util.Vector;

import com.vo.DeptVO;
import com.vo.EmpVO;

public class SalaryMgrLogic1 {
	SalaryMgrView1 smv = null;
	public SalaryMgrLogic1(SalaryMgrView1 smv) {
		this.smv = smv;
	}
	   
	   public void getEmpDetail(int pempno) {
			EmpVO eVO = new EmpVO();
			eVO.setEname("이순신");
			DeptVO dVO = new DeptVO();
			dVO.setDname("개발1팀");
			eVO.setdVO(dVO);//issue
			//java.util에서 제공되는 클래스로 타입에 대한 제약없이 늘었다 줄었다함.
			//연관있는 레코드를 한번에 밀어넣기 위해서 사용함.
			
			Vector oneRow = new Vector();
			oneRow.addElement(eVO.getEname());
			oneRow.addElement(eVO.getdVO().getDname());//확인
			smv.dtm_sal.addRow(oneRow);
			
			/*
			Vector oneRow = new Vector();
			oneRow.addElement("");
			oneRow.addElement("");
			dtm_sal.addRow(oneRow);
			*/
			/*
			for(int r=0;r<1;r++) {
				//for(int c=0;c<2;c++) {
					smv.dtm_sal.setValueAt(eVO.getEname(), r, 0);
					smv.dtm_sal.setValueAt(eVO.getdVO().getDname(), r, 1);
				//}
			}
			*/
	   }

}
