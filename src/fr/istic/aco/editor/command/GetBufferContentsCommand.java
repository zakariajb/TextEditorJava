package fr.istic.aco.editor.command;
import fr.istic.aco.editor.Engine;

import java.util.logging.Logger;


public class GetBufferContentsCommand implements Command{
	
	private Engine engine;
	
	public GetBufferContentsCommand(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	
	/**
	 * executes getBufferContents of the engine
	 * engine must not be null, throws NullPointerException
	 */
	public void execute() {
		if(engine == null) throw new NullPointerException();
		Logger.getGlobal().info(engine.getBufferContents());
		}

}
