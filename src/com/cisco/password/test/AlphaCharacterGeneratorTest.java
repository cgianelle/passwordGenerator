package com.cisco.password.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cisco.password.character.AlphaCharacterGenerator;


public class AlphaCharacterGeneratorTest
{

	@Test
	public void test()
	{
		int length = 100;
		String a = "";
		AlphaCharacterGenerator acg = new AlphaCharacterGenerator();
		
		while (length > 0)
		{
			a = a + acg.GenerateCharacter();
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
