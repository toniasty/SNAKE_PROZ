package Model;

public class Board 
{
	public enum fieldType {EMPTY,SNAKE,FOOD,WALL};
	private int width=20;
	private int heigth=20;
	private fieldType[][] board;
	Board() 
	{
		board=new fieldType[width][heigth];
		for(int i=0;i<width;i++)
		{
			for(int j=0;j<heigth;j++)
			{
				if(i==0||i==width-1||j==0||j==heigth-1)
					board[i][j]=fieldType.WALL;
				else
					board[i][j]=fieldType.EMPTY;
			}
		}
	}
	
	public fieldType getField(int x,int y)
	{
		return board[x][y];
	}
	
	void setField(int x,int y,fieldType field)
	{
		board[x][y]=field;
	}
	
	public int getWidth() 
	{
		return width;
	}
	
	public int getHeigth() 
	{
		return heigth;
	}
	
	public void newFood() 
	{

		while(true)
		{
			int x=(int)(Math.random()*width);
			int y=(int)(Math.random()*heigth);
			
			if(board[x][y]==fieldType.EMPTY)
			{
				board[x][y]=fieldType.FOOD;
				break;
			}
		}
	}
	
}
