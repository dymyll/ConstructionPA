package com.example.dj954347.constructionprojectassistant;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Dymyll on 4/2/2018.
 */

public class CreateUserFragment extends Fragment {

    private static final String ARG_CUST_ID = "customer_id";

    private Customer mCustomer;
    private EditText mUserName;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmailAddress;
    private EditText mDateOfBirth;
    private EditText mPassword;

    public static CreateUserFragment newInstance(UUID customerid) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CUST_ID, customerid);

        CreateUserFragment fragment = new CreateUserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID customerid = (UUID) getArguments().getSerializable(ARG_CUST_ID);
        mCustomer = CustomerList.get(getActivity()).getCustomer(customerid);
    }
//This allows the users information in text fields to be connected to fields in the backend
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_user, container, false);

        mUserName = (EditText) v.findViewById(R.id.username);
        mUserName.setText(mCustomer.getUserName());
        mUserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mFirstName = (EditText) v.findViewById(R.id.firstname);
        mFirstName.setText(mCustomer.getFirstName());
        mFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mLastName = (EditText) v.findViewById(R.id.lastname);
        mLastName.setText(mCustomer.getLastName());
        mLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mEmailAddress = (EditText) v.findViewById(R.id.emailaddress);
        mEmailAddress.setText(mCustomer.getEmailAddress());
        mEmailAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setEmailAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    /*
        mDateOfBirth = (EditText) v.findViewById(R.id.dateofbirth);
        mDateOfBirth.setText(mCustomer.getDateofBirth());
        mDateOfBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        */

        mPassword = (EditText) v.findViewById(R.id.password);
        mPassword.setText(mCustomer.getPassword());
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCustomer.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

            return v;
    }

    @Override
    public void onPause() {
        super.onPause();

        CustomerList.get(getActivity())
                .updateCustomer(mCustomer);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

//        if (requestCode == REQUEST_DATE) {
//            Date date = (Date) data
//                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
//            mCrime.setDate(date);
//            updateDate();
//        }
    }

//    private void updateDate() {
//        mDateButton.setText(mCrime.getDate().toString());
//    }
}

