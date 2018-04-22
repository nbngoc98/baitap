package FileDemo;

import java.io.File;

public class CountFoder {
	public static int count (String path) {
		int c = 0;
		File f = new File(path);
		String[] filename = f.list();
		for (int i=0;i<filename.length;i++) {
			File fi = new File(path+"\\"+filename[i]);
			if (fi.isFile())
			c++;
			else
				c+=count(fi.getAbsolutePath());
		}
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count("./"));

	}

}
