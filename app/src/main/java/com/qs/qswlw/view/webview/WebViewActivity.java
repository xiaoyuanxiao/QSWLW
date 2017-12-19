package com.qs.qswlw.view.webview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.MainActivity;


public class WebViewActivity extends Activity {


    View mLadingView;
    CustomActionWebView mCustomActionWebView;
    private String url;
    private String witnessChinaBusiness, interaction, products, ella, customerservice, winqs, qs_shop, qs_union, qs_fun, qs_lack_draw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
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
        }


    }

    @JavascriptInterface
    public void shop() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                System.out.println("===============shop============");
                Intent intent = new Intent(WebViewActivity.this, MainActivity.class);
                intent.putExtra("webview","webview");
                startActivity(intent);
             
            }
        });

    }

    private void init() {

        mLadingView = findViewById(R.id.loadingView);
        mCustomActionWebView = (CustomActionWebView) findViewById(R.id.customActionWebView);
        mCustomActionWebView.setWebViewClient(new CustomWebViewClient());
        //链接js注入接口，使能选中返回数据
        mCustomActionWebView.linkJSInterface();

        mCustomActionWebView.getSettings().setBuiltInZoomControls(true);
        mCustomActionWebView.getSettings().setDisplayZoomControls(false);
        //使用javascript
        mCustomActionWebView.getSettings().setJavaScriptEnabled(true);
        mCustomActionWebView.getSettings().setDomStorageEnabled(true);
        mCustomActionWebView.addJavascriptInterface(this, "qsApp");
        //增加点击回调
        mCustomActionWebView.setActionSelectListener(new ActionSelectListener() {
            @Override
            public void onClick(String title, String selectText) {
                if (title.equals("APIWeb")) {
                    Intent intent = new Intent(WebViewActivity.this, APIWebViewActivity.class);
                    startActivity(intent);
                    return;
                }
                Toast.makeText(WebViewActivity.this, "Click Item: " + title + "。\n\nValue: " + selectText, Toast.LENGTH_LONG).show();
            }
        });

        //加载url
        mCustomActionWebView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCustomActionWebView.loadUrl(url);
            }
        }, 0);
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mCustomActionWebView != null) {
            mCustomActionWebView.dismissAction();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private class CustomWebViewClient extends WebViewClient {

        private boolean mLastLoadFailed = false;

        @Override
        public void onPageFinished(WebView webView, String url) {
            super.onPageFinished(webView, url);
            if (!mLastLoadFailed) {
                CustomActionWebView customActionWebView = (CustomActionWebView) webView;
                customActionWebView.linkJSInterface();
                mLadingView.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageStarted(WebView webView, String url, Bitmap favicon) {
            super.onPageStarted(webView, url, favicon);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            mLastLoadFailed = true;
            mLadingView.setVisibility(View.GONE);
        }
    }
}
