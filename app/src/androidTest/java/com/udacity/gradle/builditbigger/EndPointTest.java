package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import com.udacity.gradle.builditbigger.MainActivity.EndpointsAsyncTask;
import java.util.concurrent.TimeUnit;





public class EndPointTest extends AndroidTestCase {
    public void AsyncTest() throws TimeoutException, InterruptedException {
        try {
           EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();

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