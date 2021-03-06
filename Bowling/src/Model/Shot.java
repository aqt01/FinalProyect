package Model;

public class Shot 
{
	private String First;
	private String Second;
	private String Third;
	private String Score;
	private int Frame_index;
	private boolean isStrike;
	private boolean isSpare;
	private boolean TenthFrame;
	private boolean isShowing;
	private boolean isNormal;
	
	public Shot(String First, String Second)
	{
		this.setFirst(First);
		this.setSecond(Second);
		// must be fixed
		System.out.println(First);
		System.out.println(Second);
		this.isSpare = ((Integer.valueOf(First) + Integer.valueOf(Second)) == 9);
		this.isSpare = (First.equals("10"));
		this.isShowing = false;
		this.isNormal = !(this.isSpare || this.isStrike);
	}
	
	public Shot(String First, String Second, String Third)
	{
		this.setFirst(First);
		this.setSecond(Second);
		this.setThird(Third);
		this.isSpare = ((Integer.valueOf(First) + Integer.valueOf(Second)) == 9);
		this.isSpare = (First.equals("10"));
		this.isShowing = false;
		this.isNormal = !(this.isSpare || this.isStrike);
	}
	
	public String getFirst() 
	{
		return this.First;
	}

	public void setFirst(String first) 
	{
		this.First = first;
	}

	public String getSecond() 
	{
		return this.Second;
	}

	public void setSecond(String second) 
	{
		this.Second = second;
	}

	public String getThird() 
	{
		return this.Third;
	}

	public void setThird(String third) 
	{
		this.Third = third;
	}

	public String getScore() 
	{
		return this.Score;
	}

	public void setScore(String score) 
	{
		this.Score = score;
	}

	public boolean isStrike() 
	{
		return this.isStrike;
	}

	public void setStrike(boolean isStrike) 
	{
		this.isStrike = isStrike;
	}

	public boolean isSpare() 
	{
		return this.isSpare;
	}

	public void setSpare(boolean isSpare) 
	{
		this.isSpare = isSpare;
	}

	public boolean isTenthFrame() 
	{
		return this.TenthFrame;
	}

	public void setTenthFrame(boolean tenthFrame) 
	{
		this.TenthFrame = tenthFrame;
	}

	public boolean isNormal() 
	{
		return this.isNormal;
	}

	public void setNormal(boolean isNormal) 
	{
		this.isNormal = isNormal;
	}

	public boolean isShowing() 
	{
		return this.isShowing;
	}

	public void setShowing(boolean isShowing) 
	{
		this.isShowing = isShowing;
	}

	public int getFrame_index() {
		return Frame_index;
	}

	public void setFrame_index(int frame_index) {
		Frame_index = frame_index;
	}

}
