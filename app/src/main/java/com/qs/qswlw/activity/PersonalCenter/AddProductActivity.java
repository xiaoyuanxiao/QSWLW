package com.qs.qswlw.activity.PersonalCenter;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.qs.qswlw.R;

/**
 * Created by xiaoyu on 2017/5/11.
 */

public class AddProductActivity extends BaseInfoActivity {

    private Spinner addproduct_spinner,addproductclassify_spinner;
    private ArrayAdapter<CharSequence> adapter;
    private String strClassification;

    @Override
    public View setConetnView() {
        View inflate = View.inflate(this, R.layout.activity_addproduct, null);
        addproduct_spinner = (Spinner) inflate.findViewById(R.id.addproduct_spinner);
        addproductclassify_spinner = (Spinner) inflate.findViewById(R.id.addproductclassify_spinner);
        return inflate;
    }

    @Override
    public void initfindviewByid() {
        super.initfindviewByid();
        tv_titlebar_center.setText("添加商品");

    }

    @Override
    public void initData() {
        super.initData();
        loadSpinner(addproduct_spinner,R.array.addproduct_mode);
        loadSpinner(addproductclassify_spinner,R.array.addproduct_classification);
    }

    /**
     * spinner
     */
    private void loadSpinner(final Spinner spinner, int array) {
        adapter = ArrayAdapter.createFromResource(this,array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.getSelectedItemPosition();
                strClassification = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
