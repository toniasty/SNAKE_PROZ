package Model;

public class Model 
{
	private Board board;
	private Snake snake;
	
	public Model()
	{
		board=new Board();
		snake=new Snake(10,10);
		snake.Move(this);
		board.newFood();
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public boolean isGameOver()
	{
		return snake.isDead();
	}
	
	public void Update()
	{
		if(!snake.isDead())
			snake.Move(this);
	}
	
	public void up()
	{
		snake.setDirection(0, -1);
	}
	
	public void down()
	{
		snake.setDirection(0, 1);
	}
	
	public void left()
	{
		snake.setDirection( -1,0);
	}
	
	public void right()
	{
		snake.setDirection(1,0);
	}

}


