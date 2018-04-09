package com.cisco.password.character;

import java.util.Date;
import java.util.Random;

public abstract class CharacterGenerator
{	
	public Random r;
	public CharacterGenerator()
	{
		Date d = new Date();
		r = new Random(d.getTime());
	}
	
	public String GenerateCharacter()
	{
		int rand = r.nextInt(26);
		
		return ReplaceCharacter(alpha.substring(rand, rand+1));	
	}
	
	protected String FlipAlphaCase(String c)
	{
		int rand = r.nextInt(2);
		
		switch(rand)
		{
		case 0: return c.toUpperCase();
		case 1: return c.toLowerCase();
		default: return c.toLowerCase();		//--This should never be called as I am moding by 2 (results should be 0 or 1) - this is to get rid of error
		}		
	}
	
	protected String GetNumeral()
	{
		int rand = r.nextInt(10);
		return numerical.substring(rand, rand+1);		
	}
	
	protected String GetSpecial()
	{
		int len = special.length();
		int rand = r.nextInt(len);
		return special.substring(rand, rand+1);
	}
	
	//--Subclasses must implement this method
	protected abstract String ReplaceCharacter(String c);
	
	protected String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	protected String numerical = "0123456789";
	protected String special = "!$%^&*()_+|~-=\\`{}[]:;'\"<>?,/";
}
