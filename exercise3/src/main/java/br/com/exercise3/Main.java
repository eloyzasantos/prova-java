package br.com.exercise3;

import java.util.LinkedList;
import java.util.List;

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
	
    public static void main( String[] args )
    {
        System.out.println(firstChar("AAbBABacafe"));
    }
    
    public static Character firstChar(String input) {
    	Stream stream = new StreamImpl(input);
    	
		List<Character> listCharacter = new LinkedList<Character>();
		
		while (stream.hasNext()) {
			Character character = stream.getNext();
						
			if (listCharacter.size() >= 2) {
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
		
		return null;
	}
    
    protected static boolean isRepeated(List<Character> listCharacter, Character character) {
    	return listCharacter.contains(character);
    }
    
    protected static boolean isVogal(String text) {
    	return VOGALS.contains(text.toLowerCase());
    }
    
    protected static boolean isConsonant(String text) {
    	return CONSONANTS.contains(text.toLowerCase());
    }
    
}
