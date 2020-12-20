package fr.istic.aco.editor.command;
import fr.istic.aco.editor.*;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.api.pipe.Engine;

public interface History {
	

	void addToHistory();
	
	
	void undo() throws Exception;
	
	void redo() throws Exception;




	
}

