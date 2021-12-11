package cat.dam.roger.permisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    // Constant única de tipus int definida pel programador
    private static final int  MY_PERMISSIONS_REQUEST_CAMERA = 1,  MY_PERMISSIONS_REQUEST_STORAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declarem els valors
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRequestPermissionsCameraResult();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRequestPermissionsStorageResult();
            }
        });
    }

    public void onRequestPermissionsCameraResult() {
        int Permisos = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
        if (Permisos == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "Permis de camara donat", Toast.LENGTH_SHORT).show();

        } else {

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA);
            Toast.makeText(MainActivity.this, "Permis de camara denegat", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRequestPermissionsStorageResult() {
        int Permisos = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (Permisos == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(MainActivity.this, "Permis de storage donat", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_STORAGE);
            Toast.makeText(MainActivity.this, "Permis de storage denegat", Toast.LENGTH_SHORT).show();
        }
    }


}