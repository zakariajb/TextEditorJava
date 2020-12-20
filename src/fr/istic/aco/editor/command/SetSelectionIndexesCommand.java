package fr.istic.aco.editor.command;
import fr.istic.aco.editor.Engine;
import fr.istic.aco.editor.Selection;


public class SetSelectionIndexesCommand implements Command{

	private Selection selection;
	private int beginIndex;
	private int endIndex;
	
	public SetSelectionIndexesCommand(Selection selection, int beginIndex, int endIndex) {
		this.selection = selection;
		this.beginIndex = beginIndex;
		this.endIndex = endIndex;
	}
	
	
	/**
	 * sets the begin index and the end index of the selection
	 * selection must not be null, throws NullPointerException
	 */
	@Override
      public void execute() {
		if(selection == null) throw new NullPointerException();
		
		try {
			selection.setBeginIndex(beginIndex);
			selection.setEndIndex(endIndex);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

}
