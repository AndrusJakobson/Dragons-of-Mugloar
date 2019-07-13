package dragonsofmugloar.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DragonsOfMugloarController {
	@Autowired
	DragonOfMugloar mainGame;
	
	@GetMapping
	public String getIndex(Model model) {
		return "index";
	}
	
	@PostMapping("playRound")
	public String getNextRoundStats(Model model) {
		mainGame.playRound(model);
		return "fragments/gameStatsFragment";
	}
	

	

	



	
	
	
}
