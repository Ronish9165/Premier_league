package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class HomePage implements ActionListener {
    JFrame fr;
    JPanel panel;
    JLabel lbl_heading, lbl_img, lbl_club, lbl_mp, lbl_won, lbl_draw, lbl_loss, lbl_gf, lbl_ga, lbl_gd, lbl_pts;
    JButton btn_addstd, btn_update, btn_logout;
    JTextField txt_mp, txt_won, txt_draw, txt_loss, txt_gf, txt_ga, txt_gd, txt_pts;
    ImageIcon image_premier;
    String user;
    Font fon1, fon2;

    public HomePage() {
        fr = new JFrame("Homepage");

        panel = new JPanel();
        panel.setBounds(0, 0, 800, 750);
        panel.setLayout(null);
        fr.add(panel);


        fon1 = new Font("arial", Font.BOLD, 22);
        fon2 = new Font("arial", Font.BOLD, 15);

        //Headings
        lbl_heading = new JLabel("WELCOME " + user);
        lbl_heading.setFont(fon1);
        lbl_heading.setForeground(Color.red);
        lbl_heading.setBounds(250, 25, 300, 30);
        panel.add(lbl_heading);

        lbl_club = new JLabel("Club");
        lbl_club.setFont(fon1);
        lbl_club.setForeground(Color.darkGray);
        lbl_club.setBounds(30, 275, 100, 20);
        panel.add(lbl_club);

        lbl_mp = new JLabel("MP");
        lbl_mp.setFont(fon1);
        lbl_mp.setForeground(Color.darkGray);
        lbl_mp.setBounds(400, 275, 100, 20);
        panel.add(lbl_mp);

        lbl_won = new JLabel("W");
        lbl_won.setFont(fon1);
        lbl_won.setForeground(Color.darkGray);
        lbl_won.setBounds(460, 275, 100, 20);
        panel.add(lbl_won);

        lbl_draw = new JLabel("D");
        lbl_draw.setFont(fon1);
        lbl_draw.setForeground(Color.darkGray);
        lbl_draw.setBounds(515, 275, 100, 20);
        panel.add(lbl_draw);

        lbl_loss = new JLabel("L");
        lbl_loss.setFont(fon1);
        lbl_loss.setForeground(Color.darkGray);
        lbl_loss.setBounds(568, 275, 100, 20);
        panel.add(lbl_loss);

        lbl_gf = new JLabel("GF");
        lbl_gf.setFont(fon1);
        lbl_gf.setForeground(Color.darkGray);
        lbl_gf.setBounds(610, 275, 100, 20);
        panel.add(lbl_gf);

        lbl_ga = new JLabel("GA");
        lbl_ga.setFont(fon1);
        lbl_ga.setForeground(Color.darkGray);
        lbl_ga.setBounds(660, 275, 100, 20);
        panel.add(lbl_ga);

        lbl_gd = new JLabel("GD");
        lbl_gd.setFont(fon1);
        lbl_gd.setForeground(Color.darkGray);
        lbl_gd.setBounds(705, 275, 100, 20);
        panel.add(lbl_gd);

        lbl_pts = new JLabel("PTS");
        lbl_pts.setFont(fon1);
        lbl_pts.setForeground(Color.darkGray);
        lbl_pts.setBounds(750, 275, 100, 20);
        panel.add(lbl_pts);


        //Buttons
        btn_addstd = new JButton("Add Standings");
        btn_addstd.setFont(fon2);
        btn_addstd.setBounds(155, 550, 170, 50);
        btn_addstd.addActionListener(this);
        panel.add(btn_addstd);

        btn_update = new JButton("Show");
        btn_update.setFont(fon2);
        btn_update.setBounds(350, 550, 130, 50);
        panel.add(btn_update);

        btn_logout = new JButton("Logout");
        btn_logout.setFont(fon1);
        btn_logout.setBounds(555, 600, 160, 30);
        btn_logout.setBackground(Color.white);
        panel.add(btn_logout);


        btn_logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginPage();
                fr.dispose();
            }
        });

        //Image
        image_premier = new ImageIcon(getClass().getResource("premier.png"));
        lbl_img = new JLabel(image_premier);
        lbl_img.setBounds(0, 0, 798, 590);
        panel.add(lbl_img);

        fr.setSize(815, 750);
        fr.setLayout(null);
        fr.setVisible(true);

    }

    public static void main(String[] args) {
        new HomePage();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_addstd) {
            new standings();
        }
    }
}
