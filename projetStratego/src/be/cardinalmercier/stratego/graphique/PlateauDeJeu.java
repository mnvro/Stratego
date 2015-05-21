package be.cardinalmercier.stratego.graphique;

import be.cardinalmercier.stratego.Stratego;



public class PlateauDeJeu extends JPanelStratego {
	

	public PlateauDeJeu(int nbLignes, int nbColonnes, char couleurDuJoueur,
			Stratego stratego) {
		super(nbLignes, nbColonnes, couleurDuJoueur, stratego,Stratego.PLATEAU_DE_JEU);
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
