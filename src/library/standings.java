package library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class standings implements ActionListener {
    JFrame fr;
    JPanel panel;
    JLabel lbl_heading, lbl_img, lbl_club, lbl_mp, lbl_won, lbl_draw, lbl_loss, lbl_gf, lbl_ga, lbl_gd, lbl_pts;
    JButton btn_update, btn_logout, btn_back;
    JTextField txt_mp, txt_won, txt_draw, txt_loss, txt_gf, txt_ga, txt_gd, txt_pts;
    ImageIcon image_premier;
    String user;
    Font fon1, fon2;
    String id;

    public standings(String id) {
        this.id = id;
        System.out.println(id);

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

        //Buttons
        btn_update = new JButton("Update");
        btn_update.setFont(fon2);
        btn_update.setBounds(350, 550, 130, 50);
        btn_update.addActionListener(this);
        panel.add(btn_update);

        btn_back = new JButton("Back");
        btn_back.setFont(fon2);
        btn_back.setBounds(550, 550, 130, 50);
        btn_back.addActionListener(this);
        panel.add(btn_back);

        String id_no = id;
        DbConnection db = new DbConnection();
        String query = "select * from standings where id='" + id_no + "'";
        ResultSet rs = db.select(query);
        try {
            while (rs.next()) {

                //TextField
                txt_mp = new JTextField(rs.getString("mp"));
                txt_mp.setFont(fon2);
                txt_mp.setBounds(400, 250, 30, 25);
                txt_mp.setBackground(new Color(245, 254, 255));
                panel.add(txt_mp);

                txt_won = new JTextField(rs.getString("won"));
                txt_won.setFont(fon2);
                txt_won.setBounds(457, 250, 30, 25);
                txt_won.setBackground(new Color(245, 254, 255));
                panel.add(txt_won);

                txt_draw = new JTextField(rs.getString("draw"));
                txt_draw.setFont(fon2);
                txt_draw.setBounds(510, 250, 30, 25);
                txt_draw.setBackground(new Color(245, 254, 255));
                panel.add(txt_draw);

                txt_loss = new JTextField(rs.getString("loss"));
                txt_loss.setFont(fon2);
                txt_loss.setBounds(563, 250, 30, 25);
                txt_loss.setBackground(new Color(245, 254, 255));
                panel.add(txt_loss);

                txt_gf = new JTextField(rs.getString("gf"));
                txt_gf.setFont(fon2);
                txt_gf.setBounds(610, 250, 30, 25);
                txt_gf.setBackground(new Color(245, 254, 255));
                panel.add(txt_gf);

                txt_ga = new JTextField(rs.getString("ga"));
                txt_ga.setFont(fon2);
                txt_ga.setBounds(660, 250, 30, 25);
                txt_ga.setBackground(new Color(245, 254, 255));
                panel.add(txt_ga);

                txt_gd = new JTextField(rs.getString("gd"));
                txt_gd.setFont(fon2);
                txt_gd.setBounds(705, 250, 30, 25);
                txt_gd.setBackground(new Color(245, 254, 255));
                panel.add(txt_gd);

                txt_pts = new JTextField(rs.getString("pts"));
                txt_pts.setFont(fon2);
                txt_pts.setBounds(750, 250, 35, 25);
                txt_pts.setBackground(new Color(245, 254, 255));
                panel.add(txt_pts);

            }

            //Image
            image_premier = new ImageIcon(getClass().getResource("premier.png"));
            lbl_img = new JLabel(image_premier);
            lbl_img.setBounds(0, 0, 798, 470);
            panel.add(lbl_img);

            fr.setSize(815, 750);
            fr.setLayout(null);
            fr.setVisible(true);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_back){
            fr.dispose();
            new HomePage();
        }
        if (e.getSource() == btn_update) {
            try {
                String query = "update standings set mp='" + txt_mp.getText() + "',"
                        + "won='" + txt_won.getText() + "',draw='" + txt_draw.getText() + "'"
                        + ",loss='" + txt_loss.getText() + "',gf='" + txt_gf.getText() + "',ga='" + txt_ga.getText() + "'" +
                        ",gd='" + txt_gd.getText() + "',pts='" + txt_pts.getText() + "'where id = '"+id+"'";
                DbConnection db = new DbConnection();
                int rs = db.Update(query);
                JOptionPane.showMessageDialog(btn_update, "Update successsful");
            } finally {

            }
        }
    }
}