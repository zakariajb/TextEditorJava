package fr.istic.aco.editor.command;
import fr.istic.aco.editor.Engine;


public class PastClipboardCommand implements Command{
	

	private Engine engine;
	String clipboardContent;

	
	
	public PastClipboardCommand(Engine engine) {
		this.engine = engine;
		clipboardContent = engine.getClipboardContents();
	
	}
	
	@Override
	
	/**
	 * executes pasteClipboard of the engine
	 * engine must not be null, throws NullPointerException
	 */
	public void execute() {
		if(engine == null) throw new NullPointerException();
		engine.pasteClipboard();
		}


}
