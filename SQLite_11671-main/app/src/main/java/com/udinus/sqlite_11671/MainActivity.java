package com.udinus.sqlite_11671;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText xnim;
    EditText xnama;
    Button tblAdd;
    Button tblView;
    DatabaseReference reff;
    Siswa siswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xnim = (EditText)findViewById(R.id.xnim);
        xnama = (EditText)findViewById(R.id.xnama);
        tblAdd = (Button)findViewById(R.id.tblAdd);
        tblView = (Button)findViewById(R.id.tblView);
        siswa = new Siswa();
        reff= FirebaseDatabase.getInstance().getReference().child("Siswa");

        tblAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                siswa.setNim(xnim.getText().toString().trim());
                siswa.setNama_siswa(xnama.getText().toString().trim());
                reff.push().setValue(siswa);
                Toast.makeText(MainActivity.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }



    public void  showMessage(String title, String Messsage){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Messsage);
        builder.show();
    }
}