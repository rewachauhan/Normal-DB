package com.example.normaldbapp;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DbActivity extends Activity {
	EditText uid,pwd,cty,mno;
	Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        uid=(EditText) findViewById(R.id.editText1);
        pwd=(EditText) findViewById(R.id.editText2);
        cty=(EditText) findViewById(R.id.editText3);
        mno=(EditText) findViewById(R.id.editText4);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String ud,pw,ct,mn;
				ud=uid.getText().toString();
				pw=pwd.getText().toString();
				ct=cty.getText().toString();
				mn=mno.getText().toString();
				SQLiteDatabase mydatabase = openOrCreateDatabase("mydb.dat",MODE_PRIVATE,null);
				mydatabase.execSQL("CREATE TABLE IF NOT EXISTS MyTable(Username VARCHAR Primary Key,Password VARCHAR,City VARCHAR,Contact VARCHAR);");
				mydatabase.execSQL("INSERT INTO MyTable VALUES('"+ud+"','"+pw+"','"+ct+"','"+mn+"');");
				Toast.makeText(getApplicationContext(),"Data Inserted Successfully" , Toast.LENGTH_LONG).show();
				String data="";
				Cursor c=mydatabase.rawQuery("SELECT * FROM MyTable", null);
				c.moveToFirst();
				while(!c.isAfterLast())
				{
					data+=c.getString(0)+"      "+c.getString(1)+"     "+c.getString(2)+"     "+c.getString(3)+"\n";
					c.moveToNext();
				}
				Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
				c.close();
			}
			
		});
         b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(DbActivity.this,DisplayActivity.class);
				
				startActivity(i);
			}
		});
         b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(DbActivity.this,UpdateActivity.class);
				
				startActivity(i);
			}
		});
         b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(DbActivity.this,DeleteActivity.class);
				
				startActivity(i);
			}
		});

    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.db, menu);
        return true;
    }
    
}
