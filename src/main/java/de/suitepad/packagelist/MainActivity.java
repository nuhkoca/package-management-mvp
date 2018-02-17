package de.suitepad.packagelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import de.suitepad.packagelist.presenter.PackagePresenter;
import de.suitepad.packagelist.presenter.PackagePresenterImpl;
import de.suitepad.packagelist.util.Popper;
import de.suitepad.packagelist.view.PackageView;

public class MainActivity extends AppCompatActivity implements PackageView {

    private static MainActivity instance;

    public static MainActivity getInstance() {
        return instance;
    }

    private Popper popper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        popper = Popper.create(this);

        ListView listView = findViewById(R.id.package_list);

        PackagePresenter packagePresenter = new PackagePresenterImpl(this, this);
        packagePresenter.populatePackages(listView);
    }

    public void onPackageUninstalled(String pkgName) {
        popper.popup(pkgName, R.string.is_uninstalled_message);
    }

    public void onPackageInstalled(String pkgName) {
        popper.popup(pkgName, R.string.is_installed_message);
    }

    public void onPackageChanged(String pkgName) {
        popper.popup(pkgName, R.string.is_changed_message);
    }
}
