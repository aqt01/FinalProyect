package Controller;

import Model.ResorseManager;

public class Master 
{
	public ModelController Model;
	public ViewController View;
	public ResorseManager Resorse;
	
	public static void main(String[] args) 
	{
		Master Game = new Master();
		Game.Resorse = new ResorseManager();
		Game.InitControllers();
		
    }
	
	public Master()
	{
		Resorse = new ResorseManager();
		Model = new ModelController();
		View = new ViewController();
	}
	
	public void InitControllers()
	{
		View.InitController();
		System.out.println(Resorse.PATH + "Files" + View.getFILE_NAME());
		Model.InitController(Resorse.PATH + "Files" + View.getFILE_NAME());
		
	}
}
