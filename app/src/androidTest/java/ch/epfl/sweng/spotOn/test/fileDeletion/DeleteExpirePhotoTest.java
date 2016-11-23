package ch.epfl.sweng.spotOn.test.fileDeletion;

import android.support.annotation.NonNull;
import android.support.test.runner.AndroidJUnit4;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.epfl.sweng.spotOn.media.PhotoObject;
import ch.epfl.sweng.spotOn.test.util.PhotoObjectTestUtils;

/**
 * Created by nico on 23.11.16.
 */
@RunWith(AndroidJUnit4.class)
public class DeleteExpirePhotoTest {

    String pictureID;
    @Test
    public void addVeryOldPictureToDB(){
        PhotoObject po = PhotoObjectTestUtils.veryOldTimestampPicture();
        pictureID = po.getPictureId();
        po.upload(true, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {}
        });
    }
}
