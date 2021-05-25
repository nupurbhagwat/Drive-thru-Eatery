package com.eatery.controllers;
import com.eatery.data.MysqlCon;
import com.eatery.models.Item;
import com.eatery.views.*;

import javax.swing.*;

public class Controller {

    private AdminWindow1 adminWindow1;
    private CustomerWindow1 customerWindow1;
    private FirstWindow firstWindow;
    private PaymentWindow paymentWindow;
    private Item model;
    private MysqlCon mysqlCon;

    public Controller(AdminWindow1 adminWindow1, CustomerWindow1 customerWindow1, FirstWindow firstWindow,
                      PaymentWindow paymentWindow, Item model, MysqlCon mysqlCon) {
        this.model = model;
        this.adminWindow1 = adminWindow1;
        this.customerWindow1 = customerWindow1;
        this.firstWindow = firstWindow;
        this.paymentWindow = paymentWindow;
        this.mysqlCon = mysqlCon;
        initView();
    }

    public void initView() {

        adminWindow1.getItemTextField().setText("ItemName");
        adminWindow1.getSetPriceTextField().setText("Set Price");
        adminWindow1.getChangePriceTextField().setText("Change Price");
        adminWindow1.getChangeOfferTextField().setText("Change Offer");

    }

    public void initController() {
        firstWindow.getStartButton().addActionListener(e -> startApplication());
        System.out.println("Entered save");
        adminWindow1.getAddFoodItemButton().addActionListener(e -> saveFoodItem());
        adminWindow1.getPriceUpdateButton().addActionListener(e -> saveUpdatedPrice());
        adminWindow1.getOfferUpdateButton().addActionListener(e -> saveUpdatedOffer());


    }

    private void startApplication(){
        String[] options = {"Administrator", "Customer"};
        int opt = JOptionPane.showOptionDialog(FirstWindow.parent,
                "Choose Account type",
                "Accounts",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(opt == 1){
            CustomerWindow1 customerWindow = new CustomerWindow1(mysqlCon);
            FirstWindow.parent.setVisible(false);
        } else{
            AdminWindow1 adminWindow = new AdminWindow1(mysqlCon);
            FirstWindow.parent.setVisible(false);
        }
    }

    private void saveFoodItem() {

        mysqlCon.insertItemInAdminWindow1(adminWindow1);
    }

    private String getComboSelectedItemPrice() {
        String item = (String) adminWindow1.getItemsCBPrice().getItemAt(adminWindow1.getItemsCBPrice().getSelectedIndex());
        return item;
    }

    private String getComboSelectedItemOffer() {
        String item = (String) adminWindow1.getItemsCBOffer().getItemAt(adminWindow1.getItemsCBOffer().getSelectedIndex());
        return item;
    }


    private void saveUpdatedPrice() {
        mysqlCon.updatePriceInAdminWindow1(adminWindow1, getComboSelectedItemPrice());
    }

    private void saveUpdatedOffer() {
        mysqlCon.updateOfferInAdminWindow1(adminWindow1, getComboSelectedItemOffer());
    }

}






