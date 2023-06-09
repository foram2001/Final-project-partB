package com.enterprise.payrollsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.User;
import utils.Operations;

public class RegisterController implements SceneController.SceneControllerLifecycle{
    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField roleField;

    @FXML
    protected void register(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String role = roleField.getText();

        User user = new User(0, username, password, role);

        Operations.register(user);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Successfully registered");
        alert.showAndWait();
    }

    @FXML
    protected void navigateToLogin(ActionEvent event) {
        SceneController.getInstance().switchScene(App.LOGIN_SCENE);
    }

    @Override
    public void onShowing() {
       
    }

    @Override
    public void onHiding() {
        
    }
}