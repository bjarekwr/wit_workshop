package mocks.TC3.country;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public class Icon {

    @SerializedName("resolutions")
    public Resolutions resolutions;

    public static Icon getCardIcon() {
        return Icon.builder()
            .resolutions(Resolutions.builder()
                             ._10("https://res.cloudinary.com/worldremit/image/upload/v1495644525/images/icons/payment-methods/1.0x/credit-card.png")
                             ._15("https://res.cloudinary.com/worldremit/image/upload/v1495644699/images/icons/payment-methods/1.5x/credit-card.png")
                             ._20("https://res.cloudinary.com/worldremit/image/upload/v1495644724/images/icons/payment-methods/2.0x/credit-card.png")
                             ._30("https://res.cloudinary.com/worldremit/image/upload/v1495644752/images/icons/payment-methods/3.0x/credit-card.png")
                             ._40("https://res.cloudinary.com/worldremit/image/upload/v1495644792/images/icons/payment-methods/4.0x/credit-card.png")
                             .build())
            .build();
    }

    @Builder
    public static class Resolutions {

        @SerializedName("1.0")
        public String _10;
        @SerializedName("1.5")
        public String _15;
        @SerializedName("2.0")
        public String _20;
        @SerializedName("3.0")
        public String _30;
        @SerializedName("4.0")
        public String _40;
    }
}
