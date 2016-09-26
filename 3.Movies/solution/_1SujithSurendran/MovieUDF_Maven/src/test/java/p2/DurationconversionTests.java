package p2;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.pig.data.DefaultTuple;
import org.apache.pig.parser.QueryParser.assert_clause_return;
import org.junit.Test;

public class DurationconversionTests {

	@Test
	public void Should_Validate_When_Input_IsNull() throws IOException {

		final String message = "duration is empty";

		DefaultTuple tuple = new DefaultTuple();
		tuple.append(null);

		assertEquals(message, new DurationConversion().exec(tuple));
	}

	@Test
	public void Should_Validate_When_Tuple_IsValide() throws IOException {

		final String message = "43 min 40 sec";

		DefaultTuple tuple = new DefaultTuple();
		tuple.append("2620");

		assertEquals(message, new DurationConversion().exec(tuple));
	}

}
