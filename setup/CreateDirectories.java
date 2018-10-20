package setup;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import main.loader;
import main.ZipExtractor;
import main.DownloadAgent;

public class CreateDirectories {
	public static boolean createDirectories(){
		File working = new File(loader.dir);
		File zip = new File(loader.dir+"latest.zip");
		File isInstalled = new File(loader.dir+"isInstalled");
		File key=new File(loader.dir+"ac.key");
		if(!working.exists()) {
			working.mkdir();
			try {
				Scanner input=new Scanner("System.in");
				System.out.println("Input Activation Key:");
				String inputkey=input.nextLine();
				input.close();
				String url = "http://totallymath.gq/UNM/dataInf.php?key="+inputkey+"&file=Launcher.jar";
				DownloadAgent.downloadUsingNIO(url, loader.dir+"Launcher.jar");
				DownloadAgent.downloadUsingStream(url, loader.dir+"Launcher.jar");
				try {
					key.createNewFile();
					FileOutputStream write= new FileOutputStream(key);
					byte[] byteKey = inputkey.getBytes();
					write.write(byteKey);
					write.close();
					loader.runcommand("java -jar "+loader.dir+"Launcher.jar");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				System.out.println("Activation Failed.");
				System.exit(1);
				}
		}
		if(!isInstalled.exists()){
			if(!zip.exists()) {
				try {
					DownloadAgent.downloadUsingStream(loader.updateURL, loader.dir+"latest.zip");
					DownloadAgent.downloadUsingNIO(loader.updateURL, loader.dir+"latest.zip");
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
			try {
				ZipExtractor.unzip(loader.dir+"unpack.zip", loader.dir);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			try {
				isInstalled.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

}
