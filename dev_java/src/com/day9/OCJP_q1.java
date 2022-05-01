package com.day9;

class OCJP_pq1{
	public byte getNumber() {
		return 1;
	}///////// end of getNumber
}///////////// end of OCJP_pq1

public class OCJP_q1 extends OCJP_pq1{

	public short getNumber(int x) {
		return 2;
	}///////// end of getNumber
	public static void main(String[] args) {
		OCJP_q1 b = new OCJP_q1();
		System.out.println(b.getNumber());
	}///////// end of main
}///////////// end of OCJP_q1
