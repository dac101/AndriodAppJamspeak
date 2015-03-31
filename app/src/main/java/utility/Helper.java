package utility;

import android.provider.UserDictionary;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import catchmedia.jamaica.dictionary.R;

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

    public void getImages(String imageFilter,ArrayList<ImageInfo> info) {
        Field[] drawables = R.drawable.class.getFields();
        ArrayList<Integer> ids = new ArrayList<Integer>();

        int[] resArray = new int[drawables.length];

        for (int i = 0; i < drawables.length; i++) {
            try {
                if (drawables[i].getName().contains(imageFilter)) {
                    resArray[i] = drawables[i].getInt(null);
                    ids.add(drawables[i].getInt(null));
                    info.add(new ImageInfo(drawables[i].getName(), drawables[i].getInt(null)));
                }
            } catch (IllegalAccessException e) {
                return;
            } catch (IllegalArgumentException e) {
                return;
            }
        }
    }
}
