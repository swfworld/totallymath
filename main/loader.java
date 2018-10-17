package main;
import java.io.File;
import java.io.IOException;

public class loader {
	public static String dir=System.getProperty("user.home") + "/Library/ApplicationSupport/JavaTM/";
	public static void runcommand(String command) throws IOException{
		Runtime.getRuntime().exec(command);
	}
	public void restartApplication(){
		final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
		final File currentJar = new File(MyClassInTheJar.class.getProtectionDomain().getCodeSource().getLocation().toURI());
		/* is it a jar file? */
		if(!currentJar.getName().endsWith(".jar"))
		return;
		/* Build command: java -jar application.jar */
		final ArrayList<String> command = new ArrayList<String>();
		command.add(javaBin);
		command.add("-jar");
		command.add(currentJar.getPath());
		final ProcessBuilder builder = new ProcessBuilder(command);
		builder.start();
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
