package com.example.taki.sqliteexample;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etname,etdept,etnumber;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ininview();
    }

    private void ininview() {
        etname=findViewById(R.id.etName);
        etdept=findViewById(R.id.etDept);
        etnumber=findViewById(R.id.etNumber);
        textView=findViewById(R.id.tvViewData);
    }

    public void saveData(View view) {

        String name= etname.getText().toString().trim();
        String dept= etdept.getText().toString().trim();
        String number= etnumber.getText().toString().trim();

        if (name.isEmpty()){
            etname.setError("please Enter Name");
            etname.requestFocus();
            return;
        }
        if (name.isEmpty()){
            etdept.setError("please Enter dept");
            etdept.requestFocus();
            return;
        }
        if (name.isEmpty()){
            etnumber.setError("please Enter Number");
            etnumber.requestFocus();
            return;
        }

        //all is Okay

        MySqlite mySqlite=new MySqlite(this);
        long checker=mySqlite.insertData(name,dept,number);
        if (checker==-1){
            Toast.makeText(this, "Faild to insert Data", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, " inserted Data", Toast.LENGTH_SHORT).show();

        }
    }

    public void ViewData(View view) {

        /*MySqlite mySqlite = new MySqlite(this);
        Cursor cursor = mySqlite.getData();
        StringBuffer stringBuffer = new StringBuffer();
        if (cursor.getCount()>0){
            //we are receving data

            while (cursor.moveToNext()){
                stringBuffer.append(cursor.getString(0)).append(" , ");
                stringBuffer.append(cursor.getString(1)).append(" , ");
                stringBuffer.append(cursor.getString(2)).append(" , ");
                stringBuffer.append(cursor.getString(3)).append(" \n\n ");

            }
            textView.setText(stringBuffer);
        }
        else {

            textView.setText("No Data Found");
        }*/
        Intent intent = new Intent(this,List_Activity.class);
        startActivity(intent);

    }
}
