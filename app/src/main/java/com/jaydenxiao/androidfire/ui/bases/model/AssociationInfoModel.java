package com.jaydenxiao.androidfire.ui.bases.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;
import com.jaydenxiao.androidfire.bean.AssociationInfoBeans;
import com.jaydenxiao.androidfire.bean.waterSituation;
import com.jaydenxiao.androidfire.ui.bases.contract.AssociationInfoContract;
import com.jaydenxiao.androidfire.ui.news.contract.WaterSituationContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import java.util.List;

import rx.Observable;


/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class AssociationInfoModel implements AssociationInfoContract.Model {

    @Override
    public Observable<List<AssociationInfoBeans>> getAssociationInfoData( String keyWord,String pageSize, String pageNum) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getAssociationInfo(keyWord,pageSize,pageNum)
                .compose(RxSchedulers.<List<AssociationInfoBeans>>io_main());
    }
}
