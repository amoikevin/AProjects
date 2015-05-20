/**
 *
 */
package android.audio.player;

import android.app.Fragment;
import android.audio.player.MusicListFragment.RecyclerAdapter.RecyclerViewHolder;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MusicListFragment extends Fragment
{
	public final class RecyclerAdapter extends Adapter<RecyclerViewHolder>
	{
		public final class RecyclerViewHolder extends ViewHolder
		{
			public RecyclerViewHolder(final View itemView)
			{
				super(itemView);
			}
		}

		@Override
		public int getItemCount()
		{

			return 0;
		}

		@Override
		public void onBindViewHolder(final RecyclerViewHolder arg0, final int arg1)
		{

		}

		@Override
		public RecyclerViewHolder onCreateViewHolder(final ViewGroup arg0, final int arg1)
		{

			return null;
		}
	}

	private RecyclerView mRecycler;

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState)
	{
		final View view = inflater.inflate(R.layout.music_list_item, null);
		mRecycler = (RecyclerView) view.findViewById(R.id.recycler);
		mRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
		return view;
	}
}
