package com.example.goterm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private EditText editText;
    private Button button;
    private String str;
    private Commands commands;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        commands = new Commands();


        editText.setHint("Enter the command");
        textView.setText("Welcome to Goterm\n");
        textView.append("Type \'help\' for help");


        button.setOnClickListener(this);
    }
    private void input_fun_no_arg(String s){
        switch (s) {
            case "help" : {
                commands.help();
                break;
            }
            case "info" : {
                commands.info();
                break;
            }
            case "clear" : {
                commands.clear();
                break;
            }
            case "" : {
                commands.emptyinput();
                break;
            }
            case "settheme" : {
                commands.settheme_arg_error();
                break;
            }
            case  "exit" :{
                commands.exit_app();
                break;
            }
            default : {
                commands.invalid(s);
                break;
            }
        }
    }
    private void input_fun_with_arg(String s){
        String[] str = s.split("\\s");
        if ("settheme".equals(str[0])) {
            commands.settheme(str[1]);
        }
        else {
            commands.invalid(s);
        }
    }
    private void take_input_from_user(){
        try{
            str = editText.getText().toString();
            {
                int arg_count = -1;
                String[] st =  str.split("\\s");
                for (String s : st){
                    arg_count += 1;
                }
                if (arg_count == 0){
                    input_fun_no_arg(str);
                }
                else {
                    input_fun_with_arg(str);
                }
            }
            editText.setText("");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        take_input_from_user();
    }
    private class Commands {
        private void help(){
            textView.append("\n\n$ help" +
                    "\nList of Commands:" +
                    "\n* help  - Show this menu" +
                    "\n* info  - Show Information" +
                    "\n* clear - Clear the screen" +
                    "\n* settheme - Set the theme of the app" +
                    "\n     blue    - Blue theme" +
                    "\n     gray    - Gray theme" +
                    "\n     default - Green theme" +
                    "\n* exit  -Exit the app");
        }
        private void info(){
            textView.append("\n\n$ info" +
                    "\nGoterm - Terminal Emulator" +
                    "\n     Version : V1.01" +
                    "\n     Version Build Date : 11-05-2020" +
                    "\n     Developer : https://github.com/charan-kumar-137" +
                    "\n     App Source-code : https://github.com/charan-kumar-137/GoTerm");
        }
        private void clear(){
            textView.setText("");
        }
        private void invalid(String s){
            textView.append("\n\nInvalid command : $ " + s);
        }
        private void emptyinput(){
            textView.append("\n\nNo Input ");
        }
        private void settheme(String s){
            switch (s){
                case "blue" : {
                    textView.setTextColor(Color.BLUE);
                    textView.setBackgroundColor(Color.GRAY);
                    editText.setTextColor(Color.BLUE);
                    editText.setBackgroundColor(Color.GRAY);
                    button.setTextColor(Color.BLUE);
                    button.setBackgroundColor(Color.GRAY);

                    textView.append("\n\nTheme Changed");
                    break;
                }
                case "gray" : {
                    textView.setTextColor(Color.BLACK);
                    textView.setBackgroundColor(Color.GRAY);
                    editText.setTextColor(Color.BLACK);
                    editText.setBackgroundColor(Color.GRAY);
                    button.setTextColor(Color.BLACK);
                    button.setBackgroundColor(Color.GRAY);

                    textView.append("\n\nTheme Changed");
                    break;
                }
                default : {
                    textView.setTextColor(Color.GREEN);
                    textView.setBackgroundColor(Color.BLACK);
                    editText.setTextColor(Color.GREEN);
                    editText.setBackgroundColor(Color.BLACK);
                    button.setTextColor(Color.GREEN);
                    button.setBackgroundColor(Color.BLACK);

                    textView.append("\n\nTheme Changed");
                    break;
                }
            }

        }
        private void settheme_arg_error(){
            textView.append("\n\nError : settheme needs arguments");
        }
        private void exit_app(){
            System.exit(1);
        }

    }
}
