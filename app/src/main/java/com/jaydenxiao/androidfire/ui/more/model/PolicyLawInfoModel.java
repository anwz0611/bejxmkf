package com.jaydenxiao.androidfire.ui.more.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;
import com.jaydenxiao.androidfire.bean.AssociationInfoBeans;
import com.jaydenxiao.androidfire.bean.PolicyLawInfoBeans;
import com.jaydenxiao.androidfire.ui.bases.contract.AssociationInfoContract;
import com.jaydenxiao.androidfire.ui.more.contract.PolicyLawInfoContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import java.util.List;

import rx.Observable;


/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class PolicyLawInfoModel implements PolicyLawInfoContract.Model {

    @Override
    public Observable<List<PolicyLawInfoBeans>> getPolicyLawInfoData(String pageSize, String pageNum) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getPolicyLawInfo(pageSize,pageNum)
                .compose(RxSchedulers.<List<PolicyLawInfoBeans>>io_main());
    }
}
