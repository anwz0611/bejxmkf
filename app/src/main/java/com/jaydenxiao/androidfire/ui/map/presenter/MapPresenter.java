package com.jaydenxiao.androidfire.ui.map.presenter;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.app.AppConstant;
import com.jaydenxiao.androidfire.bean.AssociationInfoBeans;
import com.jaydenxiao.androidfire.bean.patrolRecordBeans;
import com.jaydenxiao.androidfire.bean.waterSituation;
import com.jaydenxiao.androidfire.ui.bases.contract.AssociationInfoContract;
import com.jaydenxiao.androidfire.ui.map.contract.MapContract;
import com.jaydenxiao.common.baserx.RxSubscriber;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class MapPresenter extends MapContract.Presenter {

    @Override
    public void getWaterSituationDataRequest(String newDate,String historyDate, String flag, String pageSize, String pageNum, String sortContent, String sortType, String wptn,String keyWord) {
        mRxManage.add(mModel.getWaterSituationData(newDate,historyDate,flag,pageSize,pageNum,sortContent,sortType,wptn,keyWord).subscribe(new RxSubscriber<List<waterSituation>>(mContext, false) {
            @Override
            protected void _onNext(List<waterSituation> waterSituations) {
                mView.returnWaterSituationData(waterSituations);
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
    public void getWaterMapSituationDataRequest(String date) {
        mRxManage.add(mModel.getWaterMapSituationDate(date).subscribe(new RxSubscriber<List<waterSituation>>(mContext, false) {
            @Override
            protected void _onNext(List<waterSituation> waterSituations) {
                mView.returnWaterMapSituationDate(waterSituations);
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
    public void getPatrolRecordDataRequest() {
        mRxManage.add(mModel.getPatrolRecordData().subscribe(new RxSubscriber<List<patrolRecordBeans>>(mContext, false) {
            @Override
            protected void _onNext(List<patrolRecordBeans> patrolRecordBeans) {
                mView.returnPatrolRecordData(patrolRecordBeans);
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
