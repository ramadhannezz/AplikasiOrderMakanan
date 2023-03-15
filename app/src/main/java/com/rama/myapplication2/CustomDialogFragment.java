package com.rama.myapplication2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Buatlah tampilan dialog fragment popup
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("PERINGATAN!")
                .setMessage("Apakah anda yakin ingin beralih ke pilihan lain?")
                .setPositiveButton("Sangat Yakin!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Handle OK button click event
                    }
                })
                .setNegativeButton("Ngga Dulu Deh :(", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Handle Cancel button click event
                    }
                });

        // Return the created dialog
        return builder.create();
    }
}
