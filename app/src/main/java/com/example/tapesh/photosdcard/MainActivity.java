package com.example.tapesh.photosdcard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String  mExternalDirectory;
    Bitmap	bitmapToDiaplay=null;
    ProgressBar progressBar;
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar=(ProgressBar)findViewById(R.id.progressBar);

        imageView=(ImageView)findViewById(R.id.imageView);
        button=(Button)findViewById(R.id.button);


        File Foldername=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File filePicture=new File(Foldername,"image2.png");



        if(filePicture.exists())
        {
            	bitmapToDiaplay=BitmapFactory.decodeFile(filePicture.toString());



        }

        imageView.setImageBitmap(bitmapToDiaplay);
        button.setOnClickListener(this);


    }



@Override
  public void onClick(View view)
{

    // code to create folder in the internal storage of phone.....

    String root = Environment.getExternalStorageDirectory().toString();
    File myDir = new File(root + "/saved_images");
    myDir.mkdirs();

    String fname = "image1.png";
    File file = new File (myDir, fname);
    if (file.exists ()) file.delete ();
    try {
        FileOutputStream out = new FileOutputStream(file);
        bitmapToDiaplay.compress(Bitmap.CompressFormat.JPEG, 90, out);
        out.flush();
        out.close();

    } catch (Exception e) {
        e.printStackTrace();
    }







}
}
