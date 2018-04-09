package com.cisco.graphics;

import javax.swing.JFrame;

public class PasswordFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7385993631535558424L;

	public PasswordFrame()
	{
//		Toolkit kit = Toolkit.getDefaultToolkit();
//		Dimension screenSize = kit.getScreenSize();
//		setSize(screenSize.width / 2 , screenSize.height / 2);		
		setTitle("Password Generation Tool");
		setLocationByPlatform(true);
		PasswordPanel passwordPanel = new PasswordPanel();
		add(passwordPanel);
		pack();
	}
}

