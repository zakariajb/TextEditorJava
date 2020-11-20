package fr.istic.aco.editor;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BufferImpl implements Buffer {
	
	private String buffer;
	
	
	public BufferImpl() {
		buffer = new String();
	           
		}
	
	
	@Override
	public String readContents() {
		return buffer;
		
	}
	
	
	@Override
	public String readContents(int beginIndex, int endIndex) {	
		return readContents().substring(beginIndex, endIndex);
	}
	
	
	@Override
	public void writeNewContent(String s, int beginIndex, int endIndex) {
		
		String content = readContents();
		String Updatedcontent = finalContent(content, s, beginIndex, endIndex);
		buffer = Updatedcontent;
			
	}
	
	private String finalContent(String content, String contentToAdd,int beginIndex, int endIndex) {
		
		//if the buffer is empty just insert the new content
		if(content.equals("")) return contentToAdd;
		
		String prevInsert = content.substring(0, beginIndex);
		String followingInsert = content.substring(endIndex, content.length());
		return (prevInsert + contentToAdd +followingInsert);
		
	}

	
	public int getEndIndex() {
		return readContents().length();	
		}
	
	public int getBeginIndex() {
		return 0;
	}


	
	
	
}
