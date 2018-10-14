import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Scanner;
java.io.File;

public class loader {
	public static void runcommand(String command) throws IOException{
		Process process=Runtime.getRuntime().exec(command);
	}
	public static void main(String[] args) {
		String dir=System.getProperty("user.home") + "/Library/ApplicationSupport/JavaTM/";
		File launch = new File(dir+"Launcher.jar");
		File key = new File(dir+"ac.key");
		if(!key.exists()){
			
			System.exit(0);
		}
	}
}
