package com.onurgundogdu.common;

import com.onurgundogdu.common.georaphy.City;
import lombok.Getter;
import lombok.Setter;

public class CommonData {
    private static CommonData instance;

    @Getter
    @Setter
    private City selectedCity;

    private CommonData () {
        CommonData.instance = null;
    }

    public static CommonData getInstance() {
        if (CommonData.instance == null) {
            CommonData.instance = new CommonData();
        }
        return CommonData.instance;
    }
}
