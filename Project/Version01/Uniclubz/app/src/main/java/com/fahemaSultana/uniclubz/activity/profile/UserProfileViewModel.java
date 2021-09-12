package com.fahemaSultana.uniclubz.activity.profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fahemaSultana.uniclubz.dataModel.UserEntity;

public class UserProfileViewModel extends ViewModel {

    public MutableLiveData<UserEntity> userEntityLiveData = new MutableLiveData<>();

    public UserProfileViewModel() {
        userEntityLiveData.setValue(new UserEntity());
    }

}
