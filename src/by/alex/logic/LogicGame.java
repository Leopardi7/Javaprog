package by.alex.logic;

public class LogicGame {
	private static double x;
	private static int chooseCompNumber;
	private static int compDamage;
	private static int heroDamage;
	private static int currentHumanLife;
	private static int currentCompLife;
	
	
	


	public static int getCurrentCompLife() {
		return currentCompLife;
	}


	public static void setCurrentCompLife(int currentCompLife) {
		LogicGame.currentCompLife = currentCompLife;
	}


	public static int getChooseCompNumber() {
		return chooseCompNumber;
	}


	public static void setChooseCompNumber(int chooseCompNumber) {
		LogicGame.chooseCompNumber = chooseCompNumber;
	}


	public static int getCompDamage() {
		return compDamage;
	}


	public static void setCompDamage(int compDamage) {
		LogicGame.compDamage = compDamage;
	}


	public static int getHeroDamage() {
		return heroDamage;
	}


	public static void setHeroDamage(int heroDamage) {
		LogicGame.heroDamage = heroDamage;
	}


	public static int getCurrentHumanLife() {
		return currentHumanLife;
	}


	public static void setCurrentHumanLife(int currentHumanLife) {
		LogicGame.currentHumanLife = currentHumanLife;
	}


	public static void calculate(boolean heroChooseCheckBox , int chooseHeroNumber){
		x = Math.random()*9 + 0.5;
		chooseCompNumber = (int) Math.round(x);
		int differentChoose;
		if (heroChooseCheckBox){
			differentChoose = (chooseCompNumber - chooseHeroNumber + 9) % 9;
		} else {
			differentChoose = (chooseHeroNumber - chooseCompNumber + 9) % 9;
		}
		if (differentChoose < 4) {
			heroDamage = 0;
			compDamage = 5 - differentChoose;		
		} else {
			heroDamage = differentChoose - 3;
			compDamage = 0;
		}
		currentHumanLife-=heroDamage;
		currentCompLife-=compDamage;
		if (currentHumanLife <= 0) currentHumanLife = 0;
		if (currentCompLife <= 0) currentCompLife = 0;
			
	}
}

