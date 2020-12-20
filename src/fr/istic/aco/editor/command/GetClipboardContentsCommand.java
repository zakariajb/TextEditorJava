package fr.istic.aco.editor.command;
import fr.istic.aco.editor.Engine;


public class GetClipboardContentsCommand implements Command{
	

	private Engine engine;
	
	public GetClipboardContentsCommand(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	
	/**
	 * executes getClipboardContents of the engine
	 * engine must not be null, throws NullPointerException
	 */
	public void execute() {
		if(engine == null) throw new NullPointerException();
		engine.getClipboardContents();
		}


}
