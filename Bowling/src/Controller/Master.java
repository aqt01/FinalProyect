package Controller;

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
		System.out.println("!!!! > "+Resorse.getFilePath());
		View.InitController(Resorse.getFilePath());
		
		// a partir del fileChooser
		Model.InitController(Resorse.getPath());
		//System.out.println(Resorse.pathFiles + "Files" + View.getFILE_NAME());
		//Model.InitController(Resorse.pathFiles + "Files" + View.getFILE_NAME());
		
	}
}
