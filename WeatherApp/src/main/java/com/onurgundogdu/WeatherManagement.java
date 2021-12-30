package com.onurgundogdu;

import com.onurgundogdu.business.BusinessClient;
import com.onurgundogdu.rawdata.WeatherClient;
import com.onurgundogdu.user.UserClient;
import com.onurgundogdu.utils.LogUtil;

public class WeatherManagement {
    public static void main(String[] args) {
        LogUtil.getInstance().logInfo("Weather Management System is startin...");
        UserClient userClient = new UserClient();
        new Thread(userClient, userClient.getName()).start();
        LogUtil.getInstance().logInfo("Weather Management System has started");

    }
}
