package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestingAllVehiclesDB.class, TestingReservationDB.class,
		TestingSpecificVehicleDB.class, TestingTodaysReservationsDB.class,
		TestingTodaysReturns.class, TestingVehicleClassDB.class })

public class AllTests {

}
