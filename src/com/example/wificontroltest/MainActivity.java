package com.example.wificontroltest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.net.wifi.*;


public class MainActivity extends Activity {
	public TextView t;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.t = (TextView)findViewById(R.id.box1);
		t.setText("test1");
		Thread thr = new Thread(mTask);
	    thr.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	Runnable mTask = new Runnable() {
    public void run() {
        // just sleep for 30 seconds.
                    try {
                        Thread.sleep(3000);
                        runOnUiThread(done);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
        }
    };

    Runnable done = new Runnable() {
        public void run() {
                   t.setText("done");
            }
        };
}
