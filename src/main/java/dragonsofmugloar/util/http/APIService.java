package dragonsofmugloar.util.http;

import java.util.List;

import dragonsofmugloar.models.Ad;
import dragonsofmugloar.models.AdFeedback;
import dragonsofmugloar.models.Game;
import dragonsofmugloar.models.Purchase;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {
	@POST("game/start")
	Call<Game> getGameResponse();

	@GET("{gameId}/messages")
	Call<List<Ad>> getAdListResponse(@Path("gameId") String gameId);

	@POST("{gameId}/solve/{adId}")
	Call<AdFeedback> getAdFeedbackResponse(@Path("gameId") String gameId, @Path("adId") String adId);

	@POST("{gameId}/shop/buy/{itemId}")
	Call<Purchase> getPurchaseResponse(@Path("gameId") String gameId, @Path("itemId") String itemId);
}
