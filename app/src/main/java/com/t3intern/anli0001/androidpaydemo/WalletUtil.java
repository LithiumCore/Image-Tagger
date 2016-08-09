package com.t3intern.anli0001.androidpaydemo;

import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.PaymentMethodTokenizationParameters;
import com.google.android.gms.wallet.PaymentMethodTokenizationType;

/**
 * Created by anli0001 on 6/15/2016.
 * Created to handle Android Pay API
 */
public class WalletUtil {
    public static MaskedWalletRequest createMaskedWalletRequest(
                                                                String publicKey) {
        // Validate the public key
        if (publicKey == null || publicKey.contains("REPLACE_ME")) {
            throw new IllegalArgumentException("Invalid public key, see README for instructions.");
        }

        // Create direct integration parameters
        // [START direct_integration_parameters]
        PaymentMethodTokenizationParameters parameters =
                PaymentMethodTokenizationParameters.newBuilder()
                        .setPaymentMethodTokenizationType(PaymentMethodTokenizationType.NETWORK_TOKEN)
                        .addParameter("publicKey", publicKey)
                        .build();
        // [END direct_integration_parameters]

        //return createMaskedWalletRequest(parameters);
        return null;
    }
}
