package fr.istic.aco.editor;
import java.util.Scanner;

import  fr.istic.aco.editor.command.*;



public class Main {
	public static void main(String[] args) {
		
		Engine engine = new EngineImpl();
<<<<<<< HEAD
		UserInterface userInterface = new UserInterfaceImpl(null);
=======
<<<<<<< HEAD
		UserInterface userInterface = new UserInterfaceImpl(null);
=======
		History history = new HistoryImp(engine);
		UserInterface userInterface = new UserInterfaceImpl(null, history);
>>>>>>> 3afc1f3313237a8a89ff1005d403319b290b0aa7
>>>>>>> 66597c93ee802714ed857d0161661816322609ba
		
		
		
		
		
		while(true) {
			System.out.println("select command ( select, insert, delete,  copy, cut, print, reply, undo , redo , quit)");
			Scanner scanner = new Scanner(System.in);
			String command = scanner.nextLine();
		switch(command) {
		  case "select":
			  System.out.println("enter begin index");
			  int b = scanner.nextInt();
			  
			  System.out.println("enter end index");
			  int e = scanner.nextInt();
			  
			  Command select = new SetSelectionIndexesCommand(engine.getSelection(), b, e);
			  userInterface.setCommand(select);
			  userInterface.option();
			  break;
			  
			case "insert":
				System.out.println("enter text to insert");
				  String s = scanner.nextLine();
				  Command insert = new InsertCommand(engine, s);
				  
					
				  userInterface.setCommand(insert);
				  userInterface.option();
						  
						  
		    break;
			case "delete":
				 Command delete = new DeleteCommand(engine);
				  
					
				  userInterface.setCommand(delete);
				  userInterface.option();
				  
				  break;
			case "copy":
				 Command copy = new CopySelectedTextCommand(engine);
				  
					
				  userInterface.setCommand(copy);
				  userInterface.option();
				  
				  
				  break;
			case "cut":
				 Command cut = new CutSelectedTextCommand(engine);
				  
				
				  userInterface.setCommand(cut);
				  userInterface.option();
				  
				  break;
			case "print":
				Command print = new GetBufferContentsCommand(engine);
				  
				
				  userInterface.setCommand(print);
				  userInterface.option();
	  
				break;
<<<<<<< HEAD
	
=======
<<<<<<< HEAD
	
=======
			case "undo":
				  
				
			try {
				userInterface.undo();
			} catch (Exception e1) {
				System.out.println("cannot undo");
			}
				  
				  
				break;
			case "redo":
				try {
					userInterface.undo();
				} catch (Exception e1) {
					System.out.println("cannot redo");
				}
				  
				break;
>>>>>>> 3afc1f3313237a8a89ff1005d403319b290b0aa7
>>>>>>> 66597c93ee802714ed857d0161661816322609ba
			case "quit":
				System.out.println("goodbye");
				  return;
				
		}
		}
		
		
	}
}
