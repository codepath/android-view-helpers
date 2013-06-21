# Android View Helpers

This library is a collection of simple view helpers to make Android development easier. Right now, this library just has a few helpful classes but they will expand over time.

## SimpleAlertDialog

This is a simple way to bring up a modal alert dialog within a DialogFragment within a FragmentActivity. The dialog fragment used is the `v4.support` Fragment to support all Android versions.

### Usage

Creating an alert to display is easy:

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