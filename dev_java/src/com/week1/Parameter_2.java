package com.week1;

public class Parameter_2 {
	static Dog methodA(Dog myDog) {
		Dog yourDog = new Dog();
		System.out.println("methodA의 myDog.leg ==> "+myDog.leg);
		myDog.leg = 2;
		return yourDog;
	}
	public static void main(String[] args) {
		Dog myDog = new Dog();
		myDog.leg = 4;
		Dog yourDog = methodA(myDog);
		System.out.println("main myDog.leg ==> "+myDog.leg);
		System.out.println("main yourDog.leg ==> "+yourDog.leg);
	}

}
