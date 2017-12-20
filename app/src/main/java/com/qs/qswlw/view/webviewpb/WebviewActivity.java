package com.qs.qswlw.view.webviewpb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.qs.qswlw.R;
import com.qs.qswlw.activity.MainActivity;

public class WebviewActivity extends AppCompatActivity {

    private SlowlyProgressBar slowlyProgressBar;

    private String url;
    private String witnessChinaBusiness, interaction, products, ella, customerservice, winqs, qs_shop, qs_union, qs_fun, qs_lack_draw,
            shop_order,cash_money,cons_gold;
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
        }

    }

    private void init() {
        WebView webView = (WebView) findViewById(R.id.webview);
        // 设置与Js交互的权限
        webView.getSettings().setJavaScriptEnabled(true);
        // 设置允许JS弹窗
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.addJavascriptInterface(this, "qsApp");
        slowlyProgressBar = new SlowlyProgressBar((ProgressBar) findViewById(R.id.ProgressBar));
        webView.setWebViewClient(new webViewClient());

        webView.setWebChromeClient(new webChromeClient());
        webView.loadUrl(url);
    }

    @Override
    public void finish() {
        super.finish();
        if(slowlyProgressBar!=null){
            slowlyProgressBar.destroy();
            slowlyProgressBar = null;
        }
    }

    private class webViewClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            slowlyProgressBar.onProgressStart();
        }
    }

    private class webChromeClient extends WebChromeClient{
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            slowlyProgressBar.onProgressChange(newProgress);

        }
    }
}
