package fr.istic.aco.editor.command;
import fr.istic.aco.editor.Engine;

/**
 * delete using command design pattern
 */

public class DeleteCommand implements Command{
	

	private Engine engine;
	String contentDeleted;

	
	public DeleteCommand(Engine engine) {
		this.engine = engine;
	
	}
	
	@Override
	
	/**
	 * executes delete of the engine
	 * engine must not be null, throws NullPointerException
	 */
	public void execute() {
		if(engine == null) throw new NullPointerException();
		engine.delete();
		
		}

}
