package main;
import GUI.init;
import GUI.errorWindow;

public class GUI {
	public static void throwException(String text) {
		init.destroyGUI();
		new errorWindow(text);
	}
	public static void search(String query) {
		System.out.println(query);
	}
}
