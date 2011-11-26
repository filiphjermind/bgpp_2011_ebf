package mainWindow;
import java.util.GregorianCalendar;


public class ReservationData {
private final boolean beingServiced;
private final GregorianCalendar end;
private final GregorianCalendar start;

public ReservationData(GregorianCalendar start, GregorianCalendar end, boolean beingServiced ) {
	this.start = start;
	this.end = end;
	this.beingServiced = beingServiced;
	
}
}
