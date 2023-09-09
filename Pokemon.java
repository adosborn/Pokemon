import java.util.ArrayList;

public class Pokemon {
	
	private int level; 
	private String type;
	private int attack;
	private int xp;
	private int nextLevel;
	private int healthMax;
	private int healthCurrent;
	private boolean isAlive;
	private int realAttack = 10;
	private String name;
	private String pokeActive = "";
	private String pokeRival = "";
	private static ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
	private static ArrayList<Pokemon> party = new ArrayList<Pokemon>();
	
	
	public Pokemon() {
		level = 1;
		attack = 10;
		name = "pokemon";
		type = "nuetral";
		xp = 0;
		nextLevel = 100;
		healthMax = 100;
		healthCurrent = 100;
		isAlive = true;
	}
	public Pokemon(int pokeLevel, String pokeType, int pokeXP, int pokeNextLevel, int pokeHealthMax, int pokeHealthCurrent, boolean pokeIsAlive, String pokeName, int pokeAttack) {
		level = pokeLevel; 
		type = pokeType;
		xp = pokeXP;
		nextLevel = pokeNextLevel;
		healthMax = pokeHealthMax;
		healthCurrent = pokeHealthCurrent; 
		isAlive = pokeIsAlive;
		name = pokeName;
		attack = pokeAttack;
	}
	
	public int getHeath() {
		return healthCurrent;
	}
	public int getAttack() {
		return attack;
	}
	public int getLevel() {
		return level;
	}
	public String getType() {
		return type;
	}
	public int getXP() {
		return xp;
	}
	public String getName() {
		return name;
	}
	public void levelUp() {
		level ++;
		xp = 0;
		nextLevel = (int) (nextLevel * 1.1);
		healthMax = (int) (healthMax * 1.05);
		healthCurrent = healthMax;
		realAttack *= 1.1;
		System.out.println("Congradulations! Your Pokemon grew to level " + getLevel());
	}
	public void heal(int healPower) {
		if (healthCurrent + healPower > healthMax) {
			healthCurrent = healthMax;
		}
		else healthCurrent += healPower;
	}
	public void takeDamage(int damage) {
		healthCurrent -= damage;
		if (healthCurrent < 0) {
			healthCurrent = 0;
			isAlive = false;
		}
	}
	public void gainXP(int addedxp) {
		xp += addedxp;
		if (xp >= nextLevel) levelUp();
	}
	public double multiplier() {
		int damage = 0;
		return damage;
	}
	public void raiseStats() {
		healthCurrent *= 1.05;
		attack *= 1.05;
	}
	public void deflateStats() {
		healthCurrent = healthMax;
		attack = realAttack;
	}
	public int dealDamage(int attack) {
		double damage = attack;
		
		return (int)damage;
	}
	public static Pokemon getRanPoke() {
		fillPokedex();
		return pokedex.get((int) (Math.random() * pokedex.size()));
	}
	public static void fillPokedex() {
		Pokemon fire1 = new Pokemon(1, "fire", 0, 100, 100, 100, true, "fire1", 10);
		Pokemon water1 = new Pokemon(1, "water", 0, 100, 100, 100, true, "water1", 10);
		Pokemon grass1 = new Pokemon(1, "grass", 0, 100, 100, 100, true, "grass1", 10);
		pokedex.add(fire1);
		pokedex.add(water1);
		pokedex.add(grass1);
		
	}
	
	public static void main(String[] args) {
		//ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
		
		//Pokemon fire1 = new Pokemon(1, "fire", 0, 100, 100, 100, true, "fire1");
		//pokedex.add(fire1);
		//Pokemon water1 = new Pokemon(1, "water", 0, 100, 100, 100, true, "water1");
		//pokedex.add(water1);
		//Pokemon grass1 = new Pokemon(1, "grass", 0, 100, 100, 100, true, "grass1");
		//pokedex.add(grass1);
		Pokemon starter = getRanPoke();
		party.add(starter);
		System.out.println(starter.getName());	
	}
}