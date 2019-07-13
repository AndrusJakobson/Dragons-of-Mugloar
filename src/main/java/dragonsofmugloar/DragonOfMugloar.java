package dragonsofmugloar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import dragonsofmugloar.models.Ad;
import dragonsofmugloar.models.AdFeedback;
import dragonsofmugloar.models.AdList;
import dragonsofmugloar.models.Game;
import dragonsofmugloar.models.Purchase;

@Component
public class DragonOfMugloar {
	@Autowired
	private DragonsOfMugloarPresenter presenter;
	private AdList adList;
	private Game game;
	
	public void playRound(Model model) {
		createGame();
		while(game.hasLives()) {
			buyUpgrades();
			getAdList();
			getAdFeedback(getBestAdId());
		}
		model.addAttribute("game", game);
	}
	
	private String getBestAdId() {
		String bestAdId = "";
		int bestReward = Integer.MIN_VALUE;
		
		for(Ad ad : adList.getList()) {
			boolean isStealingSuper = isStealingSuper(ad.getMessage());
			boolean hasBetterReward = ad.getReward() > bestReward;
			if(!isStealingSuper && hasBetterReward) {
				bestReward = ad.getReward();
				bestAdId = ad.getAdId();
			}
		}
		
		if(bestAdId.isEmpty()) {
			return adList.get(0).getAdId();
		}
		return bestAdId;
	}

	private void buyUpgrades() {
		if(game.getGold() >= 400) {
			buyItem("wingpotmax");
		}
		while(game.getLives() < 3 && game.getGold() >= 50) {
			buyItem("hpot");
		}
	}
	
	private boolean isStealingSuper(String message) {
		String[] words = message.split(" ");
		String firstTwoWords = words[0] + " " + words[1];
		return firstTwoWords.equals("Steal super");
	}
	
	private void createGame() {
		game = presenter.getGame();
	}

	private void getAdList() {
		adList = presenter.getAdList(game.getGameId());
	}

	private void getAdFeedback(String adId) {
		AdFeedback feedback = presenter.getAdFeedback(game.getGameId(), adId);
		game.updateOnAdFeedback(feedback);
	}

	private void buyItem(String itemId) {
		Purchase purchase = presenter.buyItem(game.getGameId(), itemId);
		game.updateOnPurchase(purchase);
	}
}
