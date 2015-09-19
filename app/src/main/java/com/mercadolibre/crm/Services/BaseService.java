package com.mercadolibre.crm.Services;

import android.content.Context;

import com.grizzly.rest.WebServiceFactory;
import com.mercadolibre.crm.MainApplication;

/**
 * Created by fpardo on 9/17/15.
 */
public class BaseService {

    protected String TAG;
    protected WebServiceFactory _webServiceFactory;

    public BaseService()
    {
        TAG = getClass().getSimpleName();
        _webServiceFactory = new WebServiceFactory();
        _webServiceFactory.setTimeOutValue(15000);
        _webServiceFactory.setContext(MainApplication.getApplication());
    }

    public void setContext(Context context){
        _webServiceFactory.setContext(context);
    }

    public String getTAG(){
        TAG = getClass().getSimpleName();
        return TAG;
    }



}
