package be.cardinalmercier.stratego;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.border.MatteBorder;

import be.cardinalmercier.stratego.graphique.JPanelStratego;

public class GestionClic {

	private static Clic source;
	private static Clic destination;
	//private static int moment;
	private static Pion pionSelectionne;


	public static void recuClicPlacementPions(Coordonnee coord, int typeDuJPanel, Stratego stratego){
		if (source==null) {
			source = new Clic(coord,typeDuJPanel);
			int ligneSource = source.coord.getLigne();
			int colonneSource = source.coord.getColonne();
			JPanelStratego jpsource = stratego.getJPanelEnFonctionDuType(source.typeDuJPanel);
			pionSelectionne = jpsource.getJb(ligneSource,colonneSource).getPion();
			jpsource.getJb(ligneSource,colonneSource).entoureDOrange();
			stratego.getPlateauDeJeu().rendreCliquableToutesLesCasesLibresSurSonPropreTerrain();


		}
		else {
			destination = new Clic(coord,typeDuJPanel);
			if (GestionDeplacement.validePlacement(source, destination)){
				JPanelStratego jpDestination = stratego.getJPanelEnFonctionDuType(destination.typeDuJPanel);
				JPanelStratego jpSource = stratego.getJPanelEnFonctionDuType(source.typeDuJPanel);
				int ligneSource = source.coord.getLigne();
				int colonneSource = source.coord.getColonne();
				int ligneDest = coord.getLigne();
				int colonneDest = coord.getColonne();
				jpDestination.getJb(ligneDest,colonneDest).placeUnPion(pionSelectionne);
				//System.out.println("source : "+source+ " destination : "+destination);
				//System.out.println("stratego.getJPanelEnFonctionDuType(source.typeDuJPanel) : "+stratego.getJPanelEnFonctionDuType(source.typeDuJPanel).getClass());
				//jpsource.getTabJb()[source.coord.getLigne()][source.coord.getColonne()].setBorder(BorderFactory.createLineBorder(Color.white)); // beark
				jpSource.getJb(ligneSource,colonneSource).entoureDeBlanc();
				jpSource.getJb(ligneSource,colonneSource).videCase();
				stratego.getPlateauDeJeu().rendreCliquableToutesLesCasesOccupees();
				stratego.getBoiteDeRangement().rendreCliquableToutesLesCasesOccupees();
				source = null;
			} 
			destination = null;

		}
	}





}
