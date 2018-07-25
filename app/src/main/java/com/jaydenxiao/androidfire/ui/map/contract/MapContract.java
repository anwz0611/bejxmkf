package com.jaydenxiao.androidfire.ui.map.contract;


import com.jaydenxiao.androidfire.bean.patrolRecordBeans;
import com.jaydenxiao.androidfire.bean.waterSituation;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public interface MapContract {

    interface Model extends BaseModel {
        Observable<List<waterSituation>> getWaterMapSituationDate(String date);
        Observable<List<patrolRecordBeans>> getPatrolRecordData();
        //请求历史河道水情列表
        Observable<List<waterSituation>> getWaterSituationData(String newDate, String historyDate, String flag, String pageSize, String pageNum, String sortContent, String sortType, String wptn);
    }
    interface View extends BaseView {
        void returnWaterSituationData(List<waterSituation> waterSituations);
        void returnPatrolRecordData(List<patrolRecordBeans> patrolRecordBeans);

        void returnWaterMapSituationDate(List<waterSituation> waterSituations);
        //返回顶部
        void scrolltoTop();
    }

    abstract static class Presenter extends BasePresenter<MapContract.View, MapContract.Model> {
        public abstract void getWaterMapSituationDataRequest(String date);
        public abstract void getPatrolRecordDataRequest();
        public abstract void getWaterSituationDataRequest(String newDate,String historyDate,  String flag, String pageSize,String pageNum,  String sortContent, String sortType,String wptn);

    }
}
