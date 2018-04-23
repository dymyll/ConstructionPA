package com.example.dj954347.constructionprojectassistant;

/**
 * Created by Dymyll on 4/14/2018.
 */

import android.support.v4.app.Fragment;

public class CustomerListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CustomerListFragment();
    }
}
