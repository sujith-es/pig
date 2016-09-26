package p2;

import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class DurationConversion extends EvalFunc<String> {

	private static final int SECONDS_IN_A_MINUTE = 60;

	public String exec(Tuple input) throws IOException {

		if (input == null || input.size() == 0)
			return "tuple is null";

		try {
			String str = (String) input.get(0);

			if (str == null || str.isEmpty())
				return "duration is empty";

			int seconds = Integer.parseInt(str);

			return timeConversion(seconds);

		} catch (Exception e) {
			throw new IOException("Caught exception processing input row ", e);

		}

	}

	private String timeConversion(int totalSeconds) {

		int minutes = (totalSeconds) / SECONDS_IN_A_MINUTE;
		int seconds = totalSeconds - (minutesToSeconds(minutes));
		return minutes + " min " + seconds + " sec";
	}

	private int minutesToSeconds(int minutes) {
		return minutes * SECONDS_IN_A_MINUTE;
	}

}
