package com.jaydenxiao.androidfire.ui.map.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;
import com.jaydenxiao.androidfire.bean.AssociationInfoBeans;
import com.jaydenxiao.androidfire.bean.IPQCbeans;
import com.jaydenxiao.androidfire.ui.bases.contract.AssociationInfoContract;
import com.jaydenxiao.androidfire.ui.map.contract.IPQCContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import java.util.List;

import rx.Observable;


/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class IPQCModel implements IPQCContract.Model {

    @Override
    public Observable<List<IPQCbeans>> getIPQCData(String tm,String pageSize, String pageNum) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getIPQC(tm,pageSize,pageNum)
                .compose(RxSchedulers.<List<IPQCbeans>>io_main());
    }
}
