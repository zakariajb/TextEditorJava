package fr.istic.aco.editor.command;

import fr.istic.aco.editor.Engine;

public class InsertCommand implements Command{

	private Engine engine;
	private String content;

	
	public InsertCommand(Engine engine, String content) {
		this.engine = engine;
		this.content = content;
	
		
	}
	
	@Override
	
	/**
	 * executes insert of the engine
	 * engine must not be null, throws NullPointerException
	 */
	public void execute() {
		if(engine == null) throw new NullPointerException();
		engine.insert(content);
		}



}
