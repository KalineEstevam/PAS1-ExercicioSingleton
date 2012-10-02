import static org.junit.Assert.*;

import org.junit.Test;


public class LogTest {

	private Log log;
	
	public LogTest(){
		log = Log.getInstance();
	}
		
	@Test
	public void testWriteMsg(){
	log.writeMsg("mensagem-1");
		assertEquals("mensagem-1;\n", log.printLog());
	}
	
    @Test 
	public void testWriteMsg2(){
		log.writeMsg("mensagem-2");
		log.writeMsg("mensagem-3");
		assertEquals("mensagem-1;\nmensagem-2;\nmensagem-3;\n", log.printLog());
	}
	
}
