package com.jaydenxiao.androidfire.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.ui.bases.activity.AssociationInfoActivity;
import com.jaydenxiao.androidfire.ui.main.activity.SplashActivity;
import com.jaydenxiao.androidfire.ui.more.activity.MeteorologicalActivity;
import com.jaydenxiao.androidfire.ui.more.activity.PhoneListActivity;
import com.jaydenxiao.androidfire.ui.more.activity.PolicyLawInfoActivity;
import com.jaydenxiao.androidfire.ui.news.activity.AboutActivity;
import com.jaydenxiao.androidfire.ui.zone.activity.CirclePublishActivity;
import com.jaydenxiao.androidfire.utils.SharedUtil;
import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.commonutils.ToastUitl;
import com.jaydenxiao.common.commonwidget.NormalTitleBar;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Zwei  on 2018/6/7.
 * E-Mail Address：592296083@qq.com
 */

public class MoreFragment extends BaseFragment {
    @Bind(R.id.ntb)
    NormalTitleBar ntb;

    @Bind(R.id.exit_login_btn)
    Button exit_login_btn;
    @Override
    protected int getLayoutResource() {
        return R.layout.more_fragment;
    }

    @Override
    public void initPresenter() {

    }


    @Override
    protected void initView() {



        ntb.setTvLeftVisiable(false);
        ntb.setTitleText(getString(R.string.more));
    }
    @OnClick({R.id.layout_base_quhua, R.id.layout_ad_station, R.id.layout_small_watersh, R.id.layout_heliu, R.id.layout_difang,R.id.layout_difang1,R.id.exit_login_btn})
    public void OnClick(View view){
    switch (view.getId()){

        case R.id.layout_base_quhua:
            PhoneListActivity.startAction(getContext());
            break;
        case R.id.layout_ad_station:
            PolicyLawInfoActivity.startAction(getContext());
            break;
        case R.id.layout_small_watersh:
            MeteorologicalActivity.startAction(getContext());
            break;
        case R.id.layout_heliu:
            ToastUitl.showShort("已经是最新版本！");
            break;
        case R.id.layout_difang:
            AboutActivity.startAction(getContext());
            break;
        case R.id.layout_difang1:
//            CirclePublishActivity.startAction(getContext());
            break;
        case R.id.exit_login_btn:

            SharedUtil.deleteValue(getContext(),"LoginState");
            SplashActivity.startAction(getContext());
            break;
    }


    }
}
