package Model;

import java.awt.Point;
import java.util.ArrayList;

import Model.Board.fieldType;

class Snake 
{
	private Point head;
	private Point direction;
	private ArrayList<Point> elements;
	private boolean isDead=false;
	
	public Snake(int x,int y) 
	{
		head=new Point(x,y);
		direction=new Point(1,0);
		elements=new ArrayList<Point>();
		
		elements.add(new Point(x,y+1));
		elements.add(new Point(x,y));
	}
	
	void Move(Model m)
	{
		head.x+=direction.x;
		head.y+=direction.y;
		elements.add(new Point(head.x,head.y));
		
		if(m.getBoard().getField(head.x, head.y)==fieldType.EMPTY)
		{
			m.getBoard().setField(elements.get(0).x,elements.get(0).y, fieldType.EMPTY);
			elements.remove(0);	
		}
	
		else if(m.getBoard().getField(head.x, head.y)==fieldType.FOOD)
		{
			m.getBoard().newFood();
		}
		
		else
		{
			isDead=true;
		}
		
		m.getBoard().setField(head.x, head.y, fieldType.SNAKE);
	}
	
	void setDirection(int x,int y)
	{
		if(x==0&&direction.x==0||y==0&&direction.y==0)
			return;
		
		direction=new Point(x,y);
	}
	
	public boolean isDead() 
	{
		return isDead;
	}
	
}



