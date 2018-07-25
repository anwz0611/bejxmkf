package com.jaydenxiao.androidfire.ui.map.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;
import com.jaydenxiao.androidfire.bean.patrolRecordBeans;
import com.jaydenxiao.androidfire.bean.waterSituation;
import com.jaydenxiao.androidfire.ui.map.contract.MapContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import java.util.List;

import rx.Observable;


/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class MapModel implements MapContract.Model {

    @Override
    public Observable<List<patrolRecordBeans>> getPatrolRecordData() {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getPatrolRecord()
                .compose(RxSchedulers.<List<patrolRecordBeans>>io_main());
    }
    @Override
    public Observable<List<waterSituation>> getWaterMapSituationDate(String date) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getWaterMapSituation(date)
                .compose(RxSchedulers.<List<waterSituation>>io_main());
    }

    @Override
    public Observable<List<waterSituation>> getWaterSituationData(String newDate, String historyDate, String flag, String pageSize, String pageNum, String sortContent, String sortType, String wptn) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getWaterSituation(newDate,historyDate,flag,pageSize,pageNum,sortContent,sortType, wptn)
                .compose(RxSchedulers.<List<waterSituation>>io_main());


    }
}
