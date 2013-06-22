package com.codepath.libraries.androidviewhelpers;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class SimpleAlertDialog extends SimpleDialogFragment {
	SimpleAlertListener listener;
	String positiveText, negativeText;
	int alertIcon;

	// SimpleAlertDialog.build(activity, "Do you want to delete that?", 
	//  "OK", "Cancel", ...).show();
	public static SimpleAlertDialog build(FragmentActivity activity, String body,
			String positiveText, String negativeText,
			SimpleAlertListener listener) {
		SimpleAlertDialog dialogAlert = new SimpleAlertDialog();
		dialogAlert.setAlertMessage(body);
		dialogAlert.setAlertIcon(android.R.drawable.ic_dialog_alert);
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
	
	public void setAlertIcon(int drawable) {
		this.alertIcon = drawable;
	}
	
	public void setAlertButtonText(String positiveText, String negativeText) {
		this.positiveText = positiveText;
		this.negativeText = negativeText;
	}

	protected void setAlertListener(SimpleAlertListener listener) {
		this.listener = listener;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		 AlertDialog.Builder builder = 
		   new AlertDialog.Builder(getActivity())
				.setIcon(alertIcon)
				.setTitle(getAlertMessage());
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
