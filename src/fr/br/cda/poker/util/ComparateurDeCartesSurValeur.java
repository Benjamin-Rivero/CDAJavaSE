package fr.br.cda.poker.util;

import java.util.Comparator;

import fr.br.cda.poker.business.Carte;

public class ComparateurDeCartesSurValeur implements Comparator<Carte> {

	@Override
	public int compare(Carte carte1, Carte carte2) {
		if (carte1.getValeur() < carte2.getValeur()) {
			return -1;
		}
		if (carte1.getValeur() > carte2.getValeur()) {
			return 1;
		}
		return 0;
	}

}
