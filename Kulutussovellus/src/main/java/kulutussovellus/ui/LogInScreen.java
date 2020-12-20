
package kulutussovellus.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class LogInScreen {
    
    GridPane logInScreen;
    Label loginErrorLabel;
    Label usernameLabel;
    Label passwordLabel;
    TextField usernameTextField;
    PasswordField passwordField;
    Button loginButton;
    Button backToStartButton;
    
    
    
    
    public void buildLoginScreen(){
       logInScreen = new GridPane();
       loginErrorLabel = new Label();
       loginErrorLabel.setTextFill(Color.RED);
       usernameLabel = new Label("Username: ");
       passwordLabel = new Label("Password: ");
       usernameTextField= new TextField();
       passwordField = new PasswordField();
       loginButton = new Button("Login");
       backToStartButton = new Button("Return");
       
       HBox usernameLabelHb = new HBox();
       usernameLabelHb.getChildren().addAll(usernameLabel, usernameTextField);
       
       HBox passwordLabelHb = new HBox();
       passwordLabelHb.getChildren().addAll(passwordLabel, passwordField);
       
       logInScreen.setPrefSize(1000, 800);
       logInScreen.setHgap(20);
       logInScreen.setVgap(20);
       logInScreen.add(loginErrorLabel, 0, 0);
       logInScreen.add(usernameLabelHb, 0, 1);
       logInScreen.add(passwordLabelHb, 0, 2);
       logInScreen.add(loginButton, 0,3);
       logInScreen.add(backToStartButton, 1,3);
       logInScreen.setAlignment(Pos.CENTER);          
    }
}
