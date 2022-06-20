package rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/counter")
public class Counter {
	
	private int counter = -999;
	protected synchronized int getCounter() { return counter; }
	protected synchronized int incrCounter() { return ++counter; }
	protected synchronized void setCounter(int i) { counter = i; }
	
	protected synchronized int resetCounter(){ 
		int tmp = getCounter(); setCounter(0); return tmp;
	}
	@GET 
	@Produces("text/plain") public String doRead() {
	    final int tmp = incrCounter();
	    return String.format("%d\n", tmp);
	}

}
