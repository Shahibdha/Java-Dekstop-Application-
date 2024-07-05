package View.SaleReport;

import ServiceLayer.SaleReportService;
import View.HomeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaleReportView extends JFrame{
    public JPanel contentPane;
    private JTextPane txtPaneTotOrders;
    private JTextPane txtPanetotalSuppliers;
    private JTextPane txtPanetotalEmployees;
    private JTextPane txtPanetotalItems;
    private JTextPane txtPanetotalDAOrders;
    private JTextPane txtPanetotalCampaignOrders;
    private JTextPane txtPanetotalBannerOrders;
    private JButton btnGENERATE;
    private JButton btnHOME;
    private JLabel lbltotOrders;
    private JLabel lblTotSuppliers;
    private JLabel lblTotEmployees;
    private JLabel lblTotItems;
    private JLabel lblTotArtworks;
    private JLabel lblTotCampaigns;
    private JLabel lblTotBanners;
    private JLabel lblTitle;


    SaleReportService reportService = new SaleReportService();

    private void displayTotalOrders() {
        // Calculate total orders
        int totalOrders = reportService.CalTotOrders();

        // Convert the totalOrders value to a String
        String totalOrdersText = String.valueOf(totalOrders);

        // Update the JTextPane with the totalOrders value
        txtPaneTotOrders.setText(totalOrdersText);
    }

    private void displayTotalSuppliers() {
        // Calculate total orders
        int totalSuppliers = reportService.CalTotSuppliers();

        // Convert the totalOrders value to a String
        String totalSuppliersText = String.valueOf(totalSuppliers);

        // Update the JTextPane with the totalOrders value
        txtPanetotalSuppliers.setText(totalSuppliersText);
    }

    private void displayTotalEmployees() {
        // Calculate total orders
        int totalEmployees = reportService.CalTotEmployees();

        // Convert the totalOrders value to a String
        String totalEmployeesText = String.valueOf(totalEmployees);

        // Update the JTextPane with the totalOrders value
        txtPanetotalEmployees.setText(totalEmployeesText);
    }

    private void displayTotalItems() {
        // Calculate total orders
        int totalItems = reportService.CalTotItems();

        // Convert the totalOrders value to a String
        String totalItemsText = String.valueOf(totalItems);

        // Update the JTextPane with the totalOrders value
        txtPanetotalItems.setText(totalItemsText);
    }

    private void displayTotalDAOrders() {
        // Calculate total orders
        int totalDAOrders = reportService.CalTotDigitalArtworkOrders();

        // Convert the totalOrders value to a String
        String totalDAOrdersText = String.valueOf(totalDAOrders);

        // Update the JTextPane with the totalOrders value
        txtPanetotalDAOrders.setText(totalDAOrdersText);
    }

    private void displayTotalCampaignOrders() {
        // Calculate total orders
        int totalCampaignOrders = reportService.CalTotCampaignOrders();

        // Convert the totalOrders value to a String
        String totalCampaignOrdersText = String.valueOf(totalCampaignOrders);

        // Update the JTextPane with the totalOrders value
        txtPanetotalCampaignOrders.setText(totalCampaignOrdersText);
    }

    private void displayTotalBannerOrders() {
        // Calculate total orders
        int totalBannerOrders = reportService.CalTotBannerOrders();

        // Convert the totalOrders value to a String
        String totalBannerOrdersText = String.valueOf(totalBannerOrders);

        // Update the JTextPane with the totalOrders value
        txtPanetotalBannerOrders.setText(totalBannerOrdersText);
    }

    public SaleReportView() {
        btnGENERATE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTotalOrders();
                displayTotalSuppliers();
                displayTotalEmployees();
                displayTotalItems();
                displayTotalDAOrders();
                displayTotalCampaignOrders();
                displayTotalBannerOrders();

            }
        });
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
    }


    public static void main(String[] args){

        SaleReportView ui=new SaleReportView();
        ui.setContentPane(ui.contentPane);
        ui.setTitle("Manage Sale Reports");
        ui.setSize(500,550);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }

}

