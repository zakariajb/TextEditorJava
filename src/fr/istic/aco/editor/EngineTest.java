package fr.istic.aco.editor;
import java.util.logging.Logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {
	private static final Logger LOGGER = Logger.getLogger( EngineTest.class.getName() );

	private Engine engine;
	

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    	
    	 engine = new EngineImpl();
    	
    	 //engine.insert("");
    }

    private void todo() {
        fail("Unimplemented test");
    }
    @Test
    @DisplayName("Buffer must be empty after initialisation")
    void getSelection() {
    	   LOGGER.info(  engine.getClipboardContents());
        Selection selection = engine.getSelection();
        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
        assertEquals("",engine.getBufferContents());
     
    }

    @Test
    @DisplayName("Buffer contents test")

    void getBufferContents() throws Exception {

    	 engine.insert("zakaria jabrane");
    	 engine.getSelection().setBeginIndex(2);
    	 engine.getSelection().setEndIndex(5);
         engine.insert("TEST");
         engine.getSelection().setBeginIndex(6);
    	 engine.getSelection().setEndIndex(8);
         engine.insert("");
         engine.getSelection().setBeginIndex(0);
    	 engine.getSelection().setEndIndex(2);
         engine.insert("");
         engine.getSelection().setBeginIndex(5);
       	 engine.getSelection().setEndIndex(12);
    
         engine.insert("completed");
         engine.insert(" v2");
         assertEquals("TEST completed v2",engine.getBufferContents());
    }

    @Test
    void getClipboardContents() throws Exception{
    	 assertEquals("", engine.getClipboardContents());
    }

    @Test
    void cutSelectedText() throws Exception{
    	engine.insert("zakaria jabrane");
    	engine.getSelection().setBeginIndex(0);
   	 	engine.getSelection().setEndIndex(8);
   	 	engine.cutSelectedText();
   	 	assertEquals("zakaria ", engine.getClipboardContents());
   	    assertEquals("jabrane",engine.getBufferContents());
    }

    @Test
    void copySelectedText() throws Exception{
    	engine.insert("zakaria jabrane");
    	engine.getSelection().setBeginIndex(0);
   	 	engine.getSelection().setEndIndex(7);
   	 	engine.copySelectedText();
   	 	assertEquals("zakaria", engine.getClipboardContents());
    }

    @Test
    void pasteClipboard() throws Exception{
    	engine.insert("zakaria jabrane");
    	engine.getSelection().setBeginIndex(0);
   	 	engine.getSelection().setEndIndex(7);
   	 	engine.copySelectedText();
   	    engine.getSelection().setEndIndex(0);
   	    engine.pasteClipboard();
   	 	assertEquals("zakariazakaria jabrane", engine.getBufferContents());
    }
}
