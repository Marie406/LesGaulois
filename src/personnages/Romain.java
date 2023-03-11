package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement [] equipements = new Equipement [2];
	int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		assert force >=0;
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert this.getForce()>=0;
		int ancienneForce = this.force;
		this.force = this.getForce() - forceCoup;
		if (this.getForce() > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert this.getForce()<=ancienneForce;
	}
	
	private void armement(Equipement tool) {
		this.equipements[this.nbEquipement] = tool;
		this.nbEquipement +=1;
		System.out.println("Le soldat " + this.getNom() + " s’équipe avec un " + tool.toString());
	}
	
	public void sEQuipier(Equipement tool) {
		switch(nbEquipement) {
			case 0:
				this.armement(tool);
				break;
			case 1:
				if(this.equipements[0] == tool) {
					System.out.println("Le soldat " + this.getNom() + " possède déjà un " + tool.toString() + " !");
				}
				else {
					this.armement(tool);
				}
				break;
			case 2:
				System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		/*System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);*/
		Equipement.CASQUE.setNom("casque");
		Equipement.BOUCLIER.setNom("bouclier");
		minus.sEQuipier(Equipement.CASQUE);
		minus.sEQuipier(Equipement.CASQUE);
		minus.sEQuipier(Equipement.BOUCLIER);
		minus.sEQuipier(Equipement.CASQUE);
		
	}
	
	
}
