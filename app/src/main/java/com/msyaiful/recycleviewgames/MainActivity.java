package com.msyaiful.recycleviewgames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvGames;
    private ArrayList<Game> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGames = findViewById(R.id.rv_game);
        rvGames.setHasFixedSize(true);

        list.addAll(GameData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        ListGameAdapter listHeroAdapter = new ListGameAdapter(list);
        rvGames.setAdapter(listHeroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode (int selectedMode){
        switch (selectedMode){
            case R.id.action_list:
                showRecyclerList();
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                showRecyclerCardView();
                break;
        }
    }

    private void showRecyclerGrid(){
        rvGames.setLayoutManager(new GridLayoutManager(this, 2));
        GridGameAdapter gridHeroAdapter = new GridGameAdapter(list);
        rvGames.setAdapter(gridHeroAdapter);
    }

    private void showRecyclerCardView(){
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        CardViewGameAdapter cardViewHeroAdapter = new CardViewGameAdapter(list);
        rvGames.setAdapter(cardViewHeroAdapter);
    }
}
