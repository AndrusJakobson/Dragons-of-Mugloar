package dragonsofmugloar.models;
import lombok.Data;

@Data
public class AdFeedback {
	private boolean success;
	private int lives;
	private int gold;
	private int score;
	private int highScore;
	private int turn;
	private String message;
	
}
