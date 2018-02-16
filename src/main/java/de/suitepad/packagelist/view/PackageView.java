package de.suitepad.packagelist.view;

/**
 * Created by nuhkoca on 2/17/18.
 */

public interface PackageView {
    void onPackageUninstalled(String pkgName);

    void onPackageInstalled(String pkgName);

    void onPackageChanged(String pkgName);
}
