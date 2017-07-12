package optNet.model2;

import sim.engine.SimState;
import sim.engine.Steppable;

public class CAP_WeekForCAP implements Steppable {
	
	CAP cap;

	public CAP_WeekForCAP(CAP cap) {
		super();
		this.cap = cap;
	}
	
	public void step(SimState state) { //processo CapDemand --> viene lanciato all'inizio della settimana
		
		Model model = (Model) state;
		
		//double CAPWeeklyDemand = //lo devo leggere dal file Excel degli input; 
		
		//cap.weeklyDemandValue = CAPWeeklyDemandValue;
		
		cap.actualDemand = cap.actualDemand + cap.weeklyDemandValue;
		
		cap.totalDemand = cap.totalDemand + cap.weeklyDemandValue;
				
	    if (cap.DFTassociato != null) {
	    	cap.DFTassociato.dFTWeeklyDemand = cap.DFTassociato.dFTWeeklyDemand + cap.weeklyDemandValue;
	    } else if (cap.DFLassociato != null) {
	    	cap.DFLassociato.dFLWeeklyDemand = cap.DFLassociato.dFLWeeklyDemand + cap.weeklyDemandValue;
	    } else {
	    	throw new IllegalStateException("ATTENZIONE: Non � vero che il CAP � collegato a un DFT o un DFL");
	    }
		
	}
	
	
}
