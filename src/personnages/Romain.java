package personnages;

public class Romain {
	private String nom;
	private int force; 
	private Equipement [] equipements = new Equipement [2];
	int nbEquipement = 0;

	
	public Romain(String nom, int force) {
		if (force<0) {
			throw new IllegalArgumentException("Invalid force " + force);
		}
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
	
//	public void recevoirCoup(int forceCoup) {
//		assert this.getForce()>=0;
//		int ancienneForce = this.force;
//		this.force = this.getForce() - forceCoup;
//		if (this.getForce() > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert this.getForce()<=ancienneForce;
//	}
	
	private void armement(Equipement tool) {
		this.equipements[this.nbEquipement] = tool;
		this.nbEquipement +=1;
		System.out.println("Le soldat " + this.getNom() + " s’équipe avec un " + tool.toString());
	}
	
	public void sEquiper(Equipement tool) {
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
			default:
				System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
		}
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
	 // if (force > 0) {
		// parler("Aïe");
	 // } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		if (force <= 0) 
			parler("J'abandonne...");
		else {
			equipementEjecte = ejecterEquipement();
			parler("Aïe");
		}
			// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (forceCoup<resistanceEquipement) {
			return 0;
		}
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				}
			}
		return equipementEjecte;
	}

	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		/*System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);*/
		Equipement.CASQUE.setNom("casque");
		Equipement.BOUCLIER.setNom("bouclier");
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		
	}
	
	
}
