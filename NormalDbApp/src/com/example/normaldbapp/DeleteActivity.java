package com.example.normaldbapp;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends Activity {
	EditText et1;
	String uid;
	Button btn1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		et1=(EditText) findViewById(R.id.editText1);
        
		btn1=(Button) findViewById(R.id.button1);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				uid=et1.getText().toString();
				SQLiteDatabase mydatabase= openOrCreateDatabase("mydb.dat",MODE_PRIVATE,null);
				mydatabase.execSQL("DELETE FROM MyTable where Username='"+uid+"';");
				Toast.makeText(getApplicationContext(), "deleted Successfully", Toast.LENGTH_LONG).show();
				
			}
			
		}) ;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete, menu);
		return true;
	}

}
