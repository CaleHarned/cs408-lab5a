package edu.jsu.mcis.cs408.cs408lab5a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView output;
    private EditText memoAdd;
    private EditText memoDelete;
    private Button buttonMemoAdd;
    private Button buttonMemoDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.output);
        memoAdd = (EditText) findViewById(R.id.textMemoAdd);
        memoDelete = (EditText) findViewById(R.id.textMemoDelete);
        buttonMemoAdd = (Button) findViewById(R.id.buttonMemoAdd);
        buttonMemoDelete = (Button) findViewById(R.id.buttonMemoDelete);

        DatabaseHandler db = new DatabaseHandler(this,null,null,1);
        output.setText(db.getAllMemos());


    }

    public void addMemo(View v){
        DatabaseHandler db = new DatabaseHandler(this,null,null,1);
        String memo = memoAdd.getText().toString();
        db.addMemo(memo);

        output.setText(db.getAllMemos());

    }
    public void deleteMemo(View v){
        DatabaseHandler db = new DatabaseHandler(this,null,null,1);
        int memoNum = Integer.parseInt(memoDelete.getText().toString());
        db.deleteMemo(memoNum);

        output.setText(db.getAllMemos());
    }

}