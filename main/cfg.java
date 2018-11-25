package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.stream.Stream;

public class cfg {
	private static String cfgFile= loader.dir+"/cfg/maincfg.cfg";
	public static final boolean rootEnabled = false;
	public static final boolean isDev = false;
	public cfg() {
		if(new File(cfgFile).exists()==false) {
			
		}
		Hashtable<String, String> cfg= new Hashtable<String, String>();
		try (Stream<String> stream = Files.lines(Paths.get(cfgFile))) {
	        stream.forEach(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
