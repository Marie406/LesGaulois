package personnages;
import java.util.Random;


public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForcePotion() {
		return forcePotion;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public int preparerPotion() {
		Random random = new Random();
		int forcePotionDruide = random.nextInt(effetPotionMax - effetPotionMin +1) +effetPotionMin;
		if (forcePotionDruide>7) {
			this.parler("J'ai préparé une super potion de force " + forcePotionDruide);
		}
		else {
			this.parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotionDruide);
		}
		this.forcePotion = forcePotionDruide;
		return forcePotionDruide;
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			this.parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		}
		else {
			gaulois.boirePotion(this.forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 14);
		
		panoramix.booster(asterix);
		panoramix.booster(obelix);
	}
}
