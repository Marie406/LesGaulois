package histoire;

import personnages.Gaulois;
import personnages.Chef;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois [] villageois;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois [nbVillageoisMaximum];
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getNom() {
		return nom;
	}
	
	public Chef getChef() {
		return chef;
	}
	
	public void ajouterHabitant (Gaulois gaulois) {
		this.villageois[nbVillageois] = gaulois;
		this.nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant (int numHab) {
		return this.villageois[numHab];
	}
	
	public void afficherVillageois() {
		String nomChef = (this.getChef()).getNom();
		System.out.println("Dans le village du chef" + nomChef + "vivent les légendaires gaulois :");
		for(int i=0; i<nbVillageois; i++) {
			String nomGaulois = (trouverHabitant(i)).getNom();
			System.out.println("-" + nomGaulois);
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		/*Gaulois gaulois = village.trouverHabitant(30);
		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
		Le tableau commence à l'indice 0 et se termine à l'indice 29*/
		Chef Abraracourcix = new Chef("Abraracourcix ", 6, village);
		village.setChef(Abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterHabitant(asterix);
		/*Gaulois gaulois = village.trouverHabitant(1);
		System.out.println(gaulois);
		null
		Il y a un seul villageois rangé à l'indice 0 du tableau donc évidemment pour l'instant la case 1 correspond
		à une case vide*/
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
