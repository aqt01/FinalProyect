package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class LogClass {
	
	private String pth;
	private File file;
	private int times;
	Date dt = new Date();
	
	
	public LogClass(){
		pth = getDayOfMonth(dt) + "-" + dt.getMonth() + "-" + (dt.getYear() + 1900) + ", " + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + ".log";
		
		file = new File(pth);
		
		if(!fileExist()){
			createFile();
			times++;
		}
	}
	
	private boolean fileExist() {
		
		if(file.exists())
			return true;
		
		return false;
	}
	
	private void createFile(){
		
		try{
			
			file.createNewFile();
			
		}catch(Exception e){
			System.err.println(e);
		}
		
	}
	
	private int getDayOfMonth(Date actualD){
		Calendar cal = Calendar.getInstance();
		cal.setTime(actualD);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public void Log(String msg){
		//Date dt = new Date();
		
		try{
			FileWriter fwriter = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(fwriter);
			
			if(times == 0){
				
				writer.newLine();				
				writer.newLine();
				writer.append("***********************^*********************");				
				writer.newLine();
				writer.append("[date, hour]: Notification");
				writer.newLine();
				writer.append("***********************^*********************");			
				writer.newLine();
				writer.append("[ " + getDayOfMonth(dt) + "-" + dt.getMonth() + "-" + (dt.getYear() + 1900) + ", " + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " ] ");
				writer.append(": ");
				writer.append(msg);				
			}
			else {
				writer.append("[ " + getDayOfMonth(dt) + "-" + (dt.getMonth() + 1) + "-" + (dt.getYear() + 1900) + ", " + dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds() + " ] ");
				writer.append("-> ");
				writer.append(msg);
				writer.newLine();
			}
			
			writer.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		times = 100;
	}

}

