package com.jaydenxiao.androidfire.ui.map.contract;


import com.jaydenxiao.androidfire.bean.AssociationInfoBeans;
import com.jaydenxiao.androidfire.bean.IPQCbeans;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by Zwei  on 2018/5/30.
 * E-Mail Address：592296083@qq.com
 */

public interface IPQCContract {

    interface Model extends BaseModel {
        //请求历史河道水情列表
        Observable<List<IPQCbeans>> getIPQCData(String TM,String pageSize, String pageNum);
    }
    interface View extends BaseView {
        //返回获取的历史河道水情列表
        void returnIPQCData(List<IPQCbeans> IPQCbeans);
        //返回顶部
        void scrolltoTop();
    }

    abstract static class Presenter extends BasePresenter<IPQCContract.View, IPQCContract.Model> {
        //发起获取水情请求
        public abstract void getIPQCDataRequest(String TM,String pageSize,String pageNum);
    }
}
