package com.example.dj954347.constructionprojectassistant;

/**
 * Created by Dymyll on 4/14/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;


public class CustomerPagerActivity extends AppCompatActivity {

    private static final String EXTRA_CUSTOMER_ID =
            "ConstructionPA.customer_id";

    private ViewPager mViewPager;
    private List<Customer> mCustomers;

    public static Intent newIntent(Context packageContext, UUID customerId) {
        Intent intent = new Intent(packageContext, CustomerPagerActivity.class);
        intent.putExtra(EXTRA_CUSTOMER_ID, customerId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_pager);

        final UUID customerId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_CUSTOMER_ID);

        mViewPager = (ViewPager) findViewById(R.id.customer_view_pager);

        mCustomers = CustomerList.get(this).getCustomers();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            public Fragment getItem(int position) {
                Customer customer = mCustomers.get(position);
                return CreateUserFragment.newInstance(customer.getId());

            }

            @Override
            public int getCount() {
                return mCustomers.size();
            }
        });

        for (int i = 0; i < mCustomers.size(); i++) {
            if (mCustomers.get(i).getId().equals(customerId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
