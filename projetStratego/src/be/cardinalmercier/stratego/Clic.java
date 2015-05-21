package be.cardinalmercier.stratego;

public class Clic {
	Coordonnee coord;
	int  typeDuJPanel;
	public Clic(Coordonnee coord, int  typeDuJPanel) {
		super();
		this.coord = coord;
		this.typeDuJPanel = typeDuJPanel;
	}
	@Override
	public String toString() {
		return "Clic [coord=" + coord + ", typeDuJPanel=" + typeDuJPanel + "]";
	}
	
	
}
