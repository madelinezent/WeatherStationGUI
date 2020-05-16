package driver;
import java.awt.EventQueue;

import consoleView.*;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startup window = new Startup();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
