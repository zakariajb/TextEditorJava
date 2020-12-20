package fr.istic.aco.editor.command;
import fr.istic.aco.editor.Engine;


public class CutSelectedTextCommand implements Command{
	
	private Engine engine;

	public CutSelectedTextCommand(Engine engine) {
		this.engine = engine;

	}
	
	@Override
	
	/**
	 * executes cutSelectedText of the engine
	 * engine must not be null, throws NullPointerException
	 */
	public void execute() {
		if(engine == null) throw new NullPointerException();
		engine.cutSelectedText();
		}

	
}
