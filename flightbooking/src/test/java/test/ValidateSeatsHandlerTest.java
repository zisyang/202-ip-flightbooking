package test;

import org.junit.Before;
import org.junit.Test;

import model.Booking;

import static org.junit.Assert.assertEquals;

public class ValidateSeatsHandlerTest {

	private ValidateSeatsHandler validateSeatsHandler;

	@Before
	public void setup() {
		this.validateSeatsHandler = new ValidateSeatsHandler();
	}

	@Test
	public void shouldValidateRequest() {
		// TODO: initialize args
		Booking request = new Booking("bookingName", "flightNumber", "seatCategory", 1, "paymentCardNumber");

		int actualValue = validateSeatsHandler.validateRequest(request);

		// TODO: assert scenario
		assertEquals(0, actualValue);
	}
}
