package dragonsofmugloar.decrypt;

import dragonsofmugloar.models.Ad;

public class DecryptionFactory {
	public static Ad decrypt(Ad ad) {
		switch(ad.getEncrypted()) {
			case 1:
				return new Base64Decryption().decrypt(ad);
			case 2:
				return new SubstitutionDecryption().decrypt(ad);
			default:
				return null;
		}
	}
}
