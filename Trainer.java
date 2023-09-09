import java.util.ArrayList;

public class Trainer {
	
	ArrayList<Pokemon> party = new ArrayList<Pokemon>();
	
	public Trainer(Pokemon poke1, Pokemon poke2, Pokemon poke3, Pokemon poke4, Pokemon poke5, Pokemon poke6) {
		party.add(poke1);
		party.add(poke2);
		party.add(poke3);
		party.add(poke4);
		party.add(poke5);
		party.add(poke6);
	}
	
	public ArrayList<Pokemon> getParty() {
		return party;
	}
	
	public String printParty(Trainer trainer) {
		String list = "";
		for (int k = 0; k < trainer.getParty().size(); k++) {
			if (!(trainer.getParty().get(k) == null)) {
				list += (trainer.getParty().get(k).getName() + "\n");
			}
			else System.out.println(".");
		}
		return list;
	}
	
	public void switchOrder(Trainer trainer, Pokemon pokeA, Pokemon pokeB){
		Pokemon temp = pokeA;
		trainer.getParty().set(trainer.getParty().indexOf(pokeA), pokeB);
		trainer.getParty().set(trainer.getParty().indexOf(pokeB), temp);
	}
	
	public void addPoke(Trainer trainer, Pokemon poke) {
		for (int k = 0; k < trainer.getParty().size(); k++) {
			if (trainer.getParty().get(k) == null) {
				trainer.getParty().set(k, poke);
				return;
			}
		}
		System.out.println("Sorry, your party is full\nWould you like to replace one you currently have with " + poke.getName() + "?");
	}

	
    public static void main(String[] args) {
        Pokemon grass1 = new Pokemon(1, "grass", 0, 100, 100, 100, true, "grass1");
        Trainer NPC = new Trainer(grass1, null, null, null, null, null);
        NPC.addPoke(NPC, grass1);
        System.out.println(NPC.printParty(NPC));
        Pokemon fire1 = new Pokemon(1, "grass", 0, 100, 100, 100, true, "fire1");
        NPC.addPoke(NPC, fire1);
        NPC.addPoke(NPC, fire1);
        NPC.addPoke(NPC, fire1);
        NPC.addPoke(NPC, grass1);

        System.out.println(NPC.printParty(NPC));
    }
}
