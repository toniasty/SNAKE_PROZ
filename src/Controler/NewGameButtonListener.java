package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NewGameButtonListener implements ActionListener
{

	private Controler controler;
	NewGameButtonListener(Controler controler) 
	{
		this.controler=controler;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		controler.Restart();
	}	
}
