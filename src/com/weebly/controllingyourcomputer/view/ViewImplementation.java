/**
 * 
 */
package com.weebly.controllingyourcomputer.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.weebly.controllingyourcomputer.controller.Controller;
import com.weebly.controllingyourcomputer.controller.ControllerEventArgs;
import com.weebly.controllingyourcomputer.controller.ControllerEventType;

/**
 * The implementation of the view to be used in the final application (in other
 * words, not a test view implementation).
 * 
 * @author Mihir Kasmalkar
 *
 */
public class ViewImplementation implements View
{
	private Controller controller;

	private JTextArea textArea;
	
	@Override
	public View setController(Controller controller)
	{
		this.controller = controller;
		return this;
	}
	
	@Override
	public void start()
	{
		JFrame frame = new JFrame("Keyboard Code");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		
		JPanel editorPanel = new JPanel();
		
	    textArea = new JTextArea(50, 30);
		textArea.addKeyListener(new ControllerKeyListener());
	
		editorPanel.add(textArea);
		
		mainPanel.add(editorPanel);
		
		JPanel filesystemPanel = new JPanel();

		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		
		ControllerEventArgs args = new ControllerEventArgs();
		args.setEventType(ControllerEventType.STARTED);
		controller.RegisterEvent(args);
	}
	
	class ControllerKeyListener implements KeyListener
	{

		@Override
		public void keyTyped(KeyEvent e)
		{
			
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			System.out.println("Typed");
			ControllerEventArgs args = new ControllerEventArgs();
			args.setEventType(ControllerEventType.KEYPRESSED);
			args.setPressedKey(e.getKeyCode());
			args.setWidget(textArea);
			controller.RegisterEvent(args);
		}

		@Override
		public void keyReleased(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
}
