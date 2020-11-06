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
		// TODO Auto-generated method stub
		return buffer.getEndIndex();
	}

	@Override
	public void setBeginIndex(int beginIndex) throws Exception {
		if(beginIndex < 0 || endIndex > getBufferEndIndex() )
			throw new Exception("impossible index !!");
		this.beginIndex = beginIndex;
	}

	@Override
	public void setEndIndex(int endIndex) throws Exception {
		if(beginIndex < 0 || endIndex > getBufferEndIndex() )
			throw new Exception("impossible index !!");
		this.endIndex = endIndex;
	}

}
