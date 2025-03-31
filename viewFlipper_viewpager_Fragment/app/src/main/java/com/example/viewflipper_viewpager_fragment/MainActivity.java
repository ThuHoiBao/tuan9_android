package com.example.viewflipper_viewpager_fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAction;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);
        fabAction = findViewById(R.id.fabAction);

        // Set up ViewPager2 with adapter
        ViewPager2Adapter adapter = new ViewPager2Adapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        // Set up TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("New Order");
                    break;
                case 1:
                    tab.setText("Pickup");
                    break;
                case 2:
                    tab.setText("Delivery");
                    break;
                case 3:
                    tab.setText("Rating");
                    break;
                case 4:
                    tab.setText("Cancel");
                    break;
            }
        }).attach();

        // FloatingActionButton listener
        fabAction.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "FAB Clicked!", Toast.LENGTH_SHORT).show();
        });
    }
}
