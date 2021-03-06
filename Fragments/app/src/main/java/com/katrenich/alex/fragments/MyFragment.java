package com.katrenich.alex.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MyFragment extends Fragment implements View.OnClickListener {
    private String TAG = "MyLog";

    EditText edtTextToFragTwo;
    Button btnOpenNextFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);

        init(view);
    }

    private void init(View view) {
        edtTextToFragTwo = view.findViewById(R.id.edt_text_frag_two);
        btnOpenNextFragment = view.findViewById(R.id.btn_open_next_fragment);
        btnOpenNextFragment.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_open_next_fragment :

                break;
            default:
                break;
        }
    }
}
