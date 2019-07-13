package dragonsofmugloar.decrypt;

import java.util.HashMap;

import dragonsofmugloar.models.Ad;

public class SubstitutionDecryption implements Decryption {

	@Override
	public Ad decrypt(Ad ad) {
		ad.setAdId((getSubstituteAlphabetFrom(ad.getAdId())));
		ad.setMessage(getSubstituteAlphabetFrom(ad.getMessage()));
		ad.setProbability(getSubstituteAlphabetFrom(ad.getProbability()));
		return ad;
	}

	private String getSubstituteAlphabetFrom(String encoded) {
		HashMap<String, String> substitutionMap = getSubstituteAlphabet();
		StringBuilder decodedString = new StringBuilder(encoded);
		for (int i = 0; i < decodedString.length(); i++) {
			String symbol = String.valueOf(decodedString.charAt(i));
			if (!isSpace(symbol)) {
				String decodedLetter = substitutionMap.get(symbol);
				if (decodedLetter == null) {
					decodedLetter = symbol;
				}
				char decodedChar = decodedLetter.charAt(0);
				decodedString.setCharAt(i, decodedChar);
			}
		}
		return decodedString.toString();
	}

	private HashMap<String, String> getSubstituteAlphabet() {
		HashMap<String, String> decryptMap = new HashMap<String, String>();
		decryptMap.put("c", "p");
		decryptMap.put("a", "n");
		decryptMap.put("z", "m");
		decryptMap.put("x", "k");
		decryptMap.put("v", "i");
		decryptMap.put("t", "g");
		decryptMap.put("r", "e");
		decryptMap.put("p", "c");
		decryptMap.put("n", "a");
		decryptMap.put("l", "y");
		decryptMap.put("j", "w");
		decryptMap.put("h", "u");
		decryptMap.put("f", "s");
		decryptMap.put("d", "q");
		decryptMap.put("b", "o");
		decryptMap.put("y", "l");
		decryptMap.put("w", "j");
		decryptMap.put("u", "h");
		decryptMap.put("s", "f");
		decryptMap.put("q", "d");
		decryptMap.put("o", "b");
		decryptMap.put("m", "z");
		decryptMap.put("k", "x");
		decryptMap.put("i", "v");
		decryptMap.put("g", "t");
		decryptMap.put("e", "r");
		decryptMap.put("D", "Q");
		decryptMap.put("B", "O");
		decryptMap.put("Y", "L");
		decryptMap.put("W", "J");
		decryptMap.put("U", "H");
		decryptMap.put("S", "F");
		decryptMap.put("Q", "D");
		decryptMap.put("O", "B");
		decryptMap.put("M", "Z");
		decryptMap.put("K", "X");
		decryptMap.put("I", "V");
		decryptMap.put("G", "T");
		decryptMap.put("E", "R");
		decryptMap.put("C", "P");
		decryptMap.put("A", "N");
		decryptMap.put("Z", "M");
		decryptMap.put("X", "K");
		decryptMap.put("V", "I");
		decryptMap.put("T", "G");
		decryptMap.put("R", "E");
		decryptMap.put("P", "C");
		decryptMap.put("N", "A");
		decryptMap.put("L", "Y");
		decryptMap.put("J", "W");
		decryptMap.put("H", "U");
		decryptMap.put("F", "S");

		return decryptMap;
	}

	private boolean isSpace(String symbol) {
		return symbol.equals(" ");
	}
}
