package com.jaydenxiao.androidfire.ui.main.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.app.AppConstant;
import com.jaydenxiao.androidfire.bean.LoginsBeans;
import com.jaydenxiao.androidfire.bean.addressBookInfoBeans;
import com.jaydenxiao.androidfire.ui.main.contract.LoginContract;
import com.jaydenxiao.androidfire.ui.more.contract.AddressBookInfoContract;
import com.jaydenxiao.common.baserx.RxSubscriber;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class LoginPresenter extends LoginContract.Presenter{


    @Override
    public void getLoginStateRequest(String loginid, String loginpwd) {

        if (loginid ==null ||TextUtils.isEmpty(loginid)){
            mView.accountIsNull();
            return;
        }
        if (loginpwd ==null ||TextUtils.isEmpty(loginpwd)) {
            mView.passWordIsNull();
            return;
        }

        mRxManage.add(mModel.getLoginStateData(loginid,loginpwd).subscribe(new RxSubscriber<LoginsBeans>(mContext, false) {
            @Override
            protected void _onNext(LoginsBeans LoginState){

                mView.returnLoginState(LoginState);
                mView.stopLoading();
            }

            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading(mContext.getString(R.string.loading));
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
            }
        }));
    }
}
