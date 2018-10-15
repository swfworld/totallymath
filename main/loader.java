package main;
import java.io.File;
import java.io.IOException;

public class loader {
	public static String dir=System.getProperty("user.home") + "/Library/ApplicationSupport/JavaTM/";
	public static void runcommand(String command) throws IOException{
		Runtime.getRuntime().exec(command);
	}
	public static void main(String[] args) {
		File key = new File(dir+"ac.key");
		if(!key.exists()){
			
			System.exit(0);
		}
		else {
			
		}
	}
}
