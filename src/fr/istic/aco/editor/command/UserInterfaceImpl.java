package fr.istic.aco.editor.command;

import java.util.ArrayList;

import java.util.List;

public class UserInterfaceImpl implements UserInterface {
	
	private Command command;
	private Command lastCommand;
	
	// this is better be manipulated in history class
  


	/**
	 * Constructor 
	 */
	public UserInterfaceImpl(Command command ) {
		this.command = command;
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


		
	}

	
	
	/**
	 * executes the lastCommand
	 */
	public void reply() {
		lastCommand.execute();
	}
	


}
