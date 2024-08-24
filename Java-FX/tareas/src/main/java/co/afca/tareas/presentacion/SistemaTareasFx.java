package co.afca.tareas.presentacion;

import co.afca.tareas.TareasApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class SistemaTareasFx extends Application {

    private ConfigurableApplicationContext applicationContext;

    //    public static void main(String[] args) {
//        launch(args);
//    }
    //Aqui cargamos la fabrica de spring despues de activar el javafx
    @Override
    public void init() {
        this.applicationContext = new SpringApplicationBuilder(TareasApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(TareasApplication.class.getResource("/templates/index.fxml"));
        loader.setControllerFactory(this.applicationContext::getBean);
        //Configs de javaFx
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
        applicationContext.close();
        Platform.exit();
    }
}
