package com.jaydenxiao.androidfire.ui.bases.contract;


import com.jaydenxiao.androidfire.bean.AssociationInfoBeans;
import com.jaydenxiao.androidfire.bean.sluiceInfoBean;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public interface LuiceInfoContract {

    interface Model extends BaseModel {
        //请求历史河道水情列表
        Observable<List<sluiceInfoBean>> getLuiceInfoData(String keyWord,String pageSize, String pageNum);
    }
    interface View extends BaseView {
        //返回获取的历史河道水情列表
        void returnLuiceInfoData(List<sluiceInfoBean> sluiceInfoBean);
        //返回顶部
        void scrolltoTop();
    }

    abstract static class Presenter extends BasePresenter<LuiceInfoContract.View, LuiceInfoContract.Model> {
        //发起获取水情请求
        public abstract void getLuiceInfoDataRequest(String keyWord,String pageSize,String pageNum);
    }
}
