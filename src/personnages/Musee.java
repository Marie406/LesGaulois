package personnages;

// potentiellement pas finie
public class Musee {
	private Trophee [] trophees = new Trophee[200];
	private int nbTrophee;

	public Musee() {
		this.nbTrophee = 0;
	}
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		
		trophees[this.nbTrophee] = new Trophee(gaulois, equipement);
		this.nbTrophee += 1;
	}
	
	public String extraireInstructionsCaml() {
		String chaine = "let musee = [\n";
		for(int i=0; i<nbTrophee-1; i++) {
			chaine += "\"" + (trophees[i].getGaulois()).getNom() + "\"";
			chaine += ", \"" + trophees[i].getEquipement().toString() + "\";\n";
		}
		chaine += "\"" + (trophees[nbTrophee-1].getGaulois()).getNom() + "\"";
		chaine += ", \"" + trophees[nbTrophee-1].getEquipement().toString() + "\"\n]";
		return chaine;
	}
	
}
