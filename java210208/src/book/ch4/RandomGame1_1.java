package book.ch4;
import java.util.Random;
import java.util.Scanner;

public class RandomGame1_1 {
   public static void main(String[] args) {
      //난수 발생을 지원하는 클래스 추가하기 -  인스턴스화 하기
      Random r = new Random();
      //그 클래스가 제공하는 메소드를 호출하여 채번하기
      int dap = r.nextInt(10);//0.0~10.0
      //사용자로 부터 입력한 값 받아오기
      Scanner sc = new Scanner(System.in);
      //사용자가 입력한 값 담기 - 선언하기, 초기화
      //질문 : 콘솔에서 입력 받은 값은 숫자야? 아님 문자야?
      
      //0부터 9중에서 골라봐~~~~?
      System.out.println("0부터 9중에서 골라봐라~~~~~?");
      int count = 0;
      String user = null;
      //기회를 3번까지는 준다. - 1번 , 2번, 3번, 반복법
      for(;(user=sc.nextLine())!=null;)
      {
         //insert here - 실행문
         //판별식
         ////////////// 아직 기회는 있어! ////////////
         if(count<3) {
            //1번 , 2번, 3번
            if(Integer.parseInt(user)==dap) {
               System.out.println("축하합니다. 정답입니다.");
               break;//for문 탈출한다.
            }
            else if(Integer.parseInt(user) > dap) {
               count++;
               System.out.println("낮춰라");
               
            }
            else if(Integer.parseInt(user) < dap) {
               count++;
               System.out.println("높여라.");
            }
         }
         ////////////// 넌 바보인가? ///////////////
         else {
            //넌 바보 -break;//for문을 탈출하기 if문을 탈출하려면 return
            System.out.println("넌 XX야");
            break;
         }
         //정답입니다.
         
      }////////////////////end of for

   }////////////////////////end of main 
}////////////////////////////end of RandomGame1_1