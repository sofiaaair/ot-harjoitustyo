
package kulutussovellus.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class EnterExpenseScreen {
    
        GridPane enterExpenseScreen;
        Label expenseUser;
        Label expenseText;
        Label text;
        Label errorText;
        Label amountlabel;
        TextField amounttext;
        Label typelabel;
        Label typetext;    
        Button sendbutton;
        Button button;
        Button backToUsermenuButton;        
    
    public void buildEnterExpenseScreen(){
        
        enterExpenseScreen = new GridPane();
        expenseUser = new Label();
        expenseText = new Label("Hello, ");
        text = new Label("Enter the amount and type of expense");
        errorText = new Label();
        errorText.setTextFill(Color.RED);
        amountlabel = new Label("Amount: ");
        amounttext = new TextField();
        typelabel = new Label("Type of expense: ");
        typetext = new Label();

        
        
        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("housing", "leisure activities", "shopping", "traveling", "food", "other");
        typeComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                typetext.setText(newValue);
            }
        });
        
              
        HBox expenseTextHb = new HBox();
        expenseTextHb.getChildren().addAll(expenseText, expenseUser);
        
        HBox typeLabelHb = new HBox();
        typeLabelHb.getChildren().addAll(typelabel, typeComboBox);
        
        HBox amountLabelHb = new HBox();
        amountLabelHb.getChildren().addAll(amountlabel, amounttext);
        

        sendbutton = new Button("Enter");
        
        button = new Button("Entered expenses");
        backToUsermenuButton = new Button("Return");
        
        
        enterExpenseScreen.add(expenseTextHb, 0, 0);
        enterExpenseScreen.add(text, 0, 1);
        enterExpenseScreen.add(errorText, 0, 2);
        enterExpenseScreen.add(amountLabelHb, 0, 3);
        enterExpenseScreen.add(typeLabelHb, 0, 4);     
        enterExpenseScreen.add(sendbutton, 0,5);
        enterExpenseScreen.add(button, 0,6);
        enterExpenseScreen.add(backToUsermenuButton, 1,6);
        
        
        enterExpenseScreen.setPrefSize(1000,800);
        enterExpenseScreen.setAlignment(Pos.CENTER);
        enterExpenseScreen.setVgap(20);
        enterExpenseScreen.setHgap(20);
        enterExpenseScreen.setPadding(new Insets(40,40,40,40));        
    }
}
