package catchmedia.jamaica.dictionary;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class AboutUs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        final TextView textView = (TextView)findViewById(R.id.catchMediaWebsite);
         textView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(Intent.ACTION_VIEW,
                         Uri.parse("http://www.catchmedia.co/"));
                 startActivity(i);
             }
         });

    }



}
