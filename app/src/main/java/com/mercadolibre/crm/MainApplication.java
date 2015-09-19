package com.mercadolibre.crm;

import android.os.Build;
import android.support.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Created by fpardo on 9/17/15.
 */
public class MainApplication extends MultiDexApplication {

    private static MainApplication application;

    @Override
    public void onCreate(){
        super.onCreate();

        if(BuildConfig.DEBUG){
            Stetho.initialize(Stetho.newInitializerBuilder(this)
                    .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                    .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
            if(android.os.Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP) LeakCanary.install(this);
        }
        JodaTimeAndroid.init(this);
    }

    public MainApplication() {
        super();
        application = this;
    }

    public static MainApplication getApplication() {
        return application;
    }



}
