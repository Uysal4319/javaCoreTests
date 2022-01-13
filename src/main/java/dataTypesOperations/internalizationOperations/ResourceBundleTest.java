package dataTypesOperations.internalizationOperations;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    public static void main(String[] args) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages", Locale.US);
        System.out.println("Message in "+Locale.US +": "+resourceBundle.getString("message"));

        resourceBundle = ResourceBundle.getBundle("Messages", Locale.FRANCE);
        System.out.println("Mesage in"+ Locale.FRANCE+" : "+resourceBundle.getString("message"));

    }
}
