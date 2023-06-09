package com.enterprise.payrollsystem;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.User;
import utils.Operations;

public class LoginController implements SceneController.SceneControllerLifecycle{
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    protected void login(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = Operations.verifyUser(username, password);

        if (user == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid username or password");
            alert.showAndWait();
        } else {
        
            SceneController.getInstance().switchScene(App.DASHBOARD_SCENE);
        }
    }

    @FXML
    protected void navigateToRegister(ActionEvent event) {
   SceneController.getInstance().switchScene(App.REGISTER_SCENE);
    }
    
       @Override
    public void onShowing() {
       
    }

    @Override
    public void onHiding() {
        
    }
    
}