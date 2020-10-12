package com.was.minejava.ui.tab;


import com.kunminx.architecture.ui.page.DataBindingConfig;
import com.was.minejava.base.BaseActivity;
import com.was.minejava.BR;
import com.was.minejava.R;

public class TabLayoutActivity extends BaseActivity {

    TabLayoutViewModel mTabLayoutModel;

    @Override
    protected void initViewModel() {
        mTabLayoutModel = new TabLayoutViewModel();
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_tab_layout, BR.vm, mTabLayoutModel)
                .addBindingParam(BR.click, new ClickProxy());
    }


    public class ClickProxy {
        public void click() {

        }
    }
}