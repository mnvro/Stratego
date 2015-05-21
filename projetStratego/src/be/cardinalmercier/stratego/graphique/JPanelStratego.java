package be.cardinalmercier.stratego.graphique;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import be.cardinalmercier.stratego.GestionClic;
import be.cardinalmercier.stratego.Pion;
import be.cardinalmercier.stratego.Stratego;



public class JPanelStratego extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbLignes;
	private int nbColonnes;
	
	private int largeur;
	private int hauteur;
	protected int type = Stratego.PLATEAU_DE_JEU; // TODO
	
	private Stratego stratego;




	private JButtonStratego[][] tabJB;

	public void rendreCliquableToutesLesCasesLibresSurSonPropreTerrain(){
		for (int l = 6; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				if (tabJB[l][c].estLibre())
					tabJB[l][c].setCliquable(true);
				else
					tabJB[l][c].setCliquable(false);
			}
		}	
	}
	

	
	public void rendreCliquableToutesLesCasesLibres(){
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				if (tabJB[l][c].estLibre())
					tabJB[l][c].setCliquable(true);
				else
					tabJB[l][c].setCliquable(false);
			}
		}	
	}
	
	public void rendreToutNonCliquable(){
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				tabJB[l][c].setCliquable(false);
			}
		}
	}
	
	
	public void rendreCliquableToutesLesCasesOccupees(){
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				if (tabJB[l][c].estLibre())
					tabJB[l][c].setCliquable(false);
				else
					tabJB[l][c].setCliquable(true);
			}
		}
		
	}

	public JButtonStratego getJb (int ligne, int colonne){
		return tabJB[ligne][colonne];
	}
	public JButtonStratego[][] getTabJb() {
		return tabJB;
	}

	

	public void setBoutonCliquable(int ligne, int colonne){
		tabJB[ligne][colonne].setCliquable(true);
	}

	public void setBoutonNonCliquable(int ligne, int colonne, String message){
		tabJB[ligne][colonne].setCliquable(false);
		tabJB[ligne][colonne].setMessage(message);
	}
	
	public void setTousLesBoutonsCliquables(){
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				tabJB[l][c].setCliquable(true);
			}
		}
	}

	public void setTousLesBoutonsNonCliquables(String message){
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				tabJB[l][c].setCliquable(false);
				tabJB[l][c].setMessage(message);
			}
		}
	}

	public JPanelStratego(int nbLignes, int nbColonnes,char couleurDuJoueur,Stratego stratego,int type){
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.type = type;
		this.stratego = stratego;

		largeur = nbColonnes*Stratego.largeurPixelImage;
		hauteur = nbLignes*Stratego.hauteurPixelImage;

		//this.setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();

		GridBagConstraints gbc = new GridBagConstraints();

		setLayout(gridBagLayout);

		tabJB = new JButtonStratego[nbLignes][nbColonnes];
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				//System.out.println("l = "+l+" c = "+c);
				tabJB[l][c] = new JButtonStratego(l,c,type,couleurDuJoueur,this);
				tabJB[l][c].setBorder(BorderFactory.createLineBorder(Color.white));
				tabJB[l][c].setPreferredSize(new Dimension(Stratego.largeurPixelImage,Stratego.hauteurPixelImage));
				tabJB[l][c].setMinimumSize(new Dimension(Stratego.largeurPixelImage,Stratego.hauteurPixelImage));
				tabJB[l][c].addActionListener(this);
				
				gbc.gridx = c;
				gbc.gridy = l;
				if (type != Stratego.PLATEAU_DE_JEU)
					tabJB[l][c].setPion(Pion.tabPionsJoueur[l*Stratego.NBCOLONNES+c]);
				tabJB[l][c].setIcon(tabJB[l][c].getImageDeFond());
				//if (!maBoite) jb[l][c].setCliquable(false); else jb[l][c].setCliquable(true);
				add(tabJB[l][c], gbc);
			}
		}
	}



	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	public int getNbLignes() {
		return nbLignes;
	}
	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}
	public int getNbColonnes() {
		return nbColonnes;
	}
	public void setNbColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButtonStratego jbs = (JButtonStratego)e.getSource();
		if (jbs.isCliquable()) {		
			GestionClic.recuClicPlacementPions(jbs.getCoord(), type, stratego);
		}else{
			JOptionPane.showMessageDialog(null, jbs.getMessage());
		}
		

	}


}
