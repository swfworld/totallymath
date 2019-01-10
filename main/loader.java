package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import GUI.errorWindow;
import setup.CreateDirectories;

public class loader {
	public final static String dir=System.getProperty("user.home") + "/Library/ApplicationSupport/JavaTM/";
	public final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
	public final static String updateURL="http://totallymath.gq/UNM/dataInf.php?key="+key()+"&file=latest.zip";
	public static void runcommand(String command) throws IOException{
		Runtime.getRuntime().exec(command);
	}
	public static boolean loadConfig(){
		File cfgFile= new File(dir+"/cfg/main.cfg");
		if(cfgFile.exists()!=true) {
			new errorWindow("Config not found!");
			System.exit(1);
		}
		else {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(cfgFile));
				String line = reader.readLine();
				while (line != null) {
					System.setProperty(line.split("=")[0],line.split("=")[1]);
					line = reader.readLine();
				}
				reader.close();
				return true;
			}
			catch(IOException e) {
				return false;
			}
		}
		return false;
	}
	public static String key(){
		File key = new File(dir+"ac.key");
		if(!key.exists()) {
			new errorWindow("KeyFile not found!");
			System.exit(1);
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
		if(System.getProperty("version")!="") {
			
		}
		return false;
	}
	public static boolean downloadAssets() {
		try {
			DownloadAgent.downloadUsingStream(updateURL, "latest.jar");
			DownloadAgent.downloadUsingNIO(updateURL, "latest.jar");
			return true;
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
		File maindir=new File(dir);
		File key = new File(dir+"ac.key");
		if(!maindir.exists()) {
			CreateDirectories.createDirectories();
		}
	}
}
