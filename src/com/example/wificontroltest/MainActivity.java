package com.example.wificontroltest;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.net.wifi.*;
import android.util.*;

public class MainActivity extends Activity {
	public TextView t;
	private Handler mHandler;
	private Runnable mRunnable;
	private TimerTask mTask;
    private Timer mTimer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.t = (TextView)findViewById(R.id.box1);
		t.setText("test1");
		
		mTask = new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				SupplicantState status; 
	        	WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
	        	WifiInfo wifiInfo = wifiManager.getConnectionInfo();
	        	status = wifiInfo.getSupplicantState();
	        	String result = null;
				if (status.equals(SupplicantState.COMPLETED)) {
					t.setText("COMPLETED");
					result = "COMPLETED";
				} 
				if (status.equals(SupplicantState.ASSOCIATED)) {
					t.setText("ASSOCIATED");
					result = "ASSOCIATED";
				}
				if (status.equals(SupplicantState.ASSOCIATING)) {
					t.setText("ASSOCIATING");
					result = "ASSOCIATING";
				}
				if (status.equals(SupplicantState.AUTHENTICATING)) {
					t.setText("AUTHENTICATING");
					result = "AUTHENTICATING";
				}
				if (status.equals(SupplicantState.DISCONNECTED)) {
					t.setText("DISCONNECTED");
					result = "DISCONNECTED";
				}
				if (status.equals(SupplicantState.DORMANT)) {
					t.setText("DORMANT");
					result = "DORMANT";
				}
				if (status.equals(SupplicantState.FOUR_WAY_HANDSHAKE)) {
					t.setText(" FOUR_WAY_HANDSHAKE ");
					result = " FOUR_WAY_HANDSHAKE ";
				}
				if (status.equals(SupplicantState.GROUP_HANDSHAKE)) {
					t.setText("GROUP_HANDSHAKE");
					result = "GROUP_HANDSHAKE";
				}
				if (status.equals(SupplicantState.INACTIVE)) {
					t.setText("INACTIVE");
					result = "INACTIVE";
				}
				if (status.equals(SupplicantState.INTERFACE_DISABLED)) {
					t.setText("INTERFACE_DISABLED");
					result = "INTERFACE_DISABLED";
				}
				if (status.equals(SupplicantState.INVALID)) {
					t.setText("INVALID");
					result = "INVALID";
				}
				if (status.equals(SupplicantState.SCANNING)) {
					t.setText("SCANNING");
					result = "SCANNING";
				}
				if (status.equals(SupplicantState.UNINITIALIZED)) {
					t.setText("UNINITIALIZED");
					result = "UNINITIALIZED";
				}			
				Log.d("wifi testing",result );
	                   
            }
		};
		
		mTimer = new Timer();
		mTimer.schedule(mTask, 500, 1000);
			
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
    
    protected void onDestroy() {
        Log.i("test", "onDstory()");
        mTimer.cancel();
        super.onDestroy();
    }
}
