package de.suitepad.packagelist.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by nuhkoca on 2/17/18.
 */

public class Popper {

    private Context context;

    private Popper() {}

    public static Popper create(Context context) {
        Popper popper = new Popper();
        popper.context = context;
        return popper;
    }

    public void popup(String pkgName, int message) {
        Toast.makeText(context, pkgName + context.getString(message), Toast.LENGTH_SHORT).show();
    }

    public void popup(int message, String pkgName) {
        Toast.makeText(context, context.getString(message) + pkgName, Toast.LENGTH_SHORT).show();
    }
}
