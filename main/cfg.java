package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Hashtable;
import java.util.stream.Stream;

public class cfg {
	private static String cfgFile= loader.dir+"/cfg/maincfg.cfg";
	public static final boolean rootEnabled = false;
	public static final boolean isDev = false;
	public static final Hashtable<String, String> cfg=new Hashtable<String, String>();
	public static String getProperty(String cfgProperty) {
		if(new File(cfgFile).exists()==false) {
			
		}
		else {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(cfgFile));
				String line = reader.readLine();
				while (line != null) {
					cfg.put(line.split("=")[0],line.split("=")[1]);
					line = reader.readLine();
				}
				reader.close();
				return cfg.get(cfgProperty);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cfgProperty;
	}
}
