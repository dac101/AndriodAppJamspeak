package catchmedia.jamaica.dictionary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FragmentLesson extends Fragment {

	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity_fragment_lesson, container, false);
		
		View food  = rootView.findViewById(R.id.foodMergeView);
		View thing = rootView.findViewById(R.id.thingMergeView);
		View greeting = rootView.findViewById(R.id.greetingMergeView);
		
		((LinearLayout)food).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getActivity(), HomeLessonActivity.class);
				intent.putExtra("Type","Foods");
				getActivity().startActivity(intent);

			}
		});
		((LinearLayout)thing).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getActivity(), HomeLessonActivity.class);
				intent.putExtra("Type","Things" );
				getActivity().startActivity(intent);

			}
		});

		((LinearLayout)greeting).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(getActivity(), HomeLessonActivity.class);
				intent.putExtra("Type","Greetings");
				getActivity().startActivity(intent);

			}
		});
		
		return rootView;
	}

}
