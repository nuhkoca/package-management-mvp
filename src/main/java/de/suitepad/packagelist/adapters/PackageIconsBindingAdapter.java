package de.suitepad.packagelist.adapters;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import de.suitepad.packagelist.module.GlideApp;

/**
 * Created by nuhkoca on 2/20/18.
 */

public class PackageIconsBindingAdapter {

    @BindingAdapter(value = {"android:src"})
    public static void loadIcons(ImageView imageView, int resId){
        GlideApp.with(imageView.getContext())
                .load(resId)
                .into(imageView);
    }
}