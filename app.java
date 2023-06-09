package com.enterprise.payrollsystem;

import utils.Seed;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        SceneController sceneController = SceneController.getInstance();
        sceneController.setStage(primaryStage);

        sceneController.loadScene(DASHBOARD_SCENE, "/com/enterprise/payrollsystem/dashboard.fxml");
        sceneController.loadScene(ADD_EMPLOYEE_SCENE, "/com/enterprise/payrollsystem/AddEmployee.fxml");
        sceneController.loadScene(CREATE_PAYROLL_SCENE, "/com/enterprise/payrollsystem/CreatePayroll.fxml");
        sceneController.loadScene(LIST_PAYROLLS_SCENE, "/com/enterprise/payrollsystem/list_payrolls.fxml");
        sceneController.loadScene(VIEW_PAYROLL_SCENE, "/com/enterprise/payrollsystem/view_payroll.fxml");
        sceneController.loadScene(LOGIN_SCENE, "/com/enterprise/payrollsystem/Login.fxml");
        sceneController.loadScene(REGISTER_SCENE, "/com/enterprise/payrollsystem/Register.fxml");
        sceneController.switchScene(LOGIN_SCENE);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    public static final String LOGIN_SCENE = "Login";
    public static final String REGISTER_SCENE = "Register";
    public static final String DASHBOARD_SCENE = "dashboard";
    public static final String ADD_EMPLOYEE_SCENE = "addemployee";
    public static final String CREATE_PAYROLL_SCENE = "create_payroll";
    public static final String LIST_PAYROLLS_SCENE = "list_payrolls";
    public static final String VIEW_PAYROLL_SCENE = "view_payroll";
}
