package setup;
import java.io.File;
import java.io.IOException;

import main.loader;
import main.ZipExtractor;
import main.DownloadAgent;

public class CreateDirectories {
	public static boolean createDirectories(String url){
		File zip = new File(loader.dir+"unpack.zip");
		if(!zip.exists()) {
			try {
				DownloadAgent.downloadUsingStream(url, loader.dir+"unpack.zip");
				DownloadAgent.downloadUsingNIO(url, loader.dir+"unpack.zip");
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
		return true;
	}

}
