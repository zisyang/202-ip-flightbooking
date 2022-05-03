package test;

import org.junit.Before;
import org.junit.Test;

import model.Booking;
import model.Reason;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidateCardHandlerTest {

	private ValidateCardHandler validateCardHandler;

	@Before
	public void setup() {
		this.validateCardHandler = new ValidateCardHandler();
	}

	@Test
	public void shouldValidateRequest() {
		// TODO: initialize args
		Booking request = new Booking("bookingName", "flightNumber", "seatCategory", 1, "paymentCardNumber");

		int actualValue = validateCardHandler.validateRequest(request);

		// TODO: assert scenario
		assertEquals(Reason.CARD.getCode(), actualValue);
	}

	@Test
	public void shouldCheckVisa() {
		// TODO: initialize args
		String card = "234234234";

		boolean actualValue = validateCardHandler.checkVisa(card);

		// TODO: assert scenario
		assertFalse(actualValue);
	}

	@Test
	public void shouldCheckMaster() {
		// TODO: initialize args
		String card = "30457034503384096834524325";

		boolean actualValue = validateCardHandler.checkMaster(card);

		// TODO: assert scenario
		assertFalse(actualValue);
	}

	@Test
	public void shouldCheckDiscover() {
		// TODO: initialize args
		String card = "";

		boolean actualValue = validateCardHandler.checkDiscover(card);

		// TODO: assert scenario
		assertFalse(actualValue);
	}

	@Test
	public void shouldCheckAmex() {
		// TODO: initialize args
		String card = "341000000000000";

		boolean actualValue = validateCardHandler.checkAmex(card);

		// TODO: assert scenario
		assertTrue(actualValue);
	}
}
