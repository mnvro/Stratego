package be.cardinalmercier.stratego;

import java.awt.Color;

import javax.swing.border.EtchedBorder;

import be.cardinalmercier.stratego.graphique.JPanelStratego;



public class GestionClic {

	private static Clic source;
	private static Clic destination;
	//private static int moment;
	private static Pion pionSelectionne;


	public static void recuClicPlacementPions(Coordonnee coord, int typeDuJPanel, Stratego stratego){
		if (source==null) {
			source = new Clic(coord,typeDuJPanel);
			pionSelectionne = stratego.getJPanelEnFonctionDuType(typeDuJPanel).getJb()[coord.getLigne()][coord.getColonne()].getPion();
			//stratego.getJPanelEnFonctionDuType(typeDuJPanel).getJb()[coord.getLigne()][coord.getColonne()].videCase();
			stratego.getJPanelEnFonctionDuType(typeDuJPanel).getJb()[coord.getLigne()][coord.getColonne()].setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.BLACK, null));
			stratego.getPlateauDeJeu().rendreCliquableToutesLesCasesLibresSurSonPropreTerrain();
		}
		else {
			destination = new Clic(coord,typeDuJPanel);
			if (GestionDeplacement.validePlacement(source, destination)){
				stratego.getJPanelEnFonctionDuType(typeDuJPanel).getJb()[coord.getLigne()][coord.getColonne()].placeUnPion(pionSelectionne);
				//System.out.println("source : "+source+ " destination : "+destination);
				stratego.getJPanelEnFonctionDuType(source.typeDuJPanel).getJb()[source.coord.getLigne()][source.coord.getColonne()].videCase();
				stratego.getJPanelEnFonctionDuType(source.typeDuJPanel).getJb()[source.coord.getLigne()][source.coord.getColonne()].setBorder(null);
				
				
				source = null;
			} else{
				destination = null;
			}
		}




	}
}
