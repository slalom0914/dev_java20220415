package com.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomGame2 {

	public static void main(String[] args) {
		Random oRd = new Random();
		int i = oRd.nextInt(10)+1;
		int count = 1;
		int inputnum=0;
		BufferedReader br = null;
		while(true)
		{
		  try{
		     br = new BufferedReader(new InputStreamReader(System.in));
		     inputnum = Integer.parseInt(br.readLine());
		  
		  }catch(Exception e){
		  
		  }
		  if(i==inputnum){
		     System.out.println("축하합니다.");
		     break;
		  }else if(count >= 5){
				 System.out.println("넌 바보"); 		 
			}else if(i<inputnum){
			   System.out.println(count+"회 힌트:나차라"); 	
			}else if(i>inputnum){
			   System.out.println(count+"회 힌트:높여라"); 	
			}
			count++;
		}
	}
}

