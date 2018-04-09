package com.cisco.password.character;

public class AlphaSpecialCharacterGenerator extends CharacterGenerator
{

	public AlphaSpecialCharacterGenerator()
	{
		super();
	}
	
	@Override
	protected String ReplaceCharacter(String c)
	{
		int rand = r.nextInt(2);
		
		switch(rand)
		{
		case 0: return FlipAlphaCase(c);
		case 1: 
		default: return GetSpecial();
		}				
		
	}

}
