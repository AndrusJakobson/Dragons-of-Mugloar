package dragonsofmugloar.models;

import java.util.ArrayList;

public class AdList {
	private ArrayList<Ad> easyAdList = new ArrayList<Ad>();
	private ArrayList<Ad> mediumAdList = new ArrayList<Ad>();
	private ArrayList<Ad> hardAdList = new ArrayList<Ad>();
	
	private final String[] easyDifficultyArray = {"Walk in the park", "Piece of cake", "Quite likely"};
	private final String[] mediumDifficultyArray = {"Hmmm....", "Gamble", "Sure thing"};
	
	public void add(Ad ad) {
		if(ad == null) {
			return;
		}
		
		if(isEasy(ad)) {
			easyAdList.add(ad);
		}else if(isMedium(ad)) {
			mediumAdList.add(ad);
		}else {
			hardAdList.add(ad);
		}
	}
	
	public ArrayList<Ad> getList(){
		if(!easyAdList.isEmpty()) {
			return easyAdList;
		}else if(!mediumAdList.isEmpty()) {
			return mediumAdList;
		}
		return hardAdList;
	}
	
	public Ad get(int index) {
		return getList().get(index);
	}
	
	private boolean isMedium(Ad ad) {
		for(String difficulty : mediumDifficultyArray) {
			if(ad.getProbability().equals(difficulty)) {
				return true;
			}
		}
		return false;
	}

	private boolean isEasy(Ad ad) {
		for(String difficulty : easyDifficultyArray) {
			if(ad.getProbability().equals(difficulty)) {
				return true;
			}
		}
		return false;
	}
}
