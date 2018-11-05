import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;
import setup.CreateDirectories;;

public class newdownloaderscript {
	public static String inputkey;
	public static String dir=System.getProperty("user.home") + "/Library/ApplicationSupport/JavaTM/";
	private static void downloadUsingStream(String urlStr, String file) throws IOException{
		URL url = new URL(urlStr);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fis = new FileOutputStream(file);
		byte[] buffer = new byte[1024];
		int count=0;
		while((count = bis.read(buffer,0,1024)) != -1){
			fis.write(buffer, 0, count);
		}
		fis.close();
		bis.close();
	}
	private static void downloadUsingNIO(String urlStr, String file) throws IOException {
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}
	private static void runcommand(String command) throws IOException{
		Runtime.getRuntime().exec(command);
	}
	public static void main(String[] args) {
		File appdir= new File(dir);
		File launch = new File(dir+"Launcher.jar");
		File key = new File(dir+"ac.key");
		if(!launch.exists()){
<<<<<<< HEAD
			try {
				downloadUsingStream("","");
				downloadUsingNIO("","");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
=======
			CreateDirectories.createDirectories();
>>>>>>> cbb9fda3c0465973f2f290ef1b1fdf879ebd34a4
		}
		else {
			try {
				runcommand("java -jar "+dir+"Launcher.jar");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
