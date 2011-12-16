package test.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestingAllVehiclesDB.class, TestingReservationDB.class,
		TestingSpecificVehicleDB.class, TestingTodaysReservations.class,
		TestingTodaysReturns.class, TestingVehicleClassDB.class })
public class AllTests {

}
