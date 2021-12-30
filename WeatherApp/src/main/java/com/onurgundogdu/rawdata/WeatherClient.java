package com.onurgundogdu.rawdata;

import com.onurgundogdu.utils.LogUtil;

public class WeatherClient implements Runnable{
    @Override
    public void run() {
   LogUtil.getInstance().logInfo(this.getName() + " is up and runnig");
		try {
        for (int i = 0; i < 20; i++) {
            LogUtil.getInstance().logInfo(this.getName() + "-counter: " + i);
            Thread.sleep(2500);
        }
    }
		catch (InterruptedException ex) {
        LogUtil.getInstance().logError(this.getClass().getSimpleName() + " --> " + ex.getMessage());
    }

}

    public String getName() {
        return this.getClass().getSimpleName();
    }

}
