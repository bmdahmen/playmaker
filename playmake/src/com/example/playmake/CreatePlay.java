package com.example.playmake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreatePlay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_play);
    
        Button offense = (Button) findViewById(R.id.Offense);
        Button defense = (Button) findViewById(R.id.Defense);
        offense.setOnClickListener(new View.OnClickListener() {
        	@Override
			public void onClick(View v) {
        		Intent myIntent = new Intent(v.getContext(), Offense.class);
	            startActivityForResult(myIntent, 0);
			}
		});
        
        defense.setOnClickListener(new View.OnClickListener() {
        	@Override
			public void onClick(View v) {
        		Intent myIntent = new Intent(v.getContext(), Defense.class);
	            startActivityForResult(myIntent, 0);
			}
		});
        
	}
	
}
