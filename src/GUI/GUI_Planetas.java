/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAOs.DAOPlanetas;
import Entidades.Planetas;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class GUI_Planetas extends JDialog {

    Container cp;

    JPanel painelnorte = new JPanel();
    JPanel painelcentro = new JPanel();
    JPanel painelsul = new JPanel();
    JPanel painelleste = new JPanel();
    JPanel paineloeste = new JPanel();
    JLabel lsigla = new JLabel(" SIGLA : ");
    JTextField digitasigla = new JTextField(12);
    JButton botaobuscar = new JButton(" BUSCAR ");
    JButton botaoadicionar = new JButton(" ADICIONAR ");
    JButton botaosalvar = new JButton(" SALVAR ");
    JButton botaoalterar = new JButton(" ALTERAR ");
    JButton botaoexcluir = new JButton(" EXCLUIR ");
    JButton botaolistar = new JButton(" LISTAR ");
    JButton botaocancelar = new JButton(" CANCELAR ");

    JLabel labelPlanetas = new JLabel(" PLANETA : ");
    JTextField digitaPlanetas = new JTextField(30);

    int cont = 0;
    JButton tirasom = new JButton("Tirar som");
    JButton botasom = new JButton("Botar som");

    Planetas planetas = new Planetas();
    DAOPlanetas daoPlanetas = new DAOPlanetas();

    JPanel bordalinda1 = new JPanel();
    JPanel bordalinda2 = new JPanel();

    String acao = "";
    ///////////////////////////////////
    String[] colunas = new String[]{" sigla" + " Planeta"};
    String[][] dados = new String[0][6];

    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);

    private JScrollPane scrolltabela = new JScrollPane();

    private JPanel pnavisos = new JPanel(new GridLayout(1, 1));
    private JPanel pnlistagem = new JPanel(new GridLayout(1, 1));
    private JPanel pnvazio = new JPanel(new GridLayout(6, 1));

    private CardLayout cardLayout;
    private String chavePrimaria = "";

    public GUI_Planetas() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle(" Alien Planeta  - CRUD");

        cp.add(painelnorte, BorderLayout.NORTH);
        cp.add(painelcentro, BorderLayout.CENTER);
        cp.add(painelsul, BorderLayout.SOUTH);
        cp.add(painelleste, BorderLayout.EAST);
        cp.add(paineloeste, BorderLayout.WEST);

        lsigla.setForeground(Color.WHITE);

        lsigla.setFont(new Font("Courier New", Font.BOLD, 16));

        labelPlanetas.setForeground(Color.green);
        labelPlanetas.setFont(new Font("Algerian", Font.BOLD, 22));
        labelPlanetas.setHorizontalAlignment(SwingConstants.CENTER);

        digitasigla.setFont(new Font("Cursive", Font.BOLD, 16));
        digitasigla.setForeground(Color.GREEN);
        digitasigla.setBackground(Color.darkGray);

        digitaPlanetas.setFont(new Font("Impact", Font.ITALIC, 22));
        digitaPlanetas.setForeground(new Color(0, 96, 55));

        pnavisos.setBackground(new Color(50, 205, 52));
        pnlistagem.setBackground(new Color(50, 205, 52));
        pnvazio.setBackground(new Color(50, 205, 52));

        painelleste.setBackground(new Color(22, 0, 22));
        paineloeste.setBackground(new Color(22, 0, 22));
        painelnorte.setBackground(new Color(22, 0, 22));
        painelcentro.setBackground(new Color(22, 110, 22));
        painelsul.setBackground(new Color(22, 0, 22));

        painelnorte.setLayout(new FlowLayout(FlowLayout.LEFT));
        painelnorte.add(lsigla);
        painelnorte.add(digitasigla);
        painelnorte.add(botaobuscar);
        painelnorte.add(botaosalvar);
        painelnorte.add(botaolistar);
        painelnorte.add(botaoadicionar);
        painelnorte.add(botaocancelar);
        painelnorte.add(botaoalterar);
        painelnorte.add(botaoexcluir);
        painelnorte.add(tirasom);
        painelnorte.add(botasom);

        tirasom.setBackground(Color.PINK);
        botasom.setBackground(Color.PINK);
        botasom.setVisible(false);

        botaoadicionar.setVisible(false);
        botaosalvar.setVisible(false);
        botaoalterar.setVisible(false);
        botaocancelar.setVisible(false);
        botaoexcluir.setVisible(false);

        botaobuscar.setBackground(Color.GREEN);
        botaoadicionar.setBackground(Color.WHITE);
        botaosalvar.setBackground(Color.cyan);
        botaoalterar.setBackground(Color.ORANGE);
        botaoexcluir.setBackground(Color.blue);
        botaocancelar.setBackground(Color.red);
        botaolistar.setBackground(Color.LIGHT_GRAY);

        painelcentro.setLayout(new GridLayout(2, 2));

        painelcentro.add(labelPlanetas);
        painelcentro.add(digitaPlanetas);

        painelcentro.add(bordalinda1);
        painelcentro.add(bordalinda2);

        bordalinda1.setBackground(new Color(22, 0, 22));
        bordalinda2.setBackground(new Color(22, 0, 22));
        labelPlanetas.setBorder(BorderFactory.createLineBorder(Color.black));

        digitaPlanetas.setBorder(BorderFactory.createLineBorder(Color.blue));

        cardLayout = new CardLayout();
        painelsul.setLayout(cardLayout);

        for (int i = 0; i < 5; i++) {
            pnvazio.add(new JLabel(" "));
        }
        painelsul.add(pnvazio, "vazio");
        painelsul.add(pnlistagem, "listagem");
        painelsul.add(pnavisos, "avisos");
        tabela.setEnabled(false);

        pnavisos.add(new JLabel("avisos"));
        //pnlistagem.add(new JLabel(""));

        digitaPlanetas.setEditable(false);

        digitasigla.setBorder(BorderFactory.createLineBorder(Color.black));

        tirasom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                botasom.setVisible(true);
                tirasom.setVisible(false);
                cont = 1;

            }
        });

        botasom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                botasom.setVisible(false);
                tirasom.setVisible(true);
                cont = 0;

            }
        });

        botaobuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (cont == 0) {
                    play("rapaz");
                }
                cardLayout.show(painelsul, "avisos");
                chavePrimaria = digitasigla.getText();
                if (digitasigla.getText().length()==2) {
                    planetas = daoPlanetas.obter(digitasigla.getText());
                    if (planetas != null) {
                        botaoalterar.setVisible(true);
                        botaoexcluir.setVisible(true);
                        botaoadicionar.setVisible(false);
                        digitaPlanetas.setText(planetas.getNomePlaneta());

                        digitaPlanetas.setEditable(false);

                        botaosalvar.setVisible(false);

                    } else {
                        digitaPlanetas.setText("");

                        botaoadicionar.setVisible(true);
                        digitaPlanetas.setEditable(false);

                        botaosalvar.setVisible(false);
                        botaoalterar.setVisible(false);
                        botaoexcluir.setVisible(false);

                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "A sigla tem que ter SOMENTE 2 Caracteres !!!");
                }
                

            }
        });

        botaoadicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (cont == 0) {
                    play("rapaz");
                }

                digitasigla.setEditable(false);
                digitaPlanetas.setEditable(true);
                digitaPlanetas.requestFocus();

                botaoadicionar.setVisible(false);
                botaosalvar.setVisible(true);
                botaobuscar.setVisible(false);
                botaocancelar.setVisible(true);
                botaolistar.setVisible(false);
                acao = "adicionar";

            }
        });

        botaosalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {

                    botaoalterar.setVisible(false);
                    botaoexcluir.setVisible(false);
                    botaocancelar.setVisible(false);
                    botaolistar.setVisible(true);

                    if (acao.equals("adicionar")) {
                        planetas = new Planetas();
                        planetas.setSiglaPlaneta(digitasigla.getText());
                        planetas.setNomePlaneta(digitaPlanetas.getText());
                        daoPlanetas.inserir(planetas);                        
                    } else {
                        planetas.setSiglaPlaneta(digitasigla.getText());
                        planetas.setNomePlaneta(digitaPlanetas.getText());
                        daoPlanetas.atualizar(planetas);                       
                    }

                    botaosalvar.setVisible(false);
                    digitasigla.setEditable(true);
                    digitasigla.requestFocus();
                    digitasigla.setText("");
                    digitaPlanetas.setText("");

                    digitaPlanetas.setEditable(false);

                    botaobuscar.setVisible(true);

                    if (cont == 0) {
                        play("zsalvar");
                    }
                } catch (Exception errou) {
                    System.out.println("deu bosta ao salvar");
                }

            }

        });

        botaoalterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                botaolistar.setVisible(false);
                botaoexcluir.setVisible(false);
                botaobuscar.setVisible(false);
                botaoalterar.setVisible(false);
                digitasigla.setEditable(false);
                digitaPlanetas.setEditable(true);
                digitaPlanetas.requestFocus();

                botaosalvar.setVisible(true);
                botaocancelar.setVisible(true);
                acao = "alterar";

            }
        });

        botaoexcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (cont == 0) {
                    play("zaaa");
                }
                int resposta = JOptionPane.showConfirmDialog(cp, "Deseja mesmo excluir?", "Confirmar",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                botaoexcluir.setVisible(false);
                botaoalterar.setVisible(false);
                digitasigla.setEditable(true);
                digitasigla.requestFocus();
                digitasigla.setText("");
                digitaPlanetas.setText("");

                digitaPlanetas.setEditable(false);

                botaobuscar.setVisible(true);
                if (resposta == JOptionPane.YES_OPTION) {
                    daoPlanetas.remover(planetas);
                } else {
                    System.out.println(" OS DADOS DO ATLETA NÃO FORAM APAGADOS.");

                }

            }
        });

        botaolistar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                List<Planetas> planetas = daoPlanetas.list();

                String[] colunas = new String[]{" sigla", " PLANETA"};
                Object[][] dados = new Object[planetas.size()][colunas.length];
                String aux[];
                for (int i = 0; i < planetas.size(); i++) {
                    aux = planetas.get(i).toString().split(";");
                    for (int j = 0; j < colunas.length; j++) {
                        dados[i][j] = aux[j];
                    }
                }
                cardLayout.show(painelsul, "listagem");
                scrolltabela.setPreferredSize(tabela.getPreferredSize());
                pnlistagem.add(scrolltabela);
                scrolltabela.setViewportView(tabela);
                model.setDataVector(dados, colunas);

            }
        });

        botaocancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (cont == 0) {
                    play("zerro");
                }
                botaocancelar.setVisible(false);
                digitasigla.setEditable(true);
                digitasigla.requestFocus();
                digitasigla.setText("");
                digitaPlanetas.setText("");

                digitaPlanetas.setEditable(false);

                botaobuscar.setVisible(true);
                botaolistar.setVisible(true);
                botaosalvar.setVisible(false);

            }
        });

        setModal(true);
        setSize(850, 450);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void play(String nomemusica) {
        URL url = getClass().getResource(nomemusica + ".wav");
        AudioClip audio = Applet.newAudioClip(url);

        audio.play();
    }

}
