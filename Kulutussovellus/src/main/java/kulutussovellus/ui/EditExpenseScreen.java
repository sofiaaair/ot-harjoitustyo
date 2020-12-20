
package kulutussovellus.ui;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import kulutussovellus.domain.Expense;

public class EditExpenseScreen {
        
    GridPane editExpensesScreen;
    ListView<Expense> expenseListView;
    Label deletedOne;
    Button returnBackButton;
    Text headline;
    Button removeExpenseButton;
    
    
    public void buidlEditExpenseScreen(){
        editExpensesScreen = new GridPane();
        expenseListView = new ListView<>();
        deletedOne = new Label();
        
        expenseListView.getSelectionModel().selectFirst();
        

        expenseListView.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Expense> ov, final Expense oldExpense, final Expense newExpense) -> {
            try{
            deletedOne.setText(String.valueOf(newExpense.getId()));
            }catch(NullPointerException e){
                deletedOne.setText(String.valueOf(oldExpense.getId()));
            }
        });
        
        returnBackButton = new Button("Return");
        headline = new Text("Your expenses");
        headline.setFont(Font.font("Helvetica",50));
        headline.setFill(Color.DARKSEAGREEN);
        
        removeExpenseButton = new Button("Remove expense");
        
        
        editExpensesScreen.setPrefSize(1000,800);
        editExpensesScreen.setHgap(20);
        editExpensesScreen.setVgap(20);
        editExpensesScreen.add(headline, 0, 0);
        editExpensesScreen.add(expenseListView, 0, 1);
        editExpensesScreen.add(removeExpenseButton, 0, 2);
        editExpensesScreen.add(returnBackButton, 0,3);
        editExpensesScreen.setAlignment(Pos.CENTER);        
    }
    
}
