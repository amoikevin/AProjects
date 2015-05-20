package android.audio.player.models;

import java.util.ArrayList;
import java.util.List;

public class MusicInfo
{
	private String title;
	private String url;
	private String artists;
	private String album;
	private boolean hasMovie;
	private final List<AudioInfo> audios;

	public MusicInfo()
	{
		audios = new ArrayList<AudioInfo>();
	}

}
