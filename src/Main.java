import java.io.File;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		Log log = Log.getInstance();
		log.writeMsg("mensagem");
		System.out.println(log.printLog());
		

		try {
	String path = new File(".").getCanonicalPath();
		System.out.println(path);
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}

}


