package com.jaydenxiao.androidfire.ui.main.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jaydenxiao.androidfire.R;

import com.jaydenxiao.androidfire.bean.LoginsBeans;
import com.jaydenxiao.androidfire.entity.ShapeLoadingDialog;
import com.jaydenxiao.androidfire.ui.main.contract.LoginContract;
import com.jaydenxiao.androidfire.ui.main.model.LoginModel;
import com.jaydenxiao.androidfire.ui.main.presenter.LoginPresenter;

import com.jaydenxiao.androidfire.utils.SharedUtil;
import com.jaydenxiao.common.base.BaseActivity;
import com.jaydenxiao.common.commonwidget.LoadingTip;

import butterknife.Bind;

/**
 * Created by Zwei  on 2018/6/15.
 * E-Mail Address：592296083@qq.com
 */

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View {

    @Bind(R.id.login_btn)
    Button login_btn;
    @Bind(R.id.login_account)
    TextInputEditText login_account;
    @Bind(R.id.loadedTip)
    LoadingTip loadedTip;
    @Bind(R.id.login_password)
    TextInputEditText login_password;
    private ShapeLoadingDialog dialog;
    /**
     * 入口
     *
     * @param mContext
     */
    public static void startAction(Context mContext) {
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        dialog = new ShapeLoadingDialog(mContext);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getLoginStateRequest(login_account.getText().toString(),login_password.getText().toString());
            }
        });
    }

    @Override
    public void showLoading(String title) {
        dialog.loading("登录中....");
    }

    @Override
    public void stopLoading() {
        dialog.dismiss();
    }

    @Override
    public void showErrorTip(String msg) {
        loadedTip.setLoadingTip(LoadingTip.LoadStatus.error);
        loadedTip.setTips(msg);
        dialog.dismiss();
    }

    @Override
    public void returnLoginState(LoginsBeans LoginState) {
      if (LoginState.isLoginstate()){

          SharedUtil.putValue(mContext,"LoginState",LoginState.isLoginstate()+"");
          MainActivity.startAction(LoginActivity.this);
          finish();
      }else {
          Toast.makeText(mContext, "帐号或密码错误登录失败", Toast.LENGTH_LONG).show();

      }
    }

    @Override
    public void accountIsNull() {

        Toast.makeText(mContext, "请输入您的账户", Toast.LENGTH_LONG).show();
    }

    @Override
    public void passWordIsNull() {
        Toast.makeText(mContext, "请输入您的密码", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
      MainActivity.startAction(LoginActivity.this);
    }


}
