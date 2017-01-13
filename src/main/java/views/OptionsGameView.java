package views;

import controllers.OptionsController;
import models.CardSuit;
import models.Game;
import utils.IO;


public class OptionsGameView {
	private IO io;   
	private OptionsController optionsController;
	private Game game;
	public OptionsGameView() {
		io = new IO();
		this.game=new Game();
		this.optionsController=new OptionsController(this.game);
		 
	}
	
	public void board(){
		
		io.writeln("===========================");
		io.writeln("Baraja:" + game.getDeck().toString());
		io.writeln("Descarte:" + game.getDiscard().toString());
	
		for (CardSuit card: CardSuit.values()) {
			io.writeln("Palo " + card.name() + ": " + game.getFoundation(card).toString());
		}
		for (int i = 7; i > 0; i--) {
			io.writeln("Escalera " + i + ": " + game.getCardStack(i).toString());
		}
		io.writeln("---------------------------");	
		
	}	 

	public void printOptions(){
		
		io.writeln("1. Mover de baraja a descarte");
		io.writeln("2. Mover de descarte a baraja");
		io.writeln("3. Mover de descarte a palo");
		io.writeln("4. Mover de descarte a escalera");
		io.writeln("5. Mover de escalera a palo");
		io.writeln("6. Mover de escalera a escalera");
		io.writeln("7. Mover de palo a escalera");
		io.writeln("8. Voltear en escalera");
		io.writeln("9. Salir");
		
	}
	
	public void printCases(){
		do{
			board();
			printOptions();
			int num = io.readInt("Opción? [1-9]:");
			if(num<=OptionsController.getOptionCount()){
				optionsController.exec(num);
			}else{
				io.writeln("ERROR!!! La Opción debe ser entre 1 y 9 inclusives");
			}
		}while(!optionsController.exit());
		
	}
}
