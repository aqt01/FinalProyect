package Model;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;


public class ResorseManager 
{
	private static String WINDOWS_SEPARATOR = "\\";
	private static String MAC_SEPARATOR = "/";
	public String PATH;
	
	public ResorseManager()
	{
		InitManager();
	}
	
	private void InitManager()
	{
		String desktopPath =System.getProperty("user.home") + WINDOWS_SEPARATOR +"Desktop";
        String s = desktopPath.replace(WINDOWS_SEPARATOR, WINDOWS_SEPARATOR) + WINDOWS_SEPARATOR + "FinalProyect" +WINDOWS_SEPARATOR ;
        
		String osName = System.getProperty("os.name").toLowerCase();
		boolean isMacOs = osName.startsWith("mac os x");				
		boolean  isLinux = (osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0 || osName.indexOf("aix") > 0);
		
		
		if (isMacOs || isLinux) 
		{
			desktopPath = System.getProperty("user.home") + MAC_SEPARATOR + "Desktop";
			s =  desktopPath.replace("/","/") + "/" +"FinalProyect" + MAC_SEPARATOR;
		}						
	    
		PATH = s;		
		// print the path
		System.out.println("Project Folder path: ");
		System.out.println(s);
        File f = new File(s); // creates the folder        
        boolean mkdir = f.mkdir();
        
        String fp = null ; // Path w/ resources of the proyect
    	
        
        // For creating folder w/ files for the proyject resources
		if(isLinux || isMacOs)
		{
			fp = s + "Files" + MAC_SEPARATOR;
	
		} else
		{

			fp = s + "Files" + WINDOWS_SEPARATOR;			
		}
	                
        File fileFolder = new File(fp);        
        boolean mkdirFile = fileFolder.mkdir();
        
        
        
        // IF is in windows
        
        
    	// windows copying process
		if(isLinux || isMacOs)
		{			
			try {
				
				//Process process = Runtime.getRuntime()
					//	.exec("cp ./Files/* " + fp);
				String[] command = new String[] {"bash", "-c", "cp -R "  + "./\"Files/\"* \"" + fp + "/\""};
				Process process = Runtime.getRuntime()
						.exec(command);								
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// Copying process for windows
		else {
        try {        	
        	String comm = "cmd.exe /c copy .\\Files\\* " + fp;
       	Process process = Runtime.getRuntime()
					.exec(comm);			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		}          
		String mess;
		
		if(mkdir && mkdirFile)
			mess = "Folder already created or didn't exists";
		else
			mess = "Folder w/ Project Files path: ";
		
		JOptionPane.showMessageDialog(null, mess +s);
		

		System.out.println("Project Files Path: ");
		System.out.println(fp);
        System.out.println(mkdirFile);
        
	}
}
