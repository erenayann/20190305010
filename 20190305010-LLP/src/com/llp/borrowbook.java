package com.llp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class borrowbook extends JFrame {
    private JLabel lbl_name;
    private JPanel panel5;
    private JLabel lbl_surname;
    private JLabel lbl_phonenumber;
    private JTextField txt_name;
    private JTextField txt_surname;
    private JTextField txt_phonenumber;
    private JTable table_borrow;
    private JButton btn_borrow;
    private JButton btn_delete;

    DefaultTableModel borrowbook = new DefaultTableModel();

    public borrowbook(){
        table_borrow.setModel(borrowbook);
        borrowbook.setColumnIdentifiers(new String[] {"Name","Surname","Phone Number"});
        add(panel5);
        setSize(800,550);
        setBounds(500,150,800,550);
        setTitle("Borrow Book");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        btn_borrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txt_name.getText();
                String surname = txt_surname.getText();
                String phonenumber = txt_phonenumber.getText();
                txt_name.setText("");
                txt_surname.setText("");
                txt_phonenumber.setText("");
                String save_message = "Borrowing Successful";
                JOptionPane.showMessageDialog(rootPane,save_message);
                borrowbook.addRow(new String[] {name,surname,phonenumber});

            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowbook.removeRow(table_borrow.getSelectedRow());
            }
        });
    }
}
