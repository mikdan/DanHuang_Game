package controllers;

import models.Game;
import models.OptionsGame;

public class OptionsController {
 
	
	private OptionsGame  optionsGame;
	private static final int OPTION_COUNT = 9;
	
	public static int getOptionCount() {
		return OPTION_COUNT;
	}
	
	
	public OptionsController(Game game) {
		super();
		optionsGame =new OptionsGame(game);
		
	}


	public void exec(int num){

		optionsGame.optionPlay(num);;
	}
	
	public boolean exit(){
	
		return false;	 
		
	}
	

}
