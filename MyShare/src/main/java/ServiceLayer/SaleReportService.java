package ServiceLayer;

import DBLayer.DataBaseConnection;

import java.sql.*;

public class SaleReportService {
    private DataBaseConnection singleCon;
    public SaleReportService(){
        singleCon = DataBaseConnection.getSingleInstance();
    }

    public int CalTotOrders(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DataBase Connection Success");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share_app", "root", "");
            Statement st = con.createStatement();

            String query = "SELECT count(*) from `customer_order`";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                // Retrieve the count from the first column (which is the only column in this case)
                int count = rs.getInt(1);
                return count;
            } else {
                // No rows returned, handle this case based on your application's logic
                return 0;
            }

        }catch (Exception ex) {
            System.out.println("Cannot get order count");
            return 0;
        }
    }

    public int CalTotSuppliers(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DataBase Connection Success");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share_app", "root", "");
            Statement st = con.createStatement();

            String query = "SELECT count(*) from `supplier`";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                // Retrieve the count from the first column (which is the only column in this case)
                int count = rs.getInt(1);
                return count;
            } else {
                // No rows returned, handle this case based on your application's logic
                return 0;
            }

        }catch (Exception ex) {
            System.out.println("Cannot get supplier count");
            return 0;
        }
    }

    public int CalTotEmployees(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DataBase Connection Success");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share_app", "root", "");
            Statement st = con.createStatement();

            String query = "SELECT count(*) from `employee`";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                // Retrieve the count from the first column (which is the only column in this case)
                int count = rs.getInt(1);
                return count;
            } else {
                // No rows returned, handle this case based on your application's logic
                return 0;
            }

        }catch (Exception ex) {
            System.out.println("Cannot get employee count");
            return 0;
        }
    }

    public int CalTotItems(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DataBase Connection Success");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share_app", "root", "");
            Statement st = con.createStatement();

            String query = "SELECT count(*) from `products`";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                // Retrieve the count from the first column (which is the only column in this case)
                int count = rs.getInt(1);
                return count;
            } else {
                // No rows returned, handle this case based on your application's logic
                return 0;
            }

        }catch (Exception ex) {
            System.out.println("Cannot get item count");
            return 0;
        }
    }

    public int CalTotDigitalArtworkOrders(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DataBase Connection Success");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share_app", "root", "");
            Statement st = con.createStatement();

            String query = "SELECT count(*) from `customer_order` where OrderCategory = 'Digital Artworks'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                // Retrieve the count from the first column (which is the only column in this case)
                int count = rs.getInt(1);
                return count;
            } else {
                // No rows returned, handle this case based on your application's logic
                return 0;
            }

        }catch (Exception ex) {
            System.out.println("Cannot get count of digital artwork orders");
            return 0;
        }
    }

    public int CalTotCampaignOrders(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DataBase Connection Success");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share_app", "root", "");
            Statement st = con.createStatement();

            String query = "SELECT count(*) from `customer_order` where OrderCategory = 'Campaign' ";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                // Retrieve the count from the first column (which is the only column in this case)
                int count = rs.getInt(1);
                return count;
            } else {
                // No rows returned, handle this case based on your application's logic
                return 0;
            }

        }catch (Exception ex) {
            System.out.println("Cannot get count of campaign orders");
            return 0;
        }
    }

    public int CalTotBannerOrders(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DataBase Connection Success");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/share_app", "root", "");
            Statement st = con.createStatement();

            String query = "SELECT count(*) from `customer_order` where OrderCategory = 'Banners'";
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                // Retrieve the count from the first column (which is the only column in this case)
                int count = rs.getInt(1);
                return count;
            } else {
                // No rows returned, handle this case based on your application's logic
                return 0;
            }

        }catch (Exception ex) {
            System.out.println("Cannot get count of Banner orders");
            return 0;
        }
    }

}
