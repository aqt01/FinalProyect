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
		View = new ViewController(Resorse.PATH);
		
	}
	
	public void InitControllers()
	{
		View.InitController();
		Model.InitController();
		Model.setFile(View.getFILE_PATH());
	}
}
