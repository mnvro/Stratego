package be.cardinalmercier.stratego.graphique;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;

import be.cardinalmercier.stratego.Coordonnee;
import be.cardinalmercier.stratego.Pion;
import be.cardinalmercier.stratego.Stratego;

public class JButtonStratego extends JButton {
	private Coordonnee coord;
	private Pion pion;
	private ImageIcon imageDeFond;
	private int type;
	private boolean cliquable;
	private String message = "on ne peut pas cliquer ici";
	JPanelStratego parent;
	
	public void videCase(){
		pion = null;
		this.setIcon(imageDeFond);
		
		if (parent.type == Stratego.BOITE_DE_RANGEMENT){
			this.setEnabled(false);
		}
	}
	
	public void entoureDeBlanc(){
		this.setBorder(BorderFactory.createLineBorder(Color.white));
	}
	
	public void entoureDOrange(){
		this.setBorder(new MatteBorder(5, 5, 5, 5, Color.ORANGE));
	}
	//stratego.getJPanelEnFonctionDuType(source.typeDuJPanel).getJb()[source.coord.getLigne()][source.coord.getColonne()]
	
	public void placeUnPion(Pion p){
		pion = p;
		this.setIcon(new ImageIcon(GestionImage.getImagePion(p, p.getCouleur())));
	}
	
	
	public boolean isCliquable() {
		return cliquable;
	}
	public void setCliquable(boolean cliquable) {
		this.cliquable = cliquable;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @param ligne
	 * @param colonne
	 * @param surLeJeu
	 * @param couleur
	 * @param parent 0 pour dire que le jButton fait partie du plateau de jeu, 1 s'il appartient à la boîte de rangement de l'adversaire et 2 si c'est ma boîte de rangement
	 */
	public JButtonStratego(int ligne, int colonne, int type, char couleur, JPanelStratego parent) {
		super();
		this.type = type;
		this.parent = parent;
		//this.cliquable = cliquable;
		
		this.coord = new Coordonnee(ligne,colonne);
		
		if (type == Stratego.PLATEAU_DE_JEU){
			imageDeFond = new ImageIcon(GestionImage.getImagePlateauDeJeu(ligne, colonne));
			
			pion = null;
		} else{
			setPion(Pion.tabPionsJoueur[ligne*Stratego.NBCOLONNES+colonne]);
			imageDeFond = new ImageIcon(GestionImage.getImageBoiteDeRangement(pion.getType(), ligne, colonne, couleur));
			
		}
		this.setIcon(imageDeFond);
		
	}
	
	public Coordonnee getCoord() {
		return coord;
	}
	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}
	public Pion getPion() {
		return pion;
	}
	public void setPion(Pion pion) {
		this.pion = pion;
	}
	public ImageIcon getImageDeFond() {
		return imageDeFond;
	}
	public void setImageDeFond(ImageIcon imageDeFond) {
		this.imageDeFond = imageDeFond;
	}
	
	public boolean estLibre(){
		return pion == null;
	}

}
