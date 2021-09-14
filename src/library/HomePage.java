package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class HomePage {
    JFrame fr;
    JPanel panel;
    JLabel lbl_heading, lbl_img;
    JButton btn_addbooks,btn_logout;
    JTextField txt_mp, txt_win, txt_draw, txt_loss, txt_ga, txt_gd, txt_pts;
    ImageIcon image_premier;
    String user;
    Font fon1, fon2;

    public HomePage(String name) {
        this.user=name;
        fr=new JFrame("Dashboard");

        panel= new JPanel();
        panel.setBounds(0,0,800,600);
        panel.setLayout(null);
        fr.add(panel);


        fon1 = new Font("arial", Font.BOLD, 22);
        fon2 = new Font("arial", Font.BOLD, 15);

        //Headings
        lbl_heading=new JLabel("WELCOME "+user);
        lbl_heading.setFont(fon1);
        lbl_heading.setForeground(Color.red);
        lbl_heading.setBounds(250,25,300,50);
        panel.add(lbl_heading);

        //TextField
        txt_mp = new JTextField();
        txt_mp.setFont(fon2);
        txt_mp.setBounds(400, 200,30 , 25);
        panel.add(txt_mp);

        //Buttons
        btn_addbooks=new JButton("Add Books");
        btn_addbooks.setFont(fon1);
        btn_addbooks.setBounds(155, 550, 170, 50);
        panel.add(btn_addbooks);

        btn_logout=new JButton("Logout");
        btn_logout.setFont(fon1);
        btn_logout.setBounds(155, 450, 170, 30);
        btn_logout.setBackground(Color.white);
        panel.add(btn_logout);


        btn_logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                fr.dispose();
            }
        });

        image_premier=new ImageIcon(getClass().getResource("premier.png"));
        lbl_img=new JLabel(image_premier);
        lbl_img.setBounds(0,0,800,590);
        panel.add(lbl_img);

        fr.setSize(800, 600);
        fr.setLayout(null);
        fr.setVisible(true);

    }
    public static void main(String[] args){
        new HomePage("");
    }
}
