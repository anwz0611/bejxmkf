package com.jaydenxiao.androidfire.ui.zone.contract;


import com.jaydenxiao.androidfire.bean.PatrolDataBeans;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.adapter.rxjava.Result;

import rx.Observable;

/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public interface PatrolDataContract {

    interface Model extends BaseModel {

        Observable<PatrolDataBeans> getPatrolData();

        Observable<Result<String>> patrolUploading(RequestBody can, RequestBody cantype, RequestBody id, RequestBody classification, RequestBody grade
                , RequestBody tm, RequestBody part, RequestBody description, RequestBody mgr, RequestBody tel, RequestBody annex, RequestBody lgtd, RequestBody lttd, List<MultipartBody.Part> photo);
    }

    interface View extends BaseView {

        void returnPatrolData(PatrolDataBeans patrolDataBeans);

        void returnPatrolUploading(Result<String> Result);

    }

    abstract static class Presenter extends BasePresenter<PatrolDataContract.View, PatrolDataContract.Model> {

        public abstract void getPatrolDataRequest();

        public abstract void getPatrolUploadingRequest(RequestBody can, RequestBody cantype, RequestBody id, RequestBody classification, RequestBody grade
                , RequestBody tm, RequestBody part, RequestBody description, RequestBody mgr, RequestBody tel, RequestBody annex, RequestBody lgtd, RequestBody lttd, List<MultipartBody.Part> photo);
    }
}
