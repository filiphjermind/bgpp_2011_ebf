package view.homeGui;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;



public class VehicleData {
	private final int id;
	private final String vehicleClass;
	private final List<ReservationData> reservations;

	public VehicleData(int id, String vehicleClass, List<ReservationData> reservations) {
		this.id = id;
		this.vehicleClass = vehicleClass;
		this.reservations = reservations;
	}
	public int getId() {
		return id;
	}
	public String getVehicleClass() {
		return vehicleClass;
	}
	public List<ReservationData> getReservations() {
		return reservations;
	}
	
	@Override
	public String toString() {
		return "id: "+id+" vehicleClass: "+ vehicleClass + " reservations: "+ reservations.toString();
	}

}
