package system.inputmethod;

import android.util.Log;

/**
 * Logger. Same as android.util.Log.
 *
 * Note that each methods decides whether it actually writes a log or not based
 * on the result of {@link Log#isLoggable(tag,String, int)} so you can omit
 * following idiom. {@code if (MozcLog.isLoggable(tag,Log.INFO)) {
 * MozcLog.i("foobar"); } } But for such a log entry which is very frequently
 * created and is very heavy to create, you can use (and are recommended to use)
 * the above idiom.
 *
 * As described in Log's JavaDoc, the default threshold is INFO. You can change
 * the threshold by following command (on host side).
 * {@code adb shell setprop log.tag.Mozc VERVOSE}
 *
 * Q : "setprop" is tedious. Why do we have to depend on this mechanism? A : By
 * this way we can get detailed log even if we run release version. This is
 * important when we are measuring the performance.
 *
 * Log level criteria: VERVOSE - This level can be very heavy. DEBUG - Detailed
 * information but cannot be very heavy because this will be used to measure
 * performance. INFO - Usually the log will be show. WARNING - For non-fatal
 * error. ERROR - For fatal (will exit abnormally) error.
 *
 */
public class Logger {
	private Logger() {
	}

	public static boolean isLoggable(String tag, int logLevel) {
		return Log.isLoggable(tag, logLevel);
	}

	public static void v(String tag, String msg) {
		if (isLoggable(tag, Log.VERBOSE)) {
			Log.v(tag, msg);
		}
	}

	public static void v(String tag, String msg, Throwable e) {
		if (isLoggable(tag, Log.VERBOSE)) {
			Log.v(tag, msg, e);
		}
	}

	public static void d(String tag, String msg) {
		if (isLoggable(tag, Log.DEBUG)) {
			Log.d(tag, msg);
		}
	}

	public static void d(String tag, String msg, Throwable e) {
		if (isLoggable(tag, Log.DEBUG)) {
			Log.d(tag, msg, e);
		}
	}

	public static void i(String tag, String msg) {
		if (isLoggable(tag, Log.INFO)) {
			Log.i(tag, msg);
		}
	}

	public static void i(String tag, String msg, Throwable e) {
		if (isLoggable(tag, Log.INFO)) {
			Log.i(tag, msg, e);
		}
	}

	public static void w(String tag, String msg) {
		if (isLoggable(tag, Log.WARN)) {
			Log.w(tag, msg);
		}
	}

	public static void w(String tag, String msg, Throwable e) {
		if (isLoggable(tag, Log.WARN)) {
			Log.w(tag, msg, e);
		}
	}

	public static void e(String tag, String msg) {
		if (isLoggable(tag, Log.ERROR)) {
			Log.e(tag, msg);
		}
	}

	public static void e(String tag, String msg, Throwable e) {
		if (isLoggable(tag, Log.ERROR)) {
			Log.e(tag, msg, e);
		}
	}
}
