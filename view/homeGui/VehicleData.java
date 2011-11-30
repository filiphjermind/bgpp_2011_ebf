package View.homeGui;
import java.util.List;



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

}
