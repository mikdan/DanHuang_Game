package app;
import views.OptionsGameView;
public class Klondike {
	
	private OptionsGameView optionsGameView;
	
	
	public Klondike(){	   	
		optionsGameView = new OptionsGameView();	
	}
	
	public static void main(String[] args){
		new Klondike().play();
	}

	private void play() {
		optionsGameView.printCases();
	
	}
}
