package com.rama.myapplication2.model_alertdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.rama.myapplication2.HomeActivity;
import com.rama.myapplication2.R;

public class InputDialog extends DialogFragment {

    public interface InputDialogListener {
        void onInputText(String inputText);
    }

    private EditText mInputEditText;
    private InputDialogListener mListener;
    private String inputText;
    public InputDialog(InputDialogListener listener) {
        mListener = listener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_input, null);
        mInputEditText = view.findViewById(R.id.inputEditText);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("")
                .setView(view)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        inputText = mInputEditText.getText().toString();
                        Intent intent = new Intent(getActivity(), HomeActivity.class);
                        intent.putExtra("inputText", inputText);
                        startActivity(intent);
                        dismiss();
                        String inputText = mInputEditText.getText().toString();
                        mListener.onInputText(inputText);
                    }

                })
                .setNegativeButton("Close", null);
        return builder.create();
    }
}
