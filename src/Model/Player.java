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
		this.Frame_index = 0;
	}
	
	public void addShot(String f, String s)
	{
		Shot shot = new Shot(f, s);
		Shots.get(Frame_index).setFrame_index(Frame_index);
		Frame_index++;
		
		shot.setTenthFrame(Frame_index == 10);
		
		Shots.add(shot);
		
		if(shot.isTenthFrame())
			this.calcScore();
	}
	
	public void addShot(String f, String s, String t)
	{
		Shot shot = new Shot(f, s, t);
		Shots.get(Frame_index).setFrame_index(Frame_index);
		Frame_index++;
		
		shot.setTenthFrame(Frame_index == 10);
		
		Shots.add(shot);
		
		if(shot.isTenthFrame())
			this.calcScore();
	}
	
	private void calcScore()
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
				else if( Shots.get(i).isStrike() && (i+1) != 9)
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
				else if( Shots.get(i).isStrike() && (i+1) == 9)
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
	
	private int calcTenthFrame(Shot shot)
	{
		if (shot.getSecond().equals("10"))
			return 10 + Integer.valueOf(shot.getThird());		
		else if (shot.getThird() != null && shot.getThird().equals("10"))
			return 10 + Integer.valueOf(shot.getFirst());
		else
			return Integer.valueOf(Integer.valueOf(shot.getFirst()) + Integer.valueOf(shot.getSecond()));
	}
	
	private int calcFrameScore(Shot shot)
	{
		return Integer.valueOf(Integer.valueOf(shot.getFirst()) + Integer.valueOf(shot.getSecond()));	
	}
	
	public void Refresh_Scores()
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
				else if( Shots.get(i).isStrike() && (i+1) != 9)
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
				else if( Shots.get(i).isStrike() && (i+1) == 9)
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
	
	public Shot getScoreFromIdx(int idx)
	{
		return Shots.get(idx);
	}
	
	public Shot netxShot()
	{
		if(Index < Shots.size())
			Index++;
		return Shots.get(Index-1);
	}
	
	public Shot previousShot()
	{
		if(Index > 1)
			Index--;
		return Shots.get(Index-1);
	}
	
	public List<Shot> getScore()
	{
		return Shots;
	}
	
	public boolean isStrike(int idx)
	{
		return Shots.get(idx).isStrike();
	}
	
	public boolean isSpare(int idx)
	{
		return Shots.get(idx).isSpare();
	}
}
