package linuxDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Demo {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Process pro = Runtime.getRuntime().exec("cmd /k start ipconfig");
		pro.waitFor();
		InputStream in = pro.getInputStream();
		BufferedReader read = new BufferedReader(new InputStreamReader(in));  
        String result = read.readLine();  
        System.out.println("INFO:"+result);  
        Thread.sleep(5000);
	}

}
