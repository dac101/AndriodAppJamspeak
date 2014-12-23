package catchmedia.jamaica.dictionary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FragmentCulture extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		View rootView = inflater.inflate(R.layout.activity_fragment_culture,
				container, false);
		
		View map = rootView.findViewById(R.id.mapMergeView);
		View gallery = rootView.findViewById(R.id.galleryMergeView);

		((LinearLayout)gallery).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getActivity(), GalleryActivity.class);
				getActivity().startActivity(intent);

			}
		});
		((LinearLayout)map).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getActivity(), MapActivity.class);
				getActivity().startActivity(intent);

			}
		});

		return rootView;
	}

}
