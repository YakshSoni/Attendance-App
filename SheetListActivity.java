package com.example.attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;

public class SheetListActivity extends AppCompatActivity {

    private ListView sheetList;
    private ArrayAdapter adapter;
    private ArrayList<String> listItems= new ArrayList();
    private long cid;
    private Toolbar toolbar;
    private TextView subtitle;
    private String className = "Attendance Sheets";
    Calendar calendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sheet_list);
        setToolbar();
        cid = getIntent().getIntExtra("cid",-1);
        loadListItems();
        sheetList =findViewById(R.id.sheetList);
        adapter = new ArrayAdapter(this,R.layout.sheet_list,R.id.date_list_item,listItems);
        sheetList.setAdapter(adapter);

        sheetList.setOnItemClickListener((parent, view, position, id) -> openSheetActivity(position));
    }

    private void openSheetActivity(int position) {
        long[] idArray = getIntent().getLongArrayExtra("idArray");
        int[] rollArray = getIntent().getIntArrayExtra("rollArray");
        String[] nameArray = getIntent().getStringArrayExtra("nameArray");
        Intent intent = new Intent(this,SheetActivity.class);
        intent.putExtra("idArray",idArray);
        intent.putExtra("rollArray",rollArray);
        intent.putExtra("nameArray",nameArray);
        intent.putExtra("month",listItems.get(position));

        startActivity(intent);
    }

    private void loadListItems() {
        Cursor cursor = new DBHelper(this).getDistinctMonths(cid);
        while (cursor.moveToNext())
        {
            String date = cursor.getString(cursor.getColumnIndex(DBHelper.DATE_KEY));
            listItems.add(date.substring(3));
        }
    }
    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);

        TextView title = toolbar.findViewById(R.id.title_toolbar);
        subtitle = toolbar.findViewById(R.id.subtitle_toolbar);
        ImageButton back = toolbar.findViewById(R.id.back);
        ImageButton save =toolbar.findViewById(R.id.save);
        save.setOnClickListener(v->saveStatus());
        title.setText(className);
        subtitle.setText("Current :"+DateFormat.format("MM.yyyy",calendar).toString());

        back.setOnClickListener(v->onBackPressed());

    }

    private void saveStatus() {
        Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
    }
}