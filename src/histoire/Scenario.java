package histoire;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 4);
		Gaulois obelix = new Gaulois("Obélix", 14);
		Romain minus = new Romain("Minus", 16);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		
		panoramix.parler("Je vais aller préparer une petite portion...");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		
		asterix.boirePotion(panoramix.getForcePotion());
		
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.bully(minus);
	}

}
