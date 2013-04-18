package Model;

import java.io.File;

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
        String s = "\"" + desktopPath.replace(WINDOWS_SEPARATOR, WINDOWS_SEPARATOR + WINDOWS_SEPARATOR) + (WINDOWS_SEPARATOR + WINDOWS_SEPARATOR) + "satis" + "\"";
        
		String osName = System.getProperty("os.name").toLowerCase();
		boolean isMacOs = osName.startsWith("mac os x");
		
		if (isMacOs) 
		{
			desktopPath = System.getProperty("user.home") + MAC_SEPARATOR + "Desktop";
			s = MAC_SEPARATOR + desktopPath.replace("//","////") + "////" +"FinalProyect" + MAC_SEPARATOR;
		}
        
		System.out.print(s);
        File f = new File(s);
        boolean mkdir = f.mkdir();
        System.out.println(mkdir);
	}
}
