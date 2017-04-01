package br.com.exercise3;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.exercise3.stream.Stream;
import br.com.exercise3.stream.impl.StreamImpl;

/**
 * @author ebenedito
 *
 */
public class Main 
{
	protected static final String VOGALS = "aeiou";
	protected static final String CONSONANTS = "bcdfghjklmnpqrstvwxyz";
	
	/**
	 * First index that is possible has a consonant and vogal before 
	*/
	protected static final int FIRST_INDEX = 2;
	
    public static void main( String[] args )
    {
    	try {
    		System.out.println(firstChar("aAbBABacafe"));
    	} catch (NoSuchElementException ex) {
    		System.out.println("Element not found.");
    	} catch (Exception ex) {
    		System.out.println("Unexpected error.");
    	}
        
    }
    
    public static Character firstChar(String input) {
    	Stream stream = new StreamImpl(input);
    	
		List<Character> listCharacter = new LinkedList<Character>();
		
		while (stream.hasNext()) {
			Character character = stream.getNext();
						
			if (listCharacter.size() >= FIRST_INDEX) {
				String textCharacter = String.valueOf(character);
				
				if (isVogal(textCharacter) && !isRepeated(listCharacter, character))  {
					
					int sizeCurrentList = listCharacter.size();
					String c1 = String.valueOf(listCharacter.get(sizeCurrentList - 1));
					String c2 = String.valueOf(listCharacter.get(sizeCurrentList - 2));
					
					if (isConsonant(c1) && isVogal(c2)) {
						return character;
					}
				}
			}
			
			
			listCharacter.add(character);
		}
		
		throw new NoSuchElementException();
	}
    
	/**
	 * Check if already in list, if is in list, is repeated
	*/
    private static boolean isRepeated(List<Character> listCharacter, Character character) {
    	return listCharacter.contains(character);
    }
    
	/**
	 * Check if as vogal
	*/
    private static boolean isVogal(String text) {
    	return VOGALS.contains(text.toLowerCase());
    }
    
	/**
	 * Check if as consonant
	*/
    private static boolean isConsonant(String text) {
    	return CONSONANTS.contains(text.toLowerCase());
    }
    
}
