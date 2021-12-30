package com.onurgundogdu;

import com.onurgundogdu.business.BusinessClient;
import com.onurgundogdu.rawdata.WeatherClient;
import com.onurgundogdu.user.UserClient;
import com.onurgundogdu.utils.LogUtil;

public class WeatherManagement {
    public static void main(String[] args) {
        LogUtil.getInstance().logInfo("Weather Management system is starting...");
        new WeatherClient().run();
        new BusinessClient().run();
        new UserClient().run();
        LogUtil.getInstance().logInfo("Weather Management system is started...");

    }
}
