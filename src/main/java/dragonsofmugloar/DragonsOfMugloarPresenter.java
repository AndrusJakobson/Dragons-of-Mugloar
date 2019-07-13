package dragonsofmugloar;

import java.util.List;

import org.springframework.stereotype.Component;

import dragonsofmugloar.decrypt.DecryptionFactory;
import dragonsofmugloar.models.Ad;
import dragonsofmugloar.models.AdFeedback;
import dragonsofmugloar.models.AdList;
import dragonsofmugloar.models.Game;
import dragonsofmugloar.models.Purchase;

@Component
public class DragonsOfMugloarPresenter {
	public Game getGame() {
		return DragonsOfMugloarRequester.getGame(this);
	}

	public AdList getAdList(String gameId) {
		List<Ad> adList = DragonsOfMugloarRequester.getAdList(this, gameId);
		return getDecryptedAdList(adList);
	}

	public AdFeedback getAdFeedback(String gameId, String adId) {
		return DragonsOfMugloarRequester.getAdFeedback(this, gameId, adId);
	}

	public Purchase buyItem(String gameId, String itemId) {
		return DragonsOfMugloarRequester.getItem(this, gameId, itemId);
	}
	
	private AdList getDecryptedAdList(List<Ad> adList) {
		AdList decryptedAdList = new AdList();
		for(Ad ad : adList) {
			if(ad.isEncrypted()) {
				ad = DecryptionFactory.decrypt(ad);
			}
			decryptedAdList.add(ad);
		}
		return decryptedAdList;
	}
}
