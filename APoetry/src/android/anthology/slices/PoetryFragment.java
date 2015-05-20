package android.anthology.slices;

import android.anthology.R;
import android.anthology.models.Poetry;
import android.anthology.slices.PoetryFragment.RecyclerViewAdapter.RecyclerViewHolder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PoetryFragment extends Fragment
{
	public class RecyclerViewAdapter extends Adapter<RecyclerViewHolder>
	{
		public class RecyclerViewHolder extends ViewHolder
		{
			public RecyclerViewHolder(final View view)
			{
				super(view);
			}
		}

		@Override
		public RecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType)
		{
			final TextView tv = new TextView(getActivity());

			final LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			tv.setLayoutParams(params);
			return new RecyclerViewHolder(tv);
		}

		@Override
		public void onBindViewHolder(final RecyclerViewHolder holder, final int position)
		{
			((TextView) holder.itemView).setText(Html.fromHtml(mPoetry.getLines()[position]));
		}

		@Override
		public int getItemCount()
		{
			if (mPoetry == null)
				return 0;
			return mPoetry.getLines().length;
		}

	}

	private RecyclerView mRecyclerView = null;
	private TextView mTitleView;
	private TextView mAuthorView;
	private final Poetry mPoetry;
	private final RecyclerViewAdapter mRecyclerAdapter;

	public PoetryFragment(final Poetry mPoetry)
	{
		this.mPoetry = mPoetry;
		mRecyclerAdapter = new RecyclerViewAdapter();
	}

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

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup parent, final Bundle bundle)
	{
		final View view = inflater.inflate(R.layout.page_poetry, parent, false);
		mRecyclerView = (RecyclerView) view.findViewById(R.id.lines);
		return view;
	}

	@Override
	public void onActivityCreated(final Bundle bundle)
	{
		super.onActivityCreated(bundle);

		final GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
		mRecyclerView.setLayoutManager(glm);
		mRecyclerView.setAdapter(mRecyclerAdapter);
	}

}
