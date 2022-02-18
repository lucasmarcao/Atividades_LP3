/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Menu_do_projeto extends JFrame {
    private Container cp;
    private JPanel painelnorte = new JPanel();
    private JPanel painelcentro = new JPanel();
    private JPanel painelsul = new JPanel();
    private JPanel painelleste = new JPanel();
    private JPanel paineloeste = new JPanel();
    private JButton crudprincipal = new JButton(" CRUD Aliens ");
    private JButton crudfk = new JButton(" CRUD Planeta do alien ");
    private ImageIcon imagem = new ImageIcon(getClass().getResource("logo-quarto-bim-lp.png"));
    private JLabel imagemilustrativa = new JLabel(imagem);
    

    
    public Menu_do_projeto() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("      MENU PRINCIPAL. ");
        
        cp.add(painelnorte, BorderLayout.NORTH);
        cp.add(painelcentro, BorderLayout.CENTER);
        cp.add(painelsul, BorderLayout.SOUTH);
        cp.add(painelleste, BorderLayout.EAST);
        cp.add(paineloeste, BorderLayout.WEST);
        
        painelleste.setBackground(new Color (0,0,0));
        paineloeste.setBackground(new Color (0,0,0));
        painelnorte.setBackground(new Color (0,0,0));
        painelcentro.setBackground(new Color (3,186,134));
        painelsul.setBackground(new Color (0,0,0));
        
        
        crudfk.setFont(new Font("Times New Roman", Font.BOLD, 48));
        crudprincipal.setFont(new Font("Times New Roman", Font.BOLD, 79));
        
        painelnorte.setLayout(new FlowLayout((FlowLayout.CENTER)));
        painelnorte.add(crudprincipal);
        
        painelcentro.setLayout(new GridLayout(1,1));
        painelcentro.add(imagemilustrativa);
        
        painelsul.setLayout(new FlowLayout((FlowLayout.CENTER)));
        painelsul.add(crudfk);
        
        crudfk.setBackground(new Color (57,254,20));
        crudprincipal.setBackground(Color.GREEN);
        
        crudprincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUI_Aliens gui_Aliens = new GUI_Aliens();
            }
        });
        
        crudfk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUI_Planetas gui_Planetas = new GUI_Planetas();
            }
        });
        
        setSize(570,600);        
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        
    }
    
    
    
    
    
}
