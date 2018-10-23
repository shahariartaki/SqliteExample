package com.example.taki.sqliteexample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class list_adapter extends BaseAdapter {

    private Context context;
    private List<student>studentList;


    public list_adapter (Context context,List<student>studentList){
        this.context=context;
        this.studentList=studentList;
    }



    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView==null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.sample_layout, null);
        }

        TextView name,dept,number;
        name=convertView.findViewById(R.id.tvName);
        dept=convertView.findViewById(R.id.tvDept);
        number=convertView.findViewById(R.id.tvNumber);
        name.setText(studentList.get(position).getName());
        dept.setText(studentList.get(position).getDept());
        number.setText(studentList.get(position).getNumber());


        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("are you want to delete?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        MySqlite mySqlite = new MySqlite(context);
                        int res=mySqlite.delete(studentList.get(position).getId());


                        if (res==-1){
                            Toast.makeText(context, "Not Deleted", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            studentList.remove(position);
                            notifyDataSetChanged();
                        }

                    }
                });
                builder.setNegativeButton("No",null);
                builder.show();
                return false;
            }
        });

        return convertView;

    }
}
