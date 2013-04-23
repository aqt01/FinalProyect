package Controller;

import javax.swing.JFrame;

import View.BowlFrame;
import View.InitFrame;
import View.SplashScreen;
import View.TablePanel;

public class ViewController 
{
	public InitFrame InitView;
	public BowlFrame Bowl;
	private String FILE_NAME;
	
	public ViewController()
	{
		InitView = new InitFrame();
//		Bowl = new BowlFrame();
	}
	
	public void InitController(String _pathFiles)
	{
		
		FILE_NAME = _pathFiles;
		this.chooseFileWindow();

		//	Bowl.setFilePath(FILE_NAME);
		//	InitView.setFilePath(FILE_NAME);
		//	Bowl.setVisible(true);
		//	this.InitView.setFilePath(_pathFiles);
		
	}
	
	private void chooseFileWindow()
	{

		System.out.println("GOT THIS "  + FILE_NAME);
		InitFrame init = new InitFrame();
		init.setFilePath(FILE_NAME);
		JFrame frame = new JFrame("Bowling Game");			
		SplashScreen splash = new SplashScreen();
        splash.setFilePath(FILE_NAME);
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
		//FILE_NAME = p1;
		InitView.setTxtFilePath(p);
		//BowlFrame bFrame = new BowlFrame();
		//bFrame.setVisible(true);
		while ( null==InitView.getTxtFilePath() )
		{ 
			
		}
		System.out.println(" FILENAME: " + FILE_NAME);
		Bowl = new BowlFrame(FILE_NAME);		
		Bowl.setVisible(true);
	
		frame.dispose();
	}

	public String getFILE_NAME() 
	{
		return FILE_NAME;
	}
	public String getTxtFilePath() {
		return InitView.getTxtFilePath();
	}

	public void setFILE_NAME(String fILE_PATH) 
	{
		FILE_NAME = fILE_PATH;
	}
}
