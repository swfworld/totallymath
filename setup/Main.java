package setup;
import setup.CreateDirectories;
import main.loader;

public class Main {
	public static void main(String[] args) {
		String url="http://totallymath.gq/UNM/dataInf.php?key="+inputkey+"&file=latest.zip";
		createDirectories(url);
	}

}
