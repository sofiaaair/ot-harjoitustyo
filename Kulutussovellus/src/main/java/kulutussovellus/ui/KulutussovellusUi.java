
package kulutussovellus.ui;

import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import kulutussovellus.domain.DaoService;
import kulutussovellus.domain.Expense;
import kulutussovellus.domain.User;


public class KulutussovellusUi extends Application {
    
    DaoService daoService;
    PieChart pieChart;
    Integer currentId;
    WelcomeScreen welcomeScreen;
    CreateUserScreen createUserScreen;
    LogInScreen logInScreen;
    UserMenuScreen userMenu;
    EnterExpenseScreen enterExpenseScreen;
    ShowExpensesScreen showExpensesScreen;
    EditExpenseScreen editExpenseScreen;
    
    
    
    
    @Override
    public void start(Stage stage){
        
       try{ 
       init();
       }catch(SQLException e){
           System.out.println("Error occurred while running init ");
       }
       //Application's welcome view
       
       welcomeScreen.buildWelcomeScreen();
       Scene welcomeScene = new Scene(welcomeScreen.welcomeScreen);
       
        
       
       //The view where a new user is created
       
       createUserScreen.buildCreateUserScreen();
       Scene signUpScene = new Scene(createUserScreen.createUserScreen);
       
       
       
       // The view to log in
       
       logInScreen.buildLoginScreen();
       Scene logInScene = new Scene(logInScreen.logInScreen);
       
        
       // The user's personal home screen
       
       userMenu.buildUserMenuScreen();
       Scene userMenuScene = new Scene(userMenu.userMenu);
       
       //The view where a new expense is created
       

        enterExpenseScreen.buildEnterExpenseScreen();
        Scene addExpenseScene = new Scene(enterExpenseScreen.enterExpenseScreen);
        
        
        
        // The view where user can view entered expenses
        
        showExpensesScreen.buildShowExpenseScreen(pieChart);
        Scene showExpenseScene = new Scene(showExpensesScreen.showExpensesScreen);
        
        
        //The view where user can edit entered objects
       
        editExpenseScreen.buidlEditExpenseScreen();
        Scene editExpensesScene = new Scene(editExpenseScreen.editExpensesScreen);
        
        
        
        
        
        // The functionalities of the buttons used in the program can be found here
        
        
        
        
        //Button to create the new expense
        enterExpenseScreen.sendbutton.setOnAction((event)->{
            
            if(enterExpenseScreen.typetext.getText().isEmpty()){
                enterExpenseScreen.errorText.setText("Type info is missing");
            }else{    
            
           try {
               enterExpenseScreen.errorText.setText("");
               daoService.createExpense(enterExpenseScreen.amounttext.getText(), enterExpenseScreen.typetext.getText(), String.valueOf(currentId));
               enterExpenseScreen.errorText.setText("");
           } catch (Exception ex) {
               
               enterExpenseScreen.errorText.setText("Error occurred while creating expense");
           }
            }
           enterExpenseScreen.amounttext.clear();
            
        });
        
        
        
        enterExpenseScreen.button.setOnAction((event)->{
            pieChart.getData().clear();
            showExpensesScreen.expenses.setText("");         
            stage.setScene(showExpenseScene);

        });
        
        
       
        welcomeScreen.signInButton.setOnAction((event)->{
            stage.setScene(logInScene);
        });     
        
        welcomeScreen.signUpButton.setOnAction((event)->{
            stage.setScene(signUpScene);
        });          
        
        //Button to create the new user
        
        createUserScreen.createUserButton.setOnAction((event)->{
            try{
                if(!(createUserScreen.createNameTextField.getText().isEmpty()) && !(createUserScreen.createPasswordTextField.getText().isEmpty()) && !(createUserScreen.createUsernameTextField.getText().isEmpty())){
                createUserScreen.createUserErrorLabel.setText("");
                daoService.createUser(createUserScreen.createNameTextField.getText(), createUserScreen.createUsernameTextField.getText(), createUserScreen.createPasswordTextField.getText());
                }else{
                    createUserScreen.createUserErrorLabel.setText("Fill all text fields");
                }
                
            }catch(Exception e){
                createUserScreen.createUserErrorLabel.setText("Error while creating user");
            }
            createUserScreen.createUsernameTextField.clear();
            createUserScreen.createPasswordTextField.clear();
            createUserScreen.createNameTextField.clear();
        });    
        
        //Program login button
        
        logInScreen.loginButton.setOnAction((event)->{
            try{
                logInScreen.loginErrorLabel.setText("");
                int loginId=daoService.loginUser(logInScreen.usernameTextField.getText(), logInScreen.passwordField.getText()); 
                logInScreen.usernameTextField.clear();
                logInScreen.passwordField.clear();
                User user = daoService.readUser(loginId);
                stage.setScene(userMenuScene);
                currentId = user.getId();
                userMenu.currentUserId.setText(String.valueOf(user.getId()));
                userMenu.currentName.setText(user.getName());
                
            }catch(Exception e){
                logInScreen.loginErrorLabel.setText("Invalid username or password");
            }
        });
        
        userMenu.expenseMenuButton.setOnAction((event)->{
            enterExpenseScreen.expenseUser.setText(userMenu.currentName.getText());
            stage.setScene(addExpenseScene);
        });
        
        // Button to show all expenses
        showExpensesScreen.showButton.setOnAction((event)->{
           try {
               getPieChartData(currentId);
           } catch (SQLException ex) {
               showExpensesScreen.showExpensesErrorLabel.setText("Error while creating diagram");
           }
        });
        
        //Button to show expenses by type
        showExpensesScreen.showByTypeButton.setOnAction((event)->{
            try{
                showExpensesScreen.showExpensesErrorLabel.setText("");
               String StringToAdd = daoService.listExpense(showExpensesScreen.showByTypeLabel.getText(), currentId);
               showExpensesScreen.expenses.setText(StringToAdd);
            }catch(Exception e){
                showExpensesScreen.showExpensesErrorLabel.setText("Error occurred while listing expenses");
            }
        });
        
        //Button to show sum of all expenses
        showExpensesScreen.showAllExpensesButton.setOnAction((event)->{
            try{
                showExpensesScreen.showExpensesErrorLabel.setText("");
                showExpensesScreen.sumExpensesLabel.setText("Total sum of expenses: " + daoService.totalSumOfExpenses(currentId));
                
            }catch(Exception e){
                showExpensesScreen.showExpensesErrorLabel.setText("Error while summing");
            }
        
        });
        

        
        showExpensesScreen.backToFirstPage.setOnAction((event)->{
            showExpensesScreen.expenses.setText("");
            showExpensesScreen.sumExpensesLabel.setText("");
            userMenu.currentUserId.setText(String.valueOf(currentId));
           try {
              userMenu.currentName.setText(daoService.readUser(currentId).getName());
           } catch (SQLException ex) {
               userMenu.welcomeUserErrorLabel.setText("Missing id, please log out");
           }
            
            stage.setScene(userMenuScene);
            
        });
        

        
        userMenu.viewExpensesButton.setOnAction((event)->{
            showExpensesScreen.expenses.setText("");
            showExpensesScreen.showExpensesErrorLabel.setText("");
            pieChart.getData().clear();        
            try{
                getPieChartData(currentId);
            }catch(Exception e){
                showExpensesScreen.showExpensesErrorLabel.setText("Error occurred while listing expenses");
            }            
            stage.setScene(showExpenseScene);
           
        }); 
        
        showExpensesScreen.toEditExpenseButton.setOnAction((event)->{
            showExpensesScreen.expenses.setText("");
            showExpensesScreen.sumExpensesLabel.setText("");
            stage.setScene(editExpensesScene);
        try {
            editExpenseScreen.expenseListView.getItems().clear();
            editExpenseScreen.expenseListView.getItems().addAll(daoService.listAllExpenses(currentId));
        } catch (SQLException ex) {
            
        }            
            
        });
        
        //Button to remove desired expense
        
        editExpenseScreen.removeExpenseButton.setOnAction((event)->{
            editExpenseScreen.expenseListView.getItems().clear();
            
           try {
               daoService.deleteExpense(Integer.valueOf(editExpenseScreen.deletedOne.getText()));
               editExpenseScreen.expenseListView.getItems().addAll(daoService.listAllExpenses(currentId));
           } catch (SQLException e) {
               
           } catch(NumberFormatException ex){
               
           }
                    
        });
        
        
        editExpenseScreen.returnBackButton.setOnAction((event)->{
            showExpensesScreen.showExpensesErrorLabel.setText("");
            editExpenseScreen.expenseListView.getItems().clear();
            pieChart.getData().clear();
           try {            
               getPieChartData(currentId);
           } catch (SQLException ex) {
              showExpensesScreen.showExpensesErrorLabel.setText("Error while creating diagram");
           }
            stage.setScene(showExpenseScene);
        });

        logInScreen.backToStartButton.setOnAction((event)->{
            stage.setScene(welcomeScene);
        });
        
        createUserScreen.returnToStartButton.setOnAction((event)->{
            stage.setScene(welcomeScene);
        });
        
        enterExpenseScreen.backToUsermenuButton.setOnAction((event)->{
            
            userMenu.currentUserId.setText(String.valueOf(currentId));
            userMenu.currentName.setText(enterExpenseScreen.expenseUser.getText());
            stage.setScene(userMenuScene);
        });
        
        //Button to log out of system
        userMenu.logoutUserMenuButton.setOnAction((event)->{
            currentId = null;
            userMenu.currentUserId.setText(null);
            userMenu.currentName.setText(null);
            enterExpenseScreen.expenseUser.setText(null);
            
            stage.setScene(welcomeScene);
        });
        
        
        stage.setScene(welcomeScene);
        stage.show();
    }
    
    private void getPieChartData(int id) throws SQLException {
        
        pieChart.getData().clear();
        List<Expense> expensesOnTheList = daoService.listAllExpenses(id);
        double housing = 0;
        double freetime = 0;
        double traveling = 0;
        double shopping = 0;
        double food = 0;
        double other = 0;
        for(Expense e: expensesOnTheList){
            if(e.getType().equals("housing")){
                housing += e.getAmount();
            }
            if(e.getType().equals("leisure activities")){
                freetime += e.getAmount();
            }
            if(e.getType().equals("shopping")){
                shopping += e.getAmount();
            }
            if(e.getType().equals("food")){
                food += e.getAmount();
            }
            if(e.getType().equals("traveling")){
                traveling += e.getAmount();
            }
            if(e.getType().equals("other")){
                other += e.getAmount();
            }            
        }
        ObservableList<PieChart.Data> pieChartData=
                FXCollections.observableArrayList(
                new PieChart.Data("Housing", housing),
                new PieChart.Data("Leisure activities", freetime),
                new PieChart.Data("Food", food),
                new PieChart.Data("Traveling", traveling),
                new PieChart.Data("Other", other),
                new PieChart.Data("Shopping", shopping));

        pieChart.getData().addAll(pieChartData);        

    }
    
    /**
     * This method initializes daoService and pieChart object
     * 
     * @throws SQLException 
     */
    public void init() throws SQLException {
        
        daoService= new DaoService();
        daoService.createTablesDao();
        pieChart = new PieChart();
        welcomeScreen = new WelcomeScreen();
        createUserScreen = new CreateUserScreen();
        logInScreen = new LogInScreen();
        userMenu= new UserMenuScreen();
        enterExpenseScreen = new EnterExpenseScreen();
        showExpensesScreen = new ShowExpensesScreen();
        editExpenseScreen = new EditExpenseScreen();
    }
    
    
    public static void main(String[] args) throws SQLException {
        
        
        launch(args);
    }

}
