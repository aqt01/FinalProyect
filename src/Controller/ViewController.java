package Controller;

import javax.swing.JFrame;

import View.BowlFrame;
import View.InitFrame;
import View.SplashScreen;

public class ViewController 
{
	public InitFrame InitView;
	public BowlFrame Bowl;
	private String FILE_PATH = "";
	
	public ViewController(String PATH)
	{
		this.InitView = new InitFrame();
		//this.Bowl = new BowlFrame();
		this.FILE_PATH = PATH;
	}
	
	public void InitController()
	{
		chooseFileWindow();
		//Bowl.setVisible(true);
	}
	
	private void chooseFileWindow()
	{
		InitFrame init = new InitFrame();
		JFrame frame = new JFrame("Bowling Game");	
		
		SplashScreen splash = new SplashScreen();
        
        // Normally, we'd call splash.showSplash() and get on 
        // with the program. But, since this is only a test...       
		
		splash.showSplash();		
		frame.setSize(400,400);		
		init.LoadComponents(frame);
		setFILE_PATH(init.FileChooser(frame));
		
		frame.dispose();
	}

	public String getFILE_PATH() 
	{
		return FILE_PATH;
	}

	public void setFILE_PATH(String fILE_PATH) 
	{
		FILE_PATH = fILE_PATH;
	}
}
