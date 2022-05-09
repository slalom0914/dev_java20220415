package com.week3;

import java.io.*;
import java.util.*;
class RandomGame 
{
	public int nanSu()
	{
		Random r = new Random(); // 난수발생부분
		int dap= r.nextInt(10); //객체.메소드		
		return dap;
	}
	public int userInput()
	{
		int input = 0;
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		input = Integer.parseInt(str);
		return input;
	}
	public void play()
	{
		System.out.println("0부터 9중이서 골라봐라~!");
		int count = 0;
		int dap = nanSu();
		for (;count<3;)
		{
			int input = userInput();
			//if(count < 3){
				if (input==dap)
				{
					System.out.println("마따~!");
					break;
				}
				else if (input>dap)
				{
					count++;
					System.out.println("나차라~!"+count);
				}
				else if (input<dap)
				{
					count++;
					System.out.println("노피라~!"+count);
				}
			//}
		}		
		if(count==3){
			System.out.println("넌 바보~~");
		}
	}
	public static void main(String[] args) throws IOException 
	{					
		RandomGame rg = new RandomGame();
		rg.play();
	}
}

