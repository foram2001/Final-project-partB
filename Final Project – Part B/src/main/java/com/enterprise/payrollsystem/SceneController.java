package com.enterprise.payrollsystem;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneController {

    private Map<String, Scene> scenes = new HashMap<>();
    private Map<String, SceneControllerLifecycle> controllers = new HashMap<>();
    private static Stage stage;
    private Scene currentScene;
    private static SceneController instance;

    public static SceneController getInstance() {
        if (instance == null) {
            instance = new SceneController();
        }
        return instance;
    }
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void addScene(String name, Scene scene, SceneControllerLifecycle controller) {
        scenes.put(name, scene);
        controllers.put(name, controller);
    }

    public void removeScene(String name) {
        scenes.remove(name);
        controllers.remove(name);
    }

  public void switchScene(String name) {
    SceneControllerLifecycle previousController = controllers.get(getSceneName(currentScene));
    SceneControllerLifecycle nextController = controllers.get(name);
    if (previousController != null) {
        previousController.onHiding();
    }
    if (nextController != null) {
        nextController.onShowing();
    }
    stage.setScene(scenes.get(name));
    currentScene = scenes.get(name);
}

// This is a helper method to reverse lookup the name of a scene.
// Assumes that scene names are unique.
private String getSceneName(Scene scene) {
    for (Map.Entry<String, Scene> entry : scenes.entrySet()) {
        if (entry.getValue().equals(scene)) {
            return entry.getKey();
        }
    }
    return null;  // Or throw an exception.
}
    public Scene loadScene(String name, String resource) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        SceneControllerLifecycle controller = loader.getController();
        addScene(name, scene, controller);
        return scene;
    }

    public interface SceneControllerLifecycle {
        void onShowing();
        void onHiding();
    }
}