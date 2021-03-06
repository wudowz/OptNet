package optNet.model;

import org.jgrapht.WeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import packageMason.Tutorial1;
import sim.engine.*;
import sim.util.*;
import sim.field.continuous.Continuous2D;

public class Model extends SimState {
	
	public double AllCapDemand; //domanda totale generata dai CAP nel periodo considerato
	
	public double AllDemandSatisfied; //domanda totale dei CAP che � stata soddisfatta nel periodo considerato
	
	public double ServiceLevel; //livello di servizio (AllCapDemand/AllDemandSatisfied)
	
	public double TotalCost; //costo totale di trasporto da sostenere con la configurazione di rete considerata
	
	public double ToCapCost; //costo totale per raggiungere i CAP dai DFT o DFL 
	
	public double ToDFLCost; //costo totale per raggiungere i DFL dai DFT 
	
	public double ToDFTCost; //costo totale per raggiungere i DFT dai Plant 
	
	public double ToCapKm; //km totali percorsi per raggiungere i CAP dai DFT o DFL 
	
	public double ToDFLKm; //km totali percorsi per raggiungere i DFL dai DFT 
	
	public double ToDFTKm; //km totali percorsi per raggiungere i DFT dai Plant
	
	public final double TRANSP_CAPACITY = 0; //capacit� del mezzo di trasporto
	
    public final double KM_COST = 0; //costo al km
	
	public int width = 10000; //ampiezza del field model ////////////MASON
	
	public int height = 10000; //altezza del field model ////////////MASON
	
	public final int NUM_PLANT = 6; //numero dei Plant
	
	public final int NUM_CAP = 4413; //numero dei CAP
	
	public int numDFT; //numero dei DFT
	
	public int numDFL; //numero dei DFL
	
	public WeightedGraph<Object, DefaultWeightedEdge> grafo; //grafo non orientato pesato in cui i nodi sono gli impianti della Supply Chain,
															  //gli archi collegano due impianti associati e i pesi degli archi rappresentano
															  //le distanze tra questi ultimi
	
	public Continuous2D modelField = new Continuous2D(1.0,width,height); ////////////MASON
	
	public Model(long seed) ////////////MASON
    {
    super(seed);
    }
	
	/**
	 * metodo che legge il file sim_legge.txt e crea il grafo che ha come nodi i Plant, i CAP e i centri di distribuzione attivati 
	 */
	public void creaGrafo() {
		
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//leggi info da CAP.csv e da Plant.csv
		
		//crea Plant e CAP letti dai file usando i relativi costruttori (tutti i fields vanno inizializzati a 0 eccetto nome e posizione)
		
		//leggi file sim_legge.txt e determina i DFT e DFL da creare
		
		//leggi info da DFT.csv e DFL.csv
		
		//crea DFT e DFL letti dai file usando i relativi costruttori (tutti i fields vanno inizializzati a 0 eccetto nome e posizione)
		
		//aggiungi questi oggetti come nodi del grafo
		
		//per ogni Plant crea un arco verso ogni DFT
		
		//per ogni DFL crea un arco verso il DFT pi� vicino 
		
		//per ogni CAP crea un arco verso il DFT o DFL pi� vicino 
		
		/////////MASON per trovare l'oggetto pi� vicino si potrebbe usare questa funzione:
		/////////public�Bag�getNearestNeighbors(Double2D�position,int�atLeastThisMany,boolean�toroidal,boolean�nonPointObjects,boolean�radial,Bag�result)
		
	}
	
	/**
	 * dato un grafo, il metodo legge il file sim_legge.txt e modifica il grafo 
	 * @throws Exception 
	 */
	public void modificaGrafo() {
		
		if (this.grafo == null) 
			throw new NullPointerException("Non c'� nessun grafo da modificare");
		
		//leggi file sim_legge.txt
		
		//determina DFT e DFL da eliminare
		
		//elimina dal grafo i nodi associati a tali centri con il metodo: removeVertex(V�v) (� importante ridefinire equals)
		//e gli archi associati a tali nodi 
		
		//determina i DFT e DFL da creare; per crearli leggi info da DFT.csv e DFL.csv
		
		//collega ogni DFT creato ai Plant
		
		//per ogni DFL cerca il DFT pi� vicino e se non � gi� presente un link, crealo
		
		//per ogni CAP cerca il DFT o DFL pi� vicino e se non � gi� presente un link, crealo
	}
	
	/**
	 * @return il numero di DFT 
	 */
	public int contaDFT() { //conta il numero di vertici del grafo che sono DFT
		
	}
	
	/**
	 * @return il numero di DFL
	 */
	public int contaDFL() { //conta il numero di vertici del grafo che sono DFT
		
	}
	
	//il metodo start fa iniziare la simulazione	
	public void start() { ////////////MASON
		
		super.start();
		
		numDFT = contaDFT();
		
		numDFL = contaDFL();
		
		//inserire gli impianti associati ai nodi del grafo nello Schedule 
		
		//da completare
	}	

	public static void main(String[] args) { ////////////MASON
		
		Model model = new Model(System.currentTimeMillis());
		
		final int NUMERO_SIMULAZIONI = 50;
		
		final int NUMERO_RUN = 4;
		
		int contatoreSimulazioni = 0;
		
		model.creaGrafo();
		
		while (contatoreSimulazioni < NUMERO_SIMULAZIONI) {
			
			//inserire codice per leggere info da sim_legge.txt
			
			int contatoreRun = 0;
			
			model.modificaGrafo();
			
			while(contatoreRun < NUMERO_RUN) {
				
	    		model.start();
	    		
	    		long steps;
	    		
	    		do
	    			{
	    			if (!model.schedule.step(model))
	    				break;
	    			steps = model.schedule.getSteps();
	    			if (steps % 500 == 0)
	    				System.out.println("Steps: " + steps + " Time: " + model.schedule.time());
	    			}
	    		while(steps < 5000);
	    		
	    		model.finish();
	    		
	    		//inserire codice per memorizzare il costo totale e il livello di servizio del singolo run
	    		
			}
			
			//inserire codice per calcolare il valor medio del costo totale e del livello di servizio ottenuti nei vari run
			
			//inserire codice per riempire il file opt_legge.txt da dare in input all'ottimizzatore;
			
			//vedi pag 66 della tesi di marco per i diagrammi di flusso dell'ottimizzatore e del simulatore
			
			System.exit(0);  // make sure any threads finish up
		}
		
		//doLoop(Model.class, args);
		//System.exit(0);
	}

}
