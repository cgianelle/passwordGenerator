package com.cisco.password.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cisco.password.character.AlphaSpecialCharacterGenerator;

public class AlphaSpecialCharacterGeneratorTest
{

	@Test
	public void test()
	{
		int length = 100;
		String a = "";
		AlphaSpecialCharacterGenerator ascg = new AlphaSpecialCharacterGenerator();
		
		while (length > 0)
		{
			a = a + ascg.GenerateCharacter();
			length--;
		}
		
		System.out.println(a);
				
		if (a.compareTo("") == 0)
			fail("Unable to generate character string");
		
		if (a.length() != 100)
			fail("Unable to generate appropriate length string");

		assertTrue(a,true);

	}

}
