package fun.happyhacker.springbootdemo.hikari;

import com.google.gson.GsonBuilder;

public class ExtensionMethods {
    public static String toJson(Object object) {
        return new GsonBuilder().serializeNulls().create().toJson(object);
    }
}
