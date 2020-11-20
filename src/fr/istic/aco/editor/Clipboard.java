package fr.istic.aco.editor;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Clipboard implements Buffer {
	private Buffer clipboard;
	
	public Clipboard() {
		clipboard = new BufferImpl();
	}

	@Override
	public String readContents() {
		// TODO Auto-generated method stub
		return clipboard.readContents();
	}

	@Override
	public String readContents(int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return clipboard.readContents(beginIndex, endIndex);
	}

	@Override
	public void writeNewContent(String s, int beginIndex, int endIndex) {
		 clipboard.writeNewContent(s, beginIndex, endIndex);
		
	}

	@Override
	public int getEndIndex() {
		// TODO Auto-generated method stub
		return clipboard.getEndIndex();
	}

	@Override
	public int getBeginIndex() {
		// TODO Auto-generated method stub
		return clipboard.getBeginIndex();
	}


	
	

}
