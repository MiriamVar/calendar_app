//package com.example.calendar_app;
//
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.widget.Toast;
//
//import static android.widget.Toast.LENGTH_SHORT;
//
//public class ParentFragmentAcitivty extends Fragment implements AddEventActivity.AddEventActivityListener {
//
//    private void showEditDialog() {
//        FragmentManager fm = getFragmentManager();
//        AddEventActivity editNameDialogFragment = AddEventActivity.newInstance("Some Title", "Some title2");
//        // SETS the target fragment for use later when sending results
//        editNameDialogFragment.setTargetFragment(this, 300);
//        editNameDialogFragment.show(fm, "fragment_edit_name");
//    }
//
//    @Override
//    public void onFinisheditDialog(String inputText, String inputText2) {
//        Toast.makeText(this.getContext(), inputText + inputText2, LENGTH_SHORT).show();
//    }
//}
