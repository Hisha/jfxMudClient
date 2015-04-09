package com.HishaTech.java.jfxMudClient.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;

public class Controller_Main {

	@FXML
	public MenuBar menuBar;
	public Menu FileMenu;
	public MenuItem FileMenu_Exit;
	public StackPane mainHolder;

	// ***** Start File Menu Section ***** //
	// *********************************** //

	@FXML
	public void handleExitAction(final ActionEvent event) {

		System.exit(0);

	}

	// ***** End File Menu Section ***** //
	// ********************************* //

	public void initialize() {

		setMenuText();
		menuBar.setFocusTraversable(true);

	}

	private void setMenuText() {

		// File Menu Section
		FileMenu.setText(GUIConstants.FileMenu);

		FileMenu_Exit.setText(GUIConstants.FileMenu_Exit);

	}

	/**
	 * Replaces the vista displayed in the vista holder with a new vista.
	 *
	 * @param node
	 *            the vista node to be swapped in.
	 */
	public void setVista(Node node) {

		mainHolder.getChildren().setAll(node);

	}

}
