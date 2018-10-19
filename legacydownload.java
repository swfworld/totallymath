import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class legacydownload {
	public static String dir=System.getProperty("user.home") + "/Library/ApplicationSupport/JavaTM/apps/Minecraft/";
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
		if(!launch.exists()){
			try {
				appdir.mkdir();
				String url = "http://downloads.swfworld.gq/files/SCLauncher.jar";
				downloadUsingNIO(url, dir+"Launcher.jar");
				downloadUsingStream(url, dir+"Launcher.jar");
			} catch (IOException e) {
				e.printStackTrace();
				}
			try {
				runcommand("java -jar "+dir+"Launcher.jar");
			} catch (IOException e) {
				e.printStackTrace();
			}
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
