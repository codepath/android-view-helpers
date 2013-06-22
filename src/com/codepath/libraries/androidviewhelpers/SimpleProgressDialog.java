package com.codepath.libraries.androidviewhelpers;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

public class SimpleProgressDialog extends SimpleDialogFragment {
	// SimpleProgressDialog.build(activity, "Loading...").show();
	public static SimpleProgressDialog build(FragmentActivity activity,
			String message) {
		SimpleProgressDialog dialogProgress = new SimpleProgressDialog();
		dialogProgress.setAlertMessage(message);
		dialogProgress.setAlertActivity(activity);
		return dialogProgress;
	}
	
	// SimpleProgressDialog.build(activity).show();
	public static SimpleProgressDialog build(FragmentActivity activity) {
		return build(activity, "Please wait...");
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final ProgressDialog dialog = new ProgressDialog(getActivity());
		dialog.setMessage(getAlertMessage());
		dialog.setIndeterminate(true);
		dialog.setCancelable(false);
		dialog.setCanceledOnTouchOutside(false);
		disableBackButton(dialog);
		return dialog;
	}

	// Disable the back button
	private void disableBackButton(ProgressDialog dialog) {
		OnKeyListener keyListener = new OnKeyListener() {
			@Override
			public boolean onKey(DialogInterface dialog, int keyCode,
					KeyEvent event) {

				if (keyCode == KeyEvent.KEYCODE_BACK) {
					return true;
				}
				return false;
			}

		};
		dialog.setOnKeyListener(keyListener);
	}
}
