package dragonsofmugloar.models;

import lombok.Data;

@Data
public class Game {
	private String gameId;
	private int lives;
	private int gold;
	private int level;
	private int score;
	private int highScore;
	private int turn;
	
	public boolean hasLives() {
		return lives > 0;
	}
	
	public void updateOnAdFeedback(AdFeedback adFeedback) {
		lives = adFeedback.getLives();
		gold = adFeedback.getGold();
		score = adFeedback.getScore();
		highScore = adFeedback.getHighScore();
		turn = adFeedback.getTurn();
	}
	
	public void updateOnPurchase(Purchase purchase) {
		lives = purchase.getLives();
		gold = purchase.getGold();
		level = purchase.getLevel();
		turn = purchase.getTurn();
	}
}
