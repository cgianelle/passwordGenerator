package com.cisco.password;

import com.cisco.password.character.CharacterGenerator;
import com.cisco.password.character.CharacterGeneratorFactory;

public class RandomPasswordGenerator implements PasswordGeneratorInterface
{
	private int length         		=	0;
	private boolean useNumbers 		= false;
	private boolean useSpecChars	= false;
	private CharacterGenerator cg;
	
	public RandomPasswordGenerator(int length, boolean useNumbers, boolean useSpecChars)
	{
		this.length       = length;
		this.useNumbers   = useNumbers;
		this.useSpecChars = useSpecChars;
		cg = CharacterGeneratorFactory.CreateCharacterGenerator(this.useNumbers, this.useSpecChars);
	}
	
	public String GeneratePassword()
	{
		String password = "";
		while (length > 0)
		{
			password = password + cg.GenerateCharacter();
			length--;
		}
		return password;
	}
	
}

