package com.day10;


class Banana {
	public int x;//초기화 생략됨 - 그러면 0이 담겨 있음
	private static int nth;// static - 공유 - 유지
	Banana() {
		nth = nth + 1;//1->2->3
		x = nth;//x = 1, x=2  , x=3
	}
	Banana(int x) {// x= 1
		this.x = x;// x = 1
	}
}
public class BananaSimulation {
	public static void main(String[] args) {
		Banana b1 = new Banana();
		Banana b2 = new Banana();
		Banana b3 = new Banana(1);
		Banana b4 = b3;
		Banana b5 = new Banana();
		System.out.println(b1+","+b2+",\n"+b3+","+b4);
		System.out.println("b1.x => "+b1.x);//1
		System.out.println("b2.x => "+b2.x);//2
		System.out.println("b3.x => "+b3.x);//1
		System.out.println("b4.x => "+b4.x);//1
		System.out.println("b5.x => "+b5.x);//?
	}
}
