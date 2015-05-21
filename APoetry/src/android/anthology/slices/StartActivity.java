package android.anthology.slices;

import java.util.ArrayList;
import java.util.List;

import android.anthology.R;
import android.anthology.slices.StartActivity.DrawerViewAdapter.DrawerViewHolder;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity implements IFragmentManager
{
	public class DrawerViewAdapter extends Adapter<DrawerViewHolder>
	{
		public class DrawerViewHolder extends ViewHolder
		{
			private final TextView title;

			public DrawerViewHolder(final View view)
			{
				super(view);
				title = (TextView) view.findViewById(R.id.title);
			}
		}

		@Override
		public DrawerViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType)
		{
			final View view = LayoutInflater.from(StartActivity.this).inflate(R.layout.entry_drawer, parent, false);
			return new DrawerViewHolder(view);
		}

		@Override
		public void onBindViewHolder(final DrawerViewHolder holder, final int position)
		{
			final Pair<Integer, Fragment> pair = mFragments.get(0);
			final String title = getResources().getString(pair.first);
			holder.title.setText(title);
			holder.itemView.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(final View v)
				{
					replace(title, pair.second);
				}
			});
		}

		@Override
		public int getItemCount()
		{
			return mFragments.size();
		}
	}

	private Toolbar mToolbar = null;
	private ActionBarDrawerToggle mDrawerToggle = null;
	private DrawerLayout mDrawerLayout = null;
	private RecyclerView mDrawerView = null;
	private DrawerViewAdapter mDrawerAdapter = null;
	private FrameLayout mContentView = null;
	private final List<Pair<Integer, Fragment>> mFragments = new ArrayList<Pair<Integer, Fragment>>();

	public StartActivity()
	{
		mFragments.add(new Pair<Integer, Fragment>(R.string.gallery_title, new GalleryFragment(this)));
	}

	@Override
	public void onCreate(final Bundle bundle)
	{
		super.onCreate(bundle);
		setContentView(R.layout.activity_start);

		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(mToolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setHomeButtonEnabled(false);

		mContentView = (FrameLayout) findViewById(R.id.content);

		mDrawerAdapter = new DrawerViewAdapter();
		mDrawerView = (RecyclerView) findViewById(R.id.drawer);
		mDrawerView.setLayoutManager(new LinearLayoutManager(this));
		mDrawerView.setAdapter(mDrawerAdapter);
		//mDrawerView.setAdapter(new ArrayAdapter<String>(this,));
		//mRecyclerView.setOnItemClickListener(onClickItem);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, 0,
				0)
		{
			@Override
			public void onDrawerSlide(final View drawerView, final float slideOffset)
			{
				final float offset = drawerView.getWidth() * slideOffset;

				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
					mContentView.setTranslationX(offset);
				else
					ViewCompat.setTranslationX(mContentView, offset);
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

	}

	@Override
	protected void onPostCreate(final Bundle bundle)
	{
		super.onPostCreate(bundle);
		mDrawerToggle.syncState();
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
	public void replace(final String title, final Fragment fragment)
	{
		mToolbar.setTitle(title);
		getSupportFragmentManager()
				.beginTransaction().replace(R.id.content, fragment).commit();
	}
}
