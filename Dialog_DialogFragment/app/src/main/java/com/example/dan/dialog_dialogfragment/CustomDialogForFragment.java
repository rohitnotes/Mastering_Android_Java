package com.example.dan.dialog_dialogfragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dan.dialog_dialogfragment.databinding.DialogLayoutBinding;

public class CustomDialogForFragment extends DialogFragment {
    private static final String TAG = "CustomDialog";
    DialogLayoutBinding binding;

    public interface OnInputSelected{
        void sendInput(String input);
    }
    public OnInputSelected mOnInputSelected;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_layout, container,false);

        binding.tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick : Closing Dialog");
                getDialog().dismiss();
            }
        });

        binding.tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick : Capturing Input");

                String inputPrice = binding.etPrice.getText().toString();
//                String inputPrice = "HEHEHE";
                if (!inputPrice.equals("")){
                    //Easiest Way, just set the value
//                    FragmentTest fragment = (FragmentTest) getActivity().getFragmentManager().findFragmentByTag("FragmentTest");
//                    fragment.binding.tvDialogResult.setText(inputPrice);
                    mOnInputSelected.sendInput(inputPrice);
                }
                getDialog().dismiss();
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mOnInputSelected = (OnInputSelected) getTargetFragment();
        }catch(ClassCastException e){
            Log.e(TAG,"onAttach: ClassCastException: "+e.getMessage());
        }
    }
}
