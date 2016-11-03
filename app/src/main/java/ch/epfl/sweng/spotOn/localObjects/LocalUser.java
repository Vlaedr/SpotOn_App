package ch.epfl.sweng.spotOn.localObjects;


import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ch.epfl.sweng.spotOn.user.User;
import ch.epfl.sweng.spotOn.user.UserId;

/*
 * This class is used to store the info of the current user in a local storage
 * It needs a method to refresh the info from the database
 */
public class LocalUser {

    private User mCurrentUser;

    private static final String DIRECTORY_USERS_PATH = "UsersDirectory";
    private static final DatabaseReference userDBRef = FirebaseDatabase.getInstance().getReference(DIRECTORY_USERS_PATH);


    private LocalUser(){
    }

    /* This method refresh the info of the current user from the database */
    public void refreshLocalUser(){
        //TODO: Test this method
        String userId = UserId.getInstance().getUserId();
        userDBRef.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mCurrentUser = (User) dataSnapshot.getValue();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Firebase UsersDB", databaseError.toString());
            }
        });

    }


    public User getCurrentUser(){
        return mCurrentUser;
    }

    public void setCurrentUser(User user){
        mCurrentUser = user;
    }
}
