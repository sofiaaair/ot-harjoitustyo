
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
import kulutussovellus.dao.ExpenseDao;
import kulutussovellus.dao.TablesDao;
import kulutussovellus.domain.Expense;


public class KulutussovellusUi extends Application {
    
    
    
    @Override
    public void start(Stage stage) throws SQLException{
        
        
        
        
       TablesDao TablesDao = new TablesDao();
       TablesDao.create();
        
       ExpenseDao ExpenseDao = new ExpenseDao();
       
       GridPane welcomeScreen = new GridPane();
       Label welcomeText = new Label("Welcome to expense tracking application! ");
       

       
       
        
        GridPane screen = new GridPane();
        Label text = new Label("Enter the amount and type of expense");
        
        Label amountlabel = new Label("Amount: ");
        TextField amounttext = new TextField();
        Label typelabel = new Label("Type of expense: ");
        TextField typetext = new TextField();
        
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(typelabel, typetext);
        
        HBox hb = new HBox();
        hb.getChildren().addAll(amountlabel, amounttext);
        
        VBox vb = new VBox();
        vb.getChildren().addAll(text, hb, hb2);
        Button sendbutton = new Button("Enter");
        
        Button button = new Button("Entered expenses");
        
        screen.add(vb, 0, 0);
        screen.add(sendbutton, 0,1);
        screen.add(button, 0,3);
        
        screen.setPrefSize(400,200);
        screen.setAlignment(Pos.CENTER);
        screen.setVgap(20);
        screen.setHgap(20);
        screen.setPadding(new Insets(40,40,40,40));
        
        Scene addExpenseScene = new Scene(screen);
        
        
        
        Label text2 = new Label("Expenses:");
        GridPane screen2 = new  GridPane();
        Label expenses = new Label();
        Button showButton = new Button("Show expenses");
        Button backToFirstPage= new Button("Return");
        
        showButton.setOnAction((event)->{
            try{
                String textToAdd = "";
                List<Expense> expensesOnTheList = ExpenseDao.list();
                for(Expense e: expensesOnTheList){
                    textToAdd= ""+ textToAdd +"\n" + e.toString();
                }
                expenses.setText(textToAdd);
            }catch(SQLException y){
                
        }
        });

        screen2.setPrefSize(400, 500);
        screen2.add(text2, 0, 0);
        screen2.add(showButton, 0,1);
        screen2.add(expenses, 0,3);
        screen2.add(backToFirstPage, 0,4);
        screen2.setAlignment(Pos.CENTER);
        backToFirstPage.setOnAction((event)->{
            stage.setScene(addExpenseScene);
        });
        sendbutton.setOnAction((event)->{
            Expense e = new Expense(Integer.valueOf(amounttext.getText()), typetext.getText());
           try {
               ExpenseDao.create(e);
           } catch (SQLException ex) {
               Logger.getLogger(KulutussovellusUi.class.getName()).log(Level.SEVERE, null, ex);
           }
           amounttext.clear();
           typetext.clear();
            
        });
        
        Scene showExpenseScene = new Scene(screen2);
        
        button.setOnAction((event)->{
            stage.setScene(showExpenseScene);
        });
        
        
        
        stage.setTitle("Kulutussovellus");
        
        
        
        
        stage.setScene(addExpenseScene);
        stage.show();
    }
    
    public static void main(String[] args) throws SQLException {

        launch(args);
    }

}
