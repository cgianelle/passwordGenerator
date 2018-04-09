package com.cisco.password.character;

public class AlphaNumericalCharacterGenerator extends CharacterGenerator
{

	public AlphaNumericalCharacterGenerator()
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
		default: return GetNumeral();
		}				
	}
	
	

}
