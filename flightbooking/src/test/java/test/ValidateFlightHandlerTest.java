package test;

import org.junit.Before;
import org.junit.Test;

import model.Booking;
import model.Reason;

import static org.junit.Assert.assertEquals;

public class ValidateFlightHandlerTest {

	private ValidateFlightHandler validateFlightHandler;

	@Before
	public void setup() {
		this.validateFlightHandler = new ValidateFlightHandler();
	}

	@Test
	public void shouldValidateRequest() {
		// TODO: initialize args
		Booking request = new Booking("bookingName", "flightNumber", "seatCategory", 1, "paymentCardNumber");

		int actualValue = validateFlightHandler.validateRequest(request);

		// TODO: assert scenario
		assertEquals(Reason.FLIGHTNUMBER.getCode(), actualValue);
		
	}
}
