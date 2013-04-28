package Test;

import java.io.IOException;
import java.util.List;

import Model.File_Reader;
import Model.Player;

public class ModelControllerTest 
{
	private File_Reader Reader;
	private Player Player;
	private Player Player0;
	private String fileP; //
	public ModelControllerTest()
	{
		Reader = new File_Reader();
	}
	
	public void InitController(String file)
	{	
		setFile(file);
		try {
			initializePlayers(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrinTests();
	}
	
	public void initializePlayers(String file) throws IOException
	{
		Reader.setFile(file);
		List<Player> P = this.Reader.Read_Input();
		this.Player0 = P.get(0);
		this.Player = P.get(1);
	}
	
	void setFile(String file)
	{
		this.fileP = file;
		Reader.setFile(file);
	}
	
	public String getFilePath() {
		return this.fileP;
	} 
	
	public void PrinTests() 
	{	
		System.out.println("Player0: ");
		System.out.println("____________");
		this.printEntireList(0);
		System.out.println("Size: " + this.Player0.getScore().size());
		System.out.println("____________");
		System.out.println("____________");
		System.out.println("Player: ");
		System.out.println("____________");
		this.printEntireList(1);
		System.out.println("Size: " + this.Player.getScore().size());
	}
	
	public Player getPlayer(int idx)
	{
		return idx == 1 ? Player : Player0;
	}
	
	public void printEntireList(int idx)
	{
		Player temp = getPlayer(idx);
		
		for(int i=0;i<temp.getScore().size();i++)
		{
				System.out.println(i + "-First : " + temp.getScoreFromIdx(i).getFirst());
				System.out.println(i + "-Second : " + temp.getScoreFromIdx(i).getSecond());
				System.out.println(i + "-Third : " + temp.getScoreFromIdx(i).getThird() + " total by now: " + temp.getScoreFromIdx(i).getScore());
		}
	}
}
