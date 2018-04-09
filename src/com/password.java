package com;

import java.awt.*;
import javax.swing.*;

import com.cisco.graphics.PasswordFrame;

public class password 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				PasswordFrame frame = new PasswordFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});

	}

}
