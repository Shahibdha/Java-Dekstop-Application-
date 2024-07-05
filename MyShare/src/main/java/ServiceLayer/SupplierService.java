package ServiceLayer;

import DBLayer.DataBaseConnection;
import Models.Supplier;

public class SupplierService {
    private DataBaseConnection singleCon;
    public SupplierService(){
        singleCon = DataBaseConnection.getSingleInstance();
    }
    public boolean AddSupplier(String SupName,String SupEmail,String SupNumber){
        try {
            String querry = "Insert into supplier (Sup_ID,SupplierName, SupplierEmail, SupplierNumber) values(NULL,'"+SupName+"','"+SupEmail+"','"+SupNumber+"')";

            boolean result = singleCon.ExecuteQuery(querry);
            return result;
        }catch (Exception ex){
            System.out.println("Cannot Add The Supplier");
            return false;
        }
    }

    public boolean UpdateSupplier(String SupID,String SupName,String SupEmail,String SupNumber){
        try {
            String querry = "Update supplier set SupplierName='"+SupName+"',SupplierEmail='"+SupEmail+"',SupplierNumber='"+SupNumber+"' where Sup_ID='"+SupID+"'";

            boolean result = singleCon.ExecuteQuery(querry);
            return result;
        }catch (Exception ex){
            System.out.println("Cannot Update The Supplier");
            return false;
        }
    }

    public boolean DeleteSupplier(String SupID){
        try {
            String querry = "Delete from supplier where Sup_ID='"+SupID+"'";

            boolean result = singleCon.ExecuteQuery(querry);
            return result;
        }catch (Exception ex){
            System.out.println("Cannot Delete The Supplier");
            return false;
        }
    }
}
