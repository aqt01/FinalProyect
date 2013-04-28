package Model;

/**/

public final class Input_handler 
{

	//public static int MAX_LIST_SIZE = 12;
	//public static int MIN_LIST_SIZE = 11;
	public static int MAX_LIST_SIZE = 8;
	public static int MIN_LIST_SIZE = 5;
	public static int MAX_LIST_VALUE = 11;
	public static int MIN_LIST_VALUE = 10;
	private static boolean list1;
	private static boolean list2;
	
	public Input_handler() 
	{
		list1 = list2 = false;
	}
	public static boolean check_lists_values(Player Player, Player Player0)
	{
		list1 = list2 = false;
		list1 = (Player0.getScore().size() >= MIN_LIST_VALUE && Player0.getScore().size() <= MAX_LIST_VALUE);
		list2 = (Player.getScore().size() >= MIN_LIST_VALUE && Player.getScore().size() <= MAX_LIST_VALUE);
		System.out.println("List1.player1: " + MAX_LIST_SIZE );
		System.out.println("List1.player2: " + MIN_LIST_SIZE  );
		System.out.println("List2: " + list2);
		
		return list1 && list2;
	}
	public static boolean check_lists_sizes(Player Player, Player Player0)
	{
		list1 = list2 = false;
		
		for(int i=0;i<Player0.getScore().size();i++)
		{
			list1 = (Player0.getScoreFromIdx(i).getFirst() != null && Player0.getScoreFromIdx(i).getSecond() != null);
			list1 = list1 && (Integer.valueOf(Player0.getScoreFromIdx(i).getFirst()) <= MAX_LIST_SIZE && Integer.valueOf(Player0.getScoreFromIdx(i).getFirst()) >= MIN_LIST_SIZE);;;
			list1 = list1 && (Integer.valueOf(Player0.getScoreFromIdx(i).getSecond()) <= MAX_LIST_SIZE && Integer.valueOf(Player0.getScoreFromIdx(i).getSecond()) >= MIN_LIST_SIZE);
		}
		
		for(int i=0;i<Player.getScore().size();i++)
		{
			list2 = (Player.getScoreFromIdx(i).getFirst() != null && Player.getScoreFromIdx(i).getSecond() != null);
			list2 = list2 && (Integer.valueOf(Player.getScoreFromIdx(i).getFirst()) <= MAX_LIST_SIZE && Integer.valueOf(Player.getScoreFromIdx(i).getFirst()) >= MIN_LIST_SIZE);;;
			list2 = list2 && (Integer.valueOf(Player.getScoreFromIdx(i).getSecond()) <= MAX_LIST_SIZE && Integer.valueOf(Player.getScoreFromIdx(i).getSecond()) >= MIN_LIST_SIZE);
		}
		
		System.out.println("List1.player1: " + Player0.getScore().size() );
		System.out.println("List1.player2: " + Player.getScore().size() );
		
		
		return list1 && list2;
	}
}
