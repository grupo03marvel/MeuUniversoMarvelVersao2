package com.example.meuuniversomarvel;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
<<<<<<< HEAD
import androidx.test.runner.AndroidJUnit4;
=======
import androidx.test.ext.junit.runners.AndroidJUnit4;
>>>>>>> origin/development

import org.junit.Test;
import org.junit.runner.RunWith;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
=======
import static org.junit.Assert.*;
>>>>>>> origin/development

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.meuuniversomarvel", appContext.getPackageName());
    }
}
