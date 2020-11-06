package fr.istic.aco.editor;

public class EngineImpl implements Engine {
	
	private Selection selection;
	private Buffer buffer;
	
	public EngineImpl(Selection selection, Buffer buffer) {
		this.selection = selection;
		this.buffer = buffer;
	}
	
    /**
     * Provides access to the selection control object
     *
     * @return the selection object
     */
    @Override
    public Selection getSelection() {
        return selection;
    }

    /**
     * Provides the whole contents of the buffer, as a string
     *
     * @return a copy of the buffer's contents
     */
    @Override
    public String getBufferContents() {
 
        return buffer.readFile();
    }

    /**
     * Provides the clipboard contents
     *
     * @return a copy of the clipboard's contents
     */
    @Override
    public String getClipboardContents() {
        // TODO
        return null;
    }

    /**
     * Removes the text within the interval
     * specified by the selection control object,
     * from the buffer.
     */
    @Override
    public void cutSelectedText() {
        // TODO
    }

    /**
     * Copies the text within the interval
     * specified by the selection control object
     * into the clipboard.
     */
    @Override
    public void copySelectedText() {
        // TODO
    }

    /**
     * Replaces the text within the interval specified by the selection object with
     * the contents of the clipboard.
     */
    @Override
    public void pasteClipboard() {
        // TODO
    }

    /**
     * Inserts a string in the buffer, which replaces the contents of the selection
     *
     * @param s the text to insert
     */
    @Override
    public void insert(String s) {
    	buffer.writeFile(s, selection.getBeginIndex(), selection.getEndIndex());
    }

    /**
     * Removes the contents of the selection in the buffer
     */
    @Override
    public void delete() {
    	buffer.writeFile("", selection.getBeginIndex(), selection.getEndIndex());
    }
}
