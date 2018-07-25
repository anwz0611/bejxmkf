package com.jaydenxiao.androidfire.ui.news.contract;

import com.jaydenxiao.androidfire.bean.waterSituation;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by Zwei  on 2018/5/31.
 * E-Mail Address：592296083@qq.com
 */

public interface WaterSituationDetailContract {
    interface Model extends BaseModel {
        //请求历史河道水情列表
        Observable<List<waterSituation>> getWaterSituationDetailData(String stcd, String sttp, String startTime, String endTime);
    }
    interface View extends BaseView {
        //返回获取的历史河道水情列表
        void returnWaterSituationDetailData(List<waterSituation> waterSituationDetails);
        //返回顶部
        void scrolltoTop();
    }

    abstract static class Presenter extends BasePresenter<WaterSituationDetailContract.View, WaterSituationDetailContract.Model> {
        //发起获取水情详情请求
        public abstract void getWaterSituationDetailDataRequest(String stcd, String sttp, String startTime, String endTime);
    }

}
