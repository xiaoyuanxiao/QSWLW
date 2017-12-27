package com.qs.qswlw.view.webviewpb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.MainActivity;

public class WebviewActivity extends AppCompatActivity {

    private SlowlyProgressBar slowlyProgressBar;

    private String url;
    private String witnessChinaBusiness, interaction, products, ella, customerservice, winqs, qs_shop, qs_union, qs_fun, qs_lack_draw,
            shop_order,cash_money,cons_gold,qs_shop_address,qs_cat,qs_cart,qs_mine,my_shop,qs_ziying,qs_comment,qs_tegong,qs_xianfu,
            qs_chongzhi,qs_spgl;
    private WebView webView;
    private FrameLayout loadingLayout; //提示用户正在加载数据
    private FrameLayout webParentView;
    private View mErrorView; //加载错误的视图
    @JavascriptInterface
    public void shop() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("===============shop============");
                Intent intent = new Intent(WebviewActivity.this, MainActivity.class);
                intent.putExtra("webview","webview");
                startActivity(intent);

            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pb_webview);
        initErrorPage();//初始化自定义页面
        initData();
        init();
    }

    private void initData() {
        Intent intent = getIntent();
        witnessChinaBusiness = intent.getStringExtra("WitnessChinaBusiness");
        interaction = intent.getStringExtra("Interaction");
        products = intent.getStringExtra("products");
        ella = intent.getStringExtra("ella");
        customerservice = intent.getStringExtra("customerservice");
        winqs = intent.getStringExtra("winqs");
        qs_shop = intent.getStringExtra("qs_shop");
        qs_union = intent.getStringExtra("qs_union");
        qs_fun = intent.getStringExtra("qs_fun");
        qs_lack_draw = intent.getStringExtra("qs_lack_draw");
        shop_order = intent.getStringExtra("shop_order");
        cash_money = intent.getStringExtra("cash_money");
        cons_gold = intent.getStringExtra("cons_gold");
        qs_shop_address = intent.getStringExtra("qs_shop_address");
        qs_cat = intent.getStringExtra("qs_cat");
        qs_cart = intent.getStringExtra("qs_cart");
        qs_mine = intent.getStringExtra("qs_mine");
        my_shop = intent.getStringExtra("my_shop");
        qs_ziying = intent.getStringExtra("qs_ziying");
        qs_comment = intent.getStringExtra("qs_comment");
        qs_tegong = intent.getStringExtra("qs_tegong");
        qs_xianfu = intent.getStringExtra("qs_xianfu");
        qs_chongzhi = intent.getStringExtra("qs_chongzhi");
        qs_spgl = intent.getStringExtra("qs_spgl");
        if (witnessChinaBusiness != null) {
            url = witnessChinaBusiness;
        } else if (interaction != null) {
            url = interaction;
        } else if (products != null) {
            url = products;
        } else if (ella != null) {
            url = ella;
        } else if (customerservice != null) {
            url = customerservice;
        } else if (winqs != null) {
            url = winqs;
        } else if (qs_shop != null) {
            url = qs_shop;
        } else if (qs_union != null) {
            url = qs_union;
        } else if (qs_fun != null) {
            url = qs_fun;
        } else if (qs_lack_draw != null) {
            url = qs_lack_draw;
        } else if (shop_order != null) {
            url = shop_order;
        }else if (cash_money != null) {
            url = cash_money;
        }else if (cons_gold != null) {
            url = cons_gold;
        }else if (qs_shop_address != null) {
            url = qs_shop_address;
        }else if (qs_cat != null) {
            url = qs_cat;
        }else if (qs_cart != null) {
            url = qs_cart;
        }else if (qs_mine != null) {
            url = qs_mine;
        }else if (my_shop != null) {
            url = my_shop;
        }else if (qs_ziying != null) {
            url = qs_ziying;
        }else if (qs_comment != null) {
            url = qs_comment;
        }else if (qs_tegong != null) {
            url = qs_tegong;
        }else if (qs_xianfu != null) {
            url = qs_xianfu;
        }else if (qs_chongzhi != null) {
            url = qs_chongzhi;
        }else if (qs_spgl != null) {
            url = qs_spgl;
        }
        Log.e("url----------------",url);
    }

    private void init() {
        webView = (WebView) findViewById(R.id.webview);
        // 设置与Js交互的权限
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.addJavascriptInterface(this, "qsApp");
        slowlyProgressBar = new SlowlyProgressBar((ProgressBar) findViewById(R.id.ProgressBar));
        webView.setWebViewClient(new webViewClient());

        webView.setWebChromeClient(new webChromeClient());
        webView.loadUrl(url);
        webParentView = (FrameLayout) webView.getParent(); //获取父容器
    }

    @Override
    public void finish() {
        super.finish();
        webView.destroy();
        if(slowlyProgressBar!=null){
            slowlyProgressBar.destroy();
            slowlyProgressBar = null;
        }
    }

    /**
     * 显示自定义错误提示页面，用一个View覆盖在WebView
     */
    private void showErrorPage() {
        webParentView.removeAllViews(); //移除加载网页错误时，默认的提示信息
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        webParentView.addView(mErrorView, 0, layoutParams); //添加自定义的错误提示的View
    }

    /***
     * 显示加载失败时自定义的网页
     */
    private void initErrorPage() {
        if (mErrorView == null) {
            mErrorView = View.inflate(this, R.layout.activity_error, null);
        }
    }

    private class webViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            slowlyProgressBar.onProgressStart();
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            //6.0以下执行
            Log.i("TAG", "onReceivedError: ------->errorCode" + errorCode + ":" + description);
            //网络未连接
            showErrorPage();
        }

        //处理网页加载失败时
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            //6.0以上执行
            Log.i("TAG", "onReceivedError: ");
            showErrorPage();//显示错误页面
        }

    }

    private class webChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            slowlyProgressBar.onProgressChange(newProgress);

        }
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            showErrorPage();//显示错误页面
//                if (title.contains("404")){
//                    showErrorPage();
//                }
        }
    }
}
