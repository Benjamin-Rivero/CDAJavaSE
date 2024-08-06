package fr.br.cda.poker.business;

public class Carte {

	private String nom;

	private int valeur;

	private Couleur couleur;

	public Carte() {
		super();
	}

	public Carte(int valeur, Couleur couleur) {
		this();
		this.valeur = valeur;
		this.couleur = couleur;
		switch (valeur) {
		case 14 -> nom = "As";
		case 11 -> nom = "Valet";
		case 12 -> nom = "Dame";
		case 13 -> nom = "Roi";
		default -> nom = String.valueOf(valeur);
		}
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return String.format("%s %s", nom, this.getCouleur().getSymbole());
	}

}
