package dragonsofmugloar.decrypt;

import java.util.Base64;

import dragonsofmugloar.models.Ad;

public class Base64Decryption implements Decryption {

	@Override
	public Ad decrypt(Ad ad) {
		ad.setAdId(decode(ad.getAdId()));
		ad.setMessage(decode(ad.getMessage()));
		ad.setProbability(decode(ad.getProbability()));
		return ad;
	}
	
	private String decode(String encodedString) {
		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
		return new String(decodedBytes);
	}
}
