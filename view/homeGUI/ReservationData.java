package view.homeGUI;

import java.util.GregorianCalendar;

public class ReservationData {
	private final boolean beingServiced;
	private final GregorianCalendar end;
	private final GregorianCalendar start;

	public ReservationData(GregorianCalendar start, GregorianCalendar end, boolean beingServiced) {
		this.start = start;
		this.end = end;
		this.beingServiced = beingServiced;
	}

	/*
	 * @return int the start day of the reservation. Given as 0 indexed.
	 */
	public int getStartDay() {
		return start.get(GregorianCalendar.DAY_OF_MONTH)-1;
	}

	public boolean getBeingServiced() {
		return beingServiced;
	}

	/*
	 * @return the duration in days of a reservation
	 */
	public int getDuration() {
		return end.get(GregorianCalendar.DAY_OF_MONTH) - start.get(GregorianCalendar.DAY_OF_MONTH);
	}
	@Override
	public String toString() {
		return "start: "+ start.getTimeInMillis() + " end: "+ end.getTimeInMillis() + " beingServiced: " +beingServiced;
	}
}
