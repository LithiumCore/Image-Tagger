package com.t3intern.anli0001.androidpaydemo;

import android.content.Context;
import android.view.View;

import com.google.android.gms.wallet.fragment.SupportWalletFragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by anli0001 on 6/30/2016.
 */
public class CheckOutActivityTest {

    @Before
    public void setUpButton(){

    }

    @Test
    public void button_isNotCreated_noAndroidPay() throws Exception{
        assertEquals(4, 2 + 2);
    }

    @Mock
    Context mMockContext;

    @Test
    public void foobar(){

    }
}
