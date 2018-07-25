package com.jaydenxiao.androidfire.ui.main.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;
import com.jaydenxiao.androidfire.bean.LoginsBeans;
import com.jaydenxiao.androidfire.bean.addressBookInfoBeans;
import com.jaydenxiao.androidfire.ui.main.contract.LoginContract;
import com.jaydenxiao.androidfire.ui.more.contract.AddressBookInfoContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import java.util.List;

import rx.Observable;


/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<LoginsBeans> getLoginStateData(String loginid, String loginpwd) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).login(loginid,loginpwd)
                .compose(RxSchedulers.<LoginsBeans>io_main());
    }
}
