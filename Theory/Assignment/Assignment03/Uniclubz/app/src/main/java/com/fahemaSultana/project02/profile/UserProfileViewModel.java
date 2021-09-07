package com.fahemaSultana.project02.profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fahemaSultana.project02.profile.DataModel.UserEntity;

public class UserProfileViewModel extends ViewModel {

    public MutableLiveData<UserEntity> userEntityLiveData = new MutableLiveData<>();

    public UserProfileViewModel() {
        userEntityLiveData.setValue(new UserEntity());
    }

}
