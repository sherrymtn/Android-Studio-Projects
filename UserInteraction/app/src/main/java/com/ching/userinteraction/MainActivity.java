package com.ching.userinteraction;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button ok;
    TextView result;
    ImageView image;
    LinearLayout linear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ok = findViewById(R.id.buttonOK);
        result = findViewById(R.id.textView);
        image = findViewById(R.id.imageSample);
        linear = findViewById(R.id.linear);

        // TOAST MESSAGE
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "This is a TOAST message", Toast.LENGTH_LONG).show();
//            }
//        });

        // SNACKBAR MESSAGE
//        ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(linear, "This is a SNACKBAR message",
//                        Snackbar.LENGTH_INDEFINITE).setAction("CLOSE", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                }).show();
//            }
//        });


        // DIALOG MEASSAGE
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialogMessage();

            }
        });
    }

    private void showDialogMessage() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Delete")
                .setMessage("Do you want to delete text?")
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();

                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        result.setText("");

                    }
                }).show();
        alertDialog.create();

    }
}



