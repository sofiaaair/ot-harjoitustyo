
package kulutussovellus.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class CreateUserScreen {
    
    
       GridPane createUserScreen;
       Label createUserErrorLabel;
       Label createUsernameLabel;
       Label createPasswordLabel;
       Label createNameLabel;
       
       TextField createUsernameTextField;
       TextField createPasswordTextField;
       TextField createNameTextField;
       
       Button createUserButton;
       Button returnToStartButton;

    
    
    public void buildCreateUserScreen(){
    
       createUserScreen = new GridPane();
       createUserErrorLabel = new Label();
       createUserErrorLabel.setTextFill(Color.RED);
       createUsernameLabel = new Label("Username: ");
       createPasswordLabel = new Label("Password: ");
       createNameLabel = new Label("Your name: ");
       
       createUsernameTextField = new TextField();
       createPasswordTextField = new TextField();
       createNameTextField = new TextField();
       
       createUserButton = new Button("Create user");
       returnToStartButton = new Button("Return");
       HBox createUsernameHb = new HBox();
       createUsernameHb.getChildren().addAll(createUsernameLabel, createUsernameTextField);

       HBox createPasswordHb = new HBox();
       createPasswordHb.getChildren().addAll(createPasswordLabel, createPasswordTextField);

       HBox createNameHb = new HBox();
       createNameHb.getChildren().addAll(createNameLabel, createNameTextField);       
       
       createUserScreen.setPrefSize(1000,800);
       createUserScreen.setVgap(20);
       createUserScreen.setHgap(20);       
       createUserScreen.add(createUserErrorLabel, 0, 0);
       createUserScreen.add(createUsernameHb, 0, 1);
       createUserScreen.add(createPasswordHb, 0, 2);
       createUserScreen.add(createNameHb, 0, 3);
       createUserScreen.add(createUserButton, 0, 4);
       createUserScreen.add(returnToStartButton, 1, 4);
       createUserScreen.setAlignment(Pos.CENTER);  
           
    }
}
