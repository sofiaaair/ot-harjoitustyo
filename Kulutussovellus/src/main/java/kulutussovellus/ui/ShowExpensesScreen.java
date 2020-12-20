
package kulutussovellus.ui;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class ShowExpensesScreen {
    
        GridPane showExpensesScreen;
        Label showExpensesErrorLabel;
        Text expensesHeadline;
        Label expenses;
        Button showButton; 
        Label showByTypeLabel;
        Button showByTypeButton;
        Button showAllExpensesButton;
        Label sumExpensesLabel;
        Button toEditExpenseButton;
        Button backToFirstPage;
    
    public void buildShowExpenseScreen(PieChart pieChart){
        showExpensesScreen = new  GridPane();
        showExpensesErrorLabel = new Label();
        showExpensesErrorLabel.setTextFill(Color.RED);
        expensesHeadline = new Text("Expenses:");
        expensesHeadline.setFill(Color.DARKSEAGREEN);
        expensesHeadline.setFont(Font.font("Helvetica", 50));
        expenses = new Label();
        expenses.setTextFill(Color.DARKGREEN);
        expenses.setFont(Font.font(20));
        showButton = new Button("Show all expenses");
        
        showByTypeLabel = new Label();
        showByTypeLabel.setTextFill(Color.DARKGREEN);
        ComboBox<String> showByTypeComboBox = new ComboBox<>();
        showByTypeComboBox.getItems().addAll("housing", "leisure activities", "shopping", "traveling", "food", "other");
        showByTypeComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                showByTypeLabel.setText(newValue);
            }
        });        
        showByTypeButton = new Button("Show expenses by type");
        
        
        HBox showByTypeHb = new HBox();
        showByTypeHb.getChildren().addAll(showByTypeComboBox, showByTypeButton);
        
        showAllExpensesButton = new Button("TOTAL");
        sumExpensesLabel = new Label();
        sumExpensesLabel.setTextFill(Color.DARKGREEN);
        sumExpensesLabel.setFont(Font.font(20));
        
        HBox showAllExpensesHb = new HBox();
        showAllExpensesHb.getChildren().addAll(showAllExpensesButton, sumExpensesLabel);
        
        toEditExpenseButton = new Button("Edit expenses");
        
        backToFirstPage= new Button("Return");

        showExpensesScreen.setPrefSize(1000, 800);
        showExpensesScreen.setVgap(20);
        showExpensesScreen.setHgap(20);
        showExpensesScreen.add(expensesHeadline, 0, 0);
        showExpensesScreen.add(showExpensesErrorLabel, 0, 1);
        showExpensesScreen.add(showButton, 0,2);
        showExpensesScreen.add(expenses, 1,3);
        showExpensesScreen.add(pieChart, 0,3);
        showExpensesScreen.add(showByTypeHb, 0,4);
        showExpensesScreen.add(showAllExpensesHb, 0, 5);
        showExpensesScreen.add(toEditExpenseButton, 0, 6);
        showExpensesScreen.add(backToFirstPage, 1,6);
        showExpensesScreen.setAlignment(Pos.CENTER);
        
                
    }
    
}
