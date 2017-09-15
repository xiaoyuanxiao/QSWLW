package com.qs.qswlw.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qs.qswlw.MyApplication;
import com.qs.qswlw.R;
import com.qs.qswlw.adapter.InnovationAdapter;
import com.qs.qswlw.bean.EntrepreneurialDialogBean;
import com.qs.qswlw.bean.EntrepreneurialIncentiveBean;
import com.qs.qswlw.bean.MainBean;
import com.qs.qswlw.mynet.HttpSubCribe;
import com.qs.qswlw.mynet.MyRetroService;
import com.qs.qswlw.mynet.ReHttpUtils;
import com.qs.qswlw.okhttp.Iview.IEntrepreneurialView;
import com.qs.qswlw.okhttp.Presenter.EntrepreneurialPresenter;
import com.qs.qswlw.utils.ToastUtils;
import com.qs.qswlw.view.xlistview.IXListViewLoadMore;
import com.qs.qswlw.view.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by xiaoyu on 2017/9/6.
 */

public class InnovationIncentiveFragment extends BaseFragment implements IEntrepreneurialView {
    private XListView lv_sub_entrepreneurialseed;
    private EntrepreneurialPresenter entrepreneurialPresenter = new EntrepreneurialPresenter(this);
    private TextView tv_entrepreneurial_one, tv_entrepreneurial_two, tv_entrepreneurial_three, tv_entrepreneurial_four,tv_entrepreneurial_model;
    private List<EntrepreneurialIncentiveBean.ListModel2Bean> innovationList;
    private InnovationAdapter innovationAdapter;
    private LinearLayout ll_click;
    private Dialog dialog;
    private int silver;
    private String exchange_love;
    int i;
  //  private SwipeRefreshView swipeRefreshView;
    int page = 1;
    public static InnovationIncentiveFragment newInstener() {
        return new InnovationIncentiveFragment();
    }

    @Override
    View initView() {
        View inflate = View.inflate(getActivity(), R.layout.sub_entrepreneurialseed, null);
        lv_sub_entrepreneurialseed = (XListView) inflate.findViewById(R.id.lv_sub_entrepreneurialseed);
        tv_entrepreneurial_one = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_one);
        tv_entrepreneurial_two = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_two);
        tv_entrepreneurial_three = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_three);
        tv_entrepreneurial_four = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_four);
        tv_entrepreneurial_model = (TextView) inflate.findViewById(R.id.tv_entrepreneurial_model);
        ll_click = (LinearLayout) inflate.findViewById(R.id.ll_click);
        //上拉监听
        lv_sub_entrepreneurialseed.setPullLoadEnable(mLoadMoreListener);
        //开始下拉
//        swipeRefreshView = (SwipeRefreshView) inflate.findViewById(R.id.swipeRefreshView);
//        swipeRefreshView.setOnLoadListener(new SwipeRefreshView.OnLoadListener() {
//                @Override
//                public void onLoad() {
//                    entrepreneurialPresenter.getdata(MyApplication.TOKEN, page, "model2");
//                }
//        });
        return inflate;
    }
    /**
     *  上拉监听
    */
    private IXListViewLoadMore mLoadMoreListener = new IXListViewLoadMore() {
        @Override
        public void onLoadMore() {
            Toast.makeText(getActivity(), "上拉", Toast.LENGTH_SHORT).show();
            page++;
            entrepreneurialPresenter.getdata(MyApplication.TOKEN, page, "model2");
        }
    };

    @Override
    protected void initData() {
        super.initData();
        innovationList = new ArrayList<>();
        innovationAdapter = new InnovationAdapter(getActivity(), innovationList);
        lv_sub_entrepreneurialseed.setAdapter(innovationAdapter);
        entrepreneurialPresenter.getdata(MyApplication.TOKEN, page, "model2");
    }

    @Override
    protected void setOnclick() {
        ll_click.setOnClickListener(this);
    }

    @Override
    public void setEntrepreneurialData(EntrepreneurialIncentiveBean entrepreneurialData) {
        String allow_silver = entrepreneurialData.getAllow_silver_model2();
        silver = entrepreneurialData.getSilver2();
        tv_entrepreneurial_one.setText("消费银豆："+silver);
        exchange_love = entrepreneurialData.getExchange_love();
        tv_entrepreneurial_two.setText("可转为创业种子消费银豆："+allow_silver);
         i = Integer.parseInt(allow_silver) / (Integer.parseInt(exchange_love));
        tv_entrepreneurial_three.setText("正在激励创业种子："+entrepreneurialData.getLove2()+"");
        tv_entrepreneurial_four.setText("可转为创业种子数："+i + "");
        tv_entrepreneurial_model.setText(entrepreneurialData.getModel2()+"");
      //  swipeRefreshView.setLoading(false);
        if(entrepreneurialData.getList_model2()==null||entrepreneurialData.getList_model2().size()==0){
        //    ToastUtils.showToast("没有更多数据了");
            lv_sub_entrepreneurialseed.noMoreForShow();
            return;
        }
        innovationList.addAll(entrepreneurialData.getList_model2());
        innovationAdapter.notifyDataSetChanged();
        lv_sub_entrepreneurialseed.stopLoadMore();
       // page++;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_click:
                showDialog();
                break;
        }
    }
    private void showDialog() {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_sliverbeantoseed, null);
        //   Dialog dialog = new Dialog(getActivity(), R.style.custom_dialog_style);
        dialog = new Dialog(getActivity());
        dialog.setContentView(view, new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT));
        Window window = dialog.getWindow();
        view.findViewById(R.id.iv_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        TextView tv_dialog_sliverbean = (TextView) view.findViewById(R.id.tv_dialog_sliverbean);
        TextView tv_dialog_entrepreneurial = (TextView) view.findViewById(R.id.tv_dialog_entrepreneurial);
        TextView tv_describe = (TextView) view.findViewById(R.id.tv_describe);
        Button btn_dialog_determine = (Button) view.findViewById(R.id.btn_dialog_determine);
        final EditText edt_seed = (EditText) view.findViewById(R.id.edt_seed);
        tv_dialog_sliverbean.setText(silver + "");
        tv_describe.setText("注：消费银豆" + exchange_love + "=1创业种子");
        tv_dialog_entrepreneurial.setText(i + "");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        btn_dialog_determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostDialog(MyApplication.TOKEN, "model2", Integer.parseInt(edt_seed.getText().toString()));
            }
        });
    }

    private void PostDialog(final String token, final String model, final int i) {
        ReHttpUtils.instans().httpRequest(new HttpSubCribe<MainBean<EntrepreneurialDialogBean>>() {

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MainBean<EntrepreneurialDialogBean> entrepreneurialDialogBeanMainBean) {
                dialog.dismiss();
                if (1 == entrepreneurialDialogBeanMainBean.getSucc())
                    entrepreneurialPresenter.getdata(MyApplication.TOKEN, page, "model2");
                else
                    ToastUtils.showToast(entrepreneurialDialogBeanMainBean.getMsg());
            }

            @Override
            public Observable<MainBean<EntrepreneurialDialogBean>> getObservable(MyRetroService retrofit) {
                return retrofit.postEntrepreneurialDialog(token,model,i);
            }
        });


    }
}