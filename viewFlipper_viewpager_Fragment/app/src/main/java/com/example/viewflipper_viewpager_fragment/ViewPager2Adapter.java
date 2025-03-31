package com.example.viewflipper_viewpager_fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2Adapter extends FragmentStateAdapter {

    public ViewPager2Adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new NewOrderFragment();  // Tab 1: New Order
//            case 1:
//                return new PickupFragment();    // Tab 2: Pickup
//            case 2:
//                return new DeliveryFragment();  // Tab 3: Delivery
//            case 3:
//                return new RatingFragment();    // Tab 4: Rating
//            case 4:
//                return new CancelFragment();    // Tab 5: Cancel
            default:
                return new NewOrderFragment();  // Default tab
        }
    }

    @Override
    public int getItemCount() {
        return 5;  // Total number of tabs
    }
}
