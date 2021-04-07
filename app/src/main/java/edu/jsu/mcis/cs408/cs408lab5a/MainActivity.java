package edu.jsu.mcis.cs408.cs408lab5a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    private RecyclerView output;
    private EditText memoAdd;
    private EditText memoDelete;
    private DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (RecyclerView) findViewById(R.id.output);
        db= new DatabaseHandler(this,null,null,1);
        updateRecyclerView();






    }

    public void addMemo(View v){
        memoAdd = (EditText) findViewById(R.id.textMemoAdd);
        String memo = memoAdd.getText().toString();
        db.addMemo(memo);
        updateRecyclerView();

    }
    public void deleteMemo(View v){
        memoDelete = (EditText) findViewById(R.id.textMemoDelete);
        DatabaseHandler db = new DatabaseHandler(this,null,null,1);
        int memoNum = Integer.parseInt(memoDelete.getText().toString());
        db.deleteMemo(memoNum);
        updateRecyclerView();;
    }
    private void updateRecyclerView(){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(db.returnAllMemosList());
        output.setHasFixedSize(true);
        output.setLayoutManager(new LinearLayoutManager(this));
        output.setAdapter(adapter);

    }

}