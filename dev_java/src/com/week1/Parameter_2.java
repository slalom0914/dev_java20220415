package com.week1;

public class Parameter_2 {
	static Dog methodA(Dog myDog) {// myDog.leg = 4
		Dog yourDog = new Dog();// yourDog.leg=0
		System.out.println("methodA의 myDog.leg ==> "+myDog.leg);//4
		myDog.leg = 2;//4 -> 2로 바뀜
		return yourDog;// yourDog.leg = 0
	}
	public static void main(String[] args) {
		Dog myDog = new Dog();// myDog.leg = 2
		myDog.leg = 4;// myDog.leg = 4
		// 5번라인의 주소번지와 14번의 주소번지는 같다
		Dog yourDog = methodA(myDog);// 원본이 넘어간다( 11번라인)
		System.out.println("main myDog.leg ==> "+myDog.leg);//원본의 주소번지가 파라미터로 넘어갔으니까 원본이 2로 바뀐 것임
		//methodA안에서 5번에 생성된 객체는 인스턴스화만 되었을 뿐 아무런 값의 변화가 없다 
		//따라서 전변의 값은 디폴트값 그대로의 상태 입니다.
		System.out.println("main yourDog.leg ==> "+yourDog.leg);
	}

}
