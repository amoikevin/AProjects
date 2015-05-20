package android.anthology.slices;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import android.anthology.R;
import android.anthology.models.Poetry;
import android.anthology.slices.GalleryFragment.RecyclerViewAdapter.RecyclerViewHolder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

public class GalleryFragment extends Fragment
//		implements OnQueryTextListener
{
	public class RecyclerViewAdapter extends Adapter<RecyclerViewHolder>
	{
		public class RecyclerViewHolder extends ViewHolder
		{
			private final TextView title;
			private final TextView author;
			private final TextView album;
			private final TextView lines;

			public RecyclerViewHolder(final View view)
			{
				super(view);
				title = (TextView) view.findViewById(R.id.title);
				author = (TextView) view.findViewById(R.id.author);
				album = (TextView) view.findViewById(R.id.album);
				lines = (TextView) view.findViewById(R.id.lines);
			}

		}

		@Override
		public int getItemCount()
		{
			return mPoetrys.size();
		}

		@Override
		public RecyclerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType)
		{
			final View view = LayoutInflater.from(getActivity()).inflate(R.layout.entry_poetry, parent, false);
			return new RecyclerViewHolder(view);
		}

		@Override
		public void onBindViewHolder(final RecyclerViewHolder holder, final int position)
		{
			final Poetry poetry = mPoetrys.get(position);
			holder.title.setText(poetry.getTitle());
			holder.author.setText(poetry.getAuthor());
			holder.album.setText(poetry.getAlbum());
			//holder.lines.setText(poetry.getLines());
			holder.itemView.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(final View v)
				{
					final PoetryFragment fragment = new PoetryFragment(poetry);
					mFragmentManager.replace(poetry.getTitle(), fragment);
				}
			});
		}

	}

	private RecyclerView mRecyclerView = null;
	//	private SearchView mSearchView = null;
	private final List<Poetry> mPoetrys;
	private final RecyclerViewAdapter mRecyclerAdapter;
	private final IFragmentManager mFragmentManager;

	private final JsonObjectRequest mRefreshRequest = new JsonObjectRequest(Method.GET, "", null,
			new Listener<JSONObject>()
			{
				@Override
				public void onResponse(final JSONObject jroot)
				{
				}
			},
			new ErrorListener()
			{
				@Override
				public void onErrorResponse(final VolleyError error)
				{

				}
			});

	private final JsonObjectRequest mLoadRequest = new JsonObjectRequest(Method.GET, "", null,
			new Listener<JSONObject>()
			{
				@Override
				public void onResponse(final JSONObject jroot)
				{

				}
			},
			new ErrorListener()
			{
				@Override
				public void onErrorResponse(final VolleyError error)
				{

				}
			});

	public GalleryFragment(final IFragmentManager manager)
	{
		mFragmentManager = manager;
		mPoetrys = new ArrayList<Poetry>();
		mRecyclerAdapter = new RecyclerViewAdapter();

		//		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle bundle)
	{
		final View view = inflater.inflate(R.layout.page_gallery, container, false);
		mRecyclerView = (RecyclerView) view.findViewById(R.id.gallery);
		//		mSearchView = (SearchView) view.findViewById(R.id.searcher);
		return view;
	}

	@Override
	public void onActivityCreated(final Bundle bundle)
	{
		super.onActivityCreated(bundle);
		final LinearLayoutManager llm = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(llm);
		mRecyclerView.setAdapter(mRecyclerAdapter);

		//		mSearchView.setOnQueryTextListener(GalleryFragment.this);
	}

	//	@Override
	//	public boolean onQueryTextSubmit(final String query)
	//	{
	//		return false;
	//	}

	//	@Override
	//	public boolean onQueryTextChange(final String newText)
	//	{
	//		//		if(TextUtils.isEmpty(newText))
	//		return false;
	//	}

	@Override
	public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater)
	{
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.menu_gallery, menu);
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item)
	{
		return super.onOptionsItemSelected(item);
	}
}
