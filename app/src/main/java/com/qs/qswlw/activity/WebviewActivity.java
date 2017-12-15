package com.qs.qswlw.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/5/4.
 */

public class WebviewActivity extends Activity {

    private WebView webView;
    private String url;
    private String witnessChinaBusiness,interaction,products,ella,customerservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        webView = (WebView) findViewById(R.id.webview);
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
        if(witnessChinaBusiness!=null){
           url = witnessChinaBusiness;
        } else if (interaction != null) {
            url = interaction;
        }else if(products != null) {
            url = products;
        }else if(ella != null) {
            url = ella;
        }else if(customerservice != null) {
            url = customerservice;
        }

    }

    private void init() {
        webView = (WebView) findViewById(R.id.webview);
        //启用支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        //启用支持DOM Storage
        webView.getSettings().setDomStorageEnabled(true);
        //加载web资源
        webView.loadUrl(url);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            Dialog progressDialog = ProgressDialog.show(WebviewActivity.this, null,
                   "正在加载中");

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressDialog.cancel();

            }
        });
    }

    //改写物理按键的返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();//返回上一页面
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
