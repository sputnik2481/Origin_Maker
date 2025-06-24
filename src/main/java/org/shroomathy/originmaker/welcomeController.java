package org.shroomathy.originmaker;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.io.*;
import java.util.Objects;


public class welcomeController{
    public Label switchToScene2;
    public TextField powerName;
    public TextField fileName;
    public TextField codeTyping;
    public TextField error;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private char q = '"';
    private static String fileNames;
    private static String powerNames;
    public String codeType;
    public static char errorType;
    public static String powerDesc;

    public static String userInputs;

    public int onLine;

    public static String errorOutput;

    public TextField userInput;

    public TextField xValue;
    public TextField yValue;
    public TextField zValue;

    private final StringProperty text = new SimpleStringProperty();

    private StringProperty title = new SimpleStringProperty(this, "title", "");

    private static String powerCodeName;

    public Stage codeStage;

    public static String[] codeTypingArray = new String[100];
    public static String[] correctCode = new String[100];

    @FXML
    public Label codeToType;
    @FXML
    public Label codeToType0;
    @FXML
    public Label codeToType1;
    @FXML
    public Label codeToType2;
    @FXML
    public Label codeToType3;
    @FXML
    public Label codeToType4;
    @FXML
    public Label codeToType5;
    @FXML
    public Label codeToType6;
    @FXML
    public Label errorScreen;
    @FXML
    public Label oldCode;

    public static void setFileName(String name) {
        fileNames = name;
    }

    public  void setLine(int line) {
        onLine = line;
    }

    public int getLine() {return onLine;}

    public static String getFileName() {
        return fileNames;
    }

    public static void setPowerDes(String desc) {
        powerDesc = desc;
    }

    public static String getPowerDesc() {
        return powerDesc;
    }

    public static void setError(String name) {
        errorOutput = name;
    }

    public static String getErrorCode() {return errorOutput;}

    public static void setUserInput(String input) {
        userInputs = input;
    }

    public static String getUserInput() {
        return userInputs;
    }

    public static void setPowerName(String name) {
        powerNames = name;
    }

    public static String getPowerName() {
        return powerNames;
    }

    public static void setCodeTyping(String code, int line) {
        codeTypingArray[line] = code;
    }

    public static void setCorrectCode(String code, int line) {
        correctCode[line] = code;
    }

    public String getCorrectCode(int line){
        return correctCode[line];
    }

    public String getCodeTyping(int line){
        return codeTypingArray[line];
    }

    public void setErrorScreen(char error) {
        errorType = error;
    }

    public char getError(){
        return errorType;
    }

    public String getCodeTyping() {
        return codeType;
    }

    public static void setCodePowerName(String name) {
        powerCodeName = name;
    }

    public static String getCodePowerName() {
        return powerCodeName;
    }

    public void setCode(String name) {
        powerNames = name;
    }

    public String getCodeToType() {
        return toStrings("codeTyping",0);
    }
    public String getCodeToType0() {
        return toStrings("codeTyping",1);
    }
    public String getCodeToType1() {
        return toStrings("codeTyping",2);
    }
    public String getCodeToType2() {
        return toStrings("codeTyping",3);
    }
    public String getCodeToType3() {
        return toStrings("codeTyping",4);
    }
    public String getCodeToType4() {
        return toStrings("codeTyping",5);
    }
    public String getCodeToType5() {
        return toStrings("codeTyping",6);
    }
    public String getCodeToType6() {
        return toStrings("codeTyping",7);
    }

    public String getErrorScreen() {
        return(toStrings("errorMessage",0));
    }
    public String getOldCode() {
        return(toStrings("oldCode",0));
    }


    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void welcomeScreen(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("welcomeScreen.fxml")));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToScene2(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fileNamingScreen.fxml")));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene3(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        if(userInput != null) {
            String name = userInput.getText();
            String noSpaces = name.replaceAll("\\s","_");
            Boolean inputCheck = checkForError(noSpaces, "numAndAlph");
            if (!inputCheck) {
                setUserInput(noSpaces);
                String userInputs = noSpaces + ".json";

                createDoc(userInputs);
                setFileName(userInputs);

                System.out.print(getFileName());
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("powerNamingScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {
                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                System.out.print(errorScreen);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fileNamingErrorScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }
    public void switchToScene4(javafx.event.ActionEvent actionEvent) throws IOException {
        if(userInput != null) {
            String name = userInput.getText();
            setPowerName(name);

            String fileName = getFileName();

            appendDoc(name, fileName,0);

            String codeForType = ('"'+ "name"+'"'+ ':'+' ' + '"' +name+ '"'+',');

           setCodePowerName(codeForType);

           setCodeTyping(codeForType,0);

            Label label = new Label(codeForType);

            codeToType = label;

            label.setLabelFor(codeToType);

            System.out.print(codeToType);

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("codeTypingPracticeScreen.fxml")));
            stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void switchToScene5(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code,0);
            setUserInput(code);
            if (Objects.equals(inputCheck, true)) {

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("powerDescriptionScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String errorMessage = "Your code has an error";

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("codeTypingPracticeErrorScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene6(javafx.event.ActionEvent actionEvent) throws IOException {
        if(userInput != null) {
            String desc = userInput.getText();
            setPowerDes(desc);

            String fileName = getFileName();

            appendDoc(desc, fileName,1);

            String codeForDesc = ('"'+ "description"+'"'+ ':'+' ' + '"' +desc+ '"'+',');

            setPowerDes(codeForDesc);

            setCodeTyping(codeForDesc,1);

            Label label = new Label(codeForDesc);

            label.setLabelFor(codeToType0);

            System.out.print(codeToType0);

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("codeTypingPracticeDescriptionScreen.fxml")));
            stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void switchToScene7(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 0);
            setUserInput(code);
            if (Objects.equals(inputCheck, true)) {

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("codeTypingPracticeDescriptionScreenCorrect.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("codeTypingPracticeDescriptionErrorScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void switchToScene8(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 1);
            setUserInput(code);
            if (Objects.equals(inputCheck, true)) {

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("powerTypeSelection.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("codeTypingPracticeDescriptionErrorScreenLine2.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void actionOnKey(javafx.event.ActionEvent actionEvent) throws IOException {

        String keyL1 = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:active_self"+ '"'+',';
        setCodeTyping(keyL1, 2);
        appendDoc(keyL1, getFileName(), 3);
        String keyL2= '"'+ "entity_action"+'"'+ ':'+ "{";
        setCodeTyping(keyL2, 3);
        appendDoc(keyL2, getFileName(), 3);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("actionOnKeyPowers.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void actionOnHit(javafx.event.ActionEvent actionEvent) throws IOException {

        String actionOnHitL1 = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:action_on_hit"+ '"'+',';
        setCodeTyping(actionOnHitL1, 2);
        String actionOnHitL2 = '"'+ "bientity_action"+'"'+ ':'+ "{";
        setCodeTyping(actionOnHitL2, 3);
        appendDoc(actionOnHitL1, getFileName(), 2);
        appendDoc(actionOnHitL2, getFileName(), 2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("actionOnHitSelection.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
            stage.show();
    }
    public void passivePower(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("passivePowerSelection.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void fireProjectile(javafx.event.ActionEvent actionEvent) throws IOException {
        String projectileL1 = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:fire_projectile"+ '"'+',';
        String projectileL2 = '"'+ "entity_type"+'"'+ ':'+' '+ '"' +"minecraft:arrow"+ '"' + "},";
        appendDoc(projectileL1, getFileName(), 2);
        appendDoc(projectileL2, getFileName(), 2);
        setCodeTyping(projectileL1, 4);
        setCodeTyping(projectileL2, 5);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("keyChoice.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void speedBoost(javafx.event.ActionEvent actionEvent) throws IOException {
        String speedL1 = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:add_velocity"+ '"'+',';
        appendDoc(speedL1, getFileName(), 2);
        setCodeTyping(speedL1, 4);

        String speedL2 = '"'+ "z"+'"'+ ':'+' '+ 2 +"},";

        setCodeTyping(speedL2, 5);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("keyChoice.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void lightOnFire(javafx.event.ActionEvent actionEvent) throws IOException {
        String actionOnHitL1 = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:set_on_fire"+ '"'+',';
        appendDoc(actionOnHitL1, getFileName(), 2);
        setCodeTyping(actionOnHitL1, 4);



        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("keyChoice.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void launchSelf(javafx.event.ActionEvent actionEvent) throws IOException {
        String launchL1 = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:launch"+ '"'+',';
        String launchL2 = '"'+ "speed"+'"'+ ':'+' '+2+"},";

        appendDoc(launchL1, getFileName(), 2);
        setCodeTyping(launchL1, 4);

        appendDoc(launchL2, getFileName(), 2);
        setCodeTyping(launchL2, 5);


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("keyChoice.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void primaryKey(javafx.event.ActionEvent actionEvent) throws IOException {
        String keyL1 = '"'+ "key"+'"'+ ':'+' '+ '{';
        String keyL2 = '"'+ "key"+'"'+ ':'+' '+'"'+ "key.origins.primary_active" + '"'+"}}";

        appendDoc(keyL1, getFileName(), 2);
        setCodeTyping(keyL1, 6);

        appendDoc(keyL2, getFileName(), 2);
        setCodeTyping(keyL2, 7);


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL1.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void secondaryKey(javafx.event.ActionEvent actionEvent) throws IOException {
        String keyL1 = '"'+ "key"+'"'+ ':'+' '+ '{';
        String keyL2 = '"'+ "key"+'"'+ ':'+' '+'"'+ "key.origins.secondary_active" + '"'+"}}";

        appendDoc(keyL1, getFileName(), 2);
        setCodeTyping(keyL1, 6);

        appendDoc(keyL2, getFileName(), 2);
        setCodeTyping(keyL2, 7);


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL1.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void lightOnFireDuration(javafx.event.ActionEvent actionEvent) throws IOException {
        if (userInput != null) {
            String duration = userInput.getText();
            Boolean inputCheck = checkForError(duration, "num");
            if (!inputCheck) {
                int dur = Integer.parseInt(duration);
                setDuration(dur, 5);

                Label label0 = new Label(getCorrectCode(2));

                label0.setLabelFor(codeToType1);

                Label label1 = new Label(getCorrectCode(3));

                label1.setLabelFor(codeToType2);

                Label label2 = new Label(getCorrectCode(4));

                label2.setLabelFor(codeToType3);

                Label label3 = new Label(getCorrectCode(5));

                label3.setLabelFor(codeToType4);

                System.out.print(codeToType4);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL1.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {
                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL1Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void CodeCheckL1(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        System.out.print(getCodeTyping(2) + "correct Code YAY");
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 2);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL2.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL1Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }
    public void CodeCheckL2(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        System.out.print(getCodeTyping(3) + "correct Code YAY");
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 3);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL3.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL2Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void CodeCheckL3(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        System.out.print(getCodeTyping(4) + "correct Code YAY");
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 4);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL4.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL3Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void CodeCheckL4(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        System.out.print(getCodeTyping(5) + "correct Code YAY");
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 5);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL5.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL4Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void CodeCheckL5(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        System.out.print(getCodeTyping(6) + "correct Code YAY");
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 6);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL6.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL5Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void CodeCheckL6(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        System.out.print(getCodeTyping(7) + "correct Code YAY");
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 7);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("endScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TypingPracticeL6Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void fourLineCodeCheckL1(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        System.out.print(getCodeTyping(2) + "correct Code YAY");
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 2);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL2.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL1Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }
    public void fourLineCodeCheckL2(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 3);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL3.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL2Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void fourLineCodeCheckL3 (javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 4);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL4.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL3Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void fourLineCodeCheckL4 (javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 5);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("endScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL4Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void applyEffect(javafx.event.ActionEvent actionEvent) throws IOException {

        String actionOnHitL1 = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:apply_effect"+ '"'+',';
        String actionOnHitL2 = '"'+ "effect"+'"'+ ':'+" {";
        appendDoc(actionOnHitL1, getFileName(), 2);
        appendDoc(actionOnHitL2, getFileName(), 2);
        setCodeTyping(actionOnHitL1, 2);
        setCodeTyping(actionOnHitL2, 3);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chooseEffect.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void effectDuration(javafx.event.ActionEvent actionEvent) throws IOException {
        if (userInput != null) {
            String duration = userInput.getText();
            Boolean inputCheck = checkForError(duration, "num");
            if (!inputCheck) {
                setDuration(Integer.parseInt(duration), 5);

                Label label0 = new Label(getCorrectCode(2));

                label0.setLabelFor(codeToType1);

                Label label1 = new Label(getCorrectCode(3));

                label1.setLabelFor(codeToType2);

                Label label2 = new Label(getCorrectCode(4));

                label2.setLabelFor(codeToType3);

                Label label3 = new Label(getCorrectCode(5));

                label3.setLabelFor(codeToType4);

                System.out.print(codeToType1);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL1.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {
                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("applyEffectDurationErrorScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void slowness(javafx.event.ActionEvent actionEvent) throws IOException {
        String slowness = '"'+ "effect"+'"'+ ':'+' '+ '"' +"minecraft:slowness"+ '"'+',';

        appendDoc(slowness, getFileName(), 4);

        setCodeTyping(slowness,4);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("applyEffectDuration.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

    }

    public void nausea(javafx.event.ActionEvent actionEvent) throws IOException {
        String nausea = '"'+ "effect"+'"'+ ':'+' '+ '"' +"minecraft:nausea"+ '"'+',';

        appendDoc(nausea, getFileName(), 4);

        setCodeTyping(nausea,4);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("applyEffectDuration.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    public void poison(javafx.event.ActionEvent actionEvent) throws IOException {
        String poison = '"'+ "effect"+'"'+ ':'+' '+ '"' +"minecraft:poison"+ '"'+',';

        appendDoc(poison, getFileName(), 4);

        setCodeTyping(poison,4);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("applyEffectDuration.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    public void wither(javafx.event.ActionEvent actionEvent) throws IOException {
        String wither = '"'+ "effect"+'"'+ ':'+' '+ '"' +"minecraft:wither"+ '"'+',';

        appendDoc(wither, getFileName(), 4);

        setCodeTyping(wither,4);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("applyEffectDuration.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

        public void launchIntoAir(javafx.event.ActionEvent actionEvent) throws IOException {

            String launch = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:add_velocity"+ '"'+',';

            appendDoc(launch, getFileName(), 2);

            setCodeTyping(launch,2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("selectSpeed.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void selectSpeed(javafx.event.ActionEvent actionEvent) throws IOException {
        if (xValue != null && yValue != null && zValue != null  ) {
            String xValues = xValue.getText();
            String yValues = yValue.getText();
            String zValues = zValue.getText();
            System.out.print(xValues +yValues+zValues + "VALUES");
            Boolean inputCheckX = checkForError(xValues, "num");
            Boolean inputCheckY = checkForError(yValues, "num");
            Boolean inputCheckZ = checkForError(zValues, "num");

            if(!inputCheckX && !inputCheckY && !inputCheckZ){
                speedToString(xValues,yValues,zValues,3);

                Label label0 = new Label(getCorrectCode(2));

                label0.setLabelFor(codeToType1);

                Label label1 = new Label(getCorrectCode(3));

                label1.setLabelFor(codeToType2);

                Label label2 = new Label(getCorrectCode(4));

                label2.setLabelFor(codeToType3);

                Label label3 = new Label(getCorrectCode(5));

                label3.setLabelFor(codeToType4);

                System.out.print(codeToType1);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fourLineCodeTypingPracticeL1.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            else{
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("selectSpeedErrorScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();

        }
    }

    public void flightPassivePower(javafx.event.ActionEvent actionEvent) throws IOException {

        String flight = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:elytra_flight"+ '"'+',';

        appendDoc(flight, getFileName(), 2);

        setCodeTyping(flight,2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("renderElytra.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void renderElytra(javafx.event.ActionEvent actionEvent) throws IOException {
        String renderElytra = '"'+ "render_elytra"+'"'+ ':'+' '+ "true" + '}';

        appendDoc(renderElytra, getFileName(), 2);

        setCodeTyping(renderElytra,3);

        Label label0 = new Label(getCorrectCode(2));

        label0.setLabelFor(codeToType1);

        Label label1 = new Label(getCorrectCode(3));

        label1.setLabelFor(codeToType2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL1.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void dontRenderElytra(javafx.event.ActionEvent actionEvent) throws IOException {
        String renderElytra = '"'+ "render_elytra"+'"'+ ':'+' '+ "false"+'}';

        appendDoc(renderElytra, getFileName(), 2);

        setCodeTyping(renderElytra,3);

        Label label0 = new Label(getCorrectCode(2));

        label0.setLabelFor(codeToType1);

        Label label1 = new Label(getCorrectCode(3));

        label1.setLabelFor(codeToType2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL1.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void invisPassivePower(javafx.event.ActionEvent actionEvent) throws IOException {

        String launch = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:invisibility"+ '"'+'}';

        appendDoc(launch, getFileName(), 2);

        setCodeTyping(launch,2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("renderArmor.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void renderArmor(javafx.event.ActionEvent actionEvent) throws IOException {
        String renderArmor = '"'+ "render_armor"+'"'+ ':'+' '+"true"+'}';

        appendDoc(renderArmor, getFileName(), 2);

        setCodeTyping(renderArmor,3);

        Label label0 = new Label(getCorrectCode(2));

        label0.setLabelFor(codeToType1);

        Label label1 = new Label(getCorrectCode(3));

        label1.setLabelFor(codeToType2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL1.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void dontRenderArmor(javafx.event.ActionEvent actionEvent) throws IOException {
        String renderArmor = '"'+ "render_armor"+'"'+ ':'+' '+"false"+'}';

        appendDoc(renderArmor, getFileName(), 2);

        setCodeTyping(renderArmor,3);

        Label label0 = new Label(getCorrectCode(2));

        label0.setLabelFor(codeToType1);

        Label label1 = new Label(getCorrectCode(3));

        label1.setLabelFor(codeToType2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL1.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void walkOnFliudPassivePower(javafx.event.ActionEvent actionEvent) throws IOException {

        String launch = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:walk_on_fluid"+ '"'+',';

        appendDoc(launch, getFileName(), 2);

        setCodeTyping(launch,2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fluidType.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void fluidWater(javafx.event.ActionEvent actionEvent) throws IOException {
        String fluidType = '"'+ "fluid"+'"'+ ':'+' '+'"' +"minecraft:water"+'"'+'}';

        appendDoc(fluidType, getFileName(), 2);

        setCodeTyping(fluidType,3);

        Label label0 = new Label(getCorrectCode(2));

        label0.setLabelFor(codeToType1);

        Label label1 = new Label(getCorrectCode(3));

        label1.setLabelFor(codeToType2);


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL1.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void fluidLava(javafx.event.ActionEvent actionEvent) throws IOException {
        String fluidType = '"'+ "fluid"+'"'+ ':'+' '+'"' +"minecraft:lava"+'"'+'}';

        appendDoc(fluidType, getFileName(), 2);

        setCodeTyping(fluidType,3);

        Label label0 = new Label(getCorrectCode(2));

        label0.setLabelFor(codeToType1);

        Label label1 = new Label(getCorrectCode(3));

        label1.setLabelFor(codeToType2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL1.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void nightVisionPassivePower(javafx.event.ActionEvent actionEvent) throws IOException {

        String launch = '"'+ "type"+'"'+ ':'+' '+ '"' +"origins:night_vision"+ '"'+',';

        appendDoc(launch, getFileName(), 2);

        setCodeTyping(launch,2);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("nightVisionStrength.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void nightVisionStrength(javafx.event.ActionEvent actionEvent) throws IOException {
        if(userInput != null) {
            String name = userInput.getText();
            setPowerName(name);

            String fileName = getFileName();

            appendDoc(name, fileName,3);

            String codeForType = ('"'+ "strength"+'"'+ ':'+' '  +name+'}');

            setCodePowerName(codeForType);

            setCodeTyping(codeForType,3);

            Label label0 = new Label(getCorrectCode(2));

            label0.setLabelFor(codeToType1);

            Label label1 = new Label(getCorrectCode(3));

            label1.setLabelFor(codeToType2);

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL1.fxml")));
            stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void twoLineCodeCheckL1(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        System.out.print(getCodeTyping(2) + "correct Code YAY");
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 2);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL2.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL1Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }

    public void twoLineCodeCheckL2(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.print(userInput);
        System.out.print(getCodeTyping(2) + "correct Code YAY");
        if(userInput != null) {
            String code = userInput.getText();
            Boolean inputCheck = checkForCorrectCode(code, 3);
            setUserInput(code);
            if (inputCheck) {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("endScreen.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            } else {

                String correctCode = getCodeToType();

                searchForError(code, correctCode);

                String errorMessage = "Your code has an error";

                Label errorLabel = new Label(errorMessage);

                errorScreen = errorLabel;

                errorLabel.setLabelFor(errorScreen);

                String oldCodeTyped = "Old Code";

                Label oldCodeLabel = new Label(oldCodeTyped);


                oldCode = oldCodeLabel;

                oldCodeLabel.setLabelFor(oldCode);

                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("twoLineCodeTypingPracticeL2Error.fxml")));
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
            }
            stage.setScene(scene);
            stage.show();
        }
    }
    public void speedToString(String x, String y, String z,int startingLine){
        String xToString = '"'+ "x"+'"' +":" + x+",";
        appendDoc(xToString, getFileName(), startingLine);
        setCodeTyping(xToString, startingLine);

        String yToString ='"'+ "y"+'"' +":" + y +",";
        appendDoc(yToString, getFileName(), startingLine+1);
        setCodeTyping(yToString, startingLine+1);

        String zToString = '"'+ "z"+'"'+":" + z + "}";
        appendDoc(zToString, getFileName(), startingLine+2);
        setCodeTyping(zToString, startingLine+2);
    }

    public void appendDoc(String value, String fileName, int type){
        if(type==0){
            String nameLine = ('"'+ "name"+'"'+ ':'+' ' + '"' +value+ '"'+',');
            try {
                FileWriter fw = new FileWriter(fileName, true);
                PrintWriter out = new PrintWriter(fw);
                out.println(nameLine);
                out.close();
            }catch (IOException _) {
            }
        }
        else if(type==1){
            String nameLine = ('"'+ "description"+'"'+ ':'+' ' + '"' +value+ '"'+',');
            try {
                FileWriter fw = new FileWriter(fileName, true);
                PrintWriter out = new PrintWriter(fw);
                out.println(nameLine);
                out.close();
            }catch (IOException _) {
            }
        }
        else{
            try {
                FileWriter fw = new FileWriter(fileName, true);
                PrintWriter out = new PrintWriter(fw);
                out.println(value);
                out.close();
            }catch (IOException _) {
            }
        }
    }

    public void createDoc(String name){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(name);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(name, true)));
            out.println("{");
            out.close();
            fileOutputStream.close();

            System.out.println("File created successfully.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String toStrings(String type,int line){
        if(Objects.equals(type, "codeTyping")){
            return getCodeTyping(line);
        }
        else if(Objects.equals(type, "errorMessage")){
            char error = getError();
            return  "The error was caused by:    " + error;
        }
        else if(Objects.equals(type, "oldCode")){
            String code = getUserInput();
            return("Previous Input: "+code);
        }
        else {
            return(null);
        }
    }
    public void getValues(int line){

    }
    public void setDuration(int duration, int line){
        String durationCode = '"'+ "duration"+'"'+ ':'+' ' +duration+" "+"}}";
        appendDoc(durationCode,getFileName(),line );
        setCodeTyping(durationCode, line);
    }
    public Boolean checkForCorrectCode(String codeChecking, int line) throws IOException{
        String correctCode = getCodeTyping(line);
System.out.println(correctCode + " correct code");
        if(Objects.equals(codeChecking, correctCode)){
            return true;
        }
        else{
            System.out.println("WRONG");
            return false;
        }
    }

    public void searchForError(String input, String correct){
        if(input.length() > correct.length()){
            String smaller = makeTwoStringsEqual(correct, input.length());
            for(int i =0; i < input.length()-1; i++){
                if(input.charAt(i) != smaller.charAt(i)){
                    System.out.println("error"+ input.charAt(i));
                    setErrorScreen(input.charAt(i-1));
                }
            }
        }
        else if(input.length() < correct.length()){
           String smaller = makeTwoStringsEqual(input, correct.length());
            for(int i =0; i < correct.length(); i++){
                if(smaller.charAt(i) != correct.charAt(i)){
                    setErrorScreen(smaller.charAt(i));
                    break;
                }
            }
        }
    }

    public Boolean checkForError(String input, String type) {
        if(Objects.equals(type, "numAndAlph")){
            if (!input.matches(".*[a-z].*") ||!input.matches(".*[0-9].*")) {
                for (int i = 0; i < input.length(); i++) {
                    char letter = input.charAt(i);
                    if(!Character.isLetter(letter)){
                        if(!Character.isDigit(letter)){
                            if(letter != '_'){
                                setErrorScreen(input.charAt(i));
                                return(true);
                            }
                        }

                    }
                }
            }
        }
        else if(Objects.equals(type, "num")){
            if (!input.matches(".*[0-9].*")) {
                for (int i = 0; i < input.length(); i++) {
                    char letter = input.charAt(i);
                        if(!Character.isDigit(letter)){
                                setErrorScreen(input.charAt(i));
                                System.out.print(input.charAt(i));
                                return(true);
                            }
                }
            }
        }
        return false;
    }

    public String makeTwoStringsEqual(String smaller, int length){
        int difference = length - smaller.length();
        smaller = smaller + " ".repeat(Math.max(0, difference));
        System.out.print(smaller);
        return smaller;
    }



}


