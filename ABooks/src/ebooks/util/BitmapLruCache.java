package ebooks.util;

import com.android.volley.toolbox.ImageLoader.ImageCache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class BitmapLruCache extends LruCache<String, Bitmap>implements ImageCache {
	public static int getMaxLruCacheSize() {
		return (int) (Runtime.getRuntime().maxMemory() / (8 * 1024));
	}
	
	public BitmapLruCache(){
		super(getMaxLruCacheSize());
	}

	public BitmapLruCache(int maxSize) {
		super(maxSize);
	}

	@Override
	public Bitmap getBitmap(String url) {
		
		return get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		put(url, bitmap);
	}
	
	@Override
    protected int sizeOf(String key, Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
    }
}
