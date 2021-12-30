package com.onurgundogdu.rawdata;

import com.onurgundogdu.utils.LogUtil;

public class WeatherClient implements Runnable{
    private static final String NAME="Weather Client";

    @Override
    public void run() {
        LogUtil.getInstance().logInfo(WeatherClient.NAME+"is up and running");

    }

}
