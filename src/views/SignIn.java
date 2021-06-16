package views;

import Dao.connexion;
import javax.swing.*;
import com.company.Etudiant;

import java.awt.*;
import java.awt.event.ActionListener;

import com.company.Role;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.*;

public class SignIn {
    private JFrame frame;

    private JLabel lnom;
    private JLabel lemail;
    private JLabel lpassword;
    private JLabel lrole;

    private JTextField tnom;
    private JTextField temail;
    private JPasswordField tpassword;
    private JRadioButton tr1;
    private JRadioButton tr2;
    private JRadioButton tr3;

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JButton signIn;

    public SignIn() {
        frame = new JFrame("Sign In");
        lnom = new JLabel("nom : ");
        lemail = new JLabel("email : ");
        lpassword = new JLabel("password : ");
        lrole = new JLabel("role : ");


        tnom = new JTextField(60);
        temail = new JTextField(60);
        tpassword =  new JPasswordField(60);
        tr1 = new JRadioButton("Etudiant");
        tr2 = new JRadioButton("Professeur");
        tr3 = new JRadioButton("Admin");
        ButtonGroup bg=new ButtonGroup();
        bg.add(tr1);
        bg.add(tr2);
        bg.add(tr3);

        panel1 = new JPanel(new GridLayout(4, 1));
        panel2 = new JPanel(new GridLayout(4, 1));
        panel3 = new JPanel(new FlowLayout());

        signIn = new JButton("Sign In");
    }

    public void initForm(int w, int h) {
        frame.setLayout(new BorderLayout());
        frame.setSize(w, h);

        panel1.add(lnom);
        panel1.add(lemail);
        panel1.add(lpassword);

        panel3.add(lrole);
        panel3.add(tr1);
        panel3.add(tr2);
        panel3.add(tr3);

        panel2.add(tnom);
        panel2.add(temail);
        panel2.add(tpassword);


        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(BorderLayout.WEST, panel1);
        frame.add(BorderLayout.EAST, panel2);
        frame.add(BorderLayout.NORTH, panel3);
        frame.add(BorderLayout.SOUTH, signIn);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void actionForm(ArrayList<Etudiant> list, connexion dao) {
        ActionListener v = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == signIn) {
                    String rol = "etudiant";
                    Etudiant et = new Etudiant(2, tnom.getText(), temail.getText(), tpassword.getText());
                    if (list.get(0).getNom().compareTo(et.getNom()) == 0 &&
                            list.get(0).getEmail().compareTo(et.getEmail()) == 0 &&
                    list.get(0).getPassword().compareTo(et.getPassword()) == 0) {
                        System.out.println("correct student !!");
                    }
                    else
                        System.out.println("Wrooooooooong !!");
                    //listEt.fireTableDataChanged();
                    /*try {
                        Connection connect = dao.getConnect();
                        Statement st = connect.createStatement();
                        st.executeUpdate("INSERT INTO classe (numero, nom, prenom, email, sexe) "
                                +"VALUES (12 , 'toto', 'toto', 'toto@gmail.com', false)");
                    }
                    catch (Exception d)
                    {
                        System.err.println("Got an exception!");
                        System.err.println(d.getMessage());
                    }*/

                }
            }
        };
        signIn.addActionListener(v);
    }
}
