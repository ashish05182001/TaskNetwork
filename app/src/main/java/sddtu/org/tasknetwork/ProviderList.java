package sddtu.org.tasknetwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Dell on 3/16/2017.
 */

public class ProviderList extends AppCompatActivity {
    int p;

    String[][] data = {
            {"Dr. Ramesh", "Indian Spinal Center"},
            {"Dr. Rahul", "VVS lorem ipsum"},
            {"Dr. KD ipsum", "Indian lorem ipsum"},
            {"Dr. Ramesh", "Indian Spinal Center"},
            {"Dr. Rahul", "VVS lorem ipsum"},
            {"Dr. KD ipsum", "Indian lorem ipsum"},
            {"Dr. Ramesh", "Indian Spinal Center"},
            {"Dr. Rahul", "VVS lorem ipsum"},
            {"Dr. KD ipsum", "Indian lorem ipsum"},
            {"Dr. Ramesh", "Indian Spinal Center"},
            {"Dr. Rahul", "VVS lorem ipsum"},
            {"Dr. KD ipsum", "Indian lorem ipsum"},
    };

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitysearchlist);

//        p = getIntent().getIntExtra("ArrayChoose", 0);
        recyclerView = (RecyclerView) findViewById(R.id.searchrecycler);
        layoutManager = new LinearLayoutManager(ProviderList.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerInnerAdapter(getDataSet());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Provider> getDataSet() {
        ArrayList results = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            Provider provider = new Provider(data[i][0], data[i][1]);
            results.add(provider);
        }
        return results;
    }
}
