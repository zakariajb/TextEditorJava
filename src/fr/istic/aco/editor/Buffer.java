package fr.istic.aco.editor;
import java.nio.file.Path;
public interface Buffer {
	

	/**
	 * return a string of all contents in the file
	 * @param path is the path to the file
	 */
	String readFile();
	
	/**
	 * writes a give string into a given interval 
	 * @param s string to insert
	 * @param beginIndex the first index of the interval
	 * @param endIndexthe the final index of the interval
	 * @return
	 */
	void writeFile(String s, int beginIndex, int endIndex);
	
	int getEndIndex() ;
	
	int getBeginIndex();
	
}
