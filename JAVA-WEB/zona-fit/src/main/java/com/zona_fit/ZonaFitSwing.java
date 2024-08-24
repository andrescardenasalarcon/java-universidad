package com.zona_fit;


import com.formdev.flatlaf.FlatDarculaLaf;
import com.zona_fit.gui.ZonaFitForma;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

//@SpringBootApplication

//Desactivamos este @SpringBootApplication
//Tamb desactivamos
//Tabm desactivamos el @Component de zonaFitForma
//esTodo esto para que no se levante el servicio en modo escritorio

public class ZonaFitSwing {

    public static void main(String[] args) {
        //configuramos el modo oscuro
        FlatDarculaLaf.setup();

        //Instanciar la fabrica de spring
        //headless(false) --> ya que no es una aplicacion web si no de escritorio
        //web(WebApplicationType.NONE); --> para que no se ejecute como app web
        ConfigurableApplicationContext contextSpring = new SpringApplicationBuilder(ZonaFitSwing.class).headless(false).web(WebApplicationType.NONE).run(args);

        //Crear un obj de Swing
        //Ejecutamos nuestra app se swing de manera indirecta
        //Hasta que tenga todos los objetos de swing se ejecutara este SwingUtilities.invokeLater()
        SwingUtilities.invokeLater(() -> {
            ZonaFitForma zonaFitForma = contextSpring.getBean(ZonaFitForma.class);
            zonaFitForma.setVisible(true);
        });
    }
}
