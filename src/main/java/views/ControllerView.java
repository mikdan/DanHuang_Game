package views;

import controllers.FlipInFoundController;
import controllers.MoveDeckToDiscardController;
import controllers.MoveDiscardToDeckController;
import controllers.MoveDiscardToFoundController;
import controllers.MoveDiscardToStackController;
import controllers.MoveFoundToStackController;
import controllers.MoveStackToFoundController;
import controllers.MoveStackToStackController;
import models.Game;
import utils.IO;
public class ControllerView {
	
	private IO io;
	private MoveDeckToDiscardController moveDeckToDiscardController;
	private MoveDiscardToDeckController moveDiscardToDeckController;
	private MoveDiscardToFoundController moveDiscardToFoundController;
	private MoveDiscardToStackController moveDiscardToStackController;
	private MoveStackToFoundController moveStackToFoundController;
	private MoveStackToStackController moveStackToStackController;
	private MoveFoundToStackController moveFoundToStackController;
	private FlipInFoundController flipInFoundController;

	private Game game;
	
	public ControllerView(Game game) {
		super();
		io = new IO();
		this.game=game;
		moveDeckToDiscardController = new MoveDeckToDiscardController(game.getDeck(),game.getDiscard());
		moveDiscardToDeckController = new MoveDiscardToDeckController(game.getDeck(),game.getDiscard());
		moveDiscardToFoundController = new MoveDiscardToFoundController(game.getFouns(),game.getDiscard());
		moveDiscardToStackController = new MoveDiscardToStackController(game.getDiscard(),game.getStack());
		moveStackToFoundController = new MoveStackToFoundController(game.getStack(),game.getFouns());
		moveStackToStackController = new MoveStackToStackController(game.getStack());
		moveFoundToStackController = new MoveFoundToStackController(game.getFouns(),game.getStack());
		flipInFoundController = new FlipInFoundController(game.getStack());
	}


	// 1 baraja a descarte
	public void moveDeckToDiscardView(){
		moveDeckToDiscardController.exec();
	}
	
	// 2 descarte a baraja
	public void moveDiscardToDeckView(){
		moveDiscardToDeckController.exec();
	}
	
	// 3 descarte a palo
	
	public void moveDiscardToFoundView(){
		moveDiscardToFoundController.exec();
	}
	
	// 4 descarte a escalera
	
	public void moveDiscardToStackView(){	
		moveDiscardToStackController.exec();
		
	}
	
	
	// 5 escalera a palo
	public void moveStackToFoundView(){
		int numStack = io.readInt("De qué escalera? [1-7]:");
		if(numStack < Game.getStackCount()){
			moveStackToFoundController.setNumStack(numStack);
			moveStackToFoundController.exec();
		}else{
			io.writeln("Escalera no hay ");
		}
		
	}
	 
	// 6 escalera a escalera
	public void moveStackToStackView(){
		int nmCards = io.readInt("Cuántas cartas?:");
		int fromStack = io.readInt("De qué escalera? [1-7]:");
		int toStack = io.readInt("A qué escalera? [1-7]:");
		
		int cSize = game.getStack().get(fromStack).getAll().size();
		if(fromStack < Game.getStackCount()){
			moveStackToStackController.setFromStack(fromStack);
			moveStackToStackController.setNmCards(nmCards);;
			moveStackToStackController.setToStack(toStack);
			moveStackToStackController.exec();
				
		}else if(toStack < Game.getStackCount()){
			io.writeln("Escalera no hay en el inicio");
			
		}else if(nmCards > cSize){
			io.writeln("No se puede mover mas");
		}
		
		else{

			io.writeln("Escalera no hay en el final");
			
		}
		
		
	}
	
	// 7 palo a escalera
	public void moveFoundToStackView(){
		int numFound = io.readInt("De qué palo? [1-4]:");
		int numStack = io.readInt("A qué escalera? [1-7]:");
		if(numFound < Game.getFoundCount()){
			moveFoundToStackController.setNumFound(numFound);
			moveFoundToStackController.setNumStack(numStack);
			moveFoundToStackController.exec();
		}else if(Game.getStackCount() < numStack){
			io.writeln("Escalara no hay ");
		}else{
			io.writeln("Palo no hay ");
		}
		
	}
	
	// 8 voltear
	public void flipView(){
		int numStack= io.readInt("En qué escalera? [1-7]:");
		if(numStack<Game.getStackCount()){
			flipInFoundController.setNumStack(numStack);
			flipInFoundController.exec();
		}else
			io.writeln("Escalera no hay ");
	}
	
	// 9 salir
	public void exitView(){
		io.write("Adiós!!!");
		System.exit(0);
       
	}
}
