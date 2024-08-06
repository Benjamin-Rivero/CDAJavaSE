package fr.br.cda.poker.business;

import java.util.HashSet;
import java.util.Set;

public class Couleur {

	private Long id;

	private static long compteur = 0L;

	private String nom;

	private String symbole;

	private Set<Carte> cartes;

	public Couleur() {
		this.id = compteur++;
		cartes = new HashSet<Carte>();
	}

	public Couleur(String nom, String symbole) {
		this();
		this.nom = nom;
		this.symbole = symbole;
	}

	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSymbole() {
		return symbole;
	}

	public Set<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(Set<Carte> cartes) {
		this.cartes = cartes;
	}

	@Override
	public String toString() {
		return "Couleur [id=" + id + ", nom=" + nom + ", symbole=" + symbole + "]";
	}

}
