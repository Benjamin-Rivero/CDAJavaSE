package fr.br.cda.poker.business;

public class Joueur {

	private Long id;

	private static long compteur = 0L;

	private String pseudo;

	private float solde;

	private MainJoueur main;

	public Joueur() {
		this.id = compteur++;
		this.solde = 120f;
		this.main = new MainJoueur();
	}

	public Joueur(String pseudo) {
		this();
		this.pseudo = pseudo;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public MainJoueur getMain() {
		return main;
	}

	public void setMain(MainJoueur main) {
		this.main = main;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Joueur [id=" + id + ", pseudo=" + pseudo + ", solde=" + solde + ", main=" + main + "]";
	}

}
