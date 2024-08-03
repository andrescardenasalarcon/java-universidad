import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Forma extends JFrame {
    private JPanel panelPrincipal;
    private JTextField campoTexto;
    private JLabel replicadorLabel;

    public Forma() {
        inicializacionForma();
//        campoTexto.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Se ejecutó action listener");
//            }
//        });
        // O TAMBIEN SE PUEDE VER ASI COMO FUNCION LAMBDA
        campoTexto.addActionListener(e -> {
            System.out.println("Se ejecutó action listener");
            replicarTexto();
        });
        //Este metodo "keyTyped" reacciona a cada click de las teclas
        campoTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                replicarTexto();
            }
        });
    }

    private void replicarTexto() {
//        this.campoTexto.getText();//Recuperando el texto de la caja
        this.replicadorLabel.setText(this.campoTexto.getText());
    }

    private void inicializacionForma() {
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);//centramos la ventana
    }

    public static void main(String[] args) {
//        FlatLightLaf.setup(); //--> Para el modo claro
        FlatDarculaLaf.setup(); //LAF: Look And Feel -- para el DARK MODE
        Forma forma = new Forma();
        forma.setVisible(true);
    }
}
