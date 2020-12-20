package fr.istic.aco.editor.command;

public interface UserInterface {

	


	/**
	 * sets the command
	 * @param command not null, throws NullPointerException 
	 */
	void setCommand(Command command);
	
	/**
	 * executes the current command
	 */
	void option();
	
	
	/**
	 * replies the last command
	 */
	void reply();
	
	/**
	 * restores engine previous state
	 * @throws Exception 
	 */

	void redo() throws Exception;
	
	
	/**
	 * restores engine next state
	 * @throws Exception 
	 */

	void undo() throws Exception;
}
