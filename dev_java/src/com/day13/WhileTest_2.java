package com.day13;


public class WhileTest_2 {
   int hap = -1;//-1 end of file
   public int account() {
      int i = 1;
      int hap = 0;
      while(i<6) {
         hap = hap + i;
         System.out.println("i : "+i);
         System.out.println("hap : "+hap);
         i++;
      }
      System.out.println("1부터 5까지의 합은 "+hap);  //15
      return hap;
   }
   public static void main(String[] args) {
      WhileTest_2 w = new WhileTest_2();
      int hap = w.account();
      // 인스턴스변수.변수명 으로 호출하면 그것은 전역변수를 호출하는 것이다.
      // 따라서 아래에서는 -1이 출력되는 것이다.
      System.out.println("main 메소드에서 출력하기 : "+w.hap);
      System.out.println("지역변수 hap 출력하기 : "+hap);
   }

}
