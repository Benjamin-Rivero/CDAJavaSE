package fr.br.cda.poker.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainJoueur {

	private List<Carte> main;

	private int value;

	public MainJoueur() {
		super();
		main = new ArrayList<Carte>();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Carte> getMain() {
		return main;
	}

	@Override
	public String toString() {
		return "MainJoueur [main=" + main + "]";
	}

	public int combinaison() {
		List<Carte> cartes = this.getMain();

		long countCouleur = cartes.stream().map(Carte::getCouleur).distinct().count();
		long countValeur = cartes.stream().map(Carte::getValeur).distinct().count();
		var collectorPerValeur = cartes.stream()
				.collect(Collectors.groupingBy(Carte::getValeur, Collectors.counting()));
		int min = Collections.min(collectorPerValeur.keySet());
		int max = Collections.max(collectorPerValeur.keySet());
		// Quinte flush royale
		if ((max == min + 4 && countCouleur == 1 && countValeur == 5 && collectorPerValeur.containsKey(14))) {
			return 1;
		}

		// Quinte flush
		if ((max == min + 4 && countCouleur == 1 && countValeur == 5 && !collectorPerValeur.containsKey(14) || collectorPerValeur.keySet().containsAll(Set.of(14, 2, 3, 4, 5)))) {
			return 2;
		}

		// Carre
		if (collectorPerValeur.values().contains(4L)) {
			return 3;
		}

		// Full
		if ((collectorPerValeur.values().contains(2L) && collectorPerValeur.values().contains(3L))) {
			return 4;
		}

		// Couleur
		if ((countCouleur == 1 && !(max == min + 4))) {
			return 5;
		}

		// Quinte
		if ((max == min + 4 && countCouleur != 1 && countValeur == 5) || collectorPerValeur.keySet().containsAll(Set.of(14, 2, 3, 4, 5))) {
			return 6;
		}

		// Brelan
		if (collectorPerValeur.values().contains(3L) && collectorPerValeur.keySet().size() > 2) {
			return 7;
		}

		// Double paire
		if ((collectorPerValeur.values().stream().filter(value -> value == 2).count() == 2)) {
			return 8;
		}

		// Paire
		if ((collectorPerValeur.values().stream().filter(value -> value == 2).count() == 1
				&& collectorPerValeur.values().stream().filter(value -> value == 3).count() == 0)) {
			return 9;
		}

		// Carte haute
		return 10;
	}

}
