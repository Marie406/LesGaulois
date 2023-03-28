package personnages;


// Potentiellement pas finie
public class Trophee {
	private Gaulois gaulois;
	private Equipement equipement;
	
	public Trophee(Gaulois gaulois, Equipement equipement) {
		this.gaulois = gaulois;
		this.equipement = equipement;
	}
	
	public Equipement getEquipement() {
		return this.equipement;
	}
	
	public Gaulois getGaulois() {
		return this.gaulois;
	}
	
}
