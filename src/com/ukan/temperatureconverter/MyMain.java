package com.ukan.temperatureconverter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	@Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
	    VBox rootNode =  loader.load();

	    MenuBar menuBar = createMenu();
	    rootNode.getChildren().addAll(menuBar);

	    Scene scene = new Scene(rootNode, 300, 275);

	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Temperature Convertor");
	    primaryStage.show();
    }

    private MenuBar createMenu(){

		//File Menu
	    Menu fileMenu =  new Menu("File");
	    MenuItem newMenuItem = new MenuItem("New");

	    newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

	    SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
	    MenuItem quitMenuItem = new MenuItem("Quit");

	    quitMenuItem.setOnAction(event -> {
		    Platform.exit();
		    System.exit(0);
	    });
	    fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

	    //Help Menu
	    Menu helpMenu = new Menu("Help");
	    MenuItem aboutApp = new MenuItem("About");

	    aboutApp.setOnAction(event -> aboutApp());

	    helpMenu.getItems().addAll(aboutApp);


	    //Menu Bar
	    MenuBar menuBar = new MenuBar();
	    menuBar.getMenus().addAll(fileMenu, helpMenu);

	    return menuBar;

    }

	private void aboutApp() {

		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("Temperature Convertor Tool");
		alertDialog.setHeaderText("Convert Temperature");
		alertDialog.setContentText("Convert temperature from Celsius to Fahrenheit or vice-versa");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn =  new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

		if(clickedBtn.isPresent() && clickedBtn.get()== yesBtn){
			System.out.println("Yes Btn is clicked");
		} else {
			System.out.println("No Btn is Clicked");
		}

	}

	@Override
	public void stop() throws Exception {
		super.stop();
	}
}
