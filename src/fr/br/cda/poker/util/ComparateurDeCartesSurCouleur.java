package fr.br.cda.poker.util;

import java.util.Comparator;

import fr.br.cda.poker.business.Carte;

public class ComparateurDeCartesSurCouleur implements Comparator<Carte> {

	ComparateurDeCartesSurValeur compatCartesSurValeur = new ComparateurDeCartesSurValeur();

	@Override
	public int compare(Carte carte1, Carte carte2) {
		if (carte1.getCouleur().getId().equals(carte2.getCouleur().getId())) {
			return compatCartesSurValeur.compare(carte1, carte2);
		} else {
			return -2;
		}
	}

}
