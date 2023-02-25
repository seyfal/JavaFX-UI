import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * This is a template JavaFX application that demonstrates how to use a BorderPane layout to create a simple UI with two
 * buttons and two text fields. The user can enter text in the center text field, and when they click button 1, the text
 * is appended with a message and displayed in the right text field. Clicking button 2 clears the center text field and
 * resets the right text field to its initial value.
 */
public class JavaFXTemplate extends Application {

	/**
	 * The main method of the application, which launches the JavaFX application by calling the start method.
	 *
	 * @param args an array of command-line arguments, which are not used in this application.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * The start method of the application, which creates and displays the UI window.
	 *
	 * @param primaryStage the primary stage of the application, which is the top-level window.
	 * @throws Exception if an error occurs while creating or displaying the UI.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		// set the title to be Seyfal Sultanov Homework 3
		primaryStage.setTitle("Seyfal Sultanov Homework 3");

		// Create the UI layout using a BorderPane and two VBox containers.
		BorderPane borderPane = new BorderPane();
		VBox vBox = new VBox();

		// Create two text fields and two buttons to add to the UI layout.
		TextField centerTextField = new TextField();
		TextField rightTextField = new TextField();
		Button button1 = new Button("button 1");
		Button button2 = new Button("button 2");

		// Set some properties of the text fields and buttons.
		centerTextField.setPromptText("enter text here then press button 1");
		rightTextField.setEditable(false);
		rightTextField.setText("final string goes here");

		// Add the buttons to the VBox container and set the alignment of the VBox to center.
		vBox.getChildren().addAll(button1, button2);
		borderPane.setLeft(vBox);
		borderPane.setCenter(centerTextField);
		borderPane.setRight(rightTextField);
		vBox.setAlignment(Pos.CENTER);

		// Define the event handlers for the button 1.
		button1.setOnAction(event -> {
			String text = centerTextField.getText();
			String newText = text + " : from the center text field!";
			rightTextField.setText(newText);
			button1.setDisable(true);
			button1.setText("pressed");
		});

		// Define the event handlers for the button 2.
		button2.setOnAction((event) -> {
			centerTextField.clear();
			rightTextField.setText("new final string goes here");
			button1.setDisable(false);
			button1.setText("button 1");
		});

		// Set some style properties for the UI layout, text fields, and buttons.
		borderPane.setStyle("-fx-background-color: #c2a427;");
		vBox.setPadding(new Insets(10));
		borderPane.setPadding(new Insets(20));
		vBox.setSpacing(10);
		button1.setStyle("-fx-margin: 10;");
		button2.setStyle("-fx-margin: 10;");
		button1.setStyle("-fx-font-size: 16;");
		button2.setStyle("-fx-font-size: 16;");
		centerTextField.setStyle("-fx-font-size: 16;");
		rightTextField.setStyle("-fx-font-size: 16;");

		Scene scene = new Scene(borderPane, 700, 700);
		scene.getRoot().setStyle("-fx-font-family: 'serif'"); // this line
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
