package be.cardinalmercier.stratego.graphique;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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




	private JButtonStratego[][] jb;

	public void rendreCliquableToutesLesCasesLibresSurSonPropreTerrain(){
		for (int l = 6; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				if (jb[l][c].estLibre())
					jb[l][c].setCliquable(true);
			}
		}	
	}
	
	public void rendreCliquableToutesLesCasesOccupées(){
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				if (!jb[l][c].estLibre())
					jb[l][c].setCliquable(true);
			}
		}	
	}
	
	public void rendreCliquableToutesLesCasesOccupees(){
		for (int l = 6; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				if (!jb[l][c].estLibre())
					jb[l][c].setCliquable(false);
			}
		}
		
	}

	public JButtonStratego[][] getJb() {
		return jb;
	}

	public void setJb(JButtonStratego[][] jb) {
		this.jb = jb;
	}

	public void setBoutonCliquable(int ligne, int colonne){
		jb[ligne][colonne].setCliquable(true);
	}

	public void setBoutonNonCliquable(int ligne, int colonne, String message){
		jb[ligne][colonne].setCliquable(false);
		jb[ligne][colonne].setMessage(message);
	}
	
	public void setTousLesBoutonsCliquables(){
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				jb[l][c].setCliquable(true);
			}
		}
	}

	public void setTousLesBoutonsNonCliquables(String message){
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				jb[l][c].setCliquable(false);
				jb[l][c].setMessage(message);
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

		jb = new JButtonStratego[nbLignes][nbColonnes];
		for (int l = 0; l < nbLignes; l++) {
			for (int c = 0; c < nbColonnes; c++){
				//System.out.println("l = "+l+" c = "+c);
				jb[l][c] = new JButtonStratego(l,c,type,couleurDuJoueur,this);
				jb[l][c].setPreferredSize(new Dimension(Stratego.largeurPixelImage,Stratego.hauteurPixelImage));
				jb[l][c].setMinimumSize(new Dimension(Stratego.largeurPixelImage,Stratego.hauteurPixelImage));
				jb[l][c].addActionListener(this);
				
				gbc.gridx = c;
				gbc.gridy = l;
				if (type != Stratego.PLATEAU_DE_JEU)
					jb[l][c].setPion(Pion.tabPionsJoueur[l*Stratego.NBCOLONNES+c]);
				jb[l][c].setIcon(jb[l][c].getImageDeFond());
				//if (!maBoite) jb[l][c].setCliquable(false); else jb[l][c].setCliquable(true);
				add(jb[l][c], gbc);
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
