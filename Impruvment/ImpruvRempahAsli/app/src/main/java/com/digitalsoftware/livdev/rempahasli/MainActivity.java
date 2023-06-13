package com.digitalsoftware.livdev.rempahasli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.digitalsoftware.livdev.rempahasli.R.id.menu_about;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvRempah;
    private ArrayList<Rempah> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvRempah = findViewById(R.id.rv_rempah);
        rvRempah.setHasFixedSize(true);

        list.addAll(RempahData.getListData());
        showRecycleCardView();

    }

//    private void showRecyclerList(){
//        rvRempah.setLayoutManager(new LinearLayoutManager(this));
//        ListRempahAdapter listRempahAdapter = new ListRempahAdapter(list, this);
//        rvRempah.setAdapter(listRempahAdapter);
//
//        listRempahAdapter.setOnItemClickCallback(new ListRempahAdapter.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(Rempah data) {
//                showSelectedRempah(data);
//            }
//        });
//    }

    private void showRecycleCardView(){
        rvRempah.setLayoutManager(new LinearLayoutManager(this));
        CardRempahAdapter cardRempahAdapter = new CardRempahAdapter(list, this);
        rvRempah.setAdapter(cardRempahAdapter);

        cardRempahAdapter.setOnItemClickCallback(new CardRempahAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Rempah data) {
                showSelectedRempah(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_about){
           startActivity(new Intent(this, About.class));
       }
        return true;
    }

//    private void showRecyclerCardView(){
//        rvRempah.setLayoutManager(new LinearLayoutManager(this));
//        DetailViewRempahAdapter cardViewHeroAdapter = new DetailViewRempahAdapter(list);
//        rvRempah.setAdapter(cardViewHeroAdapter);
//    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private String title = "Mode List";

    private void showSelectedRempah(Rempah rempah) {
        Toast.makeText(this, "Kamu memilih" + rempah.getName(), Toast.LENGTH_SHORT).show();
    }

}
