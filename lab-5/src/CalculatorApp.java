//STARTER CODE
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Step 1: Create TextFields for input
        TextField userInput1 = new TextField();
        TextField userInput2 = new TextField();

        // Step 2: Create Buttons for operations
        Button addBtn = new Button("+");
        Button subtractBtn = new Button("-");
        Button multiplyBtn = new Button("*");
        Button divideBtn = new Button("/");
        // Step 3: Create Label for result
        Label resultText = new Label("Result: ");
        Label result = new Label();
        // Step 4: HBox for buttons
        HBox buttonsHbox = new HBox(10);
        buttonsHbox.getChildren().addAll(addBtn,subtractBtn,multiplyBtn,divideBtn);

        // Step 4a: also created hbox for user input
        HBox inputHbox = new HBox(20);
        inputHbox.getChildren().addAll(userInput1, userInput2);

        // Step 4b: created hbox for result and result text
        HBox resultHbox = new HBox(20);
        resultHbox.getChildren().addAll(resultText, result);
        // Step 5: VBox main layout
        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(inputHbox,buttonsHbox,resultHbox);
        // Step 6: Event handling for buttons
        addBtn.setOnAction(e -> {
            String input1 = userInput1.getText();
            String input2 = userInput2.getText();
            if(input1.isEmpty() || input2.isEmpty()) {
                result.setText("Input cannot be empty");
            } else {
                try {
                    int num1 = Integer.parseInt(input1);
                    int num2 = Integer.parseInt(input2);
                    result.setText(String.valueOf(num1 + num2));
                } catch (NumberFormatException err) {
                    result.setText("Input must contain only numbers!");
                }
            }
        });
        // Step 7: Create scene and show stage
        Scene scene = new Scene(vbox, 300, 350);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

//TASKS TO COMPLETE(SUBMIT SCREENSHOTS FOR ALL TASKS)

//TODO:Enter numbers in the two TextFields.

//TODO:Click any operation button to see the result in the Label.

//TODO:Test for division by zero.

//TODO:Try entering invalid input (letters) and observe program behavior (optional: you can handle exceptions for invalid input).

/*
EXPECTED OUTPUT:
Example 1:

Input1: 10
Input2: 5
Click '+'
Result: 15.0


Example 2:

Input1: 8
Input2: 0
Click '/'
Result: Error: Division by zero


Example 3:

Input1: 7
Input2: 3
Click '*'
Result: 21.0*/
