package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;




@RunWith(AndroidJUnit4.class)
public class EndPointTest extends AndroidTestCase {

    private Context instrumentationCtx;

    @Before
    public void setup() {
        instrumentationCtx  = new RenamingDelegatingContext(InstrumentationRegistry.getTargetContext(), "test_");
    }

    @Test
    public void AsyncTest() throws Exception {
        try {
           MainActivity.EndpointsAsyncTask endpointsAsyncTask = new MainActivity.EndpointsAsyncTask(instrumentationCtx);

            endpointsAsyncTask.execute(new Pair<Context, String>(getContext(), null));

            String joke = endpointsAsyncTask.get(40000, TimeUnit.MILLISECONDS);

            assertNotNull(joke);
            assertTrue(!(joke.length() <= 0));

        } catch (ExecutionException e) {
            e.printStackTrace();
            fail("timeout");
        }
    }
}