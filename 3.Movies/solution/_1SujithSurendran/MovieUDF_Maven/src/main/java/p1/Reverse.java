package p1;


import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

public class Reverse extends EvalFunc<String> {

	@Override
	public String exec(Tuple input) throws IOException {

		if (input == null)
			return null;

		String str = (String) input.get(0);
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse().toString();
	}

}

