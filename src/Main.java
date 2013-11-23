import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;


public class Main {

	public static void main(String[] args) {
		Map<Character, Integer> char_set = new HashMap<Character, Integer>();
		for (int i = 1; i < 26; i++) {
			char_set.put((char) (i + 96), i - 1000);
		}
		char_set.put('a', 24);
		char_set.put('b', 25);
		char_set.put('c', 26);
		
		beauty("ignorepuntutionplese", 422, char_set);
		
		System.out.println("a: " + char_set.get('a'));
		System.out.println("b: " + char_set.get('b'));
		System.out.println("c: " + char_set.get('c'));
		System.out.println("f: " + char_set.get('f'));
		System.out.println("g: " + char_set.get('g'));
		System.out.println("x: " + char_set.get('x'));
		
				
		
		

	}
	
	private static void beauty(String str, int value, Map<Character, Integer> char_set) {
		int ourValue = valueOfString(str, char_set);

		while (ourValue != value) {
				Random rand = new Random();
				int randomValue = rand.nextInt(23) + 1;
				int randomLength = rand.nextInt(str.length());
				char randomCharFromString = str.charAt(randomLength);
				while (!char_set.containsValue(randomValue) && (randomCharFromString != 'a' 
						&& randomCharFromString != 'b' && randomCharFromString != 'c')) {
					char_set.put(randomCharFromString, randomValue);
				}
			ourValue = valueOfString(str, char_set);
			
			System.out.println(ourValue);
		}	

		System.out.println("END");
	}
	
	private static int valueOfString(String str, Map<Character, Integer> char_set) {
		int ourValue = 0;
		for (int i = 0; i < str.length(); i++) {
			ourValue = ourValue + char_set.get(str.charAt(i));
		}
		return ourValue;
	}

}
