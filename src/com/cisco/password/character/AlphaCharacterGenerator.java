package com.cisco.password.character;

public class AlphaCharacterGenerator extends CharacterGenerator
{
	public AlphaCharacterGenerator()
	{
		super();
	}
	
	@Override
	protected String ReplaceCharacter(String c)
	{
		// TODO Auto-generated method stub
		return FlipAlphaCase(c);
	}
}
