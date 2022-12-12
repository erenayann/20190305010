package com.llp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JButton btn_users;
    private JButton btn_books;
    private JButton btn_borrow;
    private JPanel panel2;

    public Main(){
        add(panel2);
        setSize(500,550);
        setBounds(500,150,500,550);
        setTitle("Library Layout Project");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        btn_users.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                users u = new users();
                u.setVisible(true);
                setVisible(false);
            }
        });
        btn_books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                books b = new books();
                b.setVisible(true);
                setVisible(false);
            }
        });
        btn_borrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrowbook bw = new borrowbook();
                bw.setVisible(true);
                setVisible(false);
            }
        });
    }


    {

    }

}
