package be.cardinalmercier.stratego.graphique;

public class BoiteDeRangement extends JPanelStratego {

	private char couleurDuJoueur;
	private boolean maBoite; 
	public BoiteDeRangement(int nbLignes, int nbColonnes, boolean plateauDeJeu,
			char couleurDuJoueur, boolean maBoite) {
		super(nbLignes, nbColonnes, plateauDeJeu, couleurDuJoueur);
		this.maBoite = maBoite;
		if (!maBoite) {
			this.setTousLesBoutonsNonCliquables("Cliquez dans votre boîte"); 
		}
		else this.setTousLesBoutonsCliquables();
	}

}
