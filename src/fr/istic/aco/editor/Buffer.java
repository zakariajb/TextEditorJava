package fr.istic.aco.editor;
import java.nio.file.Path;
public interface Buffer {
	

	
	
	public String readContents() ;
	
	
	/**
	 * return a string of contents in the file form a beginning index to an ending index
	 * beginning index is inclusive, ending index is exclusive : content [beginning index, ending index[
	 * @param beginIndex must be within the buffer index range
	 * @param endIndex must be within the buffer index range
	 */
	public String readContents(int beginIndex, int endIndex) ;
	
	
	
	/**
	 * writes a give string into a given interval 
	 * @param s string to insert
	 * @param beginIndex must be within the buffer index range
	 * @param endIndex must be within the buffer index range
	 */
	
	void writeNewContent(String s, int beginIndex, int endIndex);
	
	/**
     * Provides the index of the first "virtual" character
     * after the end of the buffer
     *
     * @return the post end buffer index
     */
	
	int getEndIndex() ;
	
	/**
     * Provides the first writable index in the buffer (0)
     *
     * @return the buffer first index (0)
     */
	int getBeginIndex();
	
}
