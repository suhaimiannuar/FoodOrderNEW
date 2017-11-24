package com.example.suhaimi.foodorder;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class AddFood extends AppCompatActivity {

    private ImageButton foodImage;
    private static final int GALLREQ = 100;
    private EditText name, desc, price;
    private Uri uri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        name = (EditText) findViewById(R.id.foodName);
        desc = (EditText) findViewById(R.id.foodDesc);
        price = (EditText) findViewById(R.id.foodPrice);


    // + Gallery content 1
    public void imageButtonClicked(View view){
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("Image/*");
        startActivityForResult(galleryIntent,GALLREQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLREQ && resultCode == RESULT_OK){
            uri = data.getData();
            foodImage = (ImageButton) findViewById(R.id.imageFood);
            foodImage.setImageURI(uri);
        }
    }
    // - Gallery content 1

}
