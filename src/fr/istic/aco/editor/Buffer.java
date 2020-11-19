package fr.istic.aco.editor;
import java.nio.file.Path;
public interface Buffer {
	

	
	
	public String readContents() ;
	
	
	/**
	 * return a string of contents in the file form a beginning index to an ending index
	 * beginning index is inclusive, ending index is exclusive : content [beginning index, ending index[
	 * @param path is the path to the file
	 */
	public String readContents(int beginIndex, int endIndex) ;
	
	
	
	/**
	 * writes a give string into a given interval 
	 * @param s string to insert
	 * @param beginIndex the first index of the interval
	 * @param endIndexthe the final index of the interval
	 * @return
	 */
	
	void writeNewContent(String s, int beginIndex, int endIndex);
	
	int getEndIndex() ;
	
	int getBeginIndex();
	
}
