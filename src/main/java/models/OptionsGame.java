package models;

import views.ControllerView;
public class OptionsGame {

	private ControllerView controllerView;
	
	public OptionsGame(Game game){
		controllerView = new ControllerView(game);	 
	}
	
	public void optionPlay(int option){
		
		if(option==1){
			// 1 baraja a descarte
			 
			controllerView.moveDeckToDiscardView();
			
		}else if(option==2){
			// 2 descarte a baraja
		
			controllerView.moveDiscardToDeckView();	 
			
		}else if(option==3){
			// 3 descarte a palo
			 
			controllerView.moveDiscardToFoundView();
			
		}else if(option==4){
			// 4 descarte a escalera
		 
			controllerView.moveDiscardToStackView();
			
		}else if(option==5){
			// 5 escalera a palo
			 
			controllerView.moveStackToFoundView();
			
			
		}else if(option==6){
			// 6 escalera a escalera
			 
			controllerView.moveStackToStackView();
			
			
		}else if(option==7){
			// 7 palo a escalera
			 
			controllerView.moveFoundToStackView();
			
			
		}else if(option==8){
			// 8 voltear
		 
			controllerView.flipView();
			
			
		}else if(option==9){
			// 9 salir
			 
			controllerView.exitView();
			
		}
		
	}
	
	 
}
