package com.jaydenxiao.androidfire.ui.main.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.app.AppConstant;
import com.jaydenxiao.androidfire.bean.NewsChannelTable;
import com.jaydenxiao.androidfire.ui.news.activity.NewsChannelActivity;
import com.jaydenxiao.androidfire.ui.main.contract.NewsMainContract;
import com.jaydenxiao.androidfire.ui.news.fragment.NewsFrament;
import com.jaydenxiao.androidfire.ui.main.model.NewsMainModel;
import com.jaydenxiao.androidfire.ui.main.presenter.NewsMainPresenter;
import com.jaydenxiao.androidfire.ui.news.fragment.WaterSituationFrament;
import com.jaydenxiao.androidfire.utils.MyUtils;
import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.base.BaseFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * des:新闻首页首页
 *
 *
 */
public class NewsMainFragment extends BaseFragment<NewsMainPresenter,NewsMainModel>implements NewsMainContract.View {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.add_channel_iv)
    ImageView addChannelIv;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private BaseFragmentAdapter fragmentAdapter;

    @Override
    protected int getLayoutResource() {
        return R.layout.act_news;
    }

    @Override
    public void initPresenter() {
      mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        mPresenter.lodeMineChannelsRequest();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRxManager.post(AppConstant.NEWS_LIST_TO_TOP, "");
            }
        });
    }
    @OnClick(R.id.add_channel_iv)
    public void clickAdd(){
        NewsChannelActivity.startAction(getContext());
    }

    @Override
    public void returnMineNewsChannels(List<NewsChannelTable> newsChannelsMine) {
        if(newsChannelsMine!=null) {
            List<String> channelNames = new ArrayList<>();
            List<Fragment> mNewsFragmentList = new ArrayList<>();
            for (int i = 0; i < newsChannelsMine.size(); i++) {
                channelNames.add(newsChannelsMine.get(i).getNewsChannelName());
                mNewsFragmentList.add(createListFragments(newsChannelsMine.get(i)));
            }
                if (newsChannelsMine!=null){
                    List<String> channelNames1 = new ArrayList<>();
                    List<Fragment> mNewsFragmentList1 = new ArrayList<>();

                }
            if(fragmentAdapter==null) {
                fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mNewsFragmentList, channelNames);
            }else{
                //刷新fragment
                fragmentAdapter.setFragments(getChildFragmentManager(),mNewsFragmentList,channelNames);
            }
            viewPager.setAdapter(fragmentAdapter);
            tabs.setupWithViewPager(viewPager);

            viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
                /**
                 * 页面滑动时回调的方法,
                 * @param  page 当前滑动的view
                 * @param position 当从右向左滑的时候,左边page的position是[0一-1]变化的
                 * 右边page的position是[1一0]变化的,再次滑动的时候,刚才变化到-1(即已经画出视野的page)將从-1变化到-2,
                 * 而当前可见的page和右边滑过来的page的position将再次从[0一-1]变化 和 [1一0]变化   但是我们关心是position是[-1一1]变化的
                 * page,所以处理动画的时候需要我们过滤一下
                 */
                @Override
                public void transformPage(View page, float position) {
                    raised3D(page,position);//调用翻页效果
                }
            });
            MyUtils.dynamicSetTabLayoutMode(tabs);
            setPageChangeListener();
        }
    }

    private void setPageChangeListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private WaterSituationFrament createListFragments(NewsChannelTable newsChannel) {
        WaterSituationFrament fragment = new WaterSituationFrament();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstant.NEWS_ID, newsChannel.getNewsChannelId());
        bundle.putString(AppConstant.NEWS_TYPE, newsChannel.getNewsChannelType());
        bundle.putInt(AppConstant.CHANNEL_POSITION, newsChannel.getNewsChannelIndex());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
    /**
     * 动画效果1  凹陷的3D效果
     */
    public void sink3D(View view,float position){
        if(position>=-1&&position<=1){
            view.setPivotX(position<0?view.getWidth():0);
            view.setRotationY(-90*position);
        }
    }
    /**
     * 动画效果2  凸起的3D效果
     */
    public void raised3D(View view,float position){
        if(position>=-1&&position<=1){
            view.setPivotX(position<0?view.getWidth():0);//设置要旋转的Y轴的位置
            view.setRotationY(90*position);//开始设置属性动画值
        }
    }
}
