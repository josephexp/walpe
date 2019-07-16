package com.example.walpe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fresco.initialize(this);

        List<WalpeImageData> data = fill_with_data();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        WalpeRecyclerViewAdapter adapter = new WalpeRecyclerViewAdapter(data, getApplication());
        recyclerView.setAdapter(adapter);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 4);
        recyclerView.setLayoutManager(layoutManager);

    }

    public List<WalpeImageData> fill_with_data() {

        List<WalpeImageData> data = new ArrayList<>();

        data.add(new WalpeImageData("Batman vs Superman", "Following the destruction of Metropolis, Batman embarks on a personal vendetta against Superman ", "https://source.unsplash.com/user/a"));
        data.add(new WalpeImageData("X-Men: Apocalypse", "X-Men: Apocalypse is an upcoming American superhero film based on the X-Men characters that appear in Marvel Comics ", "https://source.unsplash.com/collection/190727/"));
        data.add(new WalpeImageData("Captain America: Civil War", "A feud between Captain America and Iron Man leaves the Avengers in turmoil.  ", "https://source.unsplash.com/collection/190728/"));
        data.add(new WalpeImageData("Kung Fu Panda 3", "After reuniting with his long-lost father, Po  must train a village of pandas", "https://source.unsplash.com/collection/190726/"));
        data.add(new WalpeImageData("Warcraft", "Fleeing their dying home to colonize another, fearsome orc warriors invade the peaceful realm of Azeroth. ", "https://source.unsplash.com/collection/190725/"));
        data.add(new WalpeImageData("Alice in Wonderland", "Alice in Wonderland: Through the Looking Glass ", "https://source.unsplash.com/collection/190002/"));

        return data;
    }
}
