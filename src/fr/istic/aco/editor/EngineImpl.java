package fr.istic.aco.editor;

public class EngineImpl implements Engine {
	
	private Selection selection;
	private Buffer buffer;
	private Buffer clipboard;
	
	public EngineImpl() {
		buffer = new BufferImpl();
		selection = new SelectionImpl(buffer);
		clipboard = new Clipboard(); 
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
 
        return buffer.readContents();
    }

    /**
     * Provides the clipboard contents
     *
     * @return a copy of the clipboard's contents
     */
    @Override
    public String getClipboardContents() {
        return clipboard.readContents();
    }

    /**
     * Removes the text within the interval
     * specified by the selection control object,
     * from the buffer.
     */
    @Override
    public void cutSelectedText() {
    	  copySelectedText();
    	  delete();
    }

    /**
     * Copies the text within the interval
     * specified by the selection control object
     * into the clipboard.
     */
    @Override
    public void copySelectedText() {
    	clipboard.writeNewContent(buffer.readContents(selection.getBeginIndex(), selection.getEndIndex()),
  			  0,clipboard.getEndIndex());
    }

    /**
     * Replaces the text within the interval specified by the selection object with
     * the contents of the clipboard.
     */
    @Override
    public void pasteClipboard() {
        insert(getClipboardContents());
    }

    /**
     * Inserts a string in the buffer, which replaces the contents of the selection
     *
     * @param s the text to insert
     */
    @Override
    public void insert(String s) {
    	indexesFix();
    	buffer.writeNewContent(s, selection.getBeginIndex(), selection.getEndIndex());
    	try {
    		selection.setEndIndex(selection.getBeginIndex()+s.length());
			selection.setBeginIndex(selection.getEndIndex());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    /**
     * Removes the contents of the selection in the buffer
     */
    @Override
    public void delete() {
    	insert("");
    
    }
    
    /**
	 * switches begin index and index if begin index is greater than end index
	 */
	private void indexesFix() {
		if(selection.getBeginIndex() > selection.getEndIndex()) {
			int tmp = selection.getBeginIndex();
			try {
				selection.setBeginIndex(selection.getEndIndex());
				selection.setEndIndex(tmp);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
					
	}
}
