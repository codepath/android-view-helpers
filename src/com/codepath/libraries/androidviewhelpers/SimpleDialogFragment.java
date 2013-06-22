package com.codepath.libraries.androidviewhelpers;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SimpleDialogFragment extends DialogFragment {
	private FragmentActivity activity;
	private String alertMessage;
	
	public void show() {
		this.show(activity.getSupportFragmentManager(), null);
	}

	public void setAlertMessage(String message) {
		this.alertMessage = message;
	}
	
	protected String getAlertMessage() {
		return alertMessage;
	}
	
	protected void setAlertActivity(FragmentActivity activity) {
		this.activity = activity;
	}
	
	protected FragmentManager getSupportFragmentManager() {
		return this.activity.getSupportFragmentManager();
	}
}
