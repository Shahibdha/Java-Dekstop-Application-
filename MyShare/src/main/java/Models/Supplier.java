package Models;

public class Supplier {
    private static String SupID;
    private static String SupName;
    private static String SupEmail;
    private static String SupNumber;


    public Supplier(String SupID,String SupName,String SupEmail,String SupNumber) {
        this.SupID = SupID;
        this.SupName = SupName;
        this.SupEmail = SupEmail;
        this.SupNumber = SupNumber;

    }

    public Supplier() {
    }

    public static String getSupID() {
        return SupID;
    }

    public static String getSupName() {
        return SupName;
    }

    public static String getSupEmail() {
        return SupEmail;
    }

    public static String getSupNumber() {
        return SupNumber;
    }


}
