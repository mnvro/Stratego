package be.cardinalmercier.stratego.graphique;

import be.cardinalmercier.stratego.Stratego;

public class BoiteDeRangement extends JPanelStratego {

	private char couleurDuJoueur;
	private boolean maBoite; 
	
	public BoiteDeRangement(int nbLignes, int nbColonnes, 
			char couleurDuJoueur, boolean maBoite, Stratego stratego) {
		super(nbLignes, nbColonnes, couleurDuJoueur,stratego,Stratego.BOITE_DE_RANGEMENT);
		
		
		this.maBoite = maBoite;
		if (!maBoite) {
			this.setTousLesBoutonsNonCliquables("Cliquez dans votre boîte"); 
		}
		else this.setTousLesBoutonsCliquables();
	}

}
