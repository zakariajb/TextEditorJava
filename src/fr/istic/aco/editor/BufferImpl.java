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
			System.out.println("file already exists");
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
	public void writeFile(String s, int beginIndex, int endIndex) {
		
		String content = readFile();
		
		String updatedContent = createNewContent(content, s, beginIndex, endIndex);		
		
	        try {
				Files.writeString(path, updatedContent, Charset.defaultCharset());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	private String createNewContent(String content, String contentToAdd,int beginIndex, int endIndex) {
		
		//if the buffer is empty just insert the new content
		if(content.equals("")) return contentToAdd;
		
		boolean inserted = false;	
		int currentPosition = 0;
		
		// length is the total length of the original content plus the content to insert minus the selected content
		int bufferNewLength = content.length() + contentToAdd.length() + (beginIndex - endIndex);
		
		char[] content_array = new char[bufferNewLength]; 

		
		for(int i = 0; i < content.length(); i++) {
			// if not inserted, to avoid going on an infinite loop when endIndex = 0
			if(i == beginIndex && !inserted) {
				
				for(int j = 0; j < contentToAdd.length() ; j++) {
					content_array[currentPosition++] = contentToAdd.charAt(j);
					inserted = true;
					}
				
				i= endIndex-1;
				
				} else content_array[currentPosition++] = content.charAt(i); 
			
		}
	
		return String.valueOf(content_array);  
	}

	
	public int getEndIndex() {
		return readFile().length();	
		}
	
	public int getBeginIndex() {
		return 0;
	}
	
	
	
}
