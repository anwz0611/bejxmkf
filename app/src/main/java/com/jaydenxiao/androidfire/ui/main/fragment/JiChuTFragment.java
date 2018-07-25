package com.jaydenxiao.androidfire.ui.main.fragment;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.app.AppConstant;
import com.jaydenxiao.androidfire.bean.EventBusBeans;
import com.jaydenxiao.androidfire.ui.bases.contract.UserInfoContract;
import com.jaydenxiao.androidfire.ui.bases.fragment.AssociationInfoFragment;
import com.jaydenxiao.androidfire.ui.bases.fragment.LuiceInfoFragment;
import com.jaydenxiao.androidfire.ui.bases.fragment.StationInfoFragment;
import com.jaydenxiao.androidfire.ui.bases.fragment.UserInfoFragment;
import com.jaydenxiao.androidfire.ui.bases.fragment.WaterChannelFragment;
import com.jaydenxiao.androidfire.utils.MyUtils;
import com.jaydenxiao.common.base.BaseFragment;
import com.jaydenxiao.common.base.BaseFragmentAdapter;
import com.wyt.searchbox.SearchFragment;
import com.wyt.searchbox.custom.IOnSearchClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Zwei  on 2018/6/15.
 * E-Mail Address：592296083@qq.com
 */

public class JiChuTFragment extends BaseFragment  {
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Bind(R.id.fab)
    FloatingActionButton fab;
    private BaseFragmentAdapter fragmentAdapter;
    private SearchFragment searchFragment;
    @Override
    protected int getLayoutResource() {
        return R.layout.more_tfragment;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRxManager.post(AppConstant.NEWS_LIST_TO_TOP, "");
            }
        });
        List<String> channelNames = new ArrayList<>();
        channelNames.add("渠道");
        channelNames.add("测站");
        channelNames.add("水闸");
        channelNames.add("协会");
        channelNames.add("用水户");
        List<Fragment> mNewsFragmentList = new ArrayList<>();
        mNewsFragmentList.add(new WaterChannelFragment());
        mNewsFragmentList.add(new StationInfoFragment());
        mNewsFragmentList.add(new LuiceInfoFragment());
        mNewsFragmentList.add(new AssociationInfoFragment());
        mNewsFragmentList.add(new UserInfoFragment());
        if (fragmentAdapter == null) {
            fragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), mNewsFragmentList, channelNames);
        } else {
            //刷新fragment
            fragmentAdapter.setFragments(getChildFragmentManager(), mNewsFragmentList, channelNames);
        }
        viewPager.setAdapter(fragmentAdapter);
        tabs.setupWithViewPager(viewPager);
        MyUtils.dynamicSetTabLayoutMode(tabs);
        setHasOptionsMenu(true);
        searchFragment = SearchFragment.newInstance();
        ((AppCompatActivity) getActivity()).setSupportActionBar( toolbar);
        searchFragment.setOnSearchClickListener(new IOnSearchClickListener() {
            @Override
            public void OnSearchClick(String keyword) {
                EventBusBeans eb=new  EventBusBeans();
                eb.setFlag(tabs.getSelectedTabPosition());
                 eb.setData(keyword);
                EventBus.getDefault().post(eb);
        }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case  R.id.action_search:
                searchFragment.show(getFragmentManager(), SearchFragment.TAG);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}