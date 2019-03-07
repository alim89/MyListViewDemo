package com.example.a20140550.mylistviewdemo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String[] country_name;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listviewID);


        final String[] CountryName=getResources().getStringArray(R.array.country_name);

        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.txtID,CountryName);
        listView.setAdapter(adapter);


        searchView= (SearchView) findViewById(R.id.SearchViewID);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
       public void onItemClick(AdapterView<?> parent, View view, int position, long id)

          {
           String value=CountryName[position];
           Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
   }
   });



    }
}
