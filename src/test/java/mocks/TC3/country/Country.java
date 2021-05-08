package mocks.TC3.country;

import com.google.gson.annotations.SerializedName;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import lombok.Builder;
import lombok.val;
import mocks.Codes.CountryCode;

import java.util.Collections;
import java.util.List;

import static mocks.Codes.CountryCode.*;
import static mocks.TC3.country.Currencies.getCurrencyPair;

@Builder(toBuilder = true)
public class Country {

    public String id;
    public Info info;
    @SerializedName("payment_methods")
    public List<PaymentMethod> paymentMethods;
    public Currencies currencies;
    @SerializedName("fav_destinations")
    public List<FavDestination> favDestinations;
    public List<Destination> destinations;
    @SerializedName("popular_destinations")
    public List<PopularDestination> popularDestinations;
    @SerializedName("address_schema")
    public AddressSchema addressSchema;
    public Boolean internationalMoneyTransferEnabled;
    public List<DeliveryService> services;

    public static Country getGb() {
        return getSenderCountryToDestination(GB, PH);
    }

    public static Country getSenderCountryToDestination(CountryCode senderCountry, CountryCode destinationCountry) {
        return Country.builder()
            .id(String.valueOf(PhoneNumberUtil.getInstance().getCountryCodeForRegion(senderCountry.getAlpha2())))
            .info(Info.getInfoFor(senderCountry))
            .paymentMethods(List.of(PaymentMethod.getPphMethod(), PaymentMethod.getBnkMethod(), PaymentMethod.getCybMethod()))
            .currencies(Currencies.getSendCurrency(senderCountry))
            .favDestinations(Collections.singletonList(FavDestination.getNigeriaDestination()))
            .destinations(List.of(Destination.getDefaultFor(destinationCountry), Destination.getDefaultFor(IN)))
            .popularDestinations(Collections.singletonList(PopularDestination.getPhpDestination()))
            .addressSchema(AddressSchema.getDefaultSchema())
            .internationalMoneyTransferEnabled(true)
            .build();
    }

    public static Country getTestCountry() {
        val testDestinationCountry = Destination.getDefaultFor(PH).toBuilder().name("Philippines_NEW").shortName("AAA").build();
        return Country.getGb().toBuilder()
            .destinations(Collections.singletonList(testDestinationCountry)).build();
    }

    public static Country getRecipientCountryForDefaultSender(CountryCode countryCode) {
        return getRecipientCountry(GB, countryCode);
    }

    public static Country getRecipientCountry(CountryCode senderCountry, CountryCode receiveCountry) {
        return Country.builder()
            .id(String.valueOf(PhoneNumberUtil.getInstance().getCountryCodeForRegion(receiveCountry.getAlpha2())))
            .info(Info.getInfoFor(receiveCountry))
            .paymentMethods(List.of(PaymentMethod.getPphMethod(), PaymentMethod.getBnkMethod(), PaymentMethod.getCybMethod()))
            .currencies(getCurrencyPair(senderCountry, receiveCountry))
            .services(List.of(
                DeliveryService.getBnkService(),
                DeliveryService.getCshPickupService(),
                DeliveryService.getAirtimeService(),
                DeliveryService.getAlipayService(),
                DeliveryService.getMobService()
            ))
            .addressSchema(AddressSchema.getDefaultSchema())
            .internationalMoneyTransferEnabled(true)
            .build();
    }

    public static Country getCorridorForCountry(CountryCode countryCode) {
        return getCorridorForCountry(GB, countryCode);
    }

    public static Country getCorridorForCountry(CountryCode sendCountry, CountryCode countryCode) {
        return Country.builder()
            .id(String.valueOf(PhoneNumberUtil.getInstance().getCountryCodeForRegion(countryCode.getAlpha2())))
            .info(Info.getInfoFor(countryCode))
            .paymentMethods(Collections.emptyList())
            .currencies(getCurrencyPair(sendCountry, countryCode))
            .services(List.of(
                DeliveryService.getBnkService().toBuilder().preRequisites(null).build(),
                DeliveryService.getCshPickupService().toBuilder().preRequisites(null).build(),
                DeliveryService.getAirtimeService().toBuilder().preRequisites(null).build(),
                DeliveryService.getAlipayService().toBuilder().preRequisites(null).build(),
                DeliveryService.getMobService().toBuilder().preRequisites(null).build()
            ))
            .addressSchema(AddressSchema.getDefaultSchema())
            .internationalMoneyTransferEnabled(true)
            .build();
    }
}
