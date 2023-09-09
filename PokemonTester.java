public class PokemonTester extends Pokemon{
  
  public static void TestgetHeath() {
    Pokemon charizard = new Pokemon();
    charizard.getHealth();
    }
  
  public static void TestgetLevel() {
    Pokemon charizard = new Pokemon();
    charizard.getLevel();
  }


  public static void TestgetXP() {
    Pokemon charizard = new Pokemon();
    charizard.getXP();
  }
  
  public static void TestgetName() {
    Pokemon charizard = new Pokemon();
    charizard.getName();
  }

  public static void TestlevelUp() {
    Pokemon charizard = new Pokemon();
    charizard.levelUp();
  }

  public static void Testheal() {
    Pokemon charizard = new Pokemon();
    charizard.heal();
  }
  public static void Testmultiplier() {
    Pokemon charizard = new Pokemon();
    charizard.multiplier();
  }
  
  public static void TestdealDamage() {
    Pokemon charizard = new Pokemon();
    charizard.dealDamage();
  }

  
  public static void main(String[] args) {
    TestgetHeath();
    TestgetLevel();
    TestgetXP();
    TestgetName();
    TestlevelUp();
    Testheal();
    Testmultiplier();
    TestdealDamage();
  }
}
