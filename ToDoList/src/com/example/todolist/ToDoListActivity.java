package com.example.todolist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoListActivity extends Activity {

	String EditText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_to_do_list);
		ListView myListView = (ListView) findViewById(R.id.myListView);
		final EditText myEditText = (EditText) findViewById(R.id.myEditText);

		// Create the Array List of to do Items
		final ArrayList<String> todoItems = new ArrayList<String>();

		// Create Array Adapter to bind the array
		final ArrayAdapter<String> aa = new ArrayAdapter(this,
				android.R.layout.simple_list_item_1, todoItems);
		
		myListView.setAdapter(aa);
		
		myEditText.setOnKeyListener(new View.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(event.getAction() == KeyEvent.ACTION_DOWN){
					if((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) 
							|| (keyCode == KeyEvent.KEYCODE_ENTER)){
						todoItems.add(0, myEditText.getText().toString());
						aa.notifyDataSetChanged();
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_to_do_list, menu);
        return true;
    }
    
}
