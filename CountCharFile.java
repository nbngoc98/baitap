package FileDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CountCharFile {

	public static int count(String path, char ch) {
		int c=0;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
            int data;
            data= fis.read();
            while(data!=-1) {
            	
                  if(data == ch) c++;
                  data = fis.read();
                  }
		} catch(IOException e) {
			System.out.println("loi IO"+e.getMessage());
		}
		finally {
		       try {
					fis.close();
		       }catch (Exception e2) {
		            System.out.println("loi doc file");
		            }
		       }
		return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count("./src/CountCharFile.java",'i'));

	}
}
