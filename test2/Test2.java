package test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Test2 {

	public static void main(String[] args) {
		
		try {
			FileWriter out = new FileWriter("c:/test/test.txt");
			out.write("안녕하세요~~");
			out.close();
			
		} catch(Exception e) {
			System.out.println("파일이 없는거 같아요");
		}
		
		try {			
			FileReader in = new FileReader("c:/test/test.txt");
			BufferedReader br = new BufferedReader(in);
			
			String str = br.readLine();
			
			System.out.println(str);
			
		} catch(Exception e) {
			System.out.println("파일이 없는거 같아요");
		}
		
		
	}
	
}


