package mocks.TC2;

import lombok.val;
import mocks.TC2.configuration.Flag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlagSettingsMock {

    Map<String, Boolean> defaultFlagMap = new HashMap<>();

    public List<Flag> getFlags(Map<String, Boolean> flagMap) {
        return flagMap.entrySet()
                .stream()
                .map(entry -> new Flag(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<Flag> getDefaultFlags() {
        return getFlags(defaultFlagMap);
    }

    public List<Flag> getDesiredFlags(Map<String, Boolean> desiredFlags) {
        val flags = new HashMap<>(defaultFlagMap);
        flags.putAll(desiredFlags);
        return getFlags(flags);
    }

    FlagSettingsMock() {
        defaultFlagMap.put("RecipientOnlyUserLogin", true);
        defaultFlagMap.put("WebViewNoCache", true);
        defaultFlagMap.put("InAppMessages", true);
        defaultFlagMap.put("TransactionDetails", true);
        defaultFlagMap.put("WalletTab", false);
        defaultFlagMap.put("WalletMultipleCurrencyAccounts", false);
        defaultFlagMap.put("HideWalletTabFromNewUsersWithoutAnActivatedWallet", true);
        defaultFlagMap.put("WalletTabNonPrime", false);
        defaultFlagMap.put("WalletTopUp", false);
        defaultFlagMap.put("WalletPromo", false);
        defaultFlagMap.put("WalletExchangeMoney", false);
        defaultFlagMap.put("WalletConfirmation", false);
        defaultFlagMap.put("WalletDeliveryMethodBanner", false);
        defaultFlagMap.put("RecipientRequestMoney", true);
        defaultFlagMap.put("TransactionConfirmation", true);
        defaultFlagMap.put("IdVerification", true);
        defaultFlagMap.put("SenderConfigSignup", true);
        defaultFlagMap.put("RecipientConfig", true);
        defaultFlagMap.put("WhatsAppNotifications", false);
        defaultFlagMap.put("CashPickUpInfo", false);
        defaultFlagMap.put("TransactionPdfReceipt", true);
        defaultFlagMap.put("EditMyDetails", true);
        defaultFlagMap.put("MfaDeviceVerification", true);
        defaultFlagMap.put("PaymentPolling", false);
        defaultFlagMap.put("CybersourceSavedCards", true);
        defaultFlagMap.put("SecureLogin", true);
        defaultFlagMap.put("CancelTransfer", true);
        defaultFlagMap.put("TryAgainForCancelledTransaction", false);
        defaultFlagMap.put("TransactionErrorOnTransactionDetails", false);
        defaultFlagMap.put("TransactionErrorOnTransactionDetailsVersion2", true);
        defaultFlagMap.put("VerificationStatus", false);
        defaultFlagMap.put("NeedToChangeSomething", true);
        defaultFlagMap.put("NeedToChangeSomethingV2", true);
        defaultFlagMap.put("TransactionCashPickup", true);
        defaultFlagMap.put("GetTransactionTimelineFromTransactionApi", true);
        defaultFlagMap.put("DataFieldTypeInNeedToChangeSomething", true);
        defaultFlagMap.put("CancellableLogicFromTransactionApi", true);
        defaultFlagMap.put("FingerprintAuth", true);
        defaultFlagMap.put("CancellationInNtcs", true);
        defaultFlagMap.put("ContactUsInNtcs", true);
        defaultFlagMap.put("FacebookAuth", false);
        defaultFlagMap.put("SendMoneyEmptyStatePromo", true);
        defaultFlagMap.put("CorrespondentSelectionDiscount", true);
        defaultFlagMap.put("PaymentMethodDifferentialPricing", false);
        defaultFlagMap.put("HighestFeePaymentMethodDifferentialPricing", false);
        defaultFlagMap.put("OnboardingCopyVariation", true);
        defaultFlagMap.put("BillPayments", true);
        defaultFlagMap.put("BillPaymentsRequest", true);
        defaultFlagMap.put("WarningCards", false);
        defaultFlagMap.put("CancellationReasons", true);
        defaultFlagMap.put("PostCancellationJsonResponse", true);
        defaultFlagMap.put("WebViewExternalLinks", true);
        defaultFlagMap.put("OnfidoDocumentVerification", true);
        defaultFlagMap.put("RewritePayIn", true);
        defaultFlagMap.put("BrazeTrackingSignupSuccessful", true);
        defaultFlagMap.put("BrazeTrackingTransactionCompleted", true);
        defaultFlagMap.put("CheckTodaysRate", false);
        defaultFlagMap.put("NewPricing", false);
        defaultFlagMap.put("NewPayInMethodTag", false);
        defaultFlagMap.put("RecurringPayment", true);
        defaultFlagMap.put("RecurringPaymentsManagement", true);
    }
}
