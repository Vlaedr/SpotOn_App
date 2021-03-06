package ch.epfl.sweng.spotOn.user;

import java.util.Map;

import ch.epfl.sweng.spotOn.media.PhotoObject;

/**
 * Interface representing the current user of the application
 * Created by quentin on 24.11.16.
 */
public interface User {

    int INITIAL_KARMA = 100;
    long MAX_POST_PER_DAY = 10;
    long MIN_POST_PER_DAY = 1;
    long ONE_DAY = 24 * 60 * 60 * 1000;

    String LOGIN_NO_DATABASE_CONNECTION_MESSAGE = "Couldn't verify your login informations, please ensure you are connected to the internet";
    String LOGIN_NOT_LOGGED_in_MESSAGE = "You are not logged in";
    String LOGIN_NOT_RETRIEVED_FROM_DB_MESSAGE = "We're processing your login information, please wait";

// PUBLIC METHODS
    boolean isLoggedIn();
    void removeManager();
    void addPhoto(PhotoObject photo);
    long computeRemainingPhotos();
    void removePhoto(String pictureID);

//PUBLIC GETTERS
    String getFirstName();
    String getLastName();
    String getUserId();
    long getKarma();
    Map<String, Long> getPhotosTaken();
    Map<String, Long> retrieveUpdatedPhotosTaken();
    boolean getIsRetrievedFromDB();

//PUBLIC SETTERS
    void setKarma(long karma);
    void setIsRetrievedFromDB(boolean retrievedFromDB);
    void setPhotosTaken(Map<String, Long> m);

}
