package network.step1;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
/*
 * 소켓 - 무전기에 장착된 하드웨어
 * 네트워크에서 정보가 들어가고 나가는 지점에 대한 유일한 식별자
 * 32비트의 숫자로 구성되며 짝수번 소켓은 정보를 받아들이는 용도로
 * 홀수번 소켓은 정보를 보내는 용도로 사용됨.
 * 
 * FIFO속성 가지고 있다. 큐, 스택(백팩:FILO)
 * 동시에 두가지를 할 수는 없다. (읽으면서 쓰기 혹은 쓰면서 읽기)
 * 
 * 네트워크망 구성되어 있어야 함.
 * 
 * TCP포트번호: 물리적인 장치를 꽂는 장소는 아니다. 용도에 따라 쓰는 숫자 값.
 *  서버에서 돌아가는 특정 프로그램을 나타내는 16비트 숫자
 *  웹서버 - 80
 *  텔넷서버 - 23
 *  FTP서버 - 20
 *  SMTP서버 - 25
 *  
 *  같은 포트에서 여러 프로그램이 돌아갈 수 있나요?
 *  BindException이 발생함.
 *  
 *  netstat -ano | findstr 3000
 *  taskkill /pid 42356 /f
 *  
 */
public class TimeServer extends Thread{
	Socket socket = null;
	public TimeServer() {}
	public TimeServer(Socket socket) {
		this.socket = socket;
	}
	/****************************************
	 * 스레드 기동시 호출되는 메소드이다.
	 ****************************************/
	@Override
	public void run() {
		boolean isFlag = false;
		try {
			//socket에 대한 객체 주입은 인스턴스화를 통해서 생성자가 호출되었을 때 객체 주입이 이루어짐.
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			while(!isFlag) {
				if(out!=null) {
					out.println(getTimer());
				}
				//1초동안 기다려.. 그리고 진행.. 1초 기다려.. 진행
				try {
					sleep(1000);//밀리세크 단위 설정함. 지연하기- 스레드, 경합-스레드, 순서-스레드, 순서를정한다-스레드
				} catch (InterruptedException ie) {
					System.out.println("앗~~ 넌 누구...");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("run call...");
	}
	public String getTimer() {
		Calendar cal = Calendar.getInstance();
		String str = "";
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		//삼항연산자
		return (hour < 10 ? "0"+hour : ""+hour) + ":"
			 + (min < 10 ? "0"+min : ""+min) + ":"
			 + (sec < 10 ? "0"+sec : ""+sec);
	}
	//본만큼 구현하는 것이다.
	//main메소드도 스레드이다.(default thread 이다) -entry point -static{}
	public static void main(String[] args) {
		int port = 3000;//포트번호 지정
		boolean isFlag = false;//서버를 탈출 시킬 수 있는 수단 
		ServerSocket server = null;//기다림... 클라이언트가 접속할 때 까지 new Socket("192.168.0.23",3000)
		Socket client = null;
		try {
			server = new ServerSocket(port);
		} catch (Exception e) {
			
		}
		System.out.println("TimeServer Started successfully");
		//while(true) {위험하다. 무한루프 빠질 수 있다.
		while(!isFlag) {
			try {
				//기다려. 손님 올때까지 기다려...
				client = server.accept();
				System.out.println("New Client connected..."+client.toString()+"\n");
				TimeServer ts = new TimeServer(client);
				ts.start();//run()이 호출당한다.
			} catch(Exception e) {
				
			}
		}
	}

}
