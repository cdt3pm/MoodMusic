package com.cs4720.moodmusic;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        setContentView(com.cs4720.moodmusic.R.layout.start_main);
        
        Button createMoodButton = (Button) findViewById(com.cs4720.moodmusic.R.id.createButton); // rating a song
        Button findMoodButton = (Button) findViewById(com.cs4720.moodmusic.R.id.findButton); // finding set of songs for color

        createMoodButton.setOnClickListener(new View.OnClickListener() {
			
		public void onClick(View v) {

				Intent createMoodIntent = new Intent(Main.this, SongsFromMood.class);
				startActivity(createMoodIntent);
			}
		});
        
        findMoodButton.setOnClickListener(new View.OnClickListener() {
			
		public void onClick(View v) {
				
				Intent createMoodIntent = new Intent(Main.this, RateSong.class);
				startActivity(createMoodIntent);
			}
		});
        
    }

}
