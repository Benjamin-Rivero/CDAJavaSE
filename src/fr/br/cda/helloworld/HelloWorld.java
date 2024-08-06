package fr.br.cda.helloworld;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloWorld {

	private Scanner sc = new Scanner(System.in);

	private void helloWorld() {
		System.out.println("Hello World !");
		System.out.println(this.getClass().getSimpleName());
		System.out.println(this.getClass().getPackageName());
		for (Field field : this.getClass().getFields()) {
			System.out.println(field.toString());
		}
		for (Constructor<?> constructor : this.getClass().getConstructors()) {
			System.out.println(constructor.toString());
		}
		for (Method method : this.getClass().getMethods()) {
			System.out.println(method.toString());
		}
	}

	private double convertKmToMiles(double km) {
		return km / 1.6214;
	}

	private double convertMilesToKm(double miles) {
		return miles * 1.6214;
	}

	// method to convert user input from km to miles
	private void convertWithUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bienvenue, veuillez saisir une distance en kilomètres :");
		double input;
		try {
			input = scanner.nextDouble();
			System.out.printf("Vous avez saisi : %.1f km%n", input);
			System.out.printf("Cette distance en km est équivalente à %f miles%n", this.convertKmToMiles(input));
		} catch (InputMismatchException e) {
			System.out.println("Erreur d'entrée : Valeur non reconnue");
		}

	}

	private void priceIsRight() {
		int rand = (int) (Math.random() * 100);
		Scanner scanner = new Scanner(System.in);
		int input = -1;
		int compteur = 0;
		System.out.println("Bienvenue sur Devinez un nombre !");
		do {
			System.out.print("Veuillez saisir un nombre compris entre 1 et 100 : ");
			try {
				input = scanner.nextInt();

				compteur++;
				if (input < rand) {
					System.out.println("C'est plus");
				}
				if (input > rand) {
					System.out.println("C'est moins");
				}
			} catch (InputMismatchException e) {
				System.out.println("Vous n'avez pas rentrer un nombre.");
				scanner.nextLine();
			}
		} while (input != rand);
		System.out.printf("Vous avez trouvé en %d essais%n", compteur);
	}

	private void triangle(int n) {
		String text = "";
		for (int i = 0; i < n; i++) {
//			for(int j = 0 ; j<=i ; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
			text += "*";
			System.out.println(text);
		}
	}

	/*
	 * * *** ***** ******* *********
	 */
	private void pyramide(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n - i; j > 1; j--) {
				System.out.print(" ");
			}

			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private void triangleRecursif(int n) {
		if (n == 0) {
			return;
		}
		triangleRecursif(n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();

	}

	private void horlogeBerling() {
		Scanner scanner = new Scanner(System.in);
		int heure = -1;
		int minute = -1;
		System.out.println("Bienvenue sur l'horloge de Berlin");

		while (!(heure <= 23 && heure >= 0)) {
			System.out.print("Entrez les heures (0-23) : ");
			try {
				heure = scanner.nextInt();
				if (heure > 23 || heure < 0) {
					System.out.println("Entrée invalide, en dehors des bornes");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrée invalide, mauvais type");
				scanner.nextLine();
			}

		}
		scanner.nextLine();
		while (!(minute <= 59 && minute >= 0)) {
			System.out.print("Entrez les minutes (0-59) : ");
			try {
				minute = scanner.nextInt();
				if ((minute > 59 || minute < 0)) {
					System.out.println("Entrée invalide, en dehors des bornes");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrée invalide, mauvais type");
				scanner.nextLine();
			}

		}

		String firstLine = "";
		String secondLine = "";
		String thirdLine = "";
		String fourthLine = "";
		while (heure >= 5) {
			firstLine += "O ";
			heure -= 5;
		}
		while (heure > 0) {
			secondLine += "o ";
			heure -= 1;
		}
		while (minute >= 5) {
			thirdLine += "X ";
			minute -= 5;
		}
		while (minute > 0) {
			fourthLine += "x ";
			minute -= 1;
		}
		System.out.println("L1 : " + firstLine);
		System.out.println("L2 : " + secondLine);
		System.out.println("L3 : " + thirdLine);
		System.out.println("L4 : " + fourthLine);
	}

	private void cafe() {
		System.out.println("Bienvenue sur la machine à café CDA Java");
//		System.out.println("Quantité de café dans chaque tasse : 9 grammes");
		System.out.println("Faites votre choix");
		System.out.println("1. Cappuccino");
		System.out.println("2. Espresso");
		System.out.println("3. Macchiato");
		int choix = sc.nextInt();
		sc.nextLine();
		System.out.printf("Vous avez choisi : %d%n", choix);
		System.out.println("Tapez 1 pour café court, tapez 2 pour café long");
		int choix2 = sc.nextInt();
		for (int i = 0; i < 25; i++) {
			System.out.print("|");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void cafeSansInterruption() {
		final double BORNE_MAX = 92;
		final double BORNE_MIN = 50;
		int choix=1;
		do {
			System.out.println("Bienvenue sur la machine à café CDA Java");
			System.out.println("Quantité de café dans chaque tasse : 9 grammes");
			System.out.println("1: Cappuccino");
			System.out.println("2: Espresso");
			System.out.println("3: Macchiato");
			System.out.println("Faites votre choix svp");
			try {
				choix = sc.nextInt();
				sc.nextLine();
				if (choix >= 1 && choix <= 3) {
					System.out.println("Tapez 1 pour café court, tapez 2 pour café long");
					int choix2 = sc.nextInt();
					String texte = "Préparation de votre ";
					switch (choix) {
					case 1 -> texte += "Cappuccino ";
					case 2 -> texte += "Espresso ";
					case 3 -> texte += "Macchiato ";
					}
					if (choix2 == 1) {
						texte += "Court ";
					}
					if (choix2 == 2) {
						texte += "Long ";
					}
					if(choix2 < 1 || choix2 > 2) {
						System.out.println("Ce n'est pas un choix proposé");
						continue;
					}
					texte += "en cours";
					double temperature = Math.floor((Math.random() * (BORNE_MAX - BORNE_MIN)) + BORNE_MIN);
					System.out.println(texte);
					System.out.printf("Température de l'eau : %.0f°C %n", temperature);
					System.out.println("Chauffage de l'eau pour atteindre 92.5°C");
					for (int i = 0; i < 50; i++) {
						System.out.print("|");
						try {
							Thread.sleep((long) (((BORNE_MAX / temperature) - 0.8) * 100));
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println();
					System.out.println("Voici votre café. Merci d'avoir utilisé la machine à café CDA Java. Bonne dégustation");
					System.out.println();
				} else {
					System.out.println("Ce n'est pas un choix proposé");
				}
			} catch (InputMismatchException e) {
				System.out.println("Veuillez entrer un chiffre entier");
				sc.nextLine();
			}
		} while (true);
	}

	public static void main(String[] args) {
		HelloWorld helloWorld = new HelloWorld();
//		helloWorld.helloWorld();
//		System.out.println(helloWorld.convertKmToMiles(1));
//		System.out.println(helloWorld.convertMilesToKm(1));
//		helloWorld.convertWithUserInput();
//		helloWorld.priceIsRight();
//		helloWorld.triangle(5);
//		helloWorld.pyramide(5);
//		helloWorld.triangleRecursif(5);
//		helloWorld.horlogeBerling();
//		helloWorld.cafe();
		helloWorld.cafeSansInterruption();
	}

}
