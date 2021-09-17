package com.fahemaSultana.uniclubz.fragment.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.fahemaSultana.uniclubz.R;
import com.fahemaSultana.uniclubz.dataModel.ClubListModel;
import com.fahemaSultana.uniclubz.dataModel.UniversityListModel;
import com.fahemaSultana.uniclubz.dataModel.UserEntity;
import com.fahemaSultana.uniclubz.databinding.FragmentLoginBinding;
import com.fahemaSultana.uniclubz.fragment.universities.adapter.RecyclerViewClickListener;
import com.fahemaSultana.uniclubz.sharedPreference.CredentialPreference;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInFragment extends Fragment implements RecyclerViewClickListener {

    private FragmentLoginBinding binding;
    private FirebaseDatabase database;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference universitiesRef;

    public SignInFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // get data from realtime database
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance("https://uniclubz-eb8ff-default-rtdb.asia-southeast1.firebasedatabase.app/");
        universitiesRef = database.getReference("universities");


        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.enterYourEmailSign.getText().toString();
                String password = binding.enterPasswordSignup.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            CredentialPreference.getInstance().setUserId(firebaseAuth.getUid());
                            Toast.makeText(getContext(), "Successfully logged in", Toast.LENGTH_SHORT).show();

                            database.getReference("users").child(firebaseAuth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {

                                    Log.e("login", snapshot.toString());

                                    UserEntity userDetails = snapshot.getValue(UserEntity.class);
                                    if (userDetails == null)
                                        NavHostFragment.findNavController(SignInFragment.this).navigate(R.id.userProfileFragment);
                                    else {
                                        CredentialPreference.getInstance().setUserDetails(userDetails);
                                        NavHostFragment.findNavController(SignInFragment.this).navigate(R.id.homepageFragment);
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

                        } else
                            Toast.makeText(getContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        binding.goToSignup.setOnClickListener(v -> {
            NavHostFragment.findNavController(this).navigate(R.id.signUpFragment);
        });

    }

    @Override
    public void onClick(UniversityListModel model) {
        NavHostFragment.findNavController(this).navigate(R.id.clubsFragment);
    }

    @Override
    public void onClick(ClubListModel model) {

    }
}