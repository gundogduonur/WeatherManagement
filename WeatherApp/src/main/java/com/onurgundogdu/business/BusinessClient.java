package com.onurgundogdu.business;


import com.onurgundogdu.utils.LogUtil;

public class BusinessClient implements  Runnable{
    private static final String NAME="Business Client";

    @Override
    public void run() {
        LogUtil.getInstance().logInfo(BusinessClient.NAME+"is up and running");

    }
}
