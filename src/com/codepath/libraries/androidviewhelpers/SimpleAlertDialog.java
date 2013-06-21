package com.codepath.libraries.androidviewhelpers;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

public class SimpleAlertDialog extends DialogFragment {
	SimpleAlertListener listener;
	String alertTitle, positiveText, negativeText;
	FragmentActivity activity;

	// SimpleAlertDialog.build(activity, "Do you want to delete that?", 
	//  "OK", "Cancel", ...).show();
	public static SimpleAlertDialog build(FragmentActivity activity, String body,
			String positiveText, String negativeText,
			SimpleAlertListener listener) {
		SimpleAlertDialog dialogAlert = new SimpleAlertDialog();
		dialogAlert.setAlertTitle(body);
		dialogAlert.setAlertListener(listener);
		dialogAlert.setAlertActivity(activity);
		dialogAlert.setAlertButtonText(positiveText, negativeText);
	    return dialogAlert;
	}

	// SimpleAlertDialog.build(manager, "Do you want to delete that?");
	public static SimpleAlertDialog build(FragmentActivity activity, String body,
			SimpleAlertListener listener) {
		return build(activity, body, "OK", "Cancel", listener);
	}
	
	public void show() {
		this.show(activity.getSupportFragmentManager(), null);
	}

	protected void setAlertTitle(String title) {
		this.alertTitle = title;
	}

	protected void setAlertListener(SimpleAlertListener listener) {
		this.listener = listener;
	}
	
	protected void setAlertActivity(FragmentActivity activity) {
		this.activity = activity;
	}
	
	protected void setAlertButtonText(String positiveText, String negativeText) {
		this.positiveText = positiveText;
		this.negativeText = negativeText;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		 AlertDialog.Builder builder = 
		   new AlertDialog.Builder(getActivity())
				.setIcon(android.R.drawable.ic_popup_reminder)
				.setTitle(alertTitle);
		 if (positiveText != null) {
			 builder.setPositiveButton(positiveText,
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,
							int whichButton) {
						listener.onPositive();
					}
				});
		 }
				
		 if (negativeText != null) {
			 builder.setNegativeButton(negativeText,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								listener.onNegative();
							}
						});
		 }
				
		return builder.create();
	}

	public interface SimpleAlertListener {
		public void onPositive();
		public void onNegative();
	}
}
