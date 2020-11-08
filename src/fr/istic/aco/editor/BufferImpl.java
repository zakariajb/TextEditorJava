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
	
	private Path path;
	
	
	public BufferImpl(Path path) {
		Set<PosixFilePermission> perameters = PosixFilePermissions.fromString("rwxr-x---");
		FileAttribute<Set<PosixFilePermission>> attributs = PosixFilePermissions.asFileAttribute(perameters);
		this.path = path;
		if(!Files.exists(path)) {
			try {
				Files.createFile(path, attributs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {

			writeFile("",0,getEndIndex());
		}
		
	           
		}
	
	
	@Override
	public String readFile() {
		String content = new String();
		List<String> lines = new ArrayList<>();
		
		try {
			lines = Files.readAllLines(path, Charset.defaultCharset());    
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		for(String line : lines) content+= line;
		  
		
		return content;
		
	}
	
	
	@Override
	public String readFile(int beginIndex, int endIndex) {	
		return readFile().substring(beginIndex, endIndex);
	}
	
	
	@Override
	public void writeFile(String s, int beginIndex, int endIndex) {
		
		String content = readFile();
		
		String updatedContent = finalContent(content, s, beginIndex, endIndex);		
		
	        try {
				Files.writeString(path, updatedContent, Charset.defaultCharset());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	private String finalContent(String content, String contentToAdd,int beginIndex, int endIndex) {
		
		//if the buffer is empty just insert the new content
		if(content.equals("")) return contentToAdd;
		
		String prevInsert = content.substring(0, beginIndex);
		String followingInsert = content.substring(endIndex, content.length());
		return (prevInsert + contentToAdd +followingInsert);
		
	}

	
	public int getEndIndex() {
		return readFile().length();	
		}
	
	public int getBeginIndex() {
		return 0;
	}


	
	
	
}
