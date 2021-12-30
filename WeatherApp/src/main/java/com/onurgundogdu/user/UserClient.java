package com.onurgundogdu.user;

import com.onurgundogdu.utils.LogUtil;

public class UserClient implements Runnable{
    private static final String NAME="User Client";

    @Override
    public void run() {
        LogUtil.getInstance().logInfo(UserClient.NAME+"is up and running");
    }
}

