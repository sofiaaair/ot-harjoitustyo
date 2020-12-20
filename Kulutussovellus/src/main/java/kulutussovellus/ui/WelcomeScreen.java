
package kulutussovellus.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class WelcomeScreen {
    
       GridPane welcomeScreen;
       Label welcomeText;
       Button signInButton;
       Button signUpButton;
       HBox buttonHb;
       
        public void buildWelcomeScreen(){
            welcomeScreen = new GridPane();
            welcomeText = new Label("Welcome to expense tracking application! ");
            signInButton = new Button("Sign in");
            signUpButton = new Button("Sign up");
            buttonHb = new HBox();       
           
       buttonHb.getChildren().addAll(signInButton, signUpButton);
       
       welcomeScreen.add(welcomeText, 0, 0);
       welcomeScreen.add(buttonHb, 0, 1);
       
        welcomeScreen.setPrefSize(1000, 800);
        welcomeScreen.setAlignment(Pos.CENTER);
        welcomeScreen.setVgap(20);
        welcomeScreen.setHgap(20);
        welcomeScreen.setPadding(new Insets(40,40,40,40));     
       }
    
        
    
}
