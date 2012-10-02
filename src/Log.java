import java.io.*;

public class Log {
	
	private String PATH;	
	private String arquivo;

	private static Log log;
	public static Log getInstance() {
	   if (log == null)
	      log = new Log();
	   return log;
	}
	private Log() {
	   try {
		   PATH = (new File(".").getCanonicalPath()).concat("\\sys\\log");
		   this.arquivo = getNextFileName();	    
	   } catch (IOException ex) { ex.printStackTrace(); }
	}

	public void writeMsg(String msg) {
	   
	   File file = new File(PATH+"\\"+arquivo);
	   PrintWriter out;
	   try {
		out = new PrintWriter(new BufferedWriter(new FileWriter(arquivo,true)));
		out.println(msg + ";");
		out.close();	
	   } catch (IOException ex) {
		ex.printStackTrace();
	   }

	}


	public String printLog() {

   	   BufferedReader in;
   	   String logstr = "";
	   try {
		in = new BufferedReader(new FileReader(PATH+"\\"+arquivo));
		while (in.ready()) {
			logstr += (String) in.readLine().concat("\n");
		}
	   } catch (IOException ex) {
		ex.printStackTrace();
	   }
	   return logstr;
	   
	}

	private String getNextFileName() throws IOException{
		   
	    File path = new File(PATH);
	    if (path.isDirectory()) {
		   	File listfiles[] = path.listFiles();
		   	return "log" + (listfiles.length + 1) + ".txt";

	    } else {
	    	throw new IOException("O diretorio nao existe!");
	    }

	}



}
