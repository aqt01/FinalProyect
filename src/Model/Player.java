package Model;

import java.util.ArrayList;
import java.util.List;

public class Player
{
	private List<Shot> Shots;
	private int Frame_index;
	private int Index;
	
	public Player()
	{
		Shots = new ArrayList<Shot>();
	}
	
	public void addShot(String f, String s)
	{
		Shot shot = new Shot(f, s);
		boolean tenth;
		
		Frame_index++;
		
		tenth = (Frame_index == 10) ? true: false; 
		shot.setTenthFrame(tenth);
		
		Shots.add(shot);
		
		if(shot.isTenthFrame())
			this.calcScore();
	}
	
	public void calcScore()
	{
		Shot nextShot;
		int score = 0;
		for (int i=0; i < Shots.size(); i++)
		{	
			//if last frame
			if(i == 9) 
			{
				score += calcTenthFrame(Shots.get(i));
				Shots.get(i).setScore(String.valueOf(score));
			}
			else
			{		
				if(Shots.get(i).isSpare())
				{
					nextShot = Shots.get(i+1);
					score += 10 + Integer.valueOf(nextShot.getFirst());
				}
				//if next ball is a strike, add the next frame's first ball.
				else if( Shots.get(i).isStrike() && (i+1)!=9)
				{
					nextShot = Shots.get(i+1);
					score += 10;
					if (nextShot.isStrike())					
					{	
						score += 10;
						nextShot = Shots.get(i+2);
						score += Integer.valueOf(nextShot.getFirst());
					}
					else
						score += calcFrameScore(nextShot);
				}
				else if( Shots.get(i).isStrike() && (i+1)==9)
				{
					nextShot = Shots.get(i+1);
					score += 10;
					if (nextShot.isStrike())					
					{	
						score += 10 + Integer.valueOf(nextShot.getSecond());
					}
					score += Integer.valueOf(nextShot.getFirst()) + Integer.valueOf(nextShot.getSecond());
				}
				else
					score += calcFrameScore(Shots.get(i));
				Shots.get(i).setScore(String.valueOf(score));
			}
		
		}		
	}
	
	public int calcTenthFrame(Shot shot)
	{
		if (shot.getSecond().equals("10"))
			return 10 + Integer.valueOf(shot.getThird());		
		else if (shot.getThird() != null && shot.getThird().equals("10"))
			return 10 + Integer.valueOf(shot.getFirst());
		else
			return Integer.valueOf(Integer.valueOf(shot.getFirst()) + Integer.valueOf(shot.getSecond()));
	}
	
	public int calcFrameScore(Shot shot)
	{
		return Integer.valueOf(Integer.valueOf(shot.getFirst()) + Integer.valueOf(shot.getSecond()));	
	}
}
