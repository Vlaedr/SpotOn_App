package ch.epfl.sweng.spotOn.test.location;

import org.junit.Before;
import org.junit.Test;

import ch.epfl.sweng.spotOn.localisation.ConcreteLocationTracker;

/**
 * Created by quentin on 23.11.16.
 *
 */

public class LocationTrackerTest_failureCases {

    @Before
    public void destroyIfAlreadyExists(){
        if(ConcreteLocationTracker.instanceExists()){
            ConcreteLocationTracker.destroyInstance();
        }
    }

    @Test (expected = IllegalStateException .class)
    public void ExceptionWhenNotInitialized(){
        ConcreteLocationTracker.getInstance();
    }

}
