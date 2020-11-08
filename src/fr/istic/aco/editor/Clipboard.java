package fr.istic.aco.editor;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Clipboard extends BufferImpl {
	private static final Path path = Paths.get("clipboard.txt");
	public Clipboard() {
		super(path);
	}
	

}
