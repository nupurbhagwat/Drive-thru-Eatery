package com.eatery.views;

import javax.swing.*;


import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JOptionPane;

public class FirstWindow {
    static public JFrame parent = new JFrame();
    JLabel welcomeMessage;

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    JButton startButton;



    public FirstWindow(){
        welcomeMessage = new JLabel();
        welcomeMessage.setBounds(100,50,300,100);
        welcomeMessage.setText("***WELCOME TO THE CAFE***");

        parent.getContentPane().setLayout(null);
        parent.add(welcomeMessage);

        startButton = new JButton();
        startButton.setText("Start Application");
        startButton.setBounds(120, 150, 150, 23);
        parent.add(startButton);
        parent.setSize(400,400);
        parent.setVisible(true);
    }




        /*button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //String name = JOptionPane.showInputDialog(parent,
                //  "Choose Account type", null);

                String[] options = {"Administrator", "Customer"};
                int opt = JOptionPane.showOptionDialog(parent,
                        "Choose Account type",
                        "Accounts",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                System.out.println("opt"+opt);

                if(opt == 1){
                    //CustomerWindow.main();
                    parent.setVisible(false);
                }


            }
        });*/
    }







