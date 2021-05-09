package mocks.TC2.country;


import mocks.Codes.CountryCode;

import java.util.*;

public enum CurrencyCode {
    UNDEFINED("Undefined", -1, -1, new CountryCode[0]),

    GBP("Pound Sterling", 826, 2, new CountryCode[]{CountryCode.GB, CountryCode.GG, CountryCode.IM, CountryCode.JE}),

    INR("Indian Rupee", 356, 2, new CountryCode[]{CountryCode.BT, CountryCode.IN}),

    /** @deprecated */
    @Deprecated

    PHP("Philippine Peso", 608, 2, new CountryCode[]{CountryCode.PH});



    private static final Map<Integer, CurrencyCode> numericMap = new HashMap();
    private final String name;
    private final int numeric;
    private final int minorUnit;
    private final List<CountryCode> countryList;

    private CurrencyCode(String name, int numeric, int minorUnit, CountryCode... countries) {
        this.name = name;
        this.numeric = numeric;
        this.minorUnit = minorUnit;
        this.countryList = Collections.unmodifiableList(Arrays.asList(countries));
    }

    public String getName() {
        return this.name;
    }

    public int getNumeric() {
        return this.numeric;
    }

    public static CurrencyCode getByCode(String code) {
        return getByCode(code, true);
    }

    public static CurrencyCode getByCodeIgnoreCase(String code) {
        return getByCode(code, false);
    }

    public static CurrencyCode getByCode(String code, boolean caseSensitive) {
        code = canonicalize(code, caseSensitive);
        if (code == null) {
            return null;
        } else {
            try {
                return (CurrencyCode)Enum.valueOf(CurrencyCode.class, code);
            } catch (IllegalArgumentException var3) {
                return null;
            }
        }
    }

    private static String canonicalize(String code, boolean caseSensitive) {
        if (code != null && code.length() != 0) {
            return caseSensitive ? code : code.toUpperCase();
        } else {
            return null;
        }
    }

    static {
        CurrencyCode[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            CurrencyCode cc = var0[var2];
            numericMap.put(cc.getNumeric(), cc);
        }

    }
}
