package com.example.assignment1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	static int random;
	int toGuess;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        random = (int) (Math.random() * (1000 - 0)) + 0;
        
        final EditText edtxt = (EditText) findViewById(R.id.editText1);
        
        Button gnrate = (Button) findViewById(R.id.button1);
        
        gnrate.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		
        		String value = edtxt.getText().toString();
        		toGuess = Integer.parseInt( value );
                generate();
                
        	}
        });
        
    }
    
    public void generate(){
    	
    	if( random-5 <= toGuess && toGuess <= random+5 )
    		print("Very Close");
    	else if( toGuess > random+5 )
    		print("Greater");
    	else if( toGuess < random-4 )
    		print("Smaller");
    	
    }
    
    public void print(String msg){
    	Toast.makeText(getBaseContext(), msg ,Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
