package com.example.recyclerviewemail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Email> emailList;
    private EmailAdapter emailAdapter;

    String[] senders = {"Sam", "Facebook", "Google+", "Twitter", "Pinterest Weekly", "Josh"};

    String[] subjects = {"Weekend Adventure", "James,you have 1 new notification", "Top suggested Google+ pages for you", "Follow T-Mobile, Samsung Mobile U", "Pins you'll love!", "Going lunch"};

    String[] contents = {"Let's go fishing with John and others. We will do fun things there", "A lot has happened on Facebook since", "Top suggested Google+ pages for you","James, some people you may know", "Have you seen these Pins yet? Pinterest", "Don't forget our lunch at 3PM in pizza hut"};

    String[] times = {"10:42am", "16:04pm", "18:44pm", "20:04pm", "09:04am", "01:04am"};

//    int[] imgFav = {R.drawable.ic_star_black_24dp};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);

        if (mRecyclerView != null){
            mRecyclerView.setHasFixedSize(true);
        }

        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);

        emailList = new ArrayList<>();

        for (int i = 0; i < senders.length; i++){
            Email email = new Email(senders[i], subjects[i], contents[i], times[i]);
            emailList.add(email);
        }

        emailAdapter = new EmailAdapter(this, emailList);

        mRecyclerView.setAdapter(emailAdapter);
        emailAdapter.notifyDataSetChanged();

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));


    }
}
