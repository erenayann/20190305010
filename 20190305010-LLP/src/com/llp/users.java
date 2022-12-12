package com.llp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class users extends JFrame {
    private JPanel panel3;
    private JLabel lbl_name;
    private JLabel lbl_surname;
    private JLabel lbl_email;
    private JLabel lbl_phonenumber;
    private JTextField txt_name;
    private JTextField txt_surname;
    private JTextField txt_email;
    private JTextField txt_phonenumber;
    private JButton btn_add;
    private JTable table_users;
    private JButton btn_cancel;
    private JButton btn_delete;

    DefaultTableModel users = new DefaultTableModel();

    public users(){
        table_users.setModel(users);
        users.setColumnIdentifiers(new String[] {"Name","Surname","Email","Phone Number"});
        add(panel3);
        setSize(800,550);
        setBounds(500,150,800,550);
        setTitle("Add User");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txt_name.getText();
                String surname = txt_surname.getText();
                String email = txt_email.getText();
                String phonenumber = txt_phonenumber.getText();
                txt_name.setText("");
                txt_surname.setText("");
                txt_email.setText("");
                txt_phonenumber.setText("");
                String save_message = "Adding Successful";
                JOptionPane.showMessageDialog(rootPane,save_message);
                users.addRow(new String[] {name,surname,email,phonenumber});
            }
        });
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt_name.setText("");
                txt_surname.setText("");
                txt_email.setText("");
                txt_phonenumber.setText("");
            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                users.removeRow(table_users.getSelectedRow());
            }
        });
    }

}






