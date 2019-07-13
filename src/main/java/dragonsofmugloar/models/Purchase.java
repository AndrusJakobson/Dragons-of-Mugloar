package dragonsofmugloar.models;

import lombok.Data;

@Data
public class Purchase {
	private boolean shoppingSuccess;
	private int gold;
	private int lives;
	private int level;
	private int turn;
}
