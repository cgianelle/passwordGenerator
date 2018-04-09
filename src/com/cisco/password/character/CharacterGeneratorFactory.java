package com.cisco.password.character;

public class CharacterGeneratorFactory
{
	public static CharacterGenerator CreateCharacterGenerator(boolean numerals, boolean special)
	{
		if (!numerals && !special) return new AlphaCharacterGenerator();
		else if (!numerals && special)  return new AlphaSpecialCharacterGenerator();
		else if (numerals && !special)  return new AlphaNumericalCharacterGenerator();
		else return new AlphaNumericalSpecialCharacterGenerator();		
	}
}
