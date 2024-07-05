package View.ManageSupplier;

import DBLayer.DataBaseConnection;
import ServiceLayer.SupplierService;
import View.HomeView;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageSupplierView extends JFrame{
    public JPanel contentPane;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JTextField txtSupID;
    private JTextField txtSupName;
    private JTextField txtSupEmail;
    private JButton btnADD;
    private JButton btnHOME;
    private JButton btnDELETE;
    private JButton btnUPDATE;
    private JLabel lblError;
    private JButton btnShowAll;
    private JTable tblP;
    private JLabel lblSupID;
    private JLabel lblSupName;
    private JLabel lblSupEmail;
    private JLabel lblSupNumber;
    private JTextField txtSupNumber;

    DataBaseConnection dataBaseConnection;
    PreparedStatement pst;
    Connection con;


    public ManageSupplierView() {
        dataBaseConnection = DataBaseConnection.getSingleInstance();
        con = dataBaseConnection.getConnection();
        SupplierService mng=new SupplierService();
        tableLoad();
        btnHOME.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeView v1 = new HomeView();
                setVisible(false);
                v1.setContentPane(v1.contentPane);
                v1.setTitle("Home");
                v1.setSize(600, 600);
                v1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                v1.setVisible(true);
            }
        });
        btnADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SupID = txtSupID.getText();
                String SupName = txtSupName.getText();
                String SupEmail=txtSupEmail.getText();
                String SupNumber=txtSupNumber.getText();


                if (SupName.isEmpty() || SupEmail.isEmpty() || SupNumber.isEmpty()) {
                        lblError.setText("Fill The Blanks");
                }

                else {
                    if(!SupID.isEmpty())
                    {
                        JOptionPane.showMessageDialog(contentPane,"The ID You Entered Is Replaced With An Auto Generated ID", "Alert", 1);
                    }
                    lblError.setText("");

                    if(mng.AddSupplier(SupName,SupEmail,SupNumber)){
                        JOptionPane.showMessageDialog(contentPane,"Supplier Successfully Added to the DataBase", "Success", 1);
                        tableLoad();
                        clear();

                    }else {
                        JOptionPane.showMessageDialog(contentPane,"Cannot insert to the DB", "Error", 1);
                    }
                }
            }
        });

        //Select rows from table
        tblP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectedRow = tblP.getSelectedRow();


                if (selectedRow >= 0) {
                    String SupID = tblP.getValueAt(selectedRow, 0).toString();
                    String SupName = tblP.getValueAt(selectedRow, 1).toString();
                    String SupEmail = tblP.getValueAt(selectedRow, 2).toString();
                    String SupNumber = tblP.getValueAt(selectedRow, 3).toString();

                    txtSupID.setText(SupID);
                    txtSupName.setText(SupName);
                    txtSupEmail.setText(SupEmail);
                    txtSupNumber.setText(SupNumber);
                }
            }
        });



        btnShowAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLoad();
                clear();
            }
        });


        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword=txtSearch.getText();

                if (!keyword.equals("")) {
                    try {
                        pst = con.prepareStatement("select SupplierName,SupplierEmail,SupplierNumber,Sup_ID from supplier where Sup_ID = '"+keyword+"'  OR SupplierName = '"+keyword+"'");
                        ResultSet rs = pst.executeQuery();

                        if (rs.next()) {

                            String Name = rs.getString(1);
                            String Email = rs.getString(2);
                            String Number = rs.getString(3);
                            String id = rs.getString(4);
                            tableserch(keyword);
                            txtSupID.setText(id);
                            lblError.setText("");
                            txtSupName.setText(Name);
                            txtSupEmail.setText(Email);
                            txtSupNumber.setText(Number);
                        } else {

                            tableLoad();
                            clear();
                            lblError.setText(keyword + " is Invalid Keyword");

                        }
                    } catch (SQLException e1) {
                        System.out.println("SQL ISSE");
                    }
                } else {
                    tableLoad();
                    clear();
                    lblError.setText("Please Enter ID Or Supplier Name");
                }
            }
        });


        btnUPDATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name, email, number, id;

                name = txtSupName.getText();
                email = txtSupEmail.getText();
                number = txtSupNumber.getText();
                id = txtSupID.getText();
                try {
                    int checkNumber = Integer.parseInt(number);
                } catch (NumberFormatException ex) {
                    lblError.setText("Please Enter Only Numbers For Supplier Number");
                    return; // Stop further execution of the action listener
                }
                if(mng.UpdateSupplier(id,name,email,number)){
                    JOptionPane.showMessageDialog(contentPane, "Update succesful","Success",JOptionPane.INFORMATION_MESSAGE);
                    tableLoad();
                    clear();
                }
                else{
                    JOptionPane.showMessageDialog(contentPane,"Cannot UPDATE DB", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnDELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=txtSupID.getText();
                int confirmation = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete this Supplier?",
                        "Confirm Deletion",
                        JOptionPane.YES_NO_OPTION
                );if (confirmation == JOptionPane.YES_OPTION) {
                    if(mng.DeleteSupplier(id)) {
                        JOptionPane.showMessageDialog(null, "Delete Succsessfull","Success",JOptionPane.INFORMATION_MESSAGE);
                        tableLoad();
                        clear();
                    }
                    else {
                        JOptionPane.showMessageDialog(contentPane,"Cannot DELETE SUPPLIER", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });


    }


    void tableLoad() {
        try {
            pst = con.prepareStatement("select * from supplier");
            ResultSet rs = pst.executeQuery();
            tblP.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e1) {
            System.out.println("SQL ISSUE");
        }
    }
    void tableserch(String keyword) {
        try {
            pst = con.prepareStatement("select * from supplier where Sup_ID = ?  OR SupplierName = ?");
            pst.setString(1, keyword);
            pst.setString(2, keyword);
            ResultSet rs = pst.executeQuery();
            tblP.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e1) {
            System.out.println("SQL ISSUE");
        }
    }
    void clear(){
        txtSearch.setText("");
        txtSupName.setText("");
        txtSupEmail.setText("");
        txtSupID.setText("");
        txtSupNumber.setText("");
        lblError.setText("");
    }

    public static void main(String[] args){

        ManageSupplierView ui=new ManageSupplierView();

        ui.setContentPane(ui.contentPane);
        ui.setTitle("Manage Supplier");
        ui.pack();
        ui.setSize(400,400);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);

    }
}
