package fr.istic.aco.editor.command;
import fr.istic.aco.editor.Engine;


public class CopySelectedTextCommand implements Command{

	private Engine engine;
	
	public CopySelectedTextCommand(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	
	/**
	 * executes copySelectedText of the engine
	 * engine must not be null, throws NullPointerException
	 */
	public void execute() {
		if(engine == null) throw new NullPointerException();
		engine.copySelectedText();
		}



}
