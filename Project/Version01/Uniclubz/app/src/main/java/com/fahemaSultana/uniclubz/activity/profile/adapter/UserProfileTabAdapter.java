package com.fahemaSultana.uniclubz.activity.profile.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.fahemaSultana.uniclubz.activity.profile.tabsFragment.PersonalInformationTabFragment;
import com.fahemaSultana.uniclubz.activity.profile.tabsFragment.PhoneNumberTabFragment;
import com.fahemaSultana.uniclubz.activity.profile.tabsFragment.UniversitiesTabFragment;

import java.util.ArrayList;
import java.util.List;

public class UserProfileTabAdapter extends FragmentStateAdapter {

    private List<Fragment> arrayList = new ArrayList<>();

    public UserProfileTabAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PersonalInformationTabFragment();
            case 1:
                return new UniversitiesTabFragment();
            case 2:
                return new PhoneNumberTabFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public void setArrayList(List<Fragment> arrayList) {
        this.arrayList = arrayList;
    }
}
