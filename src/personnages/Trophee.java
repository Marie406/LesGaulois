package personnages;

import personnages.Gaulois;
import personnages.Equipement;

// Potentiellement pas finie
public class Trophee {
	private Gaulois gaulois;
	private Equipement equipement;
	
	public void setGaulois(Gaulois gaulois) {
		this.gaulois = gaulois;
	}
	
	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}
	
	public Equipement getEquipement() {
		return this.equipement;
	}
	
	
	private String donnerNom(Gaulois gaulois) {
		return gaulois.getNom();
	}
}
