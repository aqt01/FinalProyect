package Controller;

import javax.swing.JFrame;

import View.BowlFrame;
import View.InitFrame;
import View.SplashScreen;

public class ViewController 
{
	public InitFrame InitView;
	public BowlFrame Bowl;
	private String FILE_NAME = "";
	
	public ViewController()
	{
		this.InitView = new InitFrame();
		//this.Bowl = new BowlFrame();
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
		
		String p1 = "", p = init.FileChooser(frame);
		System.out.println("p:" + p + " " + p.length());
		
		int i = p.length() - 1, j = 0;
		System.out.println(i + " " + p.charAt(i));
		while(i > 0)
		{
			if( (p.charAt(i) == '/') ||  (p.charAt(i) == '\''))
			{
				j = i;
				break;
			}
			i--;
		}
		p1 = p.substring(j, p.length());
		FILE_NAME = p1;
		frame.dispose();
	}

	public String getFILE_NAME() 
	{
		return FILE_NAME;
	}

	public void setFILE_NAME(String fILE_PATH) 
	{
		FILE_NAME = fILE_PATH;
	}
}
