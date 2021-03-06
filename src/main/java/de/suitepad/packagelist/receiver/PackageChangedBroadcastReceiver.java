package de.suitepad.packagelist.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

import de.suitepad.packagelist.MainActivity;
import de.suitepad.packagelist.util.Popper;

/**
 * Created by tarek on 4/6/17.
 */

public class PackageChangedBroadcastReceiver extends BroadcastReceiver {

    private static final String PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
    private static final String PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
    private static final String PACKAGE_CHANGED = "android.intent.action.PACKAGE_CHANGED";


    @Override
    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        String pkgName = removePackage(data);

        Popper popper = Popper.create(context);

        if (MainActivity.getInstance() != null) {
            if (intent.getAction() != null) {
                switch (intent.getAction()) {
                    case PACKAGE_ADDED:
                        MainActivity.getInstance().onPackageInstalled(popper, pkgName);
                        break;
                    case PACKAGE_REMOVED:
                        MainActivity.getInstance().onPackageUninstalled(popper, pkgName);
                        break;
                    case PACKAGE_CHANGED:
                        MainActivity.getInstance().onPackageChanged(popper, pkgName);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @NonNull
    private String removePackage(Uri data) {
        return data.toString().substring(data.getScheme().length() + 1);
    }
}
