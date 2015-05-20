package system.inputmethod;

import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputConnection;

public class AInputMethodService extends InputMethodService {
	private final static String TAG = AInputMethodService.class.getSimpleName();

	public class AInputMethod extends InputMethodService.InputMethodImpl {
		@Override
		public void bindInput(InputBinding binding) {

			super.bindInput(binding);
		}

		@Override
		public void startInput(InputConnection ic, EditorInfo attribute) {
			super.startInput(ic, attribute);
		}

		@Override
		public void restartInput(InputConnection ic, EditorInfo attribute) {

			super.restartInput(ic, attribute);
		}
	}

	public AInputMethodService() {
		super();
		if (Build.VERSION.SDK_INT >= 17) {
			// enableHardwareAcceleration();
		}
	}

	@Override
	public View onCreateCandidatesView() {

		return super.onCreateCandidatesView();
	}
	
	@Override
	public AbstractInputMethodImpl onCreateInputMethodInterface() {
		return new AInputMethod();
	}

	@Override
	public View onCreateExtractTextView() {

		return super.onCreateExtractTextView();
	}

	@Override
	public View onCreateInputView() {
		Logger.d(TAG, "start AInputMethodService#onCreateInputView " + System.nanoTime());
		View inputView = mViewManager.createInputView(this);
		Logger.d(TAG, "end AInputMethodService#onCreateInputView " + System.nanoTime());
		return inputView;
	}
	
	// A manager for all views and feedbacks.
	private AInputViewManager mViewManager;

	@Override
	public void onStartInput(EditorInfo attribute, boolean restarting) {

		super.onStartInput(attribute, restarting);
	}

	@Override
	public void onStartInputView(EditorInfo info, boolean restarting) {

		super.onStartInputView(info, restarting);
	}

	@Override
	public void onFinishCandidatesView(boolean finishingInput) {

		super.onFinishCandidatesView(finishingInput);
	}

	@Override
	public void onFinishInput() {
		super.onFinishInput();
	}

	@Override
	public void onFinishInputView(boolean finishingInput) {

		super.onFinishInputView(finishingInput);
	}
	


}
