package de.suitepad.packagelist.model;

/**
 * Created by tarek on 4/6/17.
 */

public class Pkg {
    private String versionName;
    private int versionCode;
    private String name;
    private String label;

    public static Pkg create(String name, String label, String versionName, int versionCode) {
        return new Pkg(name, label, versionName, versionCode);
    }

    private Pkg(String name, String label, String versionName, int versionCode) {
        this.versionName = versionName;
        this.versionCode = versionCode;
        this.name = name;
        this.label = label;
    }

    public String getVersionName() {
        return versionName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pkg)) return false;

        Pkg pkg = (Pkg) o;

        return versionCode == pkg.versionCode && (versionName != null ? versionName.equals(pkg.versionName) : pkg.versionName == null) && (name != null ? name.equals(pkg.name) : pkg.name == null && (label != null ? label.equals(pkg.label) : pkg.label == null));

    }

    @Override
    public int hashCode() {
        int code = versionName != null ? versionName.hashCode() : 0;
        code = 15 * code + (name != null ? name.hashCode() : 0);
        code = 15 * code + (label != null ? label.hashCode() : 0);
        code = 15 * code + (versionCode);

        return code;
    }
}