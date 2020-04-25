package com.example.s_to_t;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView displaytext;
    Button speakbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displaytext=findViewById(R.id.text_id);
        speakbutton=findViewById(R.id.speak_id);
        speakbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,"en-Us");
                startActivityForResult(intent,111);
            }
        });
    }
    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==111&& resultCode== Activity.RESULT_OK&& data!=null)
        {
            ArrayList<String> textList=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String text=textList.get(0);
            displaytext.setText(text);
        }

    }
}
