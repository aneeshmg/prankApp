package ieee.workshop.prank;

import android.app.Activity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.content.Intent;

public class Splash extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timer = new Thread() {

           public void run() {
              try {
                 sleep(900);
              } catch(InterruptedException e) {
                 e.printStackTrace();
              } finally {
                   Intent startMain = new Intent("ieee.workshop.prank.MAIN");
                   startActivity(startMain);
              }
           }
        };
        timer.start();
    }

    @Override
    protected void onPause()  {
      super.onPause();
      finish();
    }
}
