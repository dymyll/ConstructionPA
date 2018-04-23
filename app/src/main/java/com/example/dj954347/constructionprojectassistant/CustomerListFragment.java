package com.example.dj954347.constructionprojectassistant;

/**
 * Created by Dymyll on 4/11/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CustomerListFragment extends Fragment {

    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";

    private RecyclerView mCustomerRecyclerView;
    private CustomersAdapter mAdapter;
    private boolean mSubtitleVisible;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer_list, container, false);

        mCustomerRecyclerView = (RecyclerView) view
                .findViewById(R.id.customer_recycler_view);
        mCustomerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (savedInstanceState != null) {
            mSubtitleVisible = savedInstanceState.getBoolean(SAVED_SUBTITLE_VISIBLE);
        }

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_customer_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.show_subtitle);
        if (mSubtitleVisible) {
            subtitleItem.setTitle(R.string.hide_subtitle);
        } else {
            subtitleItem.setTitle(R.string.show_subtitle);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_customer:
                Customer customer = new Customer();
                CustomerList.get(getActivity()).addCustomer(customer);
                Intent intent = CustomerPagerActivity
                        .newIntent(getActivity(), customer.getId());
                startActivity(intent);
                return true;
            case R.id.show_subtitle:
                mSubtitleVisible = !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle() {
        CustomerList customerList = CustomerList.get(getActivity());
        int customerCount = customerList.getCustomers().size();
        String subtitle = getString(R.string.subtitle_format, customerCount);

        if (!mSubtitleVisible) {
            subtitle = null;
        }

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    private void updateUI() {
        CustomerList customerList = CustomerList.get(getActivity());
        List<Customer> customers = customerList.getCustomers();

        if (mAdapter == null) {
            mAdapter = new CustomersAdapter(customers);
            mCustomerRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setCustomers(customers);
            mAdapter.notifyDataSetChanged();
        }

        updateSubtitle();
    }

    private class CustomersHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Customer mCustomer;

        private TextView mTitleTextView;
        private TextView mUserNameTextView;
        private TextView mFirstNameTextView;
        private TextView mLastNameTextView;
        private TextView mEmailAddressTextView;

        private TextView mDateTextView;
        private ImageView mSolvedImageView;

        public CustomersHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_customer, parent, false));
            itemView.setOnClickListener(this);

            mUserNameTextView = (TextView) itemView.findViewById(R.id.username);
            mFirstNameTextView = (TextView) itemView.findViewById(R.id.firstname);
            mSolvedImageView = (ImageView) itemView.findViewById(R.id.crime_solved);
        }

        public void bind(Customer customer) {
            mCustomer = customer;
            mUserNameTextView.setText(mCustomer.getUserName());
            mFirstNameTextView.setText(mCustomer.getFirstName());
//            mLastNameTextView.setText(mCustomer.getLastName());
//            mEmailAddressTextView.setText(mCustomer.getEmailAddress());
//            mDateTextView.setText(mCustomer.getDateofBirth().toString());
           mSolvedImageView.setVisibility(customer.isSolved() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            Intent intent = CustomerPagerActivity.newIntent(getActivity(), mCustomer.getId());
            startActivity(intent);
        }
    }

    private class CustomersAdapter extends RecyclerView.Adapter<CustomersHolder> {

        private List<Customer> mCustomers;

        public CustomersAdapter(List<Customer> customers) {
            mCustomers = customers;
        }

        @Override
        public CustomersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CustomersHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(CustomersHolder holder, int position) {
            Customer customer = mCustomers.get(position);
            holder.bind(customer);
        }

        @Override
        public int getItemCount() {
            return mCustomers.size();
        }

        public void setCustomers(List<Customer> customers) {
            mCustomers = customers;
        }
    }
}

