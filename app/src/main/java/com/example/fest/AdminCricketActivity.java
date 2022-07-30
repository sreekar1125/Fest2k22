package com.example.fest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ServiceManager;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AdminCricketActivity extends AppCompatActivity {

    private String matchName;
    private EditText matchNameEt;
    private FirebaseFirestore db;
    private Button addMatchBtn;
    private Spinner team1, team2;
    private ArrayAdapter<String> team1Ada, team2Ada;
    private ValueEventListener team1L, team2L;
    private ArrayList<String> team1List, team2List;

    private DocumentReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Fest);
        setContentView(R.layout.activity_admin_cricket);

        matchNameEt = (EditText) findViewById(R.id.matchName);
        addMatchBtn = (Button) findViewById(R.id.addMatch);
        team1 = (Spinner) findViewById(R.id.team1);
        team2 = (Spinner) findViewById(R.id.team2);


        db = FirebaseFirestore.getInstance();
        ref = db.collection("cricket").document("cse");

        team1List = new ArrayList<String>();
        team1Ada = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, team1List);
        team1.setAdapter(team1Ada);
        team1List.add("Select Team 1");

        team2List = new ArrayList<String>();
        team2Ada = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, team2List);
        team2.setAdapter(team2Ada);
        team2List.add("Select Team 2");

        fetchTeam1();

        addMatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addMatch();
            }
        });

    }

    public void fetchTeam1() {
        ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        Toast.makeText(AdminCricketActivity.this, "DocumentSnapshot data: " + document.getData(), Toast.LENGTH_LONG).show();
                        team1List.add(document.getData().toString());
                    }else{
                        Toast.makeText(AdminCricketActivity.this, "No doc", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(AdminCricketActivity.this, "get Failed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void addMatch() {
        matchName = matchNameEt.getText().toString();
    }
}