package com.was.minejava.ui.tab;


import android.util.Log;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;


public class TabLayoutViewModel extends ViewModel {

    public final ObservableBoolean initTabAndPage = new ObservableBoolean();

//    public final TabLayouRequest TabLayouRequest = new TabLayouRequest();

    {
        initTabAndPage.set(true);
        Log.e("TabLayouViewModel", "init ---------> ");
    }

}
