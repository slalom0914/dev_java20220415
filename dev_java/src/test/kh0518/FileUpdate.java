package test.kh0518;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileUpdate {
	public void output() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("src/test/kh0518/test.txt",true);
			fw.write(97);// 알파벳 소문자 a
			fw.write(65);// 알파벳 대문자 A
			fw.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println(fw);
		}
	}
	public static void main(String[] args) {
		FileUpdate fu = new FileUpdate();
		fu.output();
	}

}
