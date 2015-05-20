/**
 *
 */
package android.audio.player;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

public class AudioPlayerActivity extends Activity implements ServiceConnection
{

	@Override
	public void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onStart()
	{
		super.onStart();

	}

	@Override
	public void onResume()
	{
		super.onResume();
		//bindService(service, conn, flags);
	}

	@Override
	public void onPause()
	{
		super.onPause();
		//		unbindService(conn);
	}

	@Override
	public void onStop()
	{
		super.onStop();

	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();

	}

	@Override
	public void onServiceConnected(final ComponentName name, final IBinder service)
	{

	}

	@Override
	public void onServiceDisconnected(final ComponentName name)
	{

	}

}
