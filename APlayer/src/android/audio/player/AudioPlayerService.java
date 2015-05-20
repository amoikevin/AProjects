/**
 *
 */
package android.audio.player;

import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.ExoPlayer.Listener;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.view.KeyEvent;

/**
 * @author JKL
 */
public class AudioPlayerService extends Service
{
	public final class ServiceBinder extends Binder
	{
		public void addListener(final Listener listener)
		{
			if (mExoPlayer != null)
				mExoPlayer.addListener(listener);
		}

		public void next()
		{

		}

		public void previous()
		{

		}

		public void start()
		{

		}

		public void pause()
		{

		}

		public void stop()
		{

		}
	}

	public final static String ACTION_PLAY = "ACTION_PLAY";
	public final static String ACTION_PAUSE = "";

	private ExoPlayer mExoPlayer = null;

	@Override
	public IBinder onBind(final Intent intent)
	{
		return null;
	}

	@Override
	public boolean onUnbind(final Intent intent)
	{
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate()
	{
		super.onCreate();

		mExoPlayer = ExoPlayer.Factory.newInstance(1);
	}

	@Override
	public int onStartCommand(final Intent intent, final int flags, final int startId)
	{
		if (intent != null)
			switch (intent.getAction())
			{
				case ACTION_PLAY:

					break;

				case ACTION_PAUSE:
					break;
			}
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
		if (mExoPlayer != null)
			mExoPlayer.release();
	}

	protected void play()
	{

	}

	private void register()
	{
		final IntentFilter mediafilter = new IntentFilter();
		//拦截按键KeyEvent.KEYCODE_MEDIA_NEXT、KeyEvent.KEYCODE_MEDIA_PREVIOUS、KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE
		mediafilter.addAction(Intent.ACTION_MEDIA_BUTTON);
		mediafilter.setPriority(100);//设置优先级，优先级太低可能被拦截，收不到信息。一般默认优先级为0，通话优先级为1，该优先级的值域是-1000到1000。
		registerReceiver(mMediaReceiver, mediafilter);
	}

	private final BroadcastReceiver mMediaReceiver = new BroadcastReceiver()
	{
		@Override
		public void onReceive(final Context context, final Intent intent)
		{
			//判断是不是耳机按键事件
			if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction()))
			{
				final KeyEvent event = (KeyEvent) intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);//判断有没有耳机按键事件
				if (event == null || KeyEvent.ACTION_UP != event.getAction())
					return;
				switch (event.getKeyCode())
				{
					case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE://播放或暂停

						break;

					case KeyEvent.KEYCODE_MEDIA_NEXT://短按=播放下一首音乐，长按=音量加
						break;

					case KeyEvent.KEYCODE_MEDIA_PREVIOUS://短按=播放上一首音乐，长按=音量减
						break;
				}
			}
		}
	};
}
