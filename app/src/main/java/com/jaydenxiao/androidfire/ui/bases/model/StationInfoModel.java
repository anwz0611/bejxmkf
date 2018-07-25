package com.jaydenxiao.androidfire.ui.bases.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;
import com.jaydenxiao.androidfire.bean.stationInfoBeans;
import com.jaydenxiao.androidfire.bean.userInfoBeans;
import com.jaydenxiao.androidfire.ui.bases.contract.StationInfoContract;
import com.jaydenxiao.androidfire.ui.bases.contract.UserInfoContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import java.util.List;

import rx.Observable;


/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class StationInfoModel implements StationInfoContract.Model {

    @Override
    public Observable<List<stationInfoBeans>> getStationInfoData(String keyWord,String stationType, String pageSize, String pageNum) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getStationInfo(keyWord,stationType,pageSize,pageNum)
                .compose(RxSchedulers.<List<stationInfoBeans>>io_main());
    }
}
