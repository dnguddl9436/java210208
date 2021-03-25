package mvc.address;

import java.io.*;
import java.util.*;

public class AddressCtrl {

	private AddressVO returnVO = new AddressVO();

	private static String _DEL = "delete";
	private static String _INS = "insert";
	private static String _MOD = "update";
	private static String _SEL = "select";
	private static String _ALL = "selectall";

	public AddressCtrl() {
	}

	public AddressVO send(AddressVO vo) throws Exception {
		String command = vo.getCommand();
		if(_DEL.equals(command)) {
			DeleteEntity del = new DeleteEntity();
			returnVO = del.delete(vo);
		}else if(_INS.equals(command)) {
			RegisterEntity regi = new RegisterEntity();
			returnVO = regi.insert(vo);
		}else if(_MOD.equals(command)) {
			ModifyEntity modi = new ModifyEntity();
			returnVO = modi.update(vo);
		}else if(_SEL.equals(command)) {
			RetrieveEntity ret = new RetrieveEntity();
			returnVO = ret.select(vo);
		}
		return returnVO;
	}

	public AddressVO[] send() throws Exception {
		AddressVO[] returnVOs = null;
		System.out.println("send() 호출 성공 - 반환타입이 AddressVO[]");
		return returnVOs;
	}
	public List<AddressVO> sendAll() throws Exception {
		List<AddressVO> selectAll = null;
		System.out.println("sendAll() 호출 성공 - 반환타입이 List<AddressVO>");
		return selectAll;
	}	
}