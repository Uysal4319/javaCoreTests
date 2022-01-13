package dataTypesOperations.internalizationOperations;

import java.util.Locale;

public class LocaleDetails {

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();

        System.out.println("Default Locale Properties:\n");

        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getDisplayName());
        System.out.println(locale.getISO3Country());
        System.out.println(locale.getISO3Language());
        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());

        Locale turkey = new Locale("tr","tr");

        System.out.println("\nfr Locale Properties:\n");
        System.out.println(turkey.getDisplayCountry());
        System.out.println(turkey.getDisplayLanguage());
        System.out.println(turkey.getDisplayName());
        System.out.println(turkey.getISO3Country());
        System.out.println(turkey.getISO3Language());
        System.out.println(turkey.getLanguage());
        System.out.println(turkey.getCountry());
        System.out.println("-----------------------------------------");
        Locale defaultLocale = Locale.getDefault();
        Locale enLocale = new Locale("en", "US");
        Locale frLocale = new Locale("fr", "FR");
        Locale esLocale = new Locale("es", "ES");

        System.out.println(defaultLocale.getDisplayLanguage(enLocale));
        System.out.println(defaultLocale.getDisplayLanguage(frLocale));
        System.out.println(defaultLocale.getDisplayLanguage(esLocale));


    }
}
