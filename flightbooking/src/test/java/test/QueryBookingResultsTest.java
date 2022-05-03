package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class QueryBookingResultsTest {

	private QueryBookingResults queryBookingResults;

	@Before
	public void setup() {
		this.queryBookingResults = new QueryBookingResults();
	}

	@Test
	public void shouldCreateIterator() {
		QueryResultsIterator actualValue = queryBookingResults.createIterator();

		// TODO: assert scenario
		assertNotNull(actualValue);
	}

	@Test
	public void shouldFetchData() {
		queryBookingResults.fetchData();

		// TODO: assert scenario
		assertTrue(true);
	}
}
