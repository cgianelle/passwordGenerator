package com.cisco.password.character;

public class AlphaNumericalSpecialCharacterGenerator extends CharacterGenerator
{
	public AlphaNumericalSpecialCharacterGenerator()
	{
		super();
	}
	
	@Override
	protected String ReplaceCharacter(String c)
	{
		int rand = r.nextInt(3);
		
		switch(rand)
		{
		case 0: return FlipAlphaCase(c);
		case 1: return GetNumeral();
		case 2: 
		default: return GetSpecial();
		}				
	}

}
