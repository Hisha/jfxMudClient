package com.HishaTech.java.jfxMudClient.gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class Navigation {

	public static Controller_Main controllerMain;
	public static final String MainVista = GUIConstants.fxml_Main;
	public static final String GameScreenVista = GUIConstants.fxml_GameScreen;

	public static void setController(Controller_Main controllerMain) {

		Navigation.controllerMain = controllerMain;

	}

	public static void loadDTVista(String fxml) {

		try {

			controllerMain.setVista((Node) FXMLLoader.load(Navigation.class
					.getResource(fxml)));

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}