
package kulutussovellus.ui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class UserMenuScreen {
    
       GridPane userMenu;
       Label welcomeUserErrorLabel;
       Label welcomeUserText;
       Label welcomeUserText2;
       Label currentName;
       Label currentUserId;
       Button expenseMenuButton;
       Button viewExpensesButton;
       Button logoutUserMenuButton;  
    
    
    public void buildUserMenuScreen(){
       userMenu = new GridPane();
       welcomeUserErrorLabel = new Label();
       welcomeUserErrorLabel.setTextFill(Color.RED);
       welcomeUserText = new Label("Welcome ");
       welcomeUserText2 = new Label("Your id is: ");
       currentName = new Label();
       currentUserId = new Label();   
       expenseMenuButton = new Button("Add expenses");
       viewExpensesButton = new Button("View your expenses");
       logoutUserMenuButton = new Button("Log out");


       userMenu.setPrefSize(1000, 800);
       
       userMenu.add(logoutUserMenuButton, 1, 0);
       userMenu.add(welcomeUserErrorLabel, 0,1);
       userMenu.add(welcomeUserText, 0, 3);
       userMenu.add(currentName, 1, 3);
       userMenu.add(welcomeUserText2, 0,4);
       userMenu.add(currentUserId, 1,4);
       userMenu.add(expenseMenuButton, 0, 5);
       userMenu.add(viewExpensesButton, 1, 5);
       userMenu.setVgap(20);
       userMenu.setHgap(20);
       
       
       userMenu.setAlignment(Pos.CENTER);              
    }
    
}
