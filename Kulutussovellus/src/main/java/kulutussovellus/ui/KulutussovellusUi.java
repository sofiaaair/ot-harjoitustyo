
package kulutussovellus.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class KulutussovellusUi extends Application {
    
    
    @Override
    public void start(Stage stage){
        
        Pane screen = new Pane();
        screen.setPrefSize(800, 500);
        
        Scene scene = new Scene(screen);
        
        stage.setTitle("Kulutussovellus");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
