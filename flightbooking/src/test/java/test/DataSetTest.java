package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import model.Booked;
import model.Booking;
import model.Category;
import model.Flight;

public class DataSetTest {

	private DataSet dataSet;

	@Before
	public void setup() {
		this.dataSet = DataSet.getInstance();
		String f = "ABC123";
		String c = Category.getNameFromText("Business");
		Flight flight = new Flight(c, f, 1, 10.0, "FromCity", "ToCity");
		dataSet.getFlightsMap().put("1", flight);
		dataSet.getBookings().add(new Booking("Someone", f, c, 2, "541000000000"));
	}

	@Test
	public void shouldGetInstance() {
		DataSet actualValue = DataSet.getInstance();

		// TODO: assert scenario
		assertNotNull(actualValue);
	}

	@Test
	public void shouldCreateKeyString() {
		// TODO: initialize args
		String flightNumber = "ABC123";
		String category = Category.getNameFromText("Business");

		String actualValue = DataSet.createKeyString(flightNumber, category);

		// TODO: assert scenario
		assertEquals("ABC123_Business", actualValue);
	}

	@Test
	public void shouldGetFlightsMap() {
		HashMap<String,Flight> actualValue = dataSet.getFlightsMap();

		// TODO: assert scenario
		assertEquals(1, actualValue.size());
	}

	@Test
	public void shouldGetBookeds() {
		HashSet<Booked> actualValue = dataSet.getBookeds();

		// TODO: assert scenario
		assertNotNull(actualValue);
	}

	@Test
	public void shouldGetBookings() {
		LinkedList<Booking> actualValue = dataSet.getBookings();

		// TODO: assert scenario
		assertNotNull(actualValue);
	}

	@Test
	public void shouldGetInvalids() {
		ArrayList<String> actualValue = dataSet.getInvalids();

		// TODO: assert scenario
		assertNotNull(actualValue);
	}

	@Test
	public void shouldProcessBooking() {
		// TODO: initialize args
		Booking booking = null;
		boolean validated = false;

		Booked actualValue = DataSet.processBooking(booking, validated);

		// TODO: assert scenario
		assertNull(actualValue);
	}
}
