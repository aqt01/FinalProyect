package Controller;

import Model.Player;
import Model.ResorseManager;

public class Master 
{
	public  ModelController Model = new ModelController();
	public  ViewController View = new ViewController();
	public  ResorseManager Resorse = new ResorseManager();
	
	public static void main(String[] args) 
	{
		Master Game = new Master();
		//Game.Resorse = new ResorseManager();
	    Game.InitControllers();
		
    }
	
	public Master()
	{
		//Resorse = new ResorseManager();
	//	Model = new ModelController();
	//	View = new ViewController();
	}
	
	public void InitControllers()
	{
		System.out.println("Path of File Projects: "+Resorse.getFilePath());
		System.out.println("Path of Resources of Projects : "+Resorse.getResPath());
		View.InitController(Resorse.getResPath());
		
		System.out.println("!!!<> <> ! > "+View.InitView.getTxtFilePath());
		// a partir del fileChooser
		Model.InitController(this.View.getTxtFilePath());
		View.Bowl.setPlayers(Model.getPlayer(0), Model.getPlayer(1));
		System.out.println("passed");
		//	View.Bowl.setPlayers();
		//System.out.println(Resorse.pathFiles + "Files" + View.getFILE_NAME());
		//Model.InitController(Resorse.pathFiles + "Files" + View.getFILE_NAME());
		
	}
}
