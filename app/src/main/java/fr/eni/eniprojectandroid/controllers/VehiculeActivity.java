package fr.eni.eniprojectandroid.controllers;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import fr.eni.eniprojectandroid.R;

public class VehiculeActivity extends AppCompatActivity {


    private ImageView imgVehicule;
    private Button boutonPhoto;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private EditText editModele;
    private EditText editPrix;
    private EditText editMarque;
    private EditText editPlaque;
    private Switch switchLoue;
    private Button boutonSave;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule);

        imgVehicule = (ImageView) findViewById(R.id.imgVehicule);


        boutonPhoto = (Button) findViewById(R.id.boutonPhoto);
        boutonPhoto.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {



                Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                if (checkSelfPermission(Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA},
                            MY_CAMERA_REQUEST_CODE);

                }

                startActivityForResult(intent, 0);

            }

        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bit= (Bitmap) data.getExtras().get("data");
        Drawable d = new BitmapDrawable(getResources(), bit);
        imgVehicule.setBackground(d);
    }

    @Override

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_CAMERA_REQUEST_CODE) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();


            } else {

                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();

            }

        }
    }

  //  editModele = (EditText) findViewById(R.id.editModele);
  //  editPrix = (EditText) findViewById(R.id.editPrix);
  //  editMarque = (EditText) findViewById(R.id.editMarque);
  //  editPlaque = (EditText) findViewById(R.id.editPlaque);
  //  switchLoue = (Switch) findViewById(R.id.switchLoue);
  //  boutonSave = (Button) findViewById(R.id.boutonSave);
}
