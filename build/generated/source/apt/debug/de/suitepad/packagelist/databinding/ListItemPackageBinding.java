package de.suitepad.packagelist.databinding;
import de.suitepad.packagelist.R;
import de.suitepad.packagelist.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ListItemPackageBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.pkg_label, 2);
        sViewsWithIds.put(R.id.pkg_name, 3);
        sViewsWithIds.put(R.id.pkg_version, 4);
        sViewsWithIds.put(R.id.pkg_versionCode, 5);
        sViewsWithIds.put(R.id.pkg_launch, 6);
        sViewsWithIds.put(R.id.pkg_uninstall, 7);
        sViewsWithIds.put(R.id.pkg_change, 8);
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    public final android.widget.Button pkgChange;
    @NonNull
    public final android.widget.ImageView pkgIcon;
    @NonNull
    public final android.widget.TextView pkgLabel;
    @NonNull
    public final android.widget.Button pkgLaunch;
    @NonNull
    public final android.widget.TextView pkgName;
    @NonNull
    public final android.widget.Button pkgUninstall;
    @NonNull
    public final android.widget.TextView pkgVersion;
    @NonNull
    public final android.widget.TextView pkgVersionCode;
    // variables
    @Nullable
    private de.suitepad.packagelist.model.Pkg mPkgData;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ListItemPackageBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.pkgChange = (android.widget.Button) bindings[8];
        this.pkgIcon = (android.widget.ImageView) bindings[1];
        this.pkgIcon.setTag(null);
        this.pkgLabel = (android.widget.TextView) bindings[2];
        this.pkgLaunch = (android.widget.Button) bindings[6];
        this.pkgName = (android.widget.TextView) bindings[3];
        this.pkgUninstall = (android.widget.Button) bindings[7];
        this.pkgVersion = (android.widget.TextView) bindings[4];
        this.pkgVersionCode = (android.widget.TextView) bindings[5];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.pkgData == variableId) {
            setPkgData((de.suitepad.packagelist.model.Pkg) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPkgData(@Nullable de.suitepad.packagelist.model.Pkg PkgData) {
        this.mPkgData = PkgData;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.pkgData);
        super.requestRebind();
    }
    @Nullable
    public de.suitepad.packagelist.model.Pkg getPkgData() {
        return mPkgData;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        de.suitepad.packagelist.model.Pkg pkgData = mPkgData;
        int pkgDataResId = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (pkgData != null) {
                    // read pkgData.resId
                    pkgDataResId = pkgData.getResId();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            de.suitepad.packagelist.adapter.PackageIconsBindingAdapter.loadIcons(this.pkgIcon, pkgDataResId);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ListItemPackageBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ListItemPackageBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ListItemPackageBinding>inflate(inflater, de.suitepad.packagelist.R.layout.list_item_package, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ListItemPackageBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ListItemPackageBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(de.suitepad.packagelist.R.layout.list_item_package, null, false), bindingComponent);
    }
    @NonNull
    public static ListItemPackageBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ListItemPackageBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/list_item_package_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ListItemPackageBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): pkgData
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}