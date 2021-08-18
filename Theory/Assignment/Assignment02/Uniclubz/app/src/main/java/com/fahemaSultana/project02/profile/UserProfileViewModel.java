package com.fahemaSultana.project02.profile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserProfileViewModel extends ViewModel {

    public MutableLiveData<Boolean> editInfoUpdatedCallback = new MutableLiveData<>();
    public MutableLiveData<Boolean> editUniversityUpdatedCallback = new MutableLiveData<>();
    public MutableLiveData<Boolean> editPhoneNumberUpdatedCallback = new MutableLiveData<>();

}
