package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Model;
import View.View;

public class Controler implements KeyListener 
{
	Model model;
	View view;
	boolean gameOverShown=false;
	boolean gamePaused=true;
	void mainLoop()  
	{
		while(true)
		{
			if(!model.isGameOver())
			{
				view.drawBoard(model.getBoard());
				if(!gamePaused)
					model.Update();
				
			}
			else
			{
				if(!gameOverShown)
				{
					view.showGameOver();
					gameOverShown=true;
				
				}
			}
			try 
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException exception) 
			{
				exception.printStackTrace();
			}
		}
		
	}
	
	public void Start()
	{
		model=new Model();
		view=new View(this);
		view.setOnGameOver(new NewGameButtonListener(this));
		mainLoop();
	}
	
	public void Restart()    
	{
		model=new Model();
		gameOverShown=false;
		gamePaused=true;		
	}
	
	@Override
	public void keyPressed(KeyEvent ke) 
	{   
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_UP:
			case KeyEvent.VK_W:	
				model.up();
				break;
				
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_D:	
				model.right();
				break;
				
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_S:	
				model.down();
				break;
				
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_A:	
				model.left();
				break;
		}	
		gamePaused=false;	
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
	}
	@Override
	public void keyTyped(KeyEvent arg0) {	
	}
}


