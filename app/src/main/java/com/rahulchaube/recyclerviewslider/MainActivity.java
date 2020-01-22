package com.rahulchaube.recyclerviewslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements SliderAdapter.SliderListner {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SliderAdapter sliderAdapter;

    SpeedyLinearLayoutManager speedyLinearLayoutManager;
    int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        sliderAdapter = new SliderAdapter(this, this);
        speedyLinearLayoutManager=new SpeedyLinearLayoutManager(this,SpeedyLinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(speedyLinearLayoutManager);
        recyclerView.setAdapter(sliderAdapter);
        recyclerView.setHasFixedSize(true);
        speedyLinearLayoutManager.findLastCompletelyVisibleItemPosition();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Log.e("Visible position "," "+speedyLinearLayoutManager.findLastCompletelyVisibleItemPosition());

                Log.e("Before slide position ",currentPosition+"  position "+currentPosition % 10);
                if (speedyLinearLayoutManager.findLastCompletelyVisibleItemPosition()+1!=currentPosition)
                    currentPosition=speedyLinearLayoutManager.findLastCompletelyVisibleItemPosition()+1;
                recyclerView.smoothScrollToPosition(currentPosition % 10);
                if (currentPosition % 10==0)
                    currentPosition=0;
                currentPosition++;

            }
        }, 0, 4000);
    }

    @Override
    public void currentPage(int position) {
        currentPosition = position;
        Log.e("Position Change ", " " + position);
    }
}
