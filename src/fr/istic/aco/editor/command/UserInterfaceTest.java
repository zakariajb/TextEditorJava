package fr.istic.aco.editor.command;
import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

import org.junit.jupiter.api.*;
import fr.istic.aco.editor.*;

public class UserInterfaceTest {

		private static final Logger LOGGER = Logger.getLogger( UserInterfaceTest.class.getName() );

		private Engine engine;
		private UserInterface userInterface;
<<<<<<< HEAD
=======
		History history;
>>>>>>> 3afc1f3313237a8a89ff1005d403319b290b0aa7
		

	    @org.junit.jupiter.api.BeforeEach
	    void setUp() {
	    	
	    	 engine = new EngineImpl();
<<<<<<< HEAD
	   

	    	 userInterface = new UserInterfaceImpl(null);
=======
	    	 history = new HistoryImp(engine);

	    	 userInterface = new UserInterfaceImpl(null, history);
>>>>>>> 3afc1f3313237a8a89ff1005d403319b290b0aa7
	    	 //engine.insert("");
	    }

	    private void todo() {
	        fail("Unimplemented test");
	    }
	    
	    

	
	    @Test
	    @DisplayName("set slection indexes command test")
	    void setSelectionIndexes() throws Exception {
	    	   
	           engine.insert("this is just a test");

	    	   Command selectCommand = new SetSelectionIndexesCommand(engine.getSelection(), 0, 8);	   
	    	   userInterface.setCommand(selectCommand);
	    	   userInterface.option();
	    	   
	    	   assertEquals(0,engine.getSelection().getBeginIndex());
	           assertEquals(8,engine.getSelection().getEndIndex());
	           
	           engine.insert("now the selection end index is bigger than 8 for sure");
	           userInterface.reply();
	           
	           assertEquals(0,engine.getSelection().getBeginIndex());
	           assertEquals(8,engine.getSelection().getEndIndex());



	     
	    }

	    
	    @Test
	    @DisplayName("cut selected text command test")
	    void cutSelectedText() throws Exception {
	    	   assertThrows(NullPointerException.class, () -> {
	    		    userInterface.option();
	    	   });
	    	   
	    	   
	    	   
	    	   Command cutCommand = new CutSelectedTextCommand(engine);
	    	   userInterface.setCommand(cutCommand);
	    	   
	    	   engine.insert("zakaria jabrane");
	    	   engine.getSelection().setBeginIndex(0);
	    	   engine.getSelection().setEndIndex(8);
	    	   userInterface.option();
	    	   
	           assertEquals("jabrane",engine.getBufferContents());
	           assertEquals("zakaria ",engine.getClipboardContents());



	     
	    }
	    
	    
	    @Test
	    @DisplayName("insert command")
	    void insert() throws Exception {
	    	   Command insertCommand = new InsertCommand(engine, "zakaria jabrane");
	    	   userInterface.setCommand(insertCommand);
	    	   userInterface.option();
	           assertEquals("zakaria jabrane",engine.getBufferContents());
         	     
	    }

	    
	    @Test
	    @DisplayName("delete command")
	    void delete() throws Exception {
	    	   Command insertCommand = new InsertCommand(engine, "zakaria jabrane");
	    	   userInterface.setCommand(insertCommand);
	    	   userInterface.option();
	    	   engine.getSelection().setBeginIndex(0);
	    	   engine.getSelection().setEndIndex(8);
	    	   Command delCommand = new DeleteCommand(engine);
	    	   userInterface.setCommand(delCommand);
	    	   userInterface.option();
	           assertEquals("jabrane",engine.getBufferContents());
         	     
	    }


	    
	    @Test
	    @DisplayName("copy selected text command test")
	    void copySelectedTextCommand() throws Exception {
	    	   assertThrows(NullPointerException.class, () -> {
	    		    userInterface.option();
	    	   });
	    	   
	    	   
	    	   
	    	   Command insertCommand = new InsertCommand(engine, "zakaria jabrane");
	    	   userInterface.setCommand(insertCommand);
	    	   
	    	   userInterface.option();
	    	  

	           Command copyCommand = new CopySelectedTextCommand(engine);
	    	   userInterface.setCommand(copyCommand);
	    	   engine.getSelection().setBeginIndex(0);
	    	   engine.getSelection().setEndIndex(8);
	    	   userInterface.option();

	           assertEquals("zakaria ",engine.getClipboardContents());
	           engine.getSelection().setBeginIndex(0);
	    	   engine.getSelection().setEndIndex(8);
	    	   engine.insert("");
	           assertEquals("jabrane",engine.getBufferContents());

	     
	    }

	    
	    

	    @Test
	    @DisplayName("get buffer contents command")
	    void getBufferContentsCommand() throws Exception {
	    	   Command insertCommand = new InsertCommand(engine, "zakaria jabrane");
	    	   userInterface.setCommand(insertCommand);
	    	   userInterface.option();
	    	   
	    	   engine.getSelection().setBeginIndex(0);
	    	   engine.getSelection().setEndIndex(8);
	    	   Command getBufferCommand = new GetBufferContentsCommand(engine);
	    	   userInterface.setCommand(getBufferCommand);
	    	   userInterface.option();

	           
         	     
	    }
	    
	    @Test
	    @DisplayName("get clipboard contents command")
	    void getClipboardContents() throws Exception {
	    	   Command insertCommand = new InsertCommand(engine, "zakaria jabrane");
	    	   userInterface.setCommand(insertCommand);
	    	   userInterface.option();
	    	   
	    	   engine.getSelection().setBeginIndex(0);
	    	   engine.getSelection().setEndIndex(8);
	    	   Command copyCommand = new CopySelectedTextCommand(engine);
	    	   userInterface.setCommand(copyCommand);
	    	   userInterface.option();

	           assertEquals("zakaria ",engine.getClipboardContents());
         	     
	    }
	    
	    

	    
	    @Test
	    @DisplayName("past clipboard text command test")
	    void pastCLipboard() throws Exception {
	    	
	    	   Command insertCommand = new InsertCommand(engine, "zakaria jabrane");
	    	   userInterface.setCommand(insertCommand);
	    	   
	    	   userInterface.option();


	           Command copyCommand = new CopySelectedTextCommand(engine);
	    	   userInterface.setCommand(copyCommand);
	    	   
	    	   engine.getSelection().setBeginIndex(0);
	    	   engine.getSelection().setEndIndex(8);
	    	   
	    	   userInterface.option();

	    	   engine.insert("");
	           assertEquals("jabrane",engine.getBufferContents());

	    	   engine.getSelection().setBeginIndex(0);
	    	   engine.getSelection().setEndIndex(0);
	    	   
	    	   Command past = new PastClipboardCommand(engine);
	    	   userInterface.setCommand(past);
	    	   userInterface.option();
	    	   
	           assertEquals("zakaria jabrane",engine.getBufferContents());

	     
	    }

	    
	    @Test
	    @DisplayName("reply command")
	    void reply() throws Exception {
	    	   Command cutCommand = new CutSelectedTextCommand(engine);
	    	   userInterface.setCommand(cutCommand);
	    	   
	    	   engine.insert("zakaria jabrane ");
	    	   engine.getSelection().setBeginIndex(0);
	    	   engine.getSelection().setEndIndex(8);
	    	   userInterface.option();
	    	   assertEquals("jabrane ",engine.getBufferContents());
	           assertEquals("zakaria ",engine.getClipboardContents());
	    	   engine.getSelection().setEndIndex(8);
	    	   userInterface.reply();
	    	   assertEquals("jabrane ",engine.getClipboardContents());
	    	   assertEquals("",engine.getBufferContents());
	           
	    }
	    
	    
<<<<<<< HEAD
	   
=======
	    @Test
	    @DisplayName("redo ")
	    void redo() throws Exception {

	 	    	   Command insertCommand = new InsertCommand(engine, "zakaria jabrane ");
	 	    	   userInterface.setCommand(insertCommand);
	 	    	   userInterface.option();
	 	    	   
	 	    	   Command cutCommand = new CutSelectedTextCommand(engine);
	 	    	   userInterface.setCommand(cutCommand);
	 	    	   engine.getSelection().setBeginIndex(0);
	 	    	   engine.getSelection().setEndIndex(8);
	 	    	   userInterface.option();
	 	    	   
	 	    	   Command past = new PastClipboardCommand(engine);
	 	    	   userInterface.setCommand(past);
	 	    	   engine.getSelection().setBeginIndex(8);
	 	    	   engine.getSelection().setEndIndex(8);
	 	    	   userInterface.option();
	 	    	   
	 	           assertEquals("jabrane zakaria ",engine.getBufferContents());
	 	           userInterface.undo();
	 	           userInterface.undo();
	 	           userInterface.undo();
	 	           userInterface.redo();

	 	           assertEquals("jabrane ",engine.getBufferContents());

	          	     
	 	           
	 	    }
	    	   

	    @Test
	    @DisplayName("undo ")
	    void undo() throws Exception {
	    	
			System.out.println("*****************************0");


	 	    	   Command insertCommand = new InsertCommand(engine, "zakaria jabrane ");
	 	    	   userInterface.setCommand(insertCommand);
	 	    	   userInterface.option();
	 	    	   
	 	    	   Command cutCommand = new CutSelectedTextCommand(engine);
	 	    	   userInterface.setCommand(cutCommand);
	 	    	   engine.getSelection().setBeginIndex(0);
	 	    	   engine.getSelection().setEndIndex(8);
	 	    	   userInterface.option();
	 	    	   
	 	    	   Command past = new PastClipboardCommand(engine);
	 	    	   userInterface.setCommand(past);
	 	    	   engine.getSelection().setBeginIndex(8);
	 	    	   engine.getSelection().setEndIndex(8);
	 	    	   userInterface.option();
	 	    	   
	 	           assertEquals("jabrane zakaria ",engine.getBufferContents());
	 	           
	 	           
	 	           userInterface.undo();
	 	           userInterface.undo();
	 	           userInterface.undo();
	 	           assertEquals("zakaria jabrane ",engine.getBufferContents());


	 	           
	 	    }
	    	       
>>>>>>> 3afc1f3313237a8a89ff1005d403319b290b0aa7
	    


}














