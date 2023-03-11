package personnages;

public enum Equipement {
	CASQUE, 
	BOUCLIER;
	private String nom;
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public String toString() {
		return this.nom;
	}
	
	public static void main(String[] args) {
		CASQUE.setNom("casque");
		BOUCLIER.setNom("bouclier");
	}
}
