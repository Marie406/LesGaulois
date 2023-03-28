package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	private Equipement [] trophees = new Equipement[100];
	private Musee musee;
	
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
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return ("Le gaulois " + nom + " : ");
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement [] tropheesGaulois = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesGaulois != null && i < tropheesGaulois.length; i++, this.nbTrophees++) {
			this.trophees[this.nbTrophees] = tropheesGaulois[i];
		}
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom()); 
//		romain.recevoirCoup((force*this.effetPotion)/ 3);
//	}
	
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		this.parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
	}
	
	public void bully(Romain romain) {
		while (romain.getForce()>0) {
			this.frapper(romain);
		}
	}
	
	private int getNbTrophees() {
		return this.nbTrophees;
	}
	
	private void setNbTrophees(int nbTrophees) {
		this.nbTrophees = nbTrophees;
	}
	
	// j'ai pas encore testé la fonction
	public void faireUneDonation(Musee musee) {
		if (this.getNbTrophees()>0) {
			this.parler("Je donne au musée tous mes trophées :");
		}
		for(int i=0; i<this.getNbTrophees(); i++) {
			Equipement equipement = trophees[i];
			musee.donnerTrophees(this, equipement);
			System.out.println("- " + equipement.toString());
		}
		this.setNbTrophees(0);
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
		asterix.faireUneDonation(asterix.musee);
		
		
	}
}
