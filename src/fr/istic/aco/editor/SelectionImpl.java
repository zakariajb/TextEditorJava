package fr.istic.aco.editor;

public class SelectionImpl implements Selection {
	Buffer buffer;
	private int beginIndex;
	private int endIndex;
	
	
	public SelectionImpl(Buffer buffer) {
		this.buffer = buffer;
		beginIndex = 0;
		endIndex = 0;
	}
	@Override
	public int getBeginIndex() {
		return beginIndex;
	}

	@Override
	public int getEndIndex() {
		return endIndex;
	}

	@Override
	public int getBufferBeginIndex() {
		return buffer.getBeginIndex();
	}

	@Override
	public int getBufferEndIndex() {
		return buffer.getEndIndex();
	}

	
	 /**
     * Changes the value of the begin index of the selection
     *
     * @param index, must be within the buffer index range
     * fixes index to 0 when it's < 0 and to buffer's last index if it's > buffer end index
     * switches indexes if begin index > end index
     */
	
	@Override
	public void setBeginIndex(int index) throws Exception {
		if(index < 0) index = 0;
		if(index > getBufferEndIndex()) index = getBufferEndIndex();
		beginIndex = index;
		
	
		
	}

    /**
     * Changes the value of the end index of the selection
     *
     * @param index, must be within the buffer index range
     * fixes index to 0 when it's < 0 and to buffer's last index if it's > buffer end index
     * switches indexes if begin index > end index
     */
    
    
	@Override
	public void setEndIndex(int index) {
		if(index < 0) index = 0;
		if(index > getBufferEndIndex()) index = getBufferEndIndex();
 		
		this.endIndex = index;

		
	}
	

	
	

}
