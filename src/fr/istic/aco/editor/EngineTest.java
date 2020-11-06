package fr.istic.aco.editor;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {
	
	Path path = Paths.get("test.txt");
	Buffer buffer = new BufferImpl(path);
	Selection selection = new SelectionImpl(buffer);
	private Engine engine;
	

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    	 engine = new EngineImpl(selection, buffer);
    	 //engine.insert("");
    }

    private void todo() {
        fail("Unimplemented test");
    }
    @Test
    @DisplayName("Buffer must be empty after initialisation")
    void getSelection() {
        Selection selection = engine.getSelection();
        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
        assertEquals("",engine.getBufferContents());
    }

    @Test
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
         assertEquals("TEST completed",engine.getBufferContents());
    }

    @Test
    void getClipboardContents() {
        todo();
    }

    @Test
    void cutSelectedText() {
        todo();
    }

    @Test
    void copySelectedText() {
        todo();
    }

    @Test
    void pasteClipboard() {
        todo();
    }
}
