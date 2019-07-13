package dragonsofmugloar;

import java.io.IOException;
import java.util.List;

import dragonsofmugloar.models.Ad;
import dragonsofmugloar.models.AdFeedback;
import dragonsofmugloar.models.Game;
import dragonsofmugloar.models.Purchase;
import dragonsofmugloar.util.http.APIClient;

public class DragonsOfMugloarRequester {

	public static Game getGame(DragonsOfMugloarPresenter presenter) {
		try {
			return APIClient
					.getInstance()
					.getService()
					.getGameResponse()
					.execute()
					.body();
		} catch (IOException e) {
			return null;
		}
	}

	public static List<Ad> getAdList(DragonsOfMugloarPresenter presenter, String gameId) {		
		try {
			return APIClient
				.getInstance()
				.getService()
				.getAdListResponse(gameId)
				.execute()
				.body();
		} catch (IOException e) {
			return null;
		}
	}

	public static AdFeedback getAdFeedback(DragonsOfMugloarPresenter presenter, String gameId, String adId) {
		try {
			return APIClient
					.getInstance()
					.getService()
					.getAdFeedbackResponse(gameId, adId)
					.execute()
					.body();
		} catch (IOException e) {
			return null;
		}
	}

	public static Purchase getItem(DragonsOfMugloarPresenter presenter, String gameId, String itemId) {
		try {
			return APIClient
					.getInstance()
					.getService()
					.getPurchaseResponse(gameId, itemId)
					.execute()
					.body();
			
		} catch (IOException e) {
			return null;
		}
	}
}
