package View;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controler.Controler;

import Model.Board;

public class View 
{
	SnakePanel panel;
	JButton start;
	JFrame frame;
	JLabel score,highScore;
	public View(Controler c) 
	{
		frame = new JFrame("Snake");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel=new SnakePanel();

		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));

		start=new JButton("New Game");
		
		JPanel innerpanel=new JPanel();
		innerpanel.setLayout(new BoxLayout(innerpanel,BoxLayout.X_AXIS));
		innerpanel.add(start);
		
		frame.getContentPane().add(innerpanel);
		frame.getContentPane().add(panel);
		
		frame.setSize(406,450);
		frame.setResizable(false);

		frame.setVisible(true);
		frame.addKeyListener(c);
		frame.getContentPane().addKeyListener(c);
		start.addKeyListener(c);
	}
	
	public void drawBoard(Board board) 
	{
		panel.boardToDraw=board;
		panel.repaint();
	}
	
	public void showGameOver() 
	{
		JOptionPane.showMessageDialog(frame, "GAME OVER");	
	}
	
	public void setOnGameOver(ActionListener restartGameButtonListener) 
	{
		start.addActionListener(restartGameButtonListener);		
	}
}
