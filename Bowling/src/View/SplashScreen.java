package View;
 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

@SuppressWarnings("serial")

public class SplashScreen extends JWindow implements Runnable{
	JPanel content = (JPanel)getContentPane();
    JFrame frame;  
    String resPath; // Resource Path, here this variable will be inserted by the constructor, 
    //so when it's called by ViewController, takes the correct value
    
    
    
    
    private int duration;
   
      public SplashScreen() {
        duration = 2000;
        
    }
      
    public void setFilePath(String _filePath) 
  	{
  		resPath= _filePath;
  		
  	}
    
    public void showSplash() {
        
        content.setBackground(Color.white);
         
         // Set the window's bounds, centering the window
         Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
         int width = 316;
         int height = 245;
         
         int x = (screen.width-width)/2;
         int y = (screen.height-height)/2;
         setBounds(x,y,width,height);
         System.out.println("!!!!" + resPath);
         // Build the splash screen
         JLabel label = new JLabel(new ImageIcon(resPath + "Splash.png"));
         JLabel copyrt = new JLabel
                 ("Copyright 2013 Bowling Game", JLabel.CENTER);
         copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
         content.add(label, BorderLayout.CENTER);
         content.add(copyrt, BorderLayout.SOUTH);
         
         // Display it
         setVisible(true);

         // Wait a little while, maybe while loading resources
         run();

         
         
     }

	@Override
	public void run() {
		 try { Thread.sleep(duration); } catch (Exception e) {}
		 setVisible(false);   
		// TODO Auto-generated method stub
		
	}
     

    //run Method. This is the area where we can adjust the performance of our progress bar.  
    	
     
    
    // A simple little method to show a title screen in the center
    // of the screen for the amount of time given in the constructor
   
    
    }


