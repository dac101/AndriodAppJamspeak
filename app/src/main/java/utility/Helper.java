package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

	public Helper() {
		super();
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;

	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}
}
