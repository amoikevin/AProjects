package system.inputmethod;

import android.content.Context;

/**
 * Manages Input, Candidate and Extracted views.
 */
public class AInputViewManager {
	public AInputView createInputView(Context context){
		// Because an issue about native bitmap memory management on older Android,
	    // there is a potential OutOfMemoryError. To reduce such an error case,
	    // we retry to inflate or to create drawable when OOM is found.
	    // Here is the injecting point of the procedure.
		return null;
	}
}
