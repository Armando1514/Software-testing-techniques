package piglatinTDD;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PigLatinTest {
	
	/* Testing of the Story 1, first point : "a phrase is a string made up of several words split by a 
	 * single space (i.e., multiple spaces are not allowed).
	 */
	@Test (expected = InvalidPhraseException.class)
	public void testIsSubsequentSpaces() throws InvalidPhraseException
	{
		String phrase = "New pig  is on the bank";
		new PigLatin(phrase);
	}
	
	@Test
	public void testIsNotSubsequentSpaces() throws InvalidPhraseException
	{
		String phrase = "NSew pig is on the bank";
		PigLatin x = new PigLatin(phrase);
		assertFalse(x.isSubsequentSpaces(phrase));
	}
	
	/* end of test for Story 1, first point : "a phrase is a string made up of several words split by a 
	 * single space (i.e., multiple spaces are not allowed).
	 */
	
	/* Testing of the Story 1, first point: "spaces are not allowed at the beginning and end of phrase */
	@Test (expected = InvalidPhraseException.class)
	public void testisStartWithSpace() throws InvalidPhraseException {
		
		String phrase = " new pig is on the bank";
		new PigLatin(phrase);
	}
	
	@Test
	public void testStartWithNoSpace() throws InvalidPhraseException {
		
		String phrase = "New pig is one the bank";
		PigLatin x = new PigLatin(phrase);
		assertFalse(x.isStartsWithSpace(x.getPhrase()));
	}
	
	@Test (expected = InvalidPhraseException.class)
	public void testIsEndWithSpace() throws InvalidPhraseException {
		
		String phrase = "New pig is on the bank ";
		new PigLatin(phrase);
	}
	
	@Test
	public void testIsEndWithNoSpace() throws InvalidPhraseException {
		
		String phrase = "New pig is one the bank";
		PigLatin x = new PigLatin(phrase);
		assertFalse(x.isEndsWithSpace(x.getPhrase()));
	}
	/* part for test Story 1, first point: "spaces are not allowed at the beginning and end of phrase, 
	 * finished */
	
   /* Test of Story 1, first point: ""a phrase can contain english letters and the space
    * character only".
    */
	@Test
	public void  testIsLegalPhrase() throws InvalidPhraseException
	{
		String phrase = "New pig is one the bank";
		PigLatin x = new PigLatin(phrase);
		assertTrue(x.isLegalPhrase(x.getPhrase()));
	}
	
	@Test (expected = InvalidPhraseException.class)
	public void  testIsNotLegalPhrase() throws InvalidPhraseException
	{
		String phrase = "New pig 9 one the bank";
		new PigLatin(phrase);
	}
	  /*End of implementation of Story 1, first point: ""a phrase can contain english letters and the space
	    * character only".
	    */
	
	/* Testing for Story 1, first point: "a phrase is a string made up of several words split by a single space" */
	@Test 
	public void testIsMoreThanOneWord() throws InvalidPhraseException
	{
		String phrase = "New pig is one the bank";
		PigLatin x = new PigLatin(phrase);
		assertTrue(x.isMoreThanOneWord(phrase));
		
	}
	
	@Test (expected = InvalidPhraseException.class)
	public void testIsNotMoreThanOneWord() throws InvalidPhraseException
	{
		String phrase = "New";
		new PigLatin(phrase);
		
	}
	/* part for test Story 1, first point: "a phrase is a string made up of several words split by a single space"
	 * finished
	 */
	
	/* Refactoring phase */
	@Test
	public void testGetPhrase() throws InvalidPhraseException
	{
		
		String phrase = "New pig is one the bank";
		PigLatin x = new PigLatin(phrase);
		assertEquals(phrase, x.getPhrase());
		
	}
	
	/* Test of the story 1, second point, if the word starts with a vowel, the translated word
	 * is simply the input + “ay” (e.g. “apple” -> “appleay”).
	 */
	@Test
	public void testWordStartsWithAVowel() throws InvalidPhraseException
	{
		String phrase = "Open the door anna";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Openay the door annaay", x.wordStartsWithAVowel(phrase));
	}
	/* Further test */
	@Test
	public void testWordStartsWithAVowel2() throws InvalidPhraseException
	{
		String phrase = "All together we go to open the door";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Allay together we go to openay the door", x.wordStartsWithAVowel(phrase));
	}
	@Test
	public void testWordIsNotStartsWithAVowel() throws InvalidPhraseException
	{
		String phrase = "Try to close the door";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Try to close the door", x.wordStartsWithAVowel(phrase));
	}
	/* End of test for the story 1, second point, if the word starts with a vowel, the translated word
	 * is simply the input + “ay” (e.g. “apple” -> “appleay”).
	 */
	
	/*
	 * test for the story 1, third point, in case the word begins with a consonant, 
	 * in the translated word the consonant is first moved to the end, 
	 * then the “ay” is appended likewise (e.g. “bird” -> “irdbay”).
	 */
	@Test
	public void testWordStartsWithAConsonant() throws InvalidPhraseException
	{
		String phrase = "Close the door please";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Losecay hetay oorday leasepay", x.wordStartsWithAConsonant(phrase));
	}
	/* Further test */
	@Test
	public void testWordStartsWithAConsonant2() throws InvalidPhraseException
	{
		String phrase = "Please help my brother to open the door";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Leasepay elphay ymay rotherbay otay open hetay oorday", x.wordStartsWithAConsonant(phrase));
	}
	@Test
	public void testWordIsNotStartsWithAConsonant() throws InvalidPhraseException
	{
		String phrase = "Oh anna elephant";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Oh anna elephant", x.wordStartsWithAConsonant(phrase));
	}
	/*
	 * end of test for the story 1, third point, in case the word begins with a consonant, 
	 * in the translated word the consonant is first moved to the end, 
	 * then the “ay” is appended likewise (e.g. “bird” -> “irdbay”).
	 */
	
	   /*
	    *  test for the story 1, fourth point, test the case of whole phrase (“a yellow bird” -> “aay ellowyay irdbay”).
	    */
	@Test
	public void testCheckVowelAndConsonant() throws InvalidPhraseException
	{
		String phrase = "A yellow bird";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Aay ellowyay irdbay", x.checkVowelAndConsonant(phrase));
	}
	
	/* Further test */
	@Test
	public void testCheckVowelAndConsonant2() throws InvalidPhraseException
	{
		String phrase = "Please help my brother to open the door";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Leasepay elphay ymay rotherbay otay openay hetay oorday", x.checkVowelAndConsonant(phrase));
	}
	   /*
	    *  end of the test for the story 1, fourth point, test the case of whole phrase (“a yellow bird” -> “aay ellowyay irdbay”).
	    */
	
	/*
	 * test for the story 2, first point, handle consonant clusters like “ch”, “th”, “thr”, “sch” 
	 * at the word’s beginning like a single consonant (e.g. “chair” -> “airchay”, “thread” -> “eadthray”).
	 */
	@Test
	public void testWordStartsWithAClustersOfConsonant() throws InvalidPhraseException
	{
		String phrase = "Close the door please";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Oseclay ethay oorday easeplay", x.wordStartsWithAClustersOfConsonant(phrase));
	}
	/* Further test */
	@Test
	public void testWordStartsWithAClustersOfConsonant2() throws InvalidPhraseException
	{
		String phrase = "Please help my brother to open this door";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Easeplay elphay myay otherbray otay open isthay oorday", x.wordStartsWithAClustersOfConsonant(phrase));
	}
	@Test
	public void testWordIsNotStartsWithAClustersOfConsonant() throws InvalidPhraseException
	{
		String phrase = "Oh anna elephant";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Oh anna elephant", x.wordStartsWithAClustersOfConsonant(phrase));
	}
	/*
	 * end of the test for the story 2, first point, handle consonant clusters like “ch”, “th”, “thr”, “sch” 
	 * at the word’s beginning like a single consonant (e.g. “chair” -> “airchay”, “thread” -> “eadthray”).
	 */
	
	/*
	 * test for the story 2, second point,handle “xr” at the word’s beginning like vowels (“xray” -> “xrayay”)
	 */
	@Test
	public void testWordStartsWithXRForWordWithVowels() throws InvalidPhraseException
	{
		String phrase = "Xray is xream";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Xrayay is xreamay", x.wordStartsWithXRForWordWithVowels(phrase));
	}
	/* Further test */
	@Test
	public void testWordStartsWithXRForWordWithVowels2() throws InvalidPhraseException
	{
		String phrase = "They say xry xry";
		PigLatin x = new PigLatin(phrase);
		assertEquals("They say xryay xryay", x.wordStartsWithXRForWordWithVowels(phrase));
	}
	@Test
	public void testWordNotStartsWithXRForWordWithVowels() throws InvalidPhraseException
	{
		String phrase = "Oh anna elephant";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Oh anna elephant", x.wordStartsWithXRForWordWithVowels(phrase));
	}
	/*
	 * end of test for the story 2, second point,handle “xr” at the word’s beginning like vowels (“xray” -> “xrayay”)
	 */
	
	/* 
	 * tests for the story 3, first point, uppercase input should yield uppercase output (e.g. “APPLE” -> “APPLEAY”)
	 */
	@Test
	public void testWordStartsWithAVowelUpperCaseOutput() throws InvalidPhraseException
	{
		String phrase = "ALL TOGETHER WE GO TO OPEN THE DOOR";
		PigLatin x = new PigLatin(phrase);
		assertEquals("ALLAY TOGETHER WE GO TO OPENAY THE DOOR", x.wordStartsWithAVowel(phrase));
	}
	@Test
	public void testWordIsNotStartsWithAVowelUpperCaseOutput() throws InvalidPhraseException
	{
		String phrase = "Try to close the door";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Try to close the door", x.wordStartsWithAVowel(phrase));
	}
	@Test
	public void testWordStartsWithAConsonantUpperCaseOutput() throws InvalidPhraseException
	{
		String phrase = "PLEASE HELP MY BROTHER TO OPEN THE DOOR";
		PigLatin x = new PigLatin(phrase);
		assertEquals("LEASEPAY ELPHAY YMAY ROTHERBAY OTAY OPEN HETAY OORDAY", x.wordStartsWithAConsonant(phrase));
	}
	@Test
	public void testWordIsNotStartsWithAConsonantUpperCaseOutput() throws InvalidPhraseException
	{
		String phrase = "Oh anna elephant";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Oh anna elephant", x.wordStartsWithAConsonant(phrase));
	}
	@Test
	public void testWordStartsWithAClustersOfConsonantUpperCaseOutput() throws InvalidPhraseException
	{
		String phrase = "PLEASE HELP MY BROTHER TO OPEN THIS DOOR";
		PigLatin x = new PigLatin(phrase);
		assertEquals("EASEPLAY ELPHAY MYAY OTHERBRAY OTAY OPEN ISTHAY OORDAY", x.wordStartsWithAClustersOfConsonant(phrase));
	}
	@Test
	public void testWordIsNotStartsWithAClustersOfConsonantUpperCaseOutput() throws InvalidPhraseException
	{
		String phrase = "Oh anna elephant";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Oh anna elephant", x.wordStartsWithAClustersOfConsonant(phrase));
	}
	@Test
	public void testWordStartsWithXRForWordWithVowelsUpperCaseOutput() throws InvalidPhraseException
	{
		String phrase = "THEY SAY XRY XRY";
		PigLatin x = new PigLatin(phrase);
		assertEquals("THEY SAY XRYAY XRYAY", x.wordStartsWithXRForWordWithVowels(phrase));
	}
	@Test
	public void testWordNotStartsWithXRForWordWithVowelsUpperCaseOutput() throws InvalidPhraseException
	{
		String phrase = "Oh anna elephant";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Oh anna elephant", x.wordStartsWithXRForWordWithVowels(phrase));
	}
	/* 
	 * end of tests for the story 3, first point, uppercase input should yield uppercase output (e.g. “APPLE” -> “APPLEAY”)
	 */
	
	/* 
	 * tests for the story 3, second point, also titlecase input should be kept intact,
	 *  the first letter should still be uppercase (e.g. “Bird” -> “Irdbay”)
	 */
	@Test
	public void testWordStartsWithAVowelTitleCaseOutput() throws InvalidPhraseException
	{
		String phrase = "All together we go to open the door";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Allay together we go to openay the door", x.wordStartsWithAVowel(phrase));
	}
	@Test
	public void testWordIsNotStartsWithAVowelTitleCaseOutput() throws InvalidPhraseException
	{
		String phrase = "TRY TO CLOSE THE DOOR";
		PigLatin x = new PigLatin(phrase);
		assertEquals("TRY TO CLOSE THE DOOR", x.wordStartsWithAVowel(phrase));
	}
	@Test
	public void testWordStartsWithAConsonantTitleCaseOutput() throws InvalidPhraseException
	{
		String phrase = "Please help my brother to open the door";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Leasepay elphay ymay rotherbay otay open hetay oorday", x.wordStartsWithAConsonant(phrase));
	}
	@Test
	public void testWordIsNotStartsWithAConsonantTitleCaseOutput() throws InvalidPhraseException
	{
		String phrase = "OH ANNA ELEPHANT";
		PigLatin x = new PigLatin(phrase);
		assertEquals("OH ANNA ELEPHANT", x.wordStartsWithAConsonant(phrase));
	}
	@Test
	public void testWordStartsWithAClustersOfConsonantTitleCaseOutput() throws InvalidPhraseException
	{
		String phrase = "Please help my brother to open this door";
		PigLatin x = new PigLatin(phrase);
		assertEquals("Easeplay elphay myay otherbray otay open isthay oorday", x.wordStartsWithAClustersOfConsonant(phrase));
	}
	@Test
	public void testWordIsNotStartsWithAClustersOfConsonantTitleCaseOutput() throws InvalidPhraseException
	{
		String phrase = "OH ANNA ELEPHANT";
		PigLatin x = new PigLatin(phrase);
		assertEquals("OH ANNA ELEPHANT", x.wordStartsWithAClustersOfConsonant(phrase));
	}
	@Test
	public void testWordStartsWithXRForWordWithVowelsTitleCase() throws InvalidPhraseException
	{
		String phrase = "They say xry xry";
		PigLatin x = new PigLatin(phrase);
		assertEquals("They say xryay xryay", x.wordStartsWithXRForWordWithVowels(phrase));
	}
	@Test
	public void testWordNotStartsWithXRForWordWithVowelsTitleCase() throws InvalidPhraseException
	{
		String phrase = "OH ANNA ELEPHANT";
		PigLatin x = new PigLatin(phrase);
		assertEquals("OH ANNA ELEPHANT", x.wordStartsWithXRForWordWithVowels(phrase));
	}
	
	/* 
	 * End tests for the story 3, second point, also titlecase input should be kept intact, 
	 * the first letter should still be uppercase (e.g. “Bird” -> “Irdbay”)
	 */
	
	/*
	 * Tests for the story 3, last point, other cases, different from the ones above, are not allowed (e.g., “biRd” or “BiRd”).
	 * I suppose from the specific that also the lower case is not allowed, because is not mentioned above. 
	 */

	@Test (expected = InvalidPhraseException.class)
	public void testWordIsNotTitleCaseOrUpperCase() throws InvalidPhraseException
	{
		String phrase = "try to close the door";
		new PigLatin(phrase);
	}

}
