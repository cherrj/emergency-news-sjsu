package com.example.xi.news_recommendation_feature;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView mCondtionTextView;
    Button mButtonSunny;
    Button mButtonFoggy;

    DatabaseReference mRootRef= FirebaseDatabase.getInstance().getReference();
    DatabaseReference mconditionRef=mRootRef.child("condition");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCondtionTextView=(TextView) findViewById(R.id.condition);
        mButtonFoggy=(Button) findViewById(R.id.foggy);
        mButtonSunny=(Button) findViewById(R.id.sunny);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mconditionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mCondtionTextView.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
