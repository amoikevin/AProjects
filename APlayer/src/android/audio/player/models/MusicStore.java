package android.audio.player.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MusicStore
{
	private static List<MusicInfo> _musics;
	private static int _index;

	static
	{
		_musics = new ArrayList<MusicInfo>();
		_index = -1;
	}

	public static void setList(final Collection<MusicInfo> musics)
	{
		if (_musics.size() > 0)
		{
			_musics.clear();
			_index = -1;
		}
		if (musics != null && musics.size() > 0)
			_musics.addAll(musics);
	}

	public static void setIndex(final int index)
	{
		if (index < 0 || _index == index)
			return;
		_index = index - 1;
	}

	public static void clear()
	{
		_musics.clear();
	}

	public static MusicInfo getNext()
	{
		if (_musics.size() == 0)
			return null;
		_index = ++_index % _musics.size();
		return _musics.get(_index);
	}
}
