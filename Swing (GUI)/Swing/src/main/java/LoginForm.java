import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel panelPrincipal;
    private JTextField usuarioTexto;
    private JPasswordField passwordTexto;
    private JButton enviaBoton;

    public LoginForm() {
        inicializarForma();
        enviaBoton.addActionListener(e ->
                validar()
        );
    }

    private void validar() {
        //Leer los valores de los campos de texto
        var usuario = usuarioTexto.getText();
        var password = new String(passwordTexto.getPassword());
        //Debido a que getPassword es de tipo char no se puede comparar, por eso lo casteamos a String para hacer el .equals
        if ("root".equals(usuario) && "admin".equals(password)) {
            mostrarMensaje("Datos correctos, bienvenido!");
        } else if ("root".equals(usuario)) {
            mostrarMensaje("Password incorrecto, corregirlo!");
        } else {
            mostrarMensaje("Usuario incorrecto, corregirlo");
        }

    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void inicializarForma() {
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); //centramos la ventana
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}
