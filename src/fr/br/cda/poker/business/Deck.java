package fr.br.cda.poker.business;

import java.util.ArrayList;
import java.util.List;

public class Deck {

	private List<Carte> deckCartes;

	public Deck() {
		super();
	}

	public List<Carte> getDeckCartes() {
		return deckCartes;
	}

	@Override
	public String toString() {
		return "Deck [deckCartes=" + deckCartes.size() + "]";
	}

	public void remplirDeck(List<Couleur> couleurs) {

		deckCartes = new ArrayList<Carte>();
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j <= 14; j++) {
				Carte carte = new Carte(j, couleurs.get(i));
				deckCartes.add(carte);
				couleurs.get(i).getCartes().add(carte);
			}
		}
	}

}
