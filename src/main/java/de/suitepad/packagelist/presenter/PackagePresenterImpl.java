package de.suitepad.packagelist.presenter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.suitepad.packagelist.R;
import de.suitepad.packagelist.model.Pkg;
import de.suitepad.packagelist.util.Popper;
import de.suitepad.packagelist.view.PackageView;

/**
 * Created by nuhkoca on 2/17/18.
 */

public class PackagePresenterImpl implements PackagePresenter {

    private Context context;
    private Popper popper;
    private PackageView packageView;

    public PackagePresenterImpl(PackageView packageView, Context context) {
        this.context = context;
        this.packageView = packageView;
        this.popper = Popper.create(context);
    }

    @Override
    public void populatePackages(final ListView listView) {
        ArrayList<Pkg> pkgList = new ArrayList<>();

        PackageListAdapter packageListAdapter = new PackageListAdapter(context, pkgList);
        listView.setAdapter(packageListAdapter);

        pkgList.clear();
        PackageManager pm = context.getPackageManager();
        final List<PackageInfo> packages = pm.getInstalledPackages(PackageManager.GET_META_DATA);

        for (PackageInfo packageInfo : packages) {
            pkgList.add(Pkg.create(R.drawable.ic_launcher, packageInfo.packageName, packageInfo.packageName, packageInfo.versionName, packageInfo.versionCode));
        }
    }

    class PackageListAdapter extends ArrayAdapter<Pkg> {

        PackageListAdapter(Context context, List<Pkg> packages) {
            super(context, R.layout.list_item_package, packages);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull final ViewGroup parent) {
            View currentView = convertView;

            if (currentView == null) {
                LayoutInflater vi;
                vi = LayoutInflater.from(getContext());
                currentView = vi.inflate(R.layout.list_item_package, parent, false);
            }
            final Pkg p = getItem(position);
            if (p != null) {
                TextView tt1 = currentView.findViewById(R.id.pkg_label);
                tt1.setText(p.getLabel());

                TextView tt2 = currentView.findViewById(R.id.pkg_name);
                tt2.setText(p.getName());

                TextView tt3 = currentView.findViewById(R.id.pkg_version);
                tt3.setText(p.getVersionName());

                TextView tt4 = currentView.findViewById(R.id.pkg_versionCode);
                tt4.setText(String.valueOf(p.getVersionCode()));

                Button btn1 = currentView.findViewById(R.id.pkg_uninstall);
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popper.popup(R.string.uninstalling_package_message, p.getName());
                        packageView.onPackageUninstalled(popper, p.getName());
                    }
                });

                Button btn2 = currentView.findViewById(R.id.pkg_launch);
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popper.popup(R.string.launching_package_message, p.getName());
                        packageView.onPackageInstalled(popper, p.getName());
                    }
                });

                Button btn3 = currentView.findViewById(R.id.pkg_change);
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popper.popup(R.string.changing_package_message, p.getName());
                        packageView.onPackageChanged(popper, p.getName());
                    }
                });
            }

            return currentView;
        }
    }
}