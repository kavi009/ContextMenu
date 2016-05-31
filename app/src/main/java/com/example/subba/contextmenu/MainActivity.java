package com.example.subba.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<SearchResults> searchResults = GetSearchResults();

        final ListView lv1 = (ListView) findViewById(R.id.listView1);
        lv1.setAdapter(new MyCustomBaseAdapter(this, searchResults));
        // Register the ListView  for Context menu
        registerForContextMenu(lv1);
    }
    private ArrayList<SearchResults> GetSearchResults(){
        ArrayList<SearchResults> results = new ArrayList<SearchResults>();

        SearchResults sr1 = new SearchResults();
        sr1.setName("John");
        sr1.setPhone("214-555-1234");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("James");
        sr1.setPhone("469-555-2587");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Steve");
        sr1.setPhone("305-555-7895");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Shyam");
        sr1.setPhone("612-555-1234");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Sita");
        sr1.setPhone("612-555-5678");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("krishna");
        sr1.setPhone("612-555-8765");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Ram");
        sr1.setPhone("123-555-4567");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Sam");
        sr1.setPhone("998-072-1234");
        results.add(sr1);

        return results;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
        menu.add(0, v.getId(), 0, "SMS");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
}
