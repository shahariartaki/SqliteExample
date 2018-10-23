package com.example.taki.sqliteexample;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class List_Activity extends AppCompatActivity {
    private ListView listView;
    private List<student>studentList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity);
        initview();
        loaddata();
        //addListener();
    }

    /*private void addListener() {
        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {



                return false;
            }
        });
    }*/

    private void loaddata() {
        MySqlite mySqlite = new MySqlite(this);
        Cursor cursor = mySqlite.getData();
        //StringBuffer stringBuffer = new StringBuffer();
        if (cursor.getCount()>0){
            //we are receving data

            while (cursor.moveToNext()){


                 String id=cursor.getString(0);
                 String name=cursor.getString(1);
                 String dept=cursor.getString(2);
                String number=cursor.getString(3);
                student student= new student(id,name,dept,number);
                studentList.add(student);


                /*stringBuffer.append(cursor.getString(0)).append(" , ");
                stringBuffer.append(cursor.getString(1)).append(" , ");
                stringBuffer.append(cursor.getString(2)).append(" , ");
                stringBuffer.append(cursor.getString(3)).append(" \n\n ");*/

            }

            list_adapter adapter= new list_adapter(this,studentList);
            listView.setAdapter(adapter);
            //textView.setText(stringBuffer);
        }
        else {

            //textView.setText("No Data Found");
        }
    }

    private void initview() {
        listView=findViewById(R.id.lvId);
    }
}
