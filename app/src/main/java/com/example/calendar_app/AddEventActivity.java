package com.example.calendar_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddEventActivity extends DialogFragment implements TextView.OnEditorActionListener {
     private EditText editNAme;
     private EditText editColor;
     private Button btnSave;

     public interface AddEventActivityListener{
         void onFinisheditDialog(String inputText, String inputText2);
     }

     public AddEventActivity(){

     }

     public static AddEventActivity newInstance(String title, String title2){
         AddEventActivity frag = new AddEventActivity();
         Bundle args = new Bundle();
         args.putString("title", title);
         args.putString("title2", title2);
         frag.setArguments(args);
         return frag;
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addevent, container);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        System.out.println("crating view of pop up");
        editNAme = (EditText) view.findViewById(R.id.edit_name);
        editColor = (EditText) view.findViewById(R.id.edit_color);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        String color = getArguments().getString("title2","Set Color");
        getDialog().setTitle(title);
        getDialog().setTitle(color);
        // Show soft keyboard automatically and request focus to field
        editNAme.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        editNAme.setOnEditorActionListener(this);
        editColor.setOnEditorActionListener(this);

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (EditorInfo.IME_ACTION_DONE == actionId) {
            System.out.println("skusam editovat");
            // Return input text back to activity through the implemented listener
            AddEventActivityListener listener = (AddEventActivityListener) getActivity();
            listener.onFinisheditDialog(editNAme.getText().toString(),editColor.getText().toString());
            dismiss();
            return true;
        }
        return false;
    }


//    public void sendBackResult() {
//        // Notice the use of `getTargetFragment` which will be set when the dialog is displayed
//        AddEventActivityListener  listener= (AddEventActivityListener) getTargetFragment();
//        listener.onFinisheditDialog(editNAme.getText().toString(), editColor.getText().toString());
//        dismiss();
//    }





}
