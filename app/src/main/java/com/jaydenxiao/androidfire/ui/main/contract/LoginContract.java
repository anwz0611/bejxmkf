package com.jaydenxiao.androidfire.ui.main.contract;

import com.jaydenxiao.androidfire.bean.LoginsBeans;
import com.jaydenxiao.androidfire.bean.NewsChannelTable;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * des:
 *
 *
 */
public interface LoginContract {

    interface Model extends BaseModel {
        Observable<LoginsBeans> getLoginStateData(String loginid,String loginpwd);
    }

    interface View extends BaseView {
        void returnLoginState(LoginsBeans LoginState);

        void accountIsNull();

        void passWordIsNull();

        void loginSuccess();
    }
    abstract static class Presenter extends BasePresenter<LoginContract.View, LoginContract.Model> {
        public abstract void getLoginStateRequest(String loginid,String loginpwd);
    }
}
