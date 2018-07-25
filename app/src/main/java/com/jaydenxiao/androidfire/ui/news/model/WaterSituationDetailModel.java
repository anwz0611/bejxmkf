package com.jaydenxiao.androidfire.ui.news.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;
import com.jaydenxiao.androidfire.bean.waterSituation;
import com.jaydenxiao.androidfire.ui.news.contract.WaterSituationDetailContract;
import com.jaydenxiao.common.baserx.RxSchedulers;
import com.jaydenxiao.common.commonutils.TimeUtil;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Zwei  on 2018/5/31.
 * E-Mail Address：592296083@qq.com
 */

public class WaterSituationDetailModel implements WaterSituationDetailContract.Model {
    @Override
    public Observable<List<waterSituation>> getWaterSituationDetailData( String stcd, String sttp, String startTime, String endTime) {
        return  Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getwaterSituationDetail(stcd,sttp,startTime,endTime)
                //转化时间


                .compose(RxSchedulers.<List<waterSituation>>io_main());
    }
}
