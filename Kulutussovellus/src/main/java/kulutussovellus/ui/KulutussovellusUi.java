
package kulutussovellus.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import kulutussovellus.dao.DaoService;
import kulutussovellus.dao.ExpenseDao;
import kulutussovellus.dao.TablesDao;
import kulutussovellus.domain.Expense;
import kulutussovellus.domain.User;


public class KulutussovellusUi extends Application {
    
    DaoService daoService;
    
    
    
    
    @Override
    public void start(Stage stage){
        
       try{ 
       init();
       }catch(SQLException e){
           System.out.println("Error occurred while running init ");
       }
       GridPane welcomeScreen = new GridPane();
       Label welcomeText = new Label("Welcome to expense tracking application! ");
       Button signInButton = new Button("Sign in");
       Button signUpButton = new Button("Sign up");
       HBox buttonHb = new HBox();
       buttonHb.getChildren().addAll(signInButton, signUpButton);
       
       welcomeScreen.add(welcomeText, 0, 0);
       welcomeScreen.add(buttonHb, 0, 1);
       
        welcomeScreen.setPrefSize(600, 400);
        welcomeScreen.setAlignment(Pos.CENTER);
        welcomeScreen.setVgap(20);
        welcomeScreen.setHgap(20);
        welcomeScreen.setPadding(new Insets(40,40,40,40));       
       Scene welcomeScene = new Scene(welcomeScreen);
       
        
       
       
       GridPane createUserScreen = new GridPane();
       Label createUserErrorLabel = new Label();
       Label createUsernameLabel = new Label("Username: ");
       Label createPasswordLabel = new Label("Password: ");
       Label createNameLabel = new Label("Your name: ");
       
       TextField createUsernameTextField = new TextField();
       TextField createPasswordTextField = new TextField();
       TextField createNameTextField = new TextField();
       
       Button createUserButton = new Button("Create user");
       Button returnToStartButton = new Button("Return");
       HBox createUsernameHb = new HBox();
       createUsernameHb.getChildren().addAll(createUsernameLabel, createUsernameTextField);

       HBox createPasswordHb = new HBox();
       createPasswordHb.getChildren().addAll(createPasswordLabel, createPasswordTextField);

       HBox createNameHb = new HBox();
       createNameHb.getChildren().addAll(createNameLabel, createNameTextField);       
       
       createUserScreen.setPrefSize(600,400);
       createUserScreen.add(createUserErrorLabel, 0, 0);
       createUserScreen.add(createUsernameHb, 0, 1);
       createUserScreen.add(createPasswordHb, 0, 2);
       createUserScreen.add(createNameHb, 0, 3);
       createUserScreen.add(createUserButton, 0, 4);
       createUserScreen.add(returnToStartButton, 1, 4);
       createUserScreen.setAlignment(Pos.CENTER);  
       
       Scene signUpScene = new Scene(createUserScreen);
       
       
       
       
       GridPane logInScreen = new GridPane();
       Label loginErrorLabel = new Label();
       Label usernameLabel = new Label("Username: ");
       Label passwordLabel = new Label("Password: ");
       TextField usernameTextField= new TextField();
       PasswordField passwordField = new PasswordField();
       Button loginButton = new Button("Login");
       Button backToStartButton = new Button("Return");
       
       HBox usernameLabelHb = new HBox();
       usernameLabelHb.getChildren().addAll(usernameLabel, usernameTextField);
       
       HBox passwordLabelHb = new HBox();
       passwordLabelHb.getChildren().addAll(passwordLabel, passwordField);
       
       logInScreen.setPrefSize(600, 400);
       logInScreen.add(loginErrorLabel, 0, 0);
       logInScreen.add(usernameLabelHb, 0, 1);
       logInScreen.add(passwordLabelHb, 0, 2);
       logInScreen.add(loginButton, 0,3);
       logInScreen.add(backToStartButton, 1,3);
       logInScreen.setAlignment(Pos.CENTER);  
       
       Scene logInScene = new Scene(logInScreen);
       
        
       
       
       GridPane userMenu = new GridPane();
       Label welcomeUserText = new Label("Welcome ");
       Label welcomeUserText2 = new Label("Your id is: ");
       Label currentName = new Label();
       Label currentUserId = new Label();   
       Button expenseMenuButton = new Button("Add expenses");
       Button viewExpensesButton = new Button("View your expenses");
       Button logoutUserMenuButton = new Button("Log out");


       userMenu.setPrefSize(600, 400);
       userMenu.add(logoutUserMenuButton, 1, 0);
       userMenu.add(welcomeUserText, 0, 3);
       userMenu.add(currentName, 1, 3);
       userMenu.add(welcomeUserText2, 0,4);
       userMenu.add(currentUserId, 1,4);
       userMenu.add(expenseMenuButton, 0, 5);
       userMenu.add(viewExpensesButton, 1, 5);
       
       userMenu.setAlignment(Pos.CENTER);         
       
       Scene userMenuScene = new Scene(userMenu);
       
       
       
        GridPane enterExpenseScreen = new GridPane();
        Label expenseUser = new Label();
        Label expenseUserId = new Label();
        Label expenseText = new Label("Hello, ");
        Label text = new Label("Enter the amount and type of expense");
        Label errorText = new Label();
        Label amountlabel = new Label("Amount: ");
        TextField amounttext = new TextField();
        Label typelabel = new Label("Type of expense: ");
        TextField typetext = new TextField();
        
        HBox expenseTextHb = new HBox();
        expenseTextHb.getChildren().addAll(expenseText, expenseUser);
        
        HBox typeLabelHb = new HBox();
        typeLabelHb.getChildren().addAll(typelabel, typetext);
        
        HBox amountLabelHb = new HBox();
        amountLabelHb.getChildren().addAll(amountlabel, amounttext);
        
        VBox vb = new VBox();
        vb.getChildren().addAll(text, errorText, amountLabelHb, typeLabelHb);
        Button sendbutton = new Button("Enter");
        
        Button button = new Button("Entered expenses");
        Button backToUsermenuButton = new Button("Return");
        
        enterExpenseScreen.add(expenseTextHb, 0, 0);
        enterExpenseScreen.add(vb, 0, 1);
        enterExpenseScreen.add(sendbutton, 0,2);
        enterExpenseScreen.add(button, 0,3);
        enterExpenseScreen.add(backToUsermenuButton, 1,3);
        
        enterExpenseScreen.setPrefSize(600,400);
        enterExpenseScreen.setAlignment(Pos.CENTER);
        enterExpenseScreen.setVgap(20);
        enterExpenseScreen.setHgap(20);
        enterExpenseScreen.setPadding(new Insets(40,40,40,40));
        
        Scene addExpenseScene = new Scene(enterExpenseScreen);
        
        
        
        
        GridPane showExpensesScreen = new  GridPane();
        Label showExpensesUserId = new Label();
        
        Label text2 = new Label("Expenses:");
        Label expenses = new Label();
        Button showButton = new Button("Show expenses");
        Button backToFirstPage= new Button("Return");

        showExpensesScreen.setPrefSize(600, 400);
        showExpensesScreen.add(text2, 0, 0);
        showExpensesScreen.add(showButton, 0,1);
        showExpensesScreen.add(expenses, 0,3);
        showExpensesScreen.add(backToFirstPage, 0,4);
        showExpensesScreen.setAlignment(Pos.CENTER);
        
        Scene showExpenseScene = new Scene(showExpensesScreen);
        
        
        
        sendbutton.setOnAction((event)->{
            
           try {
               errorText.setText("");
               daoService.createExpense(amounttext.getText(), typetext.getText(), expenseUserId.getText());
           } catch (Exception ex) {
               
               errorText.setText("Error occurred while creating expense");
           }
           amounttext.clear();
           typetext.clear();
            
        });
        
        
        
        button.setOnAction((event)->{
            stage.setScene(showExpenseScene);
            showExpensesUserId.setText(expenseUserId.getText());
        });
        
        
       
        signInButton.setOnAction((event)->{
            stage.setScene(logInScene);
        });     
        
        signUpButton.setOnAction((event)->{
            stage.setScene(signUpScene);
        });          
        
        
        createUserButton.setOnAction((event)->{
            try{
                createUserErrorLabel.setText("");
                daoService.createUser(createNameTextField.getText(), createUsernameTextField.getText(), createPasswordTextField.getText());
            }catch(Exception e){
                createUserErrorLabel.setText("Error while creating user");
            }
            createUsernameTextField.clear();
            createPasswordTextField.clear();
            createNameTextField.clear();
        });    
        
        
        loginButton.setOnAction((event)->{
            try{
                loginErrorLabel.setText("");
                int loginId=daoService.loginUser(usernameTextField.getText(), passwordField.getText()); 
                User user = daoService.readUser(loginId);
                stage.setScene(userMenuScene);
                currentUserId.setText(String.valueOf(user.getId()));
                currentName.setText(user.getName());
                
            }catch(Exception e){
                loginErrorLabel.setText("Invalid username or password");
            }
        });
        
        expenseMenuButton.setOnAction((event)->{
            stage.setScene(addExpenseScene);
            expenseUserId.setText(currentUserId.getText());
            expenseUser.setText(currentName.getText());
        
        });
        
        showButton.setOnAction((event)->{
            try{
            String textToAdd = daoService.listExpense(Integer.valueOf(showExpensesUserId.getText()));
            
            expenses.setText(textToAdd);
            }catch(Exception e){
                expenses.setText("Error occurred while listing");
            }
        });
        
        backToFirstPage.setOnAction((event)->{
            stage.setScene(addExpenseScene);
        });
        
        viewExpensesButton.setOnAction((event)->{
            stage.setScene(showExpenseScene);
            showExpensesUserId.setText(currentUserId.getText());
        });

        backToStartButton.setOnAction((event)->{
            stage.setScene(welcomeScene);
        });
        
        returnToStartButton.setOnAction((event)->{
            stage.setScene(welcomeScene);
        });
        
        backToUsermenuButton.setOnAction((event)->{
            currentUserId.setText(expenseUserId.getText());
            currentName.setText(expenseUser.getText());
            stage.setScene(userMenuScene);
        });
        
        logoutUserMenuButton.setOnAction((event)->{
            stage.setScene(welcomeScene);
        });
        
        
        stage.setScene(welcomeScene);
        stage.show();
    }
    
    public void init() throws SQLException{
        
        daoService= new DaoService();
        daoService.createTablesDao();
        
    }
    
    public static void main(String[] args) throws SQLException {
        
        
        launch(args);
    }

}
