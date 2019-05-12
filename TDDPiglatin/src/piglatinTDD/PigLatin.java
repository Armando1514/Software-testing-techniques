package piglatinTDD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PigLatin {
	
private String phrase;

	public PigLatin(String phrase) throws piglatinTDD.InvalidPhraseException {
		
		/*Refactoring work */
		if(this.isStartsWithSpace(phrase))
		{
			throw new InvalidPhraseException("The phrase starts with space");

		}
		else if(this.isEndsWithSpace(phrase))
		{
			throw new InvalidPhraseException("The phrase ends with space");

		}
		else if(this.isSubsequentSpaces(phrase))
		{
			throw new InvalidPhraseException("Subsequent spaces in the phrase");

		}
		else if(!this.isMoreThanOneWord(phrase))
		{
			throw new InvalidPhraseException("Only one word in the phrase");

		}
		else if(!this.isLegalPhrase(phrase))
		{
			throw new InvalidPhraseException("No legal character in the phrase (only english word and space allowed)");

		}
		else if(!this.isAllTheInputUpperCase(phrase) && !this.isTitleCase(phrase))
		{
			throw new InvalidPhraseException("Only title case or upper case inputs are allowed)");
		
		}
		else
			this.setPhrase(phrase); 
		
	}

/* Implementation of Story 1, first point: "spaces are not allowed at the beginning and end of phrase */
	public Boolean isStartsWithSpace(String phrase) {
		
		if(phrase.charAt(0) == ' ')
			return true;
		else
			return false;
		
	}
	
	public Boolean isEndsWithSpace(String phrase) {
		
		int lastChar=phrase.length();
		
		if(phrase.charAt(lastChar-1) == ' ')
			return true;
		else
			return false;
		
	}
	
	/* End implementation of
	 * Story 1, first point: "spaces are not allowed at the beginning and end of phrase */

	
	public String getPhrase() {
		
		return phrase;
		
	}
	
	public void setPhrase(String string)
	{
		this.phrase = string;
	}


	/* Implementation of the Story 1, first point : "a phrase is a string made up of several words split by a 
	 * single space (i.e., multiple spaces are not allowed).
	 */
	public boolean isSubsequentSpaces(String phrase) {
		
		if(phrase.contains("  "))
			return true;
		else
			return false;
		
	}

 /*Implementation of the  Story 1, first point: "a phrase is a string made up of several words split by a single space" */
	
	public Boolean isMoreThanOneWord(String phrase) {
		/* if there is space, does it means that there are more than one word,
		 * look that we have the control if start with space, is not allowed
		 * start with a space or finish with a space
		 */
		if(phrase.contains(" "))
		
			return true;
		else
			return false;
			
	}
	
	  /* Implementation of Story 1, first point: ""a phrase can contain english letters and the space
	    * character only".
	    */
	public boolean isLegalPhrase(String phrase) {
		/* [a-zA-Z\\s]+  
		 * a-z Matches a character having a character code between the two specified characters inclusive.
		 * A-Z Matches a character having a character code between the two specified characters inclusive.
		 * \s Matches any whitespace character (spaces, tabs, line breaks).
		 * + Matches 1 or more of the preceding token.
		 */
		String regex = "[a-zA-Z\\s]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phrase);
		return matcher.matches();

	}
	
	/* Implementation of the story 1, second point, if the word starts with a vowel, the translated word
	 * is simply the input + “ay” (e.g. “apple” -> “appleay”).
	 */
	public String wordStartsWithAVowel(String phrase) {
	/* (\\b[aeiou]\\w*)
	 * \b Matches a word boundary position between a word character and non-word character (only if start for vowel)
	 * [aeiou] Match any character in the set (the vowels no case sensitive).
	 * \w Matches any word character
	 * Matches 0 or more of the preceding token.
	 * ( ) is a group, we can use the selection with $1
	 */
		  Pattern firstVowelPattern = Pattern.compile("(\\b[aeiou]\\w*)", Pattern.CASE_INSENSITIVE);
		    Matcher matcher = firstVowelPattern.matcher(phrase);
		   return ( (isAllTheInputUpperCase(phrase)) ? matcher.replaceAll("$1AY") : matcher.replaceAll("$1ay") );

            		
	}
	
	/*
	 * Implementation of the story 1, third point, in case the word begins with a consonant, 
	 * in the translated word the consonant is first moved to the end, 
	 * then the “ay” is appended likewise (e.g. “bird” -> “irdbay”).
	 */

	public String wordStartsWithAConsonant(String phrase) {
		/* (\\b[a-zA-Z&&[^aeiouAEIOU]])([a-zA-Z]\\w*)
		 * \b Matches a word boundary position between a word character and non-word character (only if start for consonant)
		 *  && is intersection of sets, so it is like intersection of a-z with characters which are not a,e,i,o,u [^aeiouAEIOU]
	     * [a-zA-Z] Match any character in the set (all the letters), \w  any word character
	     * * Matches 0 or more of the preceding token.
	     * ( ) is a group, we can use the selection with $1 and the other ( ) for $2
		 */
				Pattern firstVowelPattern = Pattern.compile("(\\b[a-zA-Z&&[^aeiouAEIOU]])([a-zA-Z]\\w*)", Pattern.CASE_INSENSITIVE);
			    Matcher matcher = firstVowelPattern.matcher(phrase);
			   return  ( (isAllTheInputUpperCase(phrase)) ? matcher.replaceAll("$2$1AY") : converStringtInTitleCase((matcher.replaceAll("$2$1ay"))) );

	}

	  /*
	    *  Implementation of the story 1, fourth point, test the case of whole phrase (“a yellow bird” -> “aay ellowyay irdbay”).
	    */
	public String checkVowelAndConsonant(String phrase) {
     return this.wordStartsWithAConsonant(this.wordStartsWithAVowel(phrase));
	}
	
	/*
	 * Implementation for the story 2, first point, handle consonant clusters like “ch”, “th”, “thr”, “sch” 
	 * at the word’s beginning like a single consonant (e.g. “chair” -> “airchay”, “thread” -> “eadthray”).
	 */
	public String wordStartsWithAClustersOfConsonant(String phrase) {
		/* (\\b[a-zA-Z&&[^aeiouAEIOU]]+)([a-zA-Z]\\w*)?
		 * \b Matches a word boundary position between a word character and non-word character (only if start for consonant)
		 *  && is intersection of sets, so it is like intersection of a-z with characters which are not a,e,i,o,u [^aeiouAEIOU]
		 *  + matches 1 or more of the preceding token. (clusters of consonants)
	     * [a-zA-Z] Match any character in the set (all the letters), \w  any word character
	     * * Matches 0 or more of the preceding token.
	     * out there is ? , is important, because say that the second group  is optional
	     * ( ) is a group, we can use the selection with $1 and the other ( ) for $2
		 */
		
		Pattern firstVowelPattern = Pattern.compile("(\\b[a-zA-Z&&[^aeiouAEIOU]]+)([a-zA-Z]\\w*)?", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = firstVowelPattern.matcher(phrase);
	   return ( (isAllTheInputUpperCase(phrase)) ? matcher.replaceAll("$2$1AY") : converStringtInTitleCase(matcher.replaceAll("$2$1ay")) ) ;
	   
	   }
	
	/*
	 * Implementation for the story 2, second point,handle “xr” at the word’s beginning like vowels (“xray” -> “xrayay”)
	 */
	public String wordStartsWithXRForWordWithVowels(String phrase) {
		Pattern firstVowelPattern = Pattern.compile("(\\b[xr]\\w*)", Pattern.CASE_INSENSITIVE);
	    Matcher matcher = firstVowelPattern.matcher(phrase);
	   return ( (isAllTheInputUpperCase(phrase)) ? matcher.replaceAll("$1AY") : matcher.replaceAll("$1ay"));
	}
	
	/* 
	 * Implementation for the tests for the story 3, first point, uppercase input should yield uppercase output (e.g. “APPLE” -> “APPLEAY”)
	 */
   public boolean isAllTheInputUpperCase(String phrase)
   {
	  return  phrase.toUpperCase().equals(phrase);
   }

	/* 
	 * Implementation for the story 3, second point, also titlecase input should be kept intact,
	 *  the first letter should still be uppercase (e.g. “Bird” -> “Irdbay”)
	 */
   public String converStringtInTitleCase(String phrase)
   {
	  String lowPhrase = phrase.toLowerCase();
	  char firstLetter = lowPhrase.charAt(0);
	  firstLetter = Character.toTitleCase(firstLetter);
	  return  firstLetter + lowPhrase.substring(1, phrase.length());
   }
   
   /*
    * Implementation for the story 3, last point, other cases, different from the ones above, are not allowed (e.g., “biRd” or “BiRd”).
    * I need only a control for title case, because i have isAllTheInputUpperCase function.
	* I suppose from the specific that also the lower case is not allowed, because is not mentioned above. 
	*/
	public Boolean isTitleCase(String phrase)
	{
		  char firstLetter= phrase.charAt(0);
		  return Character.isUpperCase(firstLetter);
	}
}
