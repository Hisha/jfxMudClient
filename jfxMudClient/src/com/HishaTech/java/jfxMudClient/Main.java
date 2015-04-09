package com.HishaTech.java.jfxMudClient;

import java.io.IOException;
import java.net.URL;

import com.HishaTech.java.jfxMudClient.gui.Controller_Main;
import com.HishaTech.java.jfxMudClient.gui.GUIConstants;
import com.HishaTech.java.jfxMudClient.gui.Navigation;

import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {

		Stage stage = new Stage();
		stage.setScene(createScene(loadMainPane()));
		stage.show();

	}

	private Scene createScene(Pane mainPane) {

		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		Double sceneHeight = visualBounds.getHeight();
		Double sceneWidth = visualBounds.getWidth();
		Scene scene = new Scene(mainPane, sceneWidth, sceneHeight);
		scene.getStylesheets().add(
				getClass().getResource("css/application.css").toExternalForm());
		return scene;

	}

	private Pane loadMainPane() throws IOException {

		URL url = getClass().getResource(GUIConstants.fxml_Main);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(url);
		Pane dtPane = (Pane) loader.load(url.openStream());
		Controller_Main mainController = loader.getController();
		Navigation.setController(mainController);
		Navigation.loadDTVista(GUIConstants.fxml_GameScreen);
		return dtPane;

	}

	public static void main(String[] args) {

		launch(args);

	}

}