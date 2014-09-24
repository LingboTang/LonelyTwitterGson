package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ca.ualberta.cs.lonelytwitter.data.GsonFileDataManager;
import ca.ualberta.cs.lonelytwitter.data.IDataManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SummaryActivity extends Activity {
	
	private IDataManager dataManager;

	private EditText bodyText;

	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets;

	private ArrayAdapter<Tweet> tweetsViewAdapter;
	
	private Gson gson;
	private static final String FILENAME = "gsonfilecool.sav";
	
	private int num_lines;
	
	private int num_chars;
	
	private int Average_length;
	
	private int Average_latency;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		Intent intent = getIntent();
		dataManager = new GsonFileDataManager(this);
		
	}

	public int LineCounter(GsonFileDataManager dataManager) {
		
		BufferedReader fis = new BufferedReader(new InputStreamReader(Gson.openFileInput(FILENAME)));
		String line;
		StringBuffer fileContent = new StringBuffer();
		while ((line = fis.readLine()) != null){
			num_lines++;
		}
		return num_lines;
	}
	
	public int Average_Length(GsonFileDataManager dataManager) {
		BufferedReader fis = new BufferedReader(new InputStreamReader(Gson.openFileInput(FILENAME)));
		String line;
		StringBuffer fileContent = new StringBuffer();
		while ((line = fis.readLine()) != null){
			char character;
			while((character = line.getchar()) != '\n') {
				num_chars++;
			}
			
		}
		Average_length = num_chars/num_lines;
	}
	
	
	public int Average_Latency(GsonFileDataManager dataManager) {
		
		
		return Average_latency;
	}

}
