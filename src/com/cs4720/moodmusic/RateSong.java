package com.cs4720.moodmusic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import yuku.ambilwarna.AmbilWarnaDialog;
import yuku.ambilwarna.AmbilWarnaDialog.OnAmbilWarnaListener;

import android.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RateSong extends Activity {

	private final String BASEURL = "http://song-color-rating.appspot.com/rate";
	
	ArrayAdapter<Song> adapter;
	ArrayList<Song> values;
	ListView songList;
	AmbilWarnaDialog dialog;
	int currentSongId;
	private Player player;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cs4720.moodmusic.R.layout.rate_song);
        
        Song[] songs = {new Song("Mathematics","Mos Def", "MMD", 10011),
						new Song("What You Know", "Two Door Cinema Club", "TWCC", 20012),
						new Song("Hot Thing", "Talib Kweli", "Eardrum", 10001),
						new Song("You Only Live Once", "The Strokes", "First Impressions of Earth", 12415)};
        
        values = new ArrayList<Song>();
		for (int i = 0; i < songs.length; i++) {
			values.add(songs[i]);
		}
        
        adapter = new ArrayAdapter<Song>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);
        
        songList = (ListView) findViewById(com.cs4720.moodmusic.R.id.listView1);
        
        songList.setOnItemClickListener(new OnItemClickListener () {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Song currSong = values.get(arg2);
				currentSongId = currSong.getID();
				
				TextView titleField = (TextView) findViewById(com.cs4720.moodmusic.R.id.songTitle);
				TextView artistField = (TextView) findViewById(com.cs4720.moodmusic.R.id.artistName);
				
				titleField.setText(currSong.getTitle());
				titleField.setText(currSong.getArtist());
				
				LinearLayout l = (LinearLayout) findViewById(com.cs4720.moodmusic.R.id.songSpace);
				l.setBackgroundColor(0xFFFFFF);
				
			}
        	
        });
            
		songList.setAdapter(adapter);

		dialog = new AmbilWarnaDialog(this, 0, new OnAmbilWarnaListener() {
            public void onOk(AmbilWarnaDialog dialog, int color) {
            	rateSong(color);
            }
                        
            public void onCancel(AmbilWarnaDialog dialog) {
            	// Function for on cancel
            }
        });
		
		Button voteButton = (Button) findViewById(com.cs4720.moodmusic.R.id.voteButton);
		
        voteButton.setOnClickListener(new View.OnClickListener() {
			
		public void onClick(View v) {
			dialog.show();
			}
		});
    }
    
    public void rateSong(int color) {
    	int blue = Color.blue(color);
    	int red = Color.red(color);
    	int green = Color.green(color);
    	
    	TextView yourVote = (TextView)findViewById(com.cs4720.moodmusic.R.id.your_vote_color);
    	yourVote.setBackgroundColor(color);
    	
    	String webserviceArg = "?color=";
    	String r, g, b;
    	r = Integer.toHexString(red);
    	if (r.length() == 1) {
    		r = "0" + r;
    	}
    	Log.d("hex color", r);
    	g = Integer.toHexString(green);
    	if (g.length() == 1) {
    		g = "0" + g;
    	}
    	b = Integer.toHexString(blue);
    	if (b.length() == 1) {
    		b = "0" + b;
    	}
		webserviceArg += r + "_" + g + "_" + b;
		webserviceArg += "&song_id=" + currentSongId;
    	
    	Log.d("hex color", BASEURL + webserviceArg);
    	
    	new RateSongTask().execute(BASEURL + webserviceArg);
    }

	public String getJSONfromURL(String url) {

		// Initialize
		InputStream is = null;
		String result = "";
		Log.d("Song", url.toString());

		// Http GET
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			is = entity.getContent();
			Log.d("Debug", "Successful Http Connection");

		} catch (Exception e) {
			Log.e("Song", "Error in http connection " + e.toString());
		}

		// Convert response to string
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			result = sb.toString(); // + "\u001a";
			
		} catch (Exception e) {
			Log.e("Song", "Error converting result " + e.toString());
		}
		
		Log.d("Result:", result);

		return result;
	}
    
    /*@Override 
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_list_item, menu);
        return true;
    }
    */
	
	private class RateSongTask extends AsyncTask<String, Integer, Rating> {
		
		@Override
		protected void onPreExecute() {
		}

		@Override
		protected Rating doInBackground(String... params) {
			
			String url = params[0];
			Rating avg = null;

			try {

				String webJSON = getJSONfromURL(url);
				Gson gson = new Gson();
				
				Log.d("Result", webJSON);

				JsonParser parser = new JsonParser();
				JsonObject obj = (parser.parse(webJSON)).getAsJsonObject();
				
				avg = gson.fromJson(obj, Rating.class);
				
			} catch (Exception e) {
				Log.e("Song", "JSONPARSE:" + e.toString());
				return null;
			}

			return avg;
		}
		
		@Override
		protected void onProgressUpdate(Integer... ints) {

		}

		@Override
		protected void onPostExecute(Rating avg) {
			// Here we need to make a rest call to the song db
			if (avg == null) {
				return;
			}
			int color = Color.argb(255, avg.getRed(), avg.getGreen(), avg.getBlue());
			LinearLayout l = (LinearLayout) findViewById(com.cs4720.moodmusic.R.id.songSpace);
			l.setBackgroundColor(color);
		}
	}

}
