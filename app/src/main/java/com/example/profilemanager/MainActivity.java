package com.example.profilemanager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void OnOpenInGoogleMaps(View view){
        EditText teamAddress = (EditText)  findViewById(R.id.personEntersPostalCode);
        // Create a Uri from a string . Use result  to create an intent
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+ teamAddress.getText());
        Intent mapIntent = new Intent (Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){
                @SuppressLint("NonConstantResourceId")
                @Override

                public void onActivityResult(ActivityResult result){
                    if (result.getResultCode() == Activity.RESULT_OK){

                        Intent data = result.getData();

                        ImageView avatarImage = (ImageView) findViewById(R.id.avatarImage);

                        String drawableName = "flag3";

                        switch (data.getIntExtra("imageID",R.id.avatarImage)){

                            case R.id.flag1:
                                drawableName = "flag1";
                                break;
                            case R.id.flag2:
                                drawableName = "flag2";
                                break;
                            case R.id.flag3:
                                drawableName = "flag3";
                                break;
                            case R.id.flag4:
                                drawableName = "flag4";
                                break;
                            case R.id.flag5:
                                drawableName = "flag5";
                                break;
                            case R.id.flag6:
                                drawableName = "flag6";
                                break;
                            case R.id.flag7:
                                drawableName = "flag7";
                                break;
                            case R.id.flag8:
                                drawableName = "flag8";
                                break;
                            case R.id.flag9:
                                drawableName = "flag9";
                                break;
                            default:
                                drawableName = "flag2";
                                break;

                        }
                        int resID = getResources().getIdentifier(drawableName, "drawable",getPackageName());
                        avatarImage.setImageResource(resID);
                    }
                }
            });
    public void OnSetAvatarButton(View view){

        Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);

    }

}