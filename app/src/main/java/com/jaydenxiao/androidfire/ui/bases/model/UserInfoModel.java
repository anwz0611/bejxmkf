package com.jaydenxiao.androidfire.ui.bases.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;
import com.jaydenxiao.androidfire.bean.AssociationInfoBeans;
import com.jaydenxiao.androidfire.bean.userInfoBeans;
import com.jaydenxiao.androidfire.ui.bases.contract.AssociationInfoContract;
import com.jaydenxiao.androidfire.ui.bases.contract.UserInfoContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import java.util.List;

import rx.Observable;


/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class UserInfoModel implements UserInfoContract.Model {

    @Override
    public Observable<List<userInfoBeans>> getUserInfoData(String keyWord,String pageSize, String pageNum) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getUserInfo(keyWord,pageSize,pageNum)
                .compose(RxSchedulers.<List<userInfoBeans>>io_main());
    }
}
