package main;
import main.DownloadAgent;

public class UpdateAgent {

	public static void main(String[] args) {
		url = "";
		DownloadAgent.downloadUsingStream(url, "update.zip");
		DownloadAgent.downloadUsingNIO(url, "update.zip");
		
	}

}
