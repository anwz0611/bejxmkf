package com.jaydenxiao.androidfire.ui.bases.presenter;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.app.AppConstant;
import com.jaydenxiao.androidfire.bean.AssociationInfoBeans;
import com.jaydenxiao.androidfire.bean.sluiceInfoBean;
import com.jaydenxiao.androidfire.ui.bases.contract.AssociationInfoContract;
import com.jaydenxiao.androidfire.ui.bases.contract.LuiceInfoContract;
import com.jaydenxiao.common.baserx.RxSubscriber;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class LuiceInfoPresenter extends LuiceInfoContract.Presenter {
    @Override
    public void getLuiceInfoDataRequest(String keyWord,String pageSize, String pageNum) {
        mRxManage.add(mModel.getLuiceInfoData(keyWord,pageSize,pageNum).subscribe(new RxSubscriber<List<sluiceInfoBean>>(mContext, false) {
            @Override
            protected void _onNext(List<sluiceInfoBean> sluiceInfoBean) {
                mView.returnLuiceInfoData(sluiceInfoBean);
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

    @Override
    public void onStart() {
        super.onStart();

        //监听返回顶部动作
        mRxManage.on(AppConstant.NEWS_LIST_TO_TOP, new Action1<Object>() {
            @Override
            public void call(Object o) {
                mView.scrolltoTop();
            }
        });
    }


}
