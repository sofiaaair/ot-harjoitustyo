
package kulutussovellus.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class KulutussovellusUi extends Application {
    
    
    @Override
    public void start(Stage stage){
        

        
        
        Pane screen = new Pane();
        screen.setPrefSize(800, 500);
        Label text = new Label("Syötä summa ja kulun tyyppi");
        Scene scene = new Scene(screen);
        
        stage.setTitle("Kulutussovellus");
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) throws SQLException {
                Connection db = DriverManager.getConnection("jdbc:sqlite:database.db");         
        Statement s = db.createStatement();
        s.execute("BEGIN TRANSACTION");
        s.execute("PRAGMA foreign_keys = ON");
        s.execute("CREATE TABLE Expense (id INTEGER PRIMARY KEY, amount INTEGER, type TEXT)");
        s.execute("COMMIT");

        launch(args);
    }

}
