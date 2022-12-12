package com.llp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class books extends JFrame {


    private JPanel panel4;
    private JLabel lbl_books;
    private JTable table_books;
    private JButton btn_display;
    private JButton btn_clear;


    public books(){
        add(panel4);
        setSize(800,550);
        setBounds(500,150,800,550);
        setTitle("Books");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        btn_display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","1234");
                    Statement st=con.createStatement();
                    String query= "select * from booklist";
                    ResultSet rs=st.executeQuery(query);
                    ResultSetMetaData rsmd=rs.getMetaData();
                    DefaultTableModel model= (DefaultTableModel) table_books.getModel();

                    int cols=rsmd.getColumnCount();
                    String[] colName = new String[cols];
                    for(int i=0;i<cols;i++)
                        colName[i]=rsmd.getColumnName(i+1);
                    model.setColumnIdentifiers(colName);
                    String bookid,bookname,author;
                    while (rs.next()) {
                        bookid=rs.getString(1);
                        bookname=rs.getString(2);
                        author=rs.getString(3);
                        String[] row= {bookid,bookname,author};
                        model.addRow(row);
                    }
                    st.close();
                    con.close();

                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table_books.setModel(new DefaultTableModel());
            }
        });
    }



}
