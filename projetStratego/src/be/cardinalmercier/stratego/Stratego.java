package be.cardinalmercier.stratego;

import java.awt.EventQueue;

import be.cardinalmercier.stratego.graphique.BoiteDeRangement;
import be.cardinalmercier.stratego.graphique.JFramePrincipaleStratego;
import be.cardinalmercier.stratego.graphique.JPanelStratego;
/*
 * 
Les pions de chaque joueur se compose dans l'ordre croissant des pièces suivantes:

1 Drapeau	
1 Maréchal
1 Général
2 Colonels	
3 Commandants	
4 capitaines
4 lieutenants
4 sergents	
5 Démineurs	
8 Éclaireurs
1 Espion	
6 bombes

 */
import be.cardinalmercier.stratego.graphique.PlateauDeJeu;

/**
 * La classe Stratego contient toutes les valeurs concernant le jeu de Strateto
 * principalement les constantes
 * @author Marie-Noël Vroman
 *
 */
public class Stratego implements Runnable {
	/**
	 * le nombre de cases en hauteur sur le plateau de jeu
	 */
	public static final int NBLIGNES = 10;
	/**
	 * le nombre de cases en largeur sur le plateau de jeu
	 */
	public static final int NBCOLONNES = 10;
	/**
	 * la largeur en pixel de chaque image
	 */
	public static final int largeurPixelImage = 50;
	/**
	 * la hauteur en pixel de chaque image
	 */
	public static final int hauteurPixelImage = 50;

	

	public static final int nbPixelsAjoutesEnHauteur = 70;
	public static final int nbPixelsAjoutesEnLargeur = 50;
	
	public static final int MOMENT_DU_JEU_PLACER_LES_PIECES = 0;
	
	public static final int BOITE_DE_RANGEMENT = 0;
	public static final int BOITE_DE_RANGEMENT_ADVERSE = 1;
	public static final int PLATEAU_DE_JEU = 2;
	
	public int momentDuJeu = MOMENT_DU_JEU_PLACER_LES_PIECES;
	
	
	public JFramePrincipaleStratego framePrincipale;
	private char couleur;
	private BoiteDeRangement boiteDeRangement;
	private BoiteDeRangement boiteDeRangementAdversaire;
	private PlateauDeJeu plateauDeJeu;
	
	public char getCouleur() {
		return couleur;
	}
	public void setCouleur(char couleur) {
		this.couleur = couleur;
	}
	public BoiteDeRangement getBoiteDeRangement() {
		return boiteDeRangement;
	}
	public void setBoiteDeRangement(BoiteDeRangement boiteDeRangement) {
		this.boiteDeRangement = boiteDeRangement;
	}
	public BoiteDeRangement getBoiteDeRangementAdversaire() {
		return boiteDeRangementAdversaire;
	}
	public void setBoiteDeRangementAdversaire(
			BoiteDeRangement boiteDeRangementAdversaire) {
		this.boiteDeRangementAdversaire = boiteDeRangementAdversaire;
	}
	public PlateauDeJeu getPlateauDeJeu() {
		return plateauDeJeu;
	}
	public void setPlateauDeJeu(PlateauDeJeu plateauDeJeu) {
		this.plateauDeJeu = plateauDeJeu;
	}
	
	public JPanelStratego getJPanelEnFonctionDuType(int type){
		switch (type){
			case PLATEAU_DE_JEU : return plateauDeJeu; 
			case BOITE_DE_RANGEMENT : return boiteDeRangement;
			case BOITE_DE_RANGEMENT_ADVERSE : return boiteDeRangementAdversaire;
		}
		return null;
	}
	
	public Stratego(){
		EventQueue.invokeLater(this);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Stratego stratego = new Stratego();
		
	}
	@Override
	public void run() {
		try {
			framePrincipale = new JFramePrincipaleStratego(this);
			framePrincipale.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
