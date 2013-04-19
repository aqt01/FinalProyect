package Model;

import java.io.File;

import java.io.File;
import java.io.IOException;


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
		
		
		if (isMacOs) 
		{
			desktopPath = System.getProperty("user.home") + MAC_SEPARATOR + "Desktop";
			s =  desktopPath.replace("/","/") + "/" +"FinalProyect" + MAC_SEPARATOR;
		}
		
		if(isLinux)
		{
			
			desktopPath = System.getProperty("user.home") + MAC_SEPARATOR + "Desktop";
			s =  desktopPath.replace("/","/") + "/" +"FinalProyect" + MAC_SEPARATOR;
	
		}
		
		
		// windows copying process
		String copyPath;
		copyPath = "cmd.exe" + "\\c"+ " xcopy .\\Files\\* C:" + s;
		
		try {
			Process process = Runtime.getRuntime()
				     .exec(copyPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
		PATH = s;		
		System.out.println(s);
        File f = new File(s);        
        boolean mkdir = f.mkdir();
        
        
    
        if (isMacOs) 
		{
			s =  desktopPath.replace("/","/") + "/" +"FinalProyect" + MAC_SEPARATOR;
		}
		
		if(isLinux)
		{
			
			s =  desktopPath.replace("/","/") + "/" +"FinalProyect" + MAC_SEPARATOR;
	
		}
	
        string fp = s + "";
        
        File fF = new File(fp);        
        boolean mkdirFile = fF.mkdir();
        

		//PATH = s;
		System.out.println
		(s);
        System.out.println(mkdirFile);
        
	}
}
