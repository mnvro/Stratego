package be.cardinalmercier.stratego.graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.ObjectInputStream.GetField;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.cardinalmercier.stratego.Couleur;
import be.cardinalmercier.stratego.Stratego;

public class JFramePrincipaleStratego extends JFrame {
	
	Stratego stratego;






	/**
	 * Create the frame.
	 */
	public JFramePrincipaleStratego(Stratego stratego) {
		this.stratego = stratego;
		stratego.setCouleur((JOptionPane.showInputDialog("Votre couleur (R/B) ?","Bleu")).toUpperCase().charAt(0));
		
		stratego.setPlateauDeJeu(new PlateauDeJeu(Stratego.NBLIGNES,Stratego.NBCOLONNES,stratego.getCouleur(),stratego));
		stratego.setBoiteDeRangement(new BoiteDeRangement(4,Stratego.NBCOLONNES,stratego.getCouleur(),true,stratego));
		stratego.setBoiteDeRangementAdversaire(new BoiteDeRangement(4,Stratego.NBCOLONNES,Couleur.getAutreCouleur(stratego.getCouleur()),false,stratego));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, stratego.getPlateauDeJeu().getLargeur()+stratego.getBoiteDeRangement().getLargeur() + Stratego.nbPixelsAjoutesEnLargeur, 
				stratego.getPlateauDeJeu().getHauteur() + Stratego.nbPixelsAjoutesEnHauteur
		);
		setMinimumSize(new Dimension(Stratego.NBCOLONNES*Stratego.largeurPixelImage + Stratego.nbPixelsAjoutesEnLargeur, 
				Stratego.NBLIGNES*Stratego.hauteurPixelImage + Stratego.nbPixelsAjoutesEnHauteur)
		);
		
		
		JPanel jPanelHaut = new JPanel();
		getContentPane().add(jPanelHaut, BorderLayout.NORTH);
		
		JPanel jPanelBas = new JPanel();
		getContentPane().add(jPanelBas, BorderLayout.SOUTH);
		
		JPanel jPanelDroit = new JPanel();
		getContentPane().add(jPanelDroit, BorderLayout.EAST);
		jPanelDroit.setLayout(new BorderLayout(0, 0));
		
		JPanel jPanelCentre = new JPanel();
		getContentPane().add(jPanelCentre, BorderLayout.CENTER);
		
		jPanelCentre.add(stratego.getPlateauDeJeu());
		jPanelDroit.add(stratego.getBoiteDeRangementAdversaire(),BorderLayout.NORTH);
		jPanelDroit.add(stratego.getBoiteDeRangement(),BorderLayout.SOUTH);
	}

}
