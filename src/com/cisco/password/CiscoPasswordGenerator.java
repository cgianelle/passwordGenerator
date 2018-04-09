package com.cisco.password;

import com.cisco.password.character.CharacterGenerator;
import com.cisco.password.character.CharacterGeneratorFactory;

public class CiscoPasswordGenerator implements PasswordGeneratorInterface
{
	private int passwordLength;
	private CharacterGenerator cg;
	
	/*
	 * According to wwwin.cisco.com/infosec/guidelines/passwordguide.shtml
	 * the minimum number of alphanumeric characters is 8
	 */
	private static final int ALPHA_NUMERIC_MIN = 8;
	
	public CiscoPasswordGenerator(int length)
	{
		this.passwordLength = length;
		this.cg = CharacterGeneratorFactory.CreateCharacterGenerator(true,true);
	}
	
	@Override
	public String GeneratePassword()
	{
		String password = "";
		do
		{
			password = GenerateCiscoPassword();
		}
		while(!ValidateCiscoPassword(password));
		
		return password;
	}
	
	private String GenerateCiscoPassword()
	{
		int length = passwordLength;
		String password = "";
		
		while (length > 0)
		{
			password = password + cg.GenerateCharacter();
			length--;
		}
		
		return password;
	}

	
	private boolean ValidateCiscoPassword(String password)
	{
		int length = password.length();
		int alphaNumericCount = 0;
		boolean lowerCase = false;
		boolean upperCase = false;
		boolean numbers   = false;
		boolean special   = false;
		
		char characters[] = password.toCharArray();
		
		for (int i=0; i<length; i++)
		{
			//--check for Upper Case Letters
			if (characters[i] >= 65 && characters[i] <= 90) 
			{
				upperCase = true;
				alphaNumericCount++;
				continue;
			}
			//--check for lower case letters
			if (characters[i] >= 97 && characters[i] <= 122)
			{
				
				lowerCase = true;
				alphaNumericCount++;
				continue;
			}
			//--check for numbers
			if (characters[i] >= 48 && characters[i] <= 57)
			{
				numbers = true;
				alphaNumericCount++;
				continue;
			}
			//--Now for the hard part, check for special characters
			if (characters[i] == 33 ||	//--!
				characters[i] == 34 ||  //--"
				(characters[i] >= 36 && characters[i] <= 47) ||
				(characters[i] >= 58 && characters[i] <= 63) ||
				(characters[i] >= 91 && characters[i] <= 96) ||
				(characters[i] >= 123 && characters[i] <= 126))
			{
				special = true;
				continue;
			}
		}
		
		/*
		 * Make sure there are upper case, lower case, numbers, special symbols, and that there are atleast 
		 * 8 alphanumeric characters.
		 */
		if (lowerCase && upperCase && numbers && special && alphaNumericCount >= ALPHA_NUMERIC_MIN) return true;
		else return false;
	}

	

}
