package com.fahemaSultana.uniclubz.fragment.profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fahemaSultana.uniclubz.dataModel.UserEntity;
import com.fahemaSultana.uniclubz.sharedPreference.CredentialPreference;

public class UserProfileViewModel extends ViewModel {

    public MutableLiveData<UserEntity> userEntityLiveData = new MutableLiveData<>();

    public UserProfileViewModel() {
        if (CredentialPreference.getInstance().getUserDetails() == null)
            userEntityLiveData.setValue(new UserEntity());
        else
            userEntityLiveData.setValue(CredentialPreference.getInstance().getUserDetails());
    }

}
