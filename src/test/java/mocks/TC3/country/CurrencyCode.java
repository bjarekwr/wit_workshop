package mocks.TC3.country;


import mocks.Codes.CountryCode;

import java.util.*;
import java.util.regex.Pattern;

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

    public int getMinorUnit() {
        return this.minorUnit;
    }

    public List<CountryCode> getCountryList() {
        return this.countryList;
    }

    public boolean isFund() {
        return false;
    }

    public boolean isPreciousMetal() {
        return false;
    }

    public Currency getCurrency() {
        try {
            return Currency.getInstance(this.name());
        } catch (IllegalArgumentException var2) {
            return null;
        }
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


    public static List<CurrencyCode> getByCountry(CountryCode country) {
        List<CurrencyCode> list = new ArrayList();
        if (country == null) {
            return list;
        } else {
            CurrencyCode[] var2 = values();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                CurrencyCode currency = var2[var4];
                Iterator var6 = currency.countryList.iterator();

                while(var6.hasNext()) {
                    CountryCode cc = (CountryCode)var6.next();
                    if (cc == country) {
                        list.add(currency);
                    }
                }
            }

            return list;
        }
    }

    public static List<CurrencyCode> findByName(String regex) {
        if (regex == null) {
            throw new IllegalArgumentException("regex is null.");
        } else {
            Pattern pattern = Pattern.compile(regex);
            return findByName(pattern);
        }
    }

    public static List<CurrencyCode> findByName(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("pattern is null.");
        } else {
            List<CurrencyCode> list = new ArrayList();
            CurrencyCode[] var2 = values();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                CurrencyCode entry = var2[var4];
                if (pattern.matcher(entry.getName()).matches()) {
                    list.add(entry);
                }
            }

            return list;
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
