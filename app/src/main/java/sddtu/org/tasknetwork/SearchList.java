package sddtu.org.tasknetwork;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Dell on 3/16/2017.
 */

public class SearchList extends AppCompatActivity {
    String[] data={"Doctor1","Doctor2","Doctor3","Doctor4","Doctor5","Doctor6","Doctor7","Doctor8","Doctor9"};
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysearchlist);
        recyclerView=(RecyclerView)findViewById(R.id.searchrecycler);
        layoutManager=new LinearLayoutManager(SearchList.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RecyclerAdapter(getDataSet());
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<CardData> getDataSet(){
        ArrayList results=new ArrayList<CardData>();
        for(int i=0;i<data.length;i++){
            CardData cardData=new CardData(data[i]);
            results.add(i,cardData);
        }
        return results;
    }
}
