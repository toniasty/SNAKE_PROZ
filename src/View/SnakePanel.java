package View;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Model.Board;

class SnakePanel extends JPanel 
{
	Board boardToDraw;
	int fieldWidth=20,fieldHeight=20;
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		if(boardToDraw!=null)
		{
			for(int i=0;i<boardToDraw.getHeigth();i++)
			{
				for(int j=0;j<boardToDraw.getWidth();j++)
				{
					switch(boardToDraw.getField(j, i))
					{
						case WALL:
							g.setColor(Color.gray);
							break;
						case EMPTY:
							g.setColor(Color.black);
							break;
						case SNAKE:
							g.setColor(Color.green);
							break;
						case FOOD:
							g.setColor(Color.red);
							break;
					}
					g.fillRect(j*fieldWidth, i*fieldHeight, fieldWidth, fieldHeight);
				}
			}
		}
	}
}