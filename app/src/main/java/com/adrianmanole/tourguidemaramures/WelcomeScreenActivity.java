package com.adrianmanole.tourguidemaramures;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceStace) {
        super.onCreate(savedInstanceStace);

        // Set the content of the activity to use the welcome_activity.xml layout file
        setContentView(R.layout.welcome_activity);

        // Find the View that shows the image from the Welcome Screen of the application
        ImageView imageWelcomeScreen = (ImageView) findViewById(R.id.image_welcome_screen);

        // Set on click listener on the View
        imageWelcomeScreen.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the View is clicked on.
            @Override
            // Create a new intent to open the MainActivity
            public void onClick(View view) {
                // Start the MainActivity
                Intent imageWelcomeScreenIntent = new Intent(WelcomeScreenActivity.this, MainActivity.class);
                startActivity(imageWelcomeScreenIntent);
            }
        });
    }
}