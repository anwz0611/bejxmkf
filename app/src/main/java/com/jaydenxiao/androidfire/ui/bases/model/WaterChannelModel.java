package com.jaydenxiao.androidfire.ui.bases.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;
import com.jaydenxiao.androidfire.bean.AssociationInfoBeans;
import com.jaydenxiao.androidfire.bean.waterChannelBeans;
import com.jaydenxiao.androidfire.ui.bases.contract.AssociationInfoContract;
import com.jaydenxiao.androidfire.ui.bases.contract.WaterChannelContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import java.util.List;

import rx.Observable;


/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class WaterChannelModel implements WaterChannelContract.Model {

    @Override
    public Observable<List<waterChannelBeans>> getWaterChannelDetailData(String id, String type) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getWaterChannelDetail(id,type)
                .compose(RxSchedulers.<List<waterChannelBeans>>io_main());
    }

    @Override
    public Observable<List<waterChannelBeans>> getWaterChannelData() {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getWaterChannel()
                .compose(RxSchedulers.<List<waterChannelBeans>>io_main());
    }
}
