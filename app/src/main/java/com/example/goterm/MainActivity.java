package com.example.goterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText editText;
    private Button button;
    private String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);


        editText.setHint("Enter the command");
        textView.setText("Welcome to Goterm\n");
        textView.append("Type \'help\' for help");


        button.setOnClickListener(this);
    }
    private void inputfun(String s){
        if(s.equals("help")){
            textView.append("\n\n$ help" +
                    "\nList of Commands:" +
                    "\n1.help  - Show this menu" +
                    "\n2.info  - Show Information" +
                    "\n3.clear - Clear the screen");
        }
        else if(s.equals("info")){
            textView.append("\n\n$ info"+
                    "\nInformation Not Uploaded");
        }
        else if(s.equals("clear")){
            textView.setText("");
        }
        else{
            textView.append("\n\nInvalid command : $ " + s);
        }
    }

    @Override
    public void onClick(View v) {

        try{
            str = editText.getText().toString();
            inputfun(str);
            editText.setText("");
        }
        catch (Exception e){

        }


    }
}
