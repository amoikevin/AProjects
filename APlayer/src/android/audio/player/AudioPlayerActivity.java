package android.audio.player;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.exoplayer.ExoPlayer;

public class AudioPlayerActivity extends Activity
{
	private ExoPlayer _MediaPlayer = null;

	@Override
	public void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		_MediaPlayer = ExoPlayer.Factory.newInstance(1);
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

	}

	@Override
	public void onPause()
	{
		super.onPause();

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

	public void start()
	{

	}

	public void pause()
	{

	}

}
