package com.license.licensetools;
import android.util.Log;
import java.lang.reflect.Method;

public class LicenseTools {
    public static final String TAG = "LicenseTools";
    public static final String SYSTEM_PROPERTY = "android.os.SystemProperties";
    private static String getProperty(String key, String defaultValue) {
        String value = defaultValue;
        try {
            Class<?> c = Class.forName(SYSTEM_PROPERTY);
            Method get = c.getMethod("get", String.class, String.class);
            value = (String) (get.invoke(c, key, defaultValue));
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "get failed:" + e.getMessage());
        } finally {
            return value;
        }
    }
    public static String getVin(String vinKey) {
        String vin = getProperty(vinKey, "");
        Log.i(TAG, "VIN:" + vin);
        return vin;
    }
    public static String getMask() {
        return "3";
    }
}
