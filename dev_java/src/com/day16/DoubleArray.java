package com.day16;

public class DoubleArray {

	public static void main(String[] args) {
		double[] ds = new double[] {1.5,1.2,1.6,};
		for(double d:ds) {
			System.out.println(d);
		}
		for(int x=0;x<ds.length;x++) {
			System.out.println("ds["+x+"] = "+ds[x]);			
		}
	}

}
