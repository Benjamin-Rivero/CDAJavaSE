package fr.br.cda.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.br.cda.poker.business.Carte;
import fr.br.cda.poker.business.Couleur;
import fr.br.cda.poker.business.Deck;
import fr.br.cda.poker.business.Joueur;
import fr.br.cda.poker.business.MainJoueur;

public class Main {

	public static void main(String[] args) {
		int compteur = 0;
		Deck deck = new Deck();

		Joueur j1 = new Joueur("j1");
		Joueur j2 = new Joueur("j2");
		Joueur j3 = new Joueur("j3");
		Joueur j4 = new Joueur("j4");

		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(j1);
		joueurs.add(j2);
		joueurs.add(j3);
		joueurs.add(j4);
		List<Couleur> couleurs = new ArrayList<Couleur>();
		couleurs.add(new Couleur("Coeur", "♥"));
		couleurs.add(new Couleur("Trefle", "♣"));
		couleurs.add(new Couleur("Carreau", "♦"));
		couleurs.add(new Couleur("Pique", "♠"));

//		for(Joueur joueur : joueurs) {
//			joueur.setMain(joueur.sortMain());
//		}
		while (true) {
			long start2 = System.nanoTime();
			deck.remplirDeck(couleurs);
			System.out.println(deck);

			Collections.shuffle(deck.getDeckCartes());

			for (int i = 0; i < 20; i++) {
				Carte carte = deck.getDeckCartes().remove(0);
				switch (i % 4) {
				case 0 -> j1.getMain().getMain().add(carte);
				case 1 -> j2.getMain().getMain().add(carte);
				case 2 -> j3.getMain().getMain().add(carte);
				case 3 -> j4.getMain().getMain().add(carte);
				}
			}
			System.out.println("Joueur 1");
			System.out.println(j1);
//			System.out.println("Joueur 2");
//			System.out.println(j2);
//			System.out.println("Joueur 3");
//			System.out.println(j3);
//			System.out.println("Joueur 4");
//			System.out.println(j4);
			if (j1.getMain().combinaison() == 1) {
				System.out.println();
				break;
			}
			System.out.println("Compteur : " + compteur++);
			j1.setMain(new MainJoueur());
			j2.setMain(new MainJoueur());
			j3.setMain(new MainJoueur());
			j4.setMain(new MainJoueur());
			long end2 = System.nanoTime();
			System.out.println("Elapsed Time in nano seconds: " + (end2 - start2));
		}

//		System.out.println();
//		System.out.println("Joueur 2");
//		System.out.println(j2);
//		j2.getMain().test();
//		System.out.println();
//		System.out.println("Joueur 3");
//		System.out.println(j3);
//		j3.getMain().test();
//		System.out.println();
//		System.out.println("Joueur 4");
//		System.out.println(j4);
//		j4.getMain().test();
		System.out.println();

	}

}
