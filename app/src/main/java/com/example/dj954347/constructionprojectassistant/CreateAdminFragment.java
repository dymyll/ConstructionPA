package com.example.dj954347.constructionprojectassistant;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Dymyll on 4/2/2018.
 */

public class CreateAdminFragment extends Fragment {

    private static final String ARG_ADMIN_ID = "admin_id";

    private Admin mAdmin;
    private EditText mAdminName;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mEmailAddress;
    private EditText mDateOfBirth;
    private EditText mPassword;

    public static CreateAdminFragment newInstance(UUID adminid) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_ADMIN_ID, adminid);

        CreateAdminFragment fragment = new CreateAdminFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID adminid = (UUID) getArguments().getSerializable(ARG_ADMIN_ID);
        mAdmin = AdminList.get(getActivity()).getAdmin(adminid);
    }
    //This allows the users information in text fields to be connected to fields in the backend
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create_user, container, false);

        mAdminName = (EditText) v.findViewById(R.id.username);
        mAdminName.setText(mAdmin.getAdminName());
        mAdminName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdmin.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mFirstName = (EditText) v.findViewById(R.id.firstname);
        mFirstName.setText(mAdmin.getFirstName());
        mFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdmin.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mLastName = (EditText) v.findViewById(R.id.lastname);
        mLastName.setText(mAdmin.getLastName());
        mLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdmin.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mEmailAddress = (EditText) v.findViewById(R.id.emailaddress);
        mEmailAddress.setText(mAdmin.getEmailAddress());
        mEmailAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdmin.setEmailAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    /*
        mDateOfBirth = (EditText) v.findViewById(R.id.dateofbirth);
        mDateOfBirth.setText(mAdmin.getDateofBirth());
        mDateOfBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdmin.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        */

        mPassword = (EditText) v.findViewById(R.id.password);
        mPassword.setText(mAdmin.getPassword());
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mAdmin.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }
}
