package com.cisco.graphics;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;

import com.cisco.password.CiscoPasswordGenerator;
import com.cisco.password.RandomPasswordGenerator;

import java.awt.Insets;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Font;

public class PasswordPanel extends JPanel
{
	/**
	 * Auto generated serial VUID
	 */
	private static final long serialVersionUID = -2735305815839050391L;
	
	private JTextField textField;
	private JComboBox comboBox;
	private JCheckBox useNumbersChkBox;
	private JCheckBox useSpecCharsChkBox;
	private JRadioButton rdbtnUseCiscoStandards;
	public PasswordPanel()
	{		
		ActionListener generate = new GeneratePasswordAction();
		ActionListener ciscoStandards = new CiscoStandardsAction();
		
		//--Specify the gridbag layout
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		//--Create label
		JLabel lblNewLabel = new JLabel("Password Length");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		comboBox = new JComboBox(new String[] {"10","11","12","14","16","18","20","22","24"});
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.gridheight = 1;
		add(comboBox, gbc_comboBox);
		
		
		JButton btnNewButton = new JButton("Generate Password");
		btnNewButton.addActionListener(generate);
		
		rdbtnUseCiscoStandards = new JRadioButton("Use Cisco Standards?");
		rdbtnUseCiscoStandards.addActionListener(ciscoStandards);
		GridBagConstraints gbc_rdbtnUseCiscoStandards = new GridBagConstraints();
		gbc_rdbtnUseCiscoStandards.anchor = GridBagConstraints.WEST;
		gbc_rdbtnUseCiscoStandards.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnUseCiscoStandards.gridx = 1;
		gbc_rdbtnUseCiscoStandards.gridy = 1;
		add(rdbtnUseCiscoStandards, gbc_rdbtnUseCiscoStandards);
		
		useNumbersChkBox = new JCheckBox("Use numbers in password?");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 2;
		add(useNumbersChkBox, gbc_chckbxNewCheckBox);
		
		useSpecCharsChkBox = new JCheckBox("Use special characters?");
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1.gridx = 1;
		gbc_chckbxNewCheckBox_1.gridy = 3;
		add(useSpecCharsChkBox, gbc_chckbxNewCheckBox_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		gbc_btnNewButton.gridheight = 1;
		gbc_btnNewButton.gridwidth  = 3;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		add(btnNewButton, gbc_btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Liberation Mono", Font.BOLD, 18));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 5;
		gbc_textField.gridheight = 4;
		gbc_textField.gridwidth  = 3;
		gbc_textField.fill = GridBagConstraints.BOTH;
		add(textField, gbc_textField);
		textField.setColumns(10);
	}
	
	//--Handle the button press to create the password
	private class GeneratePasswordAction implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			String length      = (String)comboBox.getSelectedItem();
			int pLength        = Integer.parseInt(length);
			boolean numbers    = false;
			boolean characters = false;
			boolean cisco      = rdbtnUseCiscoStandards.isSelected();
			String password    = "";
			
			//--If the cisco radio button not selected use the checkboxes
			if (!cisco)
			{
				numbers    = useNumbersChkBox.isSelected();
				characters = useSpecCharsChkBox.isSelected();
				RandomPasswordGenerator pg = new RandomPasswordGenerator(pLength, numbers,characters);
				password = pg.GeneratePassword();

			}
			else
			{//--If radio button true, then set numbers and characters to true
				numbers    = true;
				characters = true;
				CiscoPasswordGenerator cpg = new CiscoPasswordGenerator(pLength);
				password = cpg.GeneratePassword();
			}
			
			textField.setHorizontalAlignment(JTextField.CENTER);
			textField.setText(password);
		}
		
	}
	
	private class CiscoStandardsAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			boolean ciscoStandards = rdbtnUseCiscoStandards.isSelected();
			
			//--If the cisco standards radio button is selected, disable the other check boxes
			if (ciscoStandards)
			{
				useNumbersChkBox.setEnabled(false);
				useSpecCharsChkBox.setEnabled(false);
			}
			else //if disabled, then reenable the checkboxes
			{
				useNumbersChkBox.setEnabled(true);
				useSpecCharsChkBox.setEnabled(true);				
			}
		}
		
	}
}

