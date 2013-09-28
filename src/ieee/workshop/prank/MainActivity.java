package ieee.workshop.prank;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.view.WindowManager;
import android.view.Window;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.content.Context;
import android.view.View.OnClickListener;
import android.media.MediaPlayer;


public class MainActivity extends Activity
{
    Button enter,close;
    TextView introText;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
	          requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.main);
        enter = (Button) findViewById(R.id.buttonXML);
        introText = (TextView) findViewById(R.id.introTextXML);
	      enter.setOnClickListener(new OnClickListener() {

      		@Override
		      public void onClick(View v) {
			      initiatePopupWindow();
	  	    }
	      });

    }

	private PopupWindow pwindo;

	private void initiatePopupWindow() {
    try {
      LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View layout = inflater.inflate(R.layout.popup,(ViewGroup) findViewById(R.id.popupXML));
      pwindo = new PopupWindow(layout, 300, 370, true);
      pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);

      MediaPlayer Intro = MediaPlayer.create(MainActivity.this, R.raw.screech);
      Intro.setVolume(1.0f,1.0f);
      Intro.start();
      introText.setText("HAHAHA");

      close = (Button) layout.findViewById(R.id.closeXML);
      close.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
             finish();
            System.exit(0);
        }
      });

    } catch (Exception e) {
    }
  }
}
