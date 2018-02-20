package de.suitepad.packagelist.view;

import de.suitepad.packagelist.util.Popper;

/**
 * Created by nuhkoca on 2/17/18.
 */

public interface PackageView {
    void onPackageUninstalled(Popper popper, String pkgName);

    void onPackageInstalled(Popper popper, String pkgName);

    void onPackageChanged(Popper popper, String pkgName);
}
