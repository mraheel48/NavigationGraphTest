package com.example.navigationgraphtest;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    NavController controller;
    DrawerLayout drawerLayout;
    NavigationView nav_ViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        nav_ViewMain = findViewById(R.id.nav_ViewMain);

        controller = Navigation.findNavController(this, R.id.nav_host_fargment);

         //**************************Clicking the menu item  Nav_view on*****************************//
        nav_ViewMain.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    if (Objects.equals(Objects.requireNonNull(controller.getCurrentDestination()).getLabel(), "first")) {

                        Toast.makeText(MainActivity.this, "Your are already Home Fragment", Toast.LENGTH_SHORT).show();

                    } else {

                        controller.navigate(R.id.firstFragment);
                    }

                    //This Method close the Drawer windows
                    closeDrawer();

                    break;

                case R.id.creator:

                    if (Objects.equals(Objects.requireNonNull(controller.getCurrentDestination()).getLabel(), "second")) {

                        Toast.makeText(MainActivity.this, "Your are already Creator Fragment", Toast.LENGTH_SHORT).show();

                    } else {

                        controller.navigate(R.id.secondFragment);
                    }

                    //This Method close the Drawer windows
                    closeDrawer();
                    break;

                case R.id.message:

                    if (Objects.equals(Objects.requireNonNull(controller.getCurrentDestination()).getLabel(), "third")) {

                        Toast.makeText(MainActivity.this, "Your are already Message Fragment", Toast.LENGTH_SHORT).show();

                    } else {

                        controller.navigate(R.id.thirdFragment);
                    }

                    //This Method close the Drawer windows
                    closeDrawer();
                    break;

                case R.id.exit:
                    finish();
                    break;

                default:
                    Toast.makeText(MainActivity.this, "Clicking Other Menu", Toast.LENGTH_SHORT).show();
                     //This Method close the Drawer windows
                     closeDrawer();

            }

            return false;
        });


    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);

        } else {


            if (Objects.equals(Objects.requireNonNull(controller.getCurrentDestination()).getLabel(), "first")) {

                Toast.makeText(this, "calling home", Toast.LENGTH_SHORT).show();

            } else {

                controller.navigateUp();
            }

        }

    }

    public void openDrawer() {

        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void closeDrawer() {

        drawerLayout.closeDrawer(GravityCompat.START);
    }


}
