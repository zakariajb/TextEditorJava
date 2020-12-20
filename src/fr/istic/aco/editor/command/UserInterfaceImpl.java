package fr.istic.aco.editor.command;

import java.util.ArrayList;

import java.util.List;

public class UserInterfaceImpl implements UserInterface {
	
	private Command command;
	private Command lastCommand;
	private History commandsHistory;
	
	// this is better be manipulated in history class
  


	/**
	 * Constructor 
	 */
	public UserInterfaceImpl(Command command, History history) {
		this.command = command;
		commandsHistory = history;
	}
	
	
	/**
	 * sets the command
	 * @param command not null, throws NullPointerException 
	 */
	
	public void setCommand(Command command){
		if(command == null) throw new NullPointerException();
		this.command = command;
	
    }

	/**
	 * executes the current command
	 */
	public void option() {
		command.execute();
		lastCommand = command;
		
		if(command instanceof CutSelectedTextCommand || command instanceof InsertCommand
	|| command instanceof DeleteCommand || command instanceof PastClipboardCommand || command instanceof SetSelectionIndexesCommand)
		commandsHistory.addToHistory();
		

		
	}

	
	
	/**
	 * executes the lastCommand
	 */
	public void reply() {
		lastCommand.execute();
	}
	
	/**
	 * gets previous engine state
	 * @throws Exception 
	 * 
	 */
	
	public void undo() throws Exception {
      commandsHistory.undo();
    }
	
	
	/**
	 * gets next engine state
	 * @throws Exception 
	 * 
	 */	
	
	public void redo() throws Exception  {
	      commandsHistory.redo();

    }

}
