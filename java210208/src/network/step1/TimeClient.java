package network.step1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JLabel;

public class TimeClient extends Thread{
	String timeStr = null;
	JLabel jlb_time = null;
	public TimeClient() {}
	public TimeClient(JLabel jlb_time) {
		this.jlb_time = jlb_time;
	}
	@Override
	public void run() {//콜백메소드-사용자가 아니라 시스템 레벨에서 자동 호출되는 메소드임.
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader br = null;
		boolean isFlag = false;
		try {
			socket = new Socket("localhost",3000);
			out = new PrintWriter(socket.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//InputStream is = new InputStreamReader(socket.getInputStream());
			while(!isFlag) {
				while((timeStr=br.readLine())!=null) {
					System.out.println(timeStr);
					jlb_time.setText(timeStr);
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("넌 누구...");
					}
				}
			}
		} catch (Exception e) {
			
		}
	}
	/*
	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();//run메소드 호출 해줌.
	}
	*/
}
