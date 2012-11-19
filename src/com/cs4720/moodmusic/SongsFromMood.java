package com.cs4720.moodmusic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import yuku.ambilwarna.AmbilWarnaDialog;
import yuku.ambilwarna.AmbilWarnaDialog.OnAmbilWarnaListener;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SongsFromMood extends Activity{
	
	private final String BASEURL = "http://plato.cs.virginia.edu/~cdt3pm/cakephp/songs/index/";
	
	ArrayAdapter<Song> adapter;
	ArrayList<Song> values;
	ListView songList;
	
	Song[] songs = {new Song("Mathematics","Mos Def", "MMD", 10011),
					new Song("What You Know", "Two Door Cinema Club", "TWCC", 20012),
					new Song("Hot Thing", "Talib Kweli", "Eardrum", 10001),
					new Song("You Only Live Once", "The Strokes", "First Impressions of Earth", 12415)};
	
	
	@Override
	  public void onCreate(Bundle savedInstanceState) {
	    	
	        super.onCreate(savedInstanceState);
	        
	        setContentView(com.cs4720.moodmusic.R.layout.activity_main);
	        
			if ((songList = (ListView) findViewById(com.cs4720.moodmusic.R.id.list_songs)) == null) {
				Log.d("ERROR", "ID is null");
			}
			
			values = new ArrayList<Song>();
			for (int i = 0; i < songs.length; i++) {
				values.add(songs[i]);
			}
			
	        int initialColor = 0xFFFFFF;
			adapter = new ArrayAdapter<Song>(this,
					android.R.layout.simple_list_item_1, android.R.id.text1, values);
	        
			songList.setAdapter(adapter);

	        AmbilWarnaDialog dialog = new AmbilWarnaDialog(this, initialColor, new OnAmbilWarnaListener() {
	            public void onOk(AmbilWarnaDialog dialog, int color) {
	                passHexColor(color);
	            }
	                        
	            public void onCancel(AmbilWarnaDialog dialog) {
	            	// Function for on cancel
	            }
	        });
	        
	        dialog.show();    

			//passHexColor(0);
			
	    }
	    
	    public void passHexColor(int color) {
	    	
	    	int blue = Color.blue(color);
	    	int red = Color.red(color);
	    	int green = Color.green(color);
	    	
	    	String webserviceArg = Integer.toHexString(red) + "_" + Integer.toHexString(green) + "_" + Integer.toHexString(blue);
	    	
	    	Log.d("hex color", BASEURL + webserviceArg + "?json");
	    	
	    	new GetSongsTask().execute(BASEURL + webserviceArg + "?json");
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
					sb.append(line);
				}
				is.close();
				result = sb.toString();
				// log.i("size", result.length() + "");
				
				result.trim();
				
				
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
		
		private class GetSongsTask extends AsyncTask<String, Integer, String> {
			
			@Override
			protected void onPreExecute() {
			}

			@Override
			protected String doInBackground(String... params) {
				
				String url = params[0];
				ArrayList<Song> lcs = new ArrayList<Song>();

				try {

					String webJSON = getJSONfromURL(url);
					Gson gson = new Gson();
					
					Log.d("Result", webJSON);

					JsonParser parser = new JsonParser();
					JsonArray Jarray = (parser.parse(webJSON)).getAsJsonArray();
					
					Log.d("debug", "debug statement");

					for (JsonElement obj : Jarray) {
						Song cse = gson.fromJson(obj, Song.class); //breakpoint
						lcs.add(cse);
					}

				} catch (Exception e) {
					Log.e("Song", "JSONPARSE:" + e.toString());
				}

				values.clear();
				values.addAll(lcs);

				return "Done!";
			}
			
			@Override
			protected void onProgressUpdate(Integer... ints) {

			}

			@Override
			protected void onPostExecute(String result) {
				// tells the adapter that the underlying data has changed and it
				// needs to update the view
				adapter.notifyDataSetChanged();
			}
		}
	  }

