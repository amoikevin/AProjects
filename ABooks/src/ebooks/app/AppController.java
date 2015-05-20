package ebooks.app;

import org.json.JSONArray;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.app.Application;
import ebooks.util.BitmapLruCache;

public class AppController extends Application {
	private static AppController mInstance;
	public static final String TAG = AppController.class.getSimpleName();

	public static synchronized AppController getInstance() {
		return mInstance;
	}

	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;

	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}

		return mRequestQueue;
	}

	public ImageLoader getImageLoader() {
		getRequestQueue();
		if (mImageLoader == null) {
			mImageLoader = new ImageLoader(this.mRequestQueue, new BitmapLruCache());
		}
		return this.mImageLoader;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;

		
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}
}
