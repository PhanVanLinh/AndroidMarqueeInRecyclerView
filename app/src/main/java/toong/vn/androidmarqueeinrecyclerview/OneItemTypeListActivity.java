package toong.vn.androidmarqueeinrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;

public class OneItemTypeListActivity extends AppCompatActivity implements OneItemTypeAdapter.ItemClickListener {
    private RecyclerView mRecyclerView;
    private OneItemTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("One Item Type Recycler List");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        ArrayList<Item> data = new ArrayList<>();
        for (int i = 0; i< 90; i++) {
            data.add(new Item("y This is very long text text text text text text text text", "b"));
        }
        // set up the RecyclerView
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new OneItemTypeAdapter(this, data.toArray(new Item[data.size()]));
        adapter.setItemClickListener(this);
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}