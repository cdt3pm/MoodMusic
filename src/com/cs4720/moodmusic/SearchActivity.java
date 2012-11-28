package com.cs4720.moodmusic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import spotify.model.Results;
import spotify.model.SearchQuery;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends Activity {
	private final static String BASE_URL = "http://ws.spotify.com/search/track?q=";
	private static List<Results> results;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}
	
	private void init() {
		Button searchButton = (Button) findViewById(R.id.search_button);
		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText textField = (EditText) findViewById(R.id.search_field);
				String query = textField.getText().toString();
				new SearchQueryTask().execute(BASE_URL + query);
				
			}
			
		});
		
	}
	
	public String getResults(String url) {
		InputStream is = null;
		String result = null;
		
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
		
		return result;
	}
	
	private class SearchQueryTask extends AsyncTask<String, Integer, String> {
		@Override
		protected void onPreExecute() {
		}

		@Override
		protected String doInBackground(String... params) {
			String url = params[0];

			try {

				String webJSON = getResults(url);
				Gson gson = new Gson();

				JsonParser parser = new JsonParser();
				JsonObject obj = (parser.parse(webJSON)).getAsJsonObject();
				
				SearchQuery q = gson.fromJson(obj, SearchQuery.class);
				results = q.getTracks();
			} catch (Exception e) {
				Log.e("Song", "JSONPARSE:" + e.toString());
			}

			return "Done!";
		}
		
	}
}
