package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom()); 
		romain.recevoirCoup((force*this.effetPotion)/ 3);
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
	}
	
	public void bully(Romain romain) {
		while (romain.getForce()>0) {
			this.frapper(romain);
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		//System.out.println(asterix.getNom());
		System.out.println(asterix.toString());
		
		System.out.println(asterix.prendreParole());
		asterix.parler("Me llamo Asterix");
		
		Romain vercingetorix = new Romain("Vercingétorix", 6);
		asterix.frapper(vercingetorix);
		
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
		int forcePotion = panoramix.getForcePotion();
		asterix.boirePotion(forcePotion);
		asterix.frapper(vercingetorix);
	}
}
