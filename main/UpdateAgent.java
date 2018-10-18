package main;
import java.io.IOException;

import main.DownloadAgent;

public class UpdateAgent {

	public static void main(String[] args) {
		String url = "";
		try {
			DownloadAgent.downloadUsingStream(url, "update.zip");
			DownloadAgent.downloadUsingNIO(url, "update.zip");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
