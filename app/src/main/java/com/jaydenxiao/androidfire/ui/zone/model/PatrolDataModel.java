package com.jaydenxiao.androidfire.ui.zone.model;

import com.jaydenxiao.androidfire.api.Api;
import com.jaydenxiao.androidfire.api.HostType;

import com.jaydenxiao.androidfire.bean.PatrolDataBeans;

import com.jaydenxiao.androidfire.bean.PatrolUploadingBeans;
import com.jaydenxiao.androidfire.ui.zone.contract.PatrolDataContract;
import com.jaydenxiao.common.baserx.RxSchedulers;

import java.util.List;


import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.adapter.rxjava.Result;
import rx.Observable;


/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public class PatrolDataModel implements PatrolDataContract.Model {

    @Override
    public Observable<PatrolDataBeans> getPatrolData() {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).getPatrolData()
                .compose(RxSchedulers.<PatrolDataBeans>io_main());
    }

    @Override
    public Observable<PatrolUploadingBeans> patrolUploading(RequestBody can, RequestBody cantype, RequestBody id, RequestBody classification, RequestBody grade, RequestBody tm, RequestBody part, RequestBody description, RequestBody mgr, RequestBody tel, RequestBody annex, RequestBody lgtd, RequestBody lttd, List<MultipartBody.Part> photo) {
        return Api.getDefault(HostType.NETEASE_NEWS_VIDEO).patrolUploading(can, cantype, id, classification, grade, tm, part, description, mgr, tel, annex, lgtd, lttd, photo)
                .compose(RxSchedulers.<PatrolUploadingBeans>io_main());
    }


}
