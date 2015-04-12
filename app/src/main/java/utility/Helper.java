package utility;

import android.provider.UserDictionary;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import catchmedia.jamaica.dictionary.R;
import database.Marker;

public class Helper {

	public Helper() {
		super();
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;

    /*
         * creating random postion around a location for testing purpose only
         */
    public static double[] createRandLocation(double latitude, double longitude) {

        return new double[]{latitude + ((Math.random() - 0.5) / 500),
                longitude + ((Math.random() - 0.5) / 500),
                150 + ((Math.random() - 0.5) * 10)};
    }

    public static float setIconColor(Marker x) {

        if(x.getType().contains("Sport")){
        return  BitmapDescriptorFactory.HUE_GREEN;
        }
        else if(x.getType().equals("Beach")){
         return BitmapDescriptorFactory.HUE_BLUE;
        }

        else if(x.getType().equals("staduim")){
            return BitmapDescriptorFactory.HUE_CYAN;
        }else{
          return BitmapDescriptorFactory.HUE_RED;
        }
    }

    public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

    /**
     * @param @dyamically gets all the images id and name put it
     * @param @class      call ImageInfo
     * @by using fields
     */
    public static void getImages(String imageFilter,ArrayList<ImageInfo> info) {
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
