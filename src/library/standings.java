package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class standings implements ActionListener {
    JFrame fr;
    JPanel panel;
    JLabel lbl_heading, lbl_img, lbl_club, lbl_mp, lbl_won, lbl_draw, lbl_loss, lbl_gf, lbl_ga, lbl_gd, lbl_pts;
    JButton btn_addstd, btn_update, btn_logout, btn_back;
    JTextField txt_mp, txt_won, txt_draw, txt_loss, txt_gf, txt_ga, txt_gd, txt_pts;
    ImageIcon image_premier;
    String user;
    Font fon1, fon2;

    public standings() {

        fr = new JFrame("Standings");

        panel = new JPanel();
        panel.setBounds(0, 0, 800, 750);
        panel.setLayout(null);
        fr.add(panel);


        fon1 = new Font("arial", Font.BOLD, 22);
        fon2 = new Font("arial", Font.BOLD, 15);

        //Headings

        lbl_club = new JLabel("Club");
        lbl_club.setFont(fon1);
        lbl_club.setForeground(Color.darkGray);
        lbl_club.setBounds(30, 220, 100, 20);
        panel.add(lbl_club);

        lbl_mp = new JLabel("MP");
        lbl_mp.setFont(fon1);
        lbl_mp.setForeground(Color.darkGray);
        lbl_mp.setBounds(400, 220, 100, 20);
        panel.add(lbl_mp);

        lbl_won = new JLabel("W");
        lbl_won.setFont(fon1);
        lbl_won.setForeground(Color.darkGray);
        lbl_won.setBounds(460, 220, 100, 20);
        panel.add(lbl_won);

        lbl_draw = new JLabel("D");
        lbl_draw.setFont(fon1);
        lbl_draw.setForeground(Color.darkGray);
        lbl_draw.setBounds(515, 220, 100, 20);
        panel.add(lbl_draw);

        lbl_loss = new JLabel("L");
        lbl_loss.setFont(fon1);
        lbl_loss.setForeground(Color.darkGray);
        lbl_loss.setBounds(568, 220, 100, 20);
        panel.add(lbl_loss);

        lbl_gf = new JLabel("GF");
        lbl_gf.setFont(fon1);
        lbl_gf.setForeground(Color.darkGray);
        lbl_gf.setBounds(610, 220, 100, 20);
        panel.add(lbl_gf);

        lbl_ga = new JLabel("GA");
        lbl_ga.setFont(fon1);
        lbl_ga.setForeground(Color.darkGray);
        lbl_ga.setBounds(660, 220, 100, 20);
        panel.add(lbl_ga);

        lbl_gd = new JLabel("GD");
        lbl_gd.setFont(fon1);
        lbl_gd.setForeground(Color.darkGray);
        lbl_gd.setBounds(705, 220, 100, 20);
        panel.add(lbl_gd);

        lbl_pts = new JLabel("PTS");
        lbl_pts.setFont(fon1);
        lbl_pts.setForeground(Color.darkGray);
        lbl_pts.setBounds(750, 220, 100, 20);
        panel.add(lbl_pts);


        //TextField
        txt_mp = new JTextField();
        txt_mp.setFont(fon2);
        txt_mp.setBounds(400, 250, 30, 25);
        panel.add(txt_mp);

        txt_won = new JTextField();
        txt_won.setFont(fon2);
        txt_won.setBounds(457, 250, 30, 25);
        panel.add(txt_won);

        txt_draw = new JTextField();
        txt_draw.setFont(fon2);
        txt_draw.setBounds(510, 250, 30, 25);
        panel.add(txt_draw);

        txt_loss = new JTextField();
        txt_loss.setFont(fon2);
        txt_loss.setBounds(563, 250, 30, 25);
        panel.add(txt_loss);

        txt_gf = new JTextField();
        txt_gf.setFont(fon2);
        txt_gf.setBounds(610, 250, 30, 25);
        panel.add(txt_gf);

        txt_ga = new JTextField();
        txt_ga.setFont(fon2);
        txt_ga.setBounds(660, 250, 30, 25);
        panel.add(txt_ga);

        txt_gd = new JTextField();
        txt_gd.setFont(fon2);
        txt_gd.setBounds(705, 250, 30, 25);
        panel.add(txt_gd);

        txt_pts = new JTextField();
        txt_pts.setFont(fon2);
        txt_pts.setBounds(750, 250, 35, 25);
        panel.add(txt_pts);

        //Buttons
        btn_addstd = new JButton("Add Standings");
        btn_addstd.setFont(fon2);
        btn_addstd.setBounds(155, 550, 170, 50);
        btn_addstd.addActionListener(this);
        panel.add(btn_addstd);

        btn_update = new JButton("Update");
        btn_update.setFont(fon2);
        btn_update.setBounds(350, 550, 130, 50);
        panel.add(btn_update);

        btn_back = new JButton("Back");
        btn_back.setFont(fon2);
        btn_back.setBounds(550, 550, 130, 50);
        btn_addstd.addActionListener(this);
        panel.add(btn_back);

        //Image
        image_premier = new ImageIcon(getClass().getResource("premier.png"));
        lbl_img = new JLabel(image_premier);
        lbl_img.setBounds(0, 0, 798, 470);
        panel.add(lbl_img);

        fr.setSize(815, 750);
        fr.setLayout(null);
        fr.setVisible(true);

    }


    public static void main(String[] args) {
        new standings();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_back){
            fr.dispose();
            new HomePage();
        }
        String mp = txt_mp.getText();
        String won = txt_won.getText();
        String draw = txt_draw.getText();
        String loss = txt_loss.getText();
        String gf = txt_gf.getText();
        String ga = txt_ga.getText();
        String gd = txt_gd.getText();
        String pts = txt_pts.getText();

        if (e.getSource() == btn_addstd) {
            DbConnection db = new DbConnection();
            String query = "insert into standings(mp,won,draw,loss,gf,ga,gd,pts) " +
                    "values('" + mp + "','" + won + "','" + draw + "','" + loss + "','" + gf + "','" + ga + "','" + gd + "','" + pts + "')";
            int ans = db.insert(query);
            if (ans > 0) {
                JOptionPane.showMessageDialog(fr, "Added Successfully!");

            }


        }
    }
}