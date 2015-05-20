/**
 *
 */
package android.audio.player;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.Window;
import android.widget.FrameLayout;

/**
 * @author JKL
 */
public class VideoPlayerActivity extends Activity implements Callback, OnBufferingUpdateListener, OnCompletionListener,
		OnErrorListener, OnInfoListener, OnSeekCompleteListener, OnPreparedListener
{
	private FrameLayout mRootLayout = null;
	private SurfaceView mVideoSurface = null;
	private MediaPlayer mMediaPlayer = null;

	@Override
	public void onCreate(final Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_default_video_player);

		mRootLayout = (FrameLayout) findViewById(R.id.root);
		mVideoSurface = (SurfaceView) mRootLayout.findViewById(R.id.video_surface);
		mVideoSurface.getHolder().addCallback(this);

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

	private void stop()
	{
		if (mMediaPlayer != null && mMediaPlayer.isPlaying())
			mMediaPlayer.stop();
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		if (mMediaPlayer != null)
		{
			mMediaPlayer.release();
			mMediaPlayer = null;
		}
	}

	@Override
	public void surfaceCreated(final SurfaceHolder holder)
	{
		mMediaPlayer = new MediaPlayer();
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer.setDisplay(holder);
		mMediaPlayer.setOnBufferingUpdateListener(this);
		mMediaPlayer.setOnPreparedListener(this);
		mMediaPlayer.setVideoScalingMode(MediaPlayer.VIDEO_SCALING_MODE_SCALE_TO_FIT);
		mMediaPlayer.setOnCompletionListener(this);
		mMediaPlayer.setOnErrorListener(this);
		mMediaPlayer.setOnInfoListener(this);
		mMediaPlayer.setOnSeekCompleteListener(this);

	}

	@Override
	public void surfaceChanged(final SurfaceHolder holder, final int format, final int width, final int height)
	{

	}

	@Override
	public void surfaceDestroyed(final SurfaceHolder holder)
	{
	}

	@Override
	public void onPrepared(final MediaPlayer mp)
	{
		mMediaPlayer.start();
	}

	@Override
	public void onBufferingUpdate(final MediaPlayer mp, final int percent)
	{

	}

	@Override
	public boolean onKeyUp(final int keyCode, final KeyEvent event)
	{
		switch (keyCode)
		{
			case KeyEvent.KEYCODE_MEDIA_PREVIOUS://耳机三个按键是的上键，注意并不是耳机上的三个按键的物理位置的上下。
				previous();
				break;
			case KeyEvent.KEYCODE_MEDIA_NEXT://耳机三个按键是的下键
				next();
				break;
			case KeyEvent.KEYCODE_MEDIA_PAUSE:
				onPause();
				break;
			case KeyEvent.KEYCODE_MEDIA_PLAY:
				start();
				break;
			case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
			case KeyEvent.KEYCODE_HEADSETHOOK:
				start();
				break;
			default:
				return super.onKeyUp(keyCode, event);
		}
		return true;
	}

	private void next()
	{
		// TODO 自动生成的方法存根

	}

	private void start()
	{
		if (mMediaPlayer != null && !mMediaPlayer.isPlaying())
			try
		{
				mMediaPlayer.setDataSource(
						"http://musicdata.baidu.com/data2/music/240373726/2403730813600128.mp3");
				mMediaPlayer.prepareAsync();
		}
		catch (IllegalArgumentException | SecurityException | IllegalStateException | IOException e)
		{
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	private void previous()
	{
		// TODO 自动生成的方法存根

	}

	@Override
	public boolean onError(final MediaPlayer mp, final int what, final int extra)
	{

		return false;
	}

	@Override
	public void onCompletion(final MediaPlayer mp)
	{

	}

	@Override
	public boolean onInfo(final MediaPlayer mp, final int what, final int extra)
	{

		return false;
	}

	@Override
	public void onSeekComplete(final MediaPlayer mp)
	{

	}

}
