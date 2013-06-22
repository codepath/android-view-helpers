# Android View Helpers

This library is a collection of simple view helpers to make Android development easier. Right now, this library just has a few helpful classes but they will expand over time.

## Installation

Download the latest [jar file](https://www.dropbox.com/s/zhxgms8ck0a4wj2/codepath-android-view-helpers-0.1.0.jar) and drag the JAR to your "libs" folder.

## SimpleAlertDialog

This is a simple way to bring up a modal alert dialog within a DialogFragment within a FragmentActivity. The dialog fragment used is the `v4.support` Fragment to support all Android versions.

### Usage

In apps, you often may want to display an alert asking the user a question or displaying a message
to the user. Creating an alert to display is easy:

```java
class MyActivity extends FragmentActivity {
	public void showDialog() {
		SimpleAlertDialog.build(this, 
			"Sure you want to continue?", new SimpleAlertListener() {
				@Override
				public void onPositive() {
					// handle OK
				}
				
				@Override
				public void onNegative() {
					// handle cancel
				}
		}
	   ).show();
   }
}
```

By default, this will display the following alert:

![AlertDialog](http://i.imgur.com/3xjhVlZ.png)

You can also adjust the alert to include no buttons, or change the button text. 
To display just an "Sure" button:

```java
SimpleAlertDialog.build(this, 
	"Sure you want to continue?", "Sure", null, new SimpleAlertListener()
).show();
```

To display a "Yes" and "No" button:

```java
SimpleAlertDialog.build(this, 
	"Sure you want to continue?", "Yes", "No", new SimpleAlertListener()
).show();
```

You can also customize the icon in the alert and other properties:

```java
SimpleAlertDialog alert = SimpleAlertDialog.build(this, "Confirm?", new SimpleAlertListener());
alert.setAlertIcon(R.drawable.ic_some_icon);
alert.setAlertButtons("Yes", "No");
alert.show();
```

## SimpleProgressDialog

Often in an application there might be a long running task that requires the UI to be blocked 
such as uploading an image. While this isn't the best UI, occassionally this can come up.

Creating an indeterminate modal progress dialog is easy:

```java
SimpleProgressDialog dialog = SimpleProgressDialog.build(this);
```

By default, this will display the following alert:

![ProgressDialog](http://i.imgur.com/rbEV8pM.png)

You can dismiss the dialog once the task is complete with:

```java
dialog.dismiss();
```

You can also adjust the progress dialog to have a custom message:

```java
SimpleProgressDialog dialog = SimpleProgressDialog.build(this, "Uploading...");
dialog.show();
```
