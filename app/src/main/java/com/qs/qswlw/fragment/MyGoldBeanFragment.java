package com.qs.qswlw.fragment;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.activity.PersonalCenter.VenturegoldBeansActivity;
import com.qs.qswlw.adapter.VentureGoldBeansAdapter;
import com.qs.qswlw.bean.VenturegoldBean;
import com.qs.qswlw.okhttp.Iview.IVenturegoldBeansView;
import com.qs.qswlw.okhttp.Presenter.VenturegoldBeanPresenter;

import java.util.ArrayList;
import java.util.List;

import static com.qs.qswlw.R.id.tv_sub_mygoldenbean_one;
import static com.qs.qswlw.R.id.tv_sub_mygoldenbean_two;

/**
 * Created by xiaoyu on 2017/9/8.
 */
//这个我写了
public class MyGoldBeanFragment extends BaseFragment implements IVenturegoldBeansView {
    VenturegoldBeanPresenter venturegoldBeanPresenter = new VenturegoldBeanPresenter(this);
    private RadioButton rb_myGoldenBean_left, rb_myGoldenBean_right;

    public static MyGoldBeanFragment newInstance(String type) {//等下
        MyGoldBeanFragment myGoldBeanFragment = new MyGoldBeanFragment();
        myGoldBeanFragment.setGoldType(type);
        return myGoldBeanFragment;
    }

    public static String GIVE = "give";
    public static String TJJD = "tjjd";
    private String Gold_type = "";

    private void setGoldType(String Gold_type) {
        this.Gold_type = Gold_type;
    }

    @Override
    View initView() {
        View inflate = View.inflate(activity, R.layout.sub_mygoldenbean, null);
        rb_myGoldenBean_left = (RadioButton) inflate.findViewById(R.id.rb_myGoldenBean_left);
        rb_myGoldenBean_right = (RadioButton) inflate.findViewById(R.id.rb_myGoldenBean_right);

        return inflate;
    }
    @Override
    protected void setOnclick() {
        rb_myGoldenBean_left.setOnClickListener(this);
        rb_myGoldenBean_right.setOnClickListener(this);
        initButton();
        initList();
        checklisy(true);
    }

    public void refreshlist() {
        initListdata(ischeckmodel);
    }

    void initListdata(String modetype) {
        venturegoldBeanPresenter.getData(MyApplication.TOKEN, 1, modetype, Gold_type, ((VenturegoldBeansActivity) getActivity()).getType());
    }

    void initButton() {
        if (Gold_type.equals(TJJD)) {
            rb_myGoldenBean_left.setText("创业激励");
            rb_myGoldenBean_right.setText("创新激励");
            initListViewtitle("获赠时间");
        } else if (Gold_type.equals(GIVE)) {
            rb_myGoldenBean_left.setText("100%激励");
            rb_myGoldenBean_right.setText("20%激励");
            initListViewtitle("获奖时间");
        } else if (Gold_type.equals("")) {
            rb_myGoldenBean_left.setText("创业激励");
            rb_myGoldenBean_right.setText("创新激励");
        }
    }

    ListView lv_sub_myGoldenBean, lv_sub_myGoldenBean2;

    private void initListViewtitle(String nameone ) {
        view.findViewById(R.id.tv_sub_mygoldenbean_three).setVisibility(View.GONE);
        view.findViewById(R.id.tv_sub_mygoldenbean_four).setVisibility(View.GONE);
        ((TextView) view.findViewById(tv_sub_mygoldenbean_two)).setText("获得金豆");
        ((TextView) view.findViewById(tv_sub_mygoldenbean_one)).setText(nameone);
        //不是啊 这个是
    }

    BaseAdapter ventureGoldBeansAdapter, ventureGoldBeansAdapter2;

    void initList() {

        ventureGoldBeansAdapter = new VentureGoldBeansAdapter(activity, list1, Gold_type);
        ventureGoldBeansAdapter2 = new VentureGoldBeansAdapter(activity, list1, Gold_type);
        lv_sub_myGoldenBean = (ListView) view.findViewById(R.id.lv_sub_myGoldenBean);
        lv_sub_myGoldenBean.setAdapter(ventureGoldBeansAdapter);
        lv_sub_myGoldenBean2 = (ListView) view.findViewById(R.id.lv_sub_myGoldenBean2);
        lv_sub_myGoldenBean2.setAdapter(ventureGoldBeansAdapter2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_myGoldenBean_left://还没初始化-我知道0-00--
                checklisy(true);
                break;
            case R.id.rb_myGoldenBean_right:
                checklisy(false);
                break;
        }
    }

    String ischeckmodel = "model1";

    void checklisy(boolean checked) {
        if (checked) {
            initListdata("model1");
            lv_sub_myGoldenBean.setVisibility(View.VISIBLE);
            lv_sub_myGoldenBean2.setVisibility(View.GONE);
        } else {
            lv_sub_myGoldenBean.setVisibility(View.GONE);
            lv_sub_myGoldenBean2.setVisibility(View.VISIBLE);
            initListdata("model2");
        }
    }

    List<VenturegoldBean.ListBean> list1 = new ArrayList<>();
    List<VenturegoldBean.ListBean> list2 = new ArrayList<>();

    @Override
    public void setVenturegoldBeanData(VenturegoldBean venturegoldBeanData, String modeltype) {
        List<VenturegoldBean.ListBean> list = venturegoldBeanData.getList();
        ischeckmodel = modeltype;
        if (modeltype.equals("model1")) {
            list1.clear();
            list1.addAll(list);
            ventureGoldBeansAdapter.notifyDataSetChanged();
        } else {
            list2.clear();
            list2.addAll(list);
            ventureGoldBeansAdapter2.notifyDataSetChanged();
        }
    }
}
