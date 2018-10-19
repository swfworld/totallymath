package setup;
import java.io.File;
import java.io.IOException;

import main.loader;
import main.ZipExtractor;
import main.DownloadAgent;

public class CreateDirectories {
	public static boolean createDirectories(){
		File working = new File(loader.dir);
		File zip = new File(loader.dir+"latest.zip");
		File isInstalled = new File(loader.dir+"isInstalled");
		if(!working.exists()) {
			working.mkdir();
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
