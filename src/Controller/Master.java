package Controller;

public class Master 
{
	public ModelController Model;
	public ViewController View;
	
	public static void main(String args) 
	{
		Master Game = new Master();
		
		Game.InitControllers();
	}
	
	public Master()
	{
		Model = new ModelController();
		View = new ViewController();
	}
	
	public void InitControllers()
	{
		View.InitController();
		Model.InitController();
		Model.setFile(View.getFILE_PATH());
	}
}
