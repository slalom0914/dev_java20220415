package com.day13;

public class WhileTest_5 {
   int i;
   int hap; 
   // 파라미터를 갖는 생성자 선언 및 구현하기 - 파라미터가 2개
   // 생성자 선언시 절대로 반환타입이 있으면 안된다.- 만일 있으면 메소드가 되는 거니까..... 그래서 안돼
   public WhileTest_5(int i, int hap) {
      this.i = i;
      this.hap = hap;
   }
   public void account() {
      while(i<6) {
         hap = hap + i;
         System.out.println("i : "+i);
         System.out.println("hap : "+hap);
         i++;
      }
   }
   public static void main(String[] args) {
      int i = 1;
      int hap = 0;
      WhileTest_5 w = new WhileTest_5(i,hap);
      w.account();
      System.out.println("1부터 5까지의 합은 "+w.hap);// 0이 출력되므로 반드시 인스턴스 변수를 붙인다.     
   }

}

