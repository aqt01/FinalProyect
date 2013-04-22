package Model;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;


public class  ResorseManager 
{
	private static String WINDOWS_SEPARATOR = "\\";
	private static String MAC_SEPARATOR = "/";
	public String PATH; // path to FinalProyect folder
	public String pathFiles; // path to FinalProyect Files
	public String pathRes; // path to resFiles
	
	public ResorseManager()
	{
		this.InitManager();
	}
	
	public void InitManager()
	{
		String desktopPath;        
        String s;
		String osName = System.getProperty("os.name").toLowerCase();
		boolean isMacOs = osName.startsWith("mac os x");				
		boolean  isLinux = (osName.indexOf("nix") >= 0 || osName.indexOf("nux") >= 0 || osName.indexOf("aix") > 0);
		
		
		if (isMacOs || isLinux) 
		{
			desktopPath = System.getProperty("user.home") + MAC_SEPARATOR + "Desktop";
			s =  desktopPath.replace("/","/") + "/" +"FinalProyect" + MAC_SEPARATOR;
			pathRes = "."+MAC_SEPARATOR + "Res" + MAC_SEPARATOR; 
		} else
		{
			desktopPath =System.getProperty("user.home") + WINDOWS_SEPARATOR +"Desktop";
	        s = desktopPath.replace(WINDOWS_SEPARATOR, WINDOWS_SEPARATOR) + WINDOWS_SEPARATOR + "FinalProyect" +WINDOWS_SEPARATOR ;	        
	        pathRes = "."+MAC_SEPARATOR + "Res" + MAC_SEPARATOR;
		}
		this.PATH = s;		
		// print the path
		System.out.println("Project Folder path: ");
		System.out.println(s);
        File f = new File(s); // creates the folder        
        boolean mkdir = f.mkdir();
        
         // Path w/ resources of the proyect
    	
        
        // For creating folder w/ files for the proyject resources
		if(isLinux || isMacOs)
		{
			this.pathFiles = s + "Files" + MAC_SEPARATOR;
	
		} else
		{

			this.pathFiles = s + "Files" + WINDOWS_SEPARATOR;			
		}
	                
        File fileFolder = new File(this.pathFiles);        
        boolean mkdirFile = fileFolder.mkdir();
        
        
        
        // IF is in windows
        
        
    	// windows copying process
		if(isLinux || isMacOs)
		{			
			try {
				
				//Process process = Runtime.getRuntime()
					//	.exec("cp ./Files/* " + this.pathFiles);
				String[] command = new String[] {"bash", "-c", "cp -R "  + "./\"Files/\"ArchivoPrueba.txt  \"" + this.pathFiles + "/\""};
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
        	String comm = "cmd.exe /c copy .\\Files\\ArchivoPrueba.txt " + this.pathFiles;
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
		System.out.println(this.pathFiles);
        System.out.println(mkdirFile);
        
	}
	
	public String getResPath() 
	{
		return pathRes;
	}
	
	public String getFilePath() {
		return this.pathFiles;
	}
	
	public String getPath() {
		return this.PATH;
	}
	
}
