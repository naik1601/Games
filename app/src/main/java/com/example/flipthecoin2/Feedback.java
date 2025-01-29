package com.example.flipthecoin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final EditText edit1=(EditText)findViewById(R.id.edit1);
        final EditText edit2=(EditText)findViewById(R.id.edit2);
        Button btn=(Button)findViewById(R.id.buttonsend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");

                String[]to={"naikshreyesh1601@gmail.com"};
                //sets email client. Test kar
                i.putExtra(Intent.EXTRA_EMAIL,to);
                i.putExtra(Intent.EXTRA_SUBJECT,"Flip the coin  App");
                i.putExtra(Intent.EXTRA_TEXT,"Name:"+edit1.getText()+"\n Message:"+edit2.getText());
                try{
                    startActivity(Intent.createChooser(i,"please select email"));
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(Feedback.this,"There are no email clients",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
