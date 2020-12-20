package fr.istic.aco.editor.command;
import fr.istic.aco.editor.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class HistoryImp implements History{
	Engine engine;
	List<String> bufferStates;
	List<Selection> selections;
	int current;
	
	public HistoryImp( Engine engine) {
		this.engine = engine;
		this.bufferStates = new ArrayList<String>();
		this.selections = new ArrayList<Selection>();
		current =0;
	}
	
	/**
	 * 
	 */
	@Override
	public void addToHistory() {
		bufferStates.add(current, engine.getBufferContents());
		selections.add(current, engine.getSelection());
		current++;
	

	}
	
	/**
	 * 
	 */
	@Override
	public void undo() throws Exception {
		


		
		current--;
		if(current >= 0) {
	
			engine.getSelection().setBeginIndex(0);
			engine.getSelection().setEndIndex(engine.getSelection().getBufferEndIndex());
			engine.insert(bufferStates.get(current));
			engine.getSelection().setBeginIndex(selections.get(current).getBeginIndex());
			engine.getSelection().setEndIndex(selections.get(current).getEndIndex());
			
			
		
		}
			
	}
	
	/**
	 * 
	 */
	@Override
	public void redo() throws Exception {
		current++;
		
		if(current < bufferStates.size()) {

			
			engine.getSelection().setBeginIndex(0);
			engine.getSelection().setEndIndex(engine.getSelection().getBufferEndIndex());
			engine.insert(bufferStates.get(current));
			engine.getSelection().setBeginIndex(selections.get(current).getBeginIndex());
			engine.getSelection().setEndIndex(selections.get(current).getEndIndex());
		}
	}
	
		
	}
