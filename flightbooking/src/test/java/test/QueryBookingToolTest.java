package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class QueryBookingToolTest {

	private QueryBookingTool queryBookingTool;

	@Before
	public void setup() {
		this.queryBookingTool = new QueryBookingTool();
	}

	@Test
	public void shouldExecuteQuery() {
		QueryResults actualValue = queryBookingTool.executeQuery();

		// TODO: assert scenario
		assertNotNull(actualValue);
	}

	@Test
	public void shouldRun() {
		queryBookingTool.run();

		// TODO: assert scenario
		assertTrue(true);
	}
}
