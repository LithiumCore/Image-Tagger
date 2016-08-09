package com.t3intern.anli0001.androidpaydemo;

import com.google.android.gms.wallet.WalletConstants;

/**
 * Created by anli0001 on 6/14/2016.
 */
public class Constants {
    // Environment to use when creating an instance of Wallet.WalletOptions
    public static final int WALLET_ENVIRONMENT = WalletConstants.ENVIRONMENT_TEST;
    // Strings needed for transaction
    public static final String MERCHANT_NAME = "Headphone Shop";
    public static final String CURRENCY_CODE_USD = "USD";

    // Intent extra keys
    public static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";
    public static final String EXTRA_MASKED_WALLET = "EXTRA_MASKED_WALLET";
    public static final String EXTRA_FULL_WALLET = "EXTRA_FULL_WALLET";
}
