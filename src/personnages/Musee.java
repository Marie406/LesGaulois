package personnages;

// potentiellement pas finie
public class Musee {
	private Trophee [] trophees = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[this.nbTrophee].setEquipement(equipement);
		this.nbTrophee += 1;
	}
	
}
