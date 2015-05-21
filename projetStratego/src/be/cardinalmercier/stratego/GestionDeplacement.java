package be.cardinalmercier.stratego;

public class GestionDeplacement {
	public static boolean validePlacement(Clic source, Clic destination){
		// la destination est le plateau de jeu : toujours valide
		if (destination.typeDuJPanel == Stratego.PLATEAU_DE_JEU) return true;
		return false;
	}

}
