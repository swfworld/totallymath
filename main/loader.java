package main;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class loader {
	public final static String dir=System.getProperty("user.home") + "/Library/ApplicationSupport/JavaTM/";
	final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
	public static void runcommand(String command) throws IOException{
		Runtime.getRuntime().exec(command);
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
