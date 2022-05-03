package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;
import model.Booking;

public class QueryBookingResultsIteratorTest {

	private LinkedList<Booking> list;

	private QueryBookingResultsIterator queryBookingResultsIterator;

	@Before
	public void setup() {
		list = new LinkedList<>();
		list.add(new Booking(null, null, null, 0, null));
		this.queryBookingResultsIterator = new QueryBookingResultsIterator(list);
	}

	@Test
	public void shouldFirst() {
		Booking actualValue = queryBookingResultsIterator.first();

		// TODO: assert scenario
		assertEquals(list.getFirst(), actualValue);
	}

	@Test
	public void shouldNext() {
		Booking actualValue = queryBookingResultsIterator.next();

		// TODO: assert scenario
		assertNull(actualValue);
	}

	@Test
	public void shouldCurrentItem() {
		Booking actualValue = queryBookingResultsIterator.currentItem();

		// TODO: assert scenario
		assertNotNull(actualValue);
	}

	@Test
	public void shouldIsDone() {
		boolean actualValue = queryBookingResultsIterator.isDone();

		// TODO: assert scenario
		assertFalse(actualValue);
	}
}
