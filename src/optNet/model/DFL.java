package optNet.model;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import sim.engine.SimState;
import sim.util.Double2D;

public class DFL {

	public String name;
	
	public Double2D posizione; 
	
	public double dFLWeeklyDemand; //domanda generata dai CAP di competenza che il DFL deve soddisfare

	public double dFTOrder; //ordine di prodotto inviato al DFT
		
	public double weekVolSatisfied; //volume di prodotto ricevuto dal DFT nella settimana considerata
	
	public double inventoryWeight; //scorte
	
	public WeightedGraph<Object, DefaultWeightedEdge> grafo;
	
	//private double[] kmVolDFTDFL; //vettore a 2 componenti che tiene conto della distanza dal DFT da cui viene servito e della quantit� di prodotto che � stata consegnata al DFL
	
	//private double numberOfTrip; //numero di viaggi compiuti tra il DFT e il DFL per soddisfare gli ordini del DFL
	
	//private double kmTravelled; //numero di km percorsi per raggiungere il DFL dal DFT
	
	//private double transpCost; //costo totale di trasporto per raggiungere il DFL dal DFT
	
	//private final double TRANSP_CAPACITY; //capacit� del mezzo di trasporto per servire il DFL
	
	//private final double KM_COST; //costo al km
	
	//costruttore
	public DFL(String name, Double2D posizione, double dFLWeeklyDemand, double dFTOrder, double weekVolSatisfied, double inventoryWeight, WeightedGraph<Object, DefaultWeightedEdge> grafo) {
		super();
		this.name = name;
		this.posizione = posizione;
		this.dFLWeeklyDemand = dFLWeeklyDemand;
		this.dFTOrder = dFTOrder;
		this.weekVolSatisfied = weekVolSatisfied;
		this.inventoryWeight = inventoryWeight;
		this.grafo = grafo;
	}
	
	public void step(SimState state) { ////////////MASON
		
		Model model = (Model) state;
		
		this.grafo = model.grafo; 
		
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((posizione == null) ? 0 : posizione.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DFL other = (DFL) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (posizione == null) {
			if (other.posizione != null)
				return false;
		} else if (!posizione.equals(other.posizione))
			return false;
		return true;
	}
	
	
	
}
