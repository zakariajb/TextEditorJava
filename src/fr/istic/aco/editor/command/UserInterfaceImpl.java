package fr.istic.aco.editor.command;

import java.util.ArrayList;

import java.util.List;

public class UserInterfaceImpl implements UserInterface {
	
	private Command command;
	private Command lastCommand;
<<<<<<< HEAD
=======
	private History commandsHistory;
>>>>>>> 3afc1f3313237a8a89ff1005d403319b290b0aa7
	
	// this is better be manipulated in history class
  


	/**
	 * Constructor 
	 */
<<<<<<< HEAD
	public UserInterfaceImpl(Command command ) {
		this.command = command;
=======
	public UserInterfaceImpl(Command command, History history) {
		this.command = command;
		commandsHistory = history;
>>>>>>> 3afc1f3313237a8a89ff1005d403319b290b0aa7
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
<<<<<<< HEAD

=======
		
		if(command instanceof CutSelectedTextCommand || command instanceof InsertCommand
	|| command instanceof DeleteCommand || command instanceof PastClipboardCommand || command instanceof SetSelectionIndexesCommand)
		commandsHistory.addToHistory();
		
>>>>>>> 3afc1f3313237a8a89ff1005d403319b290b0aa7

		
	}

	
	
	/**
	 * executes the lastCommand
	 */
	public void reply() {
		lastCommand.execute();
	}
	
<<<<<<< HEAD

=======
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
>>>>>>> 3afc1f3313237a8a89ff1005d403319b290b0aa7

}
