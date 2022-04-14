/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Truong Thi Bui - 101300750
 *
 */
// Looks like someone failed javafx class...
public class Assignment2 extends Application {

    private static ContactManager cm;
    private int editContactId;

    @Override
    public void start(Stage primaryStage) {
        // Menu for basic services add, edit and delete
        Menu basicMenu = new Menu("Basic Services");
        MenuItem addContact = new MenuItem("Add Contact");
        MenuItem editContact = new MenuItem("Edit Contact");
        MenuItem deleteContact = new MenuItem("Delete Contact");
        basicMenu.getItems().addAll(addContact, editContact, deleteContact);

        Menu auxiliaryMenu = new Menu("Auxiliary Services");
        MenuItem viewAllContacts = new MenuItem("View All Contacts");
        MenuItem findContact = new MenuItem("Find Contact");
        MenuItem viewContactsInCity = new MenuItem("List Contact In A City");
        auxiliaryMenu.getItems().addAll(viewAllContacts, findContact, viewContactsInCity);

        MenuBar menuBar = new MenuBar(basicMenu, auxiliaryMenu);
        Label lblTitle = new Label("\n\nWelcome to ABC contact manager\nPick any of the operations in the top left menu to begin");
        lblTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.REGULAR, 30));
        lblTitle.setTextAlignment(TextAlignment.CENTER);
        HBox titleBox = new HBox(10, lblTitle);
        titleBox.setAlignment(Pos.CENTER);
        VBox headerBox = new VBox(20, menuBar, titleBox);
        // Root
        BorderPane root = new BorderPane();
        root.setTop(headerBox);
        // Labels
        Label lblFName = new Label("First Name:");
        Label lblLName = new Label("Last Name:");
        Label lblHomePhone = new Label("Home Phone:");
        Label lblWorkPhone = new Label("Work Phone:");
        Label lblEmail = new Label("Email:");
        Label lblNotes = new Label("Notes:");
        Label[] labels = {lblFName, lblLName, lblHomePhone, lblWorkPhone, lblEmail, lblNotes};

        Label lblStreet1 = new Label("Street Info 1:");
        Label lblStreet2 = new Label("Street Info 2:");
        Label lblCity = new Label("City:");
        Label lblPostalCode = new Label("Postal Code:");
        Label lblProvince = new Label("Province:");
        Label lblCountry = new Label("Country:");
        Label[] addressLabels = {lblStreet1, lblStreet2, lblCity, lblPostalCode, lblProvince, lblCountry};

        Label lblDay = new Label("Day: ");
        Label lblMonth = new Label("Month: ");
        Label lblYear = new Label("Year: ");
        Label[] dateLabels = {lblDay, lblMonth, lblYear};

        Label lblId = new Label("Id: ");
        Label lblOutput = new Label();
        // Grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setAlignment(Pos.CENTER);
        // Text Fields
        TextField txtFName = new TextField();
        TextField txtLName = new TextField();
        TextField txtHomePhone = new TextField();
        TextField txtWorkPhone = new TextField();
        TextField txtEmail = new TextField();
        TextField txtNotes = new TextField();
        TextField[] contactTexts = {txtFName, txtLName, txtHomePhone, txtWorkPhone, txtEmail, txtNotes};

        TextField txtStreet1 = new TextField();
        TextField txtStreet2 = new TextField();
        TextField txtCity = new TextField();
        TextField txtPostalCode = new TextField();
        TextField txtProvince = new TextField();
        TextField txtCountry = new TextField();
        TextField[] addressTexts = {txtStreet1, txtStreet2, txtCity, txtPostalCode, txtProvince, txtCountry};

        TextField txtDay = new TextField();
        TextField txtMonth = new TextField();
        TextField txtYear = new TextField();
        TextField[] dateTexts = {txtDay, txtMonth, txtYear};

        TextField txtCitySearch = new TextField();
        TextField txtFNameSearch = new TextField();
        TextField txtLNameSearch = new TextField();
        TextField txtIdSearch = new TextField();

        TextField[] allTextFields = {txtFName, txtLName, txtHomePhone, txtWorkPhone, txtEmail,
            txtStreet1, txtStreet2, txtCity, txtPostalCode, txtProvince, txtCountry, txtNotes, txtDay, txtMonth, txtYear};
        Label[] allLabels = {lblFName, lblLName, lblHomePhone, lblWorkPhone, lblEmail,
            lblStreet1, lblStreet2, lblCity, lblPostalCode, lblProvince, lblCountry, lblNotes, lblDay, lblMonth, lblYear};

        addToGrid(0, grid, labels, contactTexts);
        addToGrid(2, grid, addressLabels, addressTexts);
        addToGrid(4, grid, dateLabels, dateTexts);

        // Buttons
        Button btnAdd = new Button("Add");
        Button btnSearch = new Button("Search");
        Button btnEdit = new Button("Edit");
        Button btnDelete = new Button("Delete");
        Button btnFind = new Button("Find");
        Button btnPick = new Button("Pick");

        Button[] buttons = {btnAdd, btnSearch, btnEdit, btnDelete, btnFind, btnPick};
        for (Button btn : buttons) {
            btn.setPadding(new Insets(10, 100, 10, 100));
            BorderPane.setAlignment(btn, Pos.CENTER);
            BorderPane.setMargin(btn, new Insets(50));
        }

        TextArea outputBox = new TextArea();
        outputBox.setPrefWidth(1000);
        outputBox.setEditable(false);
        BorderPane.setMargin(outputBox, new Insets(10));

        // Actions for menu items
        viewAllContacts.setOnAction((event) -> {
            lblTitle.setText("View All Contacts");
            displayOutputBox(root, outputBox);
        });
        viewContactsInCity.setOnAction((event) -> {
            clearBP(root);
            lblTitle.setText("View Contacts In A City");
            HBox searchBox = new HBox(10, new Label("City:"), txtCitySearch);
            searchBox.setAlignment(Pos.CENTER);
            root.setCenter(searchBox);
            root.setBottom(btnSearch);
        });
        findContact.setOnAction((event) -> {
            clearBP(root);
            lblTitle.setText("Find Contact");
            HBox searchBox = new HBox(10, new Label("First Name:"), txtFNameSearch, new Label("Last Name:"), txtLNameSearch);
            searchBox.setAlignment(Pos.CENTER);
            root.setCenter(searchBox);
            root.setBottom(btnFind);
        });
        deleteContact.setOnAction((event) -> {
            clearBP(root);
            lblTitle.setText("Delete Contact");
            HBox inputBox = new HBox(10, lblId, txtIdSearch);
            HBox labelBox = new HBox(10, lblOutput);
            VBox searchBox = new VBox(10, inputBox, labelBox);
            labelBox.setAlignment(Pos.CENTER);
            inputBox.setAlignment(Pos.CENTER);
            searchBox.setAlignment(Pos.CENTER);
            lblOutput.setText("Be advised that id merely represents the order in which contacts appear\nDouble check when you delete a contact!");
            outputBox.setText(cm.viewAllContacts());
            root.setLeft(outputBox);
            root.setCenter(searchBox);
            root.setBottom(btnDelete);
        });
        editContact.setOnAction((event) -> {
            clearBP(root);
            clearLabelsAndTexts(allTextFields, allLabels);
            lblTitle.setText("Choose a contact to edit");
            HBox inputBox = new HBox(10, lblId, txtIdSearch);
            HBox labelBox = new HBox(10, lblOutput);
            VBox searchBox = new VBox(10, inputBox, labelBox);
            labelBox.setAlignment(Pos.CENTER);
            inputBox.setAlignment(Pos.CENTER);
            searchBox.setAlignment(Pos.CENTER);
            lblOutput.setText("Be advised that id merely represents the order in which contacts appear!");
            outputBox.setText(cm.viewAllContacts());
            root.setLeft(outputBox);
            root.setCenter(searchBox);
            root.setBottom(btnPick);
        });
        addContact.setOnAction((event) -> {
            clearBP(root);
            clearLabelsAndTexts(allTextFields, allLabels);
            lblTitle.setText("Add Contact");
            root.setCenter(grid);
            root.setBottom(btnAdd);
        });

        // Actions for buttons
        // View contacts in city
        btnSearch.setOnAction((event) -> {
            outputBox.setText(cm.viewContactsInCity(txtCitySearch.getText()));
            root.setCenter(outputBox);
        });
        // Find contact with full name
        btnFind.setOnAction((event) -> {
            String fName = txtFNameSearch.getText();
            String lName = txtLNameSearch.getText();
            if (fName.isEmpty() || lName.isEmpty()) {
                outputBox.setText("Please enter adequate information");
            } else {
                outputBox.setText(cm.findContact(fName, lName));
            }
            root.setCenter(outputBox);
        });
        // Delete
        btnDelete.setOnAction((event) -> {
            String id = txtIdSearch.getText();
            if (isInt(id)) {
                int realId = Integer.parseInt(id);
                if (realId < cm.getNumContact()) {
                    lblOutput.setText("Deleted Contact Name: " + cm.getContact(realId).getFirstName() + " " + cm.getContact(realId).getLastName());
                    cm.remove(realId);
                    outputBox.setText(cm.viewAllContacts());
                } else {
                    lblOutput.setText("Id not found");
                }
            } else {
                lblOutput.setText("Invalid Input\nMust be a 9 digits or less positive integer!");
            }
        });
        // Add
        TextField[] requiredTextFields = {txtFName, txtLName, txtHomePhone, txtWorkPhone, txtEmail,
            txtStreet1, txtCity, txtPostalCode, txtProvince, txtCountry};
        Label[] requiredLabels = {lblFName, lblLName, lblHomePhone, lblWorkPhone, lblEmail,
            lblStreet1, lblCity, lblPostalCode, lblProvince, lblCountry};
        TextField[] dateTextFields = {txtDay, txtMonth, txtYear};

        btnAdd.setOnAction((event) -> {
            boolean goodInputs = validateInputs(requiredTextFields, requiredLabels, dateTextFields, dateLabels);

            if (goodInputs) {
                String firstName = txtFName.getText();
                String lastName = txtLName.getText();
                String homePhone = txtHomePhone.getText();
                String workPhone = txtWorkPhone.getText();
                String streetInfo1 = txtStreet1.getText();
                String streetInfo2 = txtStreet2.getText();
                String city = txtCity.getText();
                String postalCode = txtPostalCode.getText();
                String province = txtProvince.getText();
                String country = txtCountry.getText();
                String email = txtEmail.getText();
                int day = Integer.parseInt(txtDay.getText());
                int month = Integer.parseInt(txtMonth.getText());
                int year = Integer.parseInt(txtYear.getText());
                String notes = txtNotes.getText();
                cm.add(firstName, lastName, homePhone, workPhone,
                        streetInfo1, streetInfo2, city, postalCode, province,
                        country, email, day, month, year, notes);
                lblTitle.setText("Contact Added");
                displayOutputBox(root, outputBox);
            }
        });
        // Pick an id for editing
        btnPick.setOnAction((event) -> {
            String id = txtIdSearch.getText();
            if (isInt(id)) {
                editContactId = Integer.parseInt(id);
                if (editContactId < cm.getNumContact()) {
                    Contact c = cm.getContact(editContactId);
                    txtFName.setText(c.getFirstName());
                    txtLName.setText(c.getLastName());
                    txtHomePhone.setText(c.getHomePhone());
                    txtWorkPhone.setText(c.getWorkPhone());
                    txtStreet1.setText(c.getHomeAddress().streetInfo1);
                    txtStreet2.setText(c.getHomeAddress().streetInfo2);
                    txtCity.setText(c.getHomeAddress().city);
                    txtPostalCode.setText(c.getHomeAddress().postalCode);
                    txtProvince.setText(c.getHomeAddress().province);
                    txtCountry.setText(c.getHomeAddress().country);
                    txtEmail.setText(c.getEmail());
                    txtDay.setText(Integer.toString(c.getBirthday().getDay()));
                    txtMonth.setText(Integer.toString(c.getBirthday().getMonth()));
                    txtYear.setText(Integer.toString(c.getBirthday().getYear()));
                    txtNotes.setText(c.getNotes());
                    clearBP(root);
                    root.setCenter(grid);
                    root.setBottom(btnEdit);
                } else {
                    lblOutput.setText("Id not found");
                }
            } else {
                lblOutput.setText("Invalid Input\nMust be a 9 digits or less positive integer!");
            }
        });
        btnEdit.setOnAction((event) -> {
            boolean goodInputs = validateInputs(requiredTextFields, requiredLabels, dateTextFields, dateLabels);
            if (goodInputs) {
                String firstName = txtFName.getText();
                String lastName = txtLName.getText();
                String homePhone = txtHomePhone.getText();
                String workPhone = txtWorkPhone.getText();
                String streetInfo1 = txtStreet1.getText();
                String streetInfo2 = txtStreet2.getText();
                String city = txtCity.getText();
                String postalCode = txtPostalCode.getText();
                String province = txtProvince.getText();
                String country = txtCountry.getText();
                String email = txtEmail.getText();
                int day = Integer.parseInt(txtDay.getText());
                int month = Integer.parseInt(txtMonth.getText());
                int year = Integer.parseInt(txtYear.getText());
                String notes = txtNotes.getText();
                cm.edit(editContactId, firstName, lastName, homePhone, workPhone,
                        streetInfo1, streetInfo2, city, postalCode, province,
                        country, email, day, month, year, notes);
                displayOutputBox(root, outputBox);
                lblTitle.setText("Contact Edited");
            }
        });

        // Scene
        Scene scene = new Scene(root, 1600, 800);
        // Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Address Book");
        primaryStage.show();
    }

    private static void clearLabelsAndTexts(TextField[] texts, Label[] labels) {
        for (int i = 0; i < texts.length; i++) {
            texts[i].setText("");
            labels[i].setTextFill(Color.color(0, 0, 0));
        }
    }

    private static boolean validateInputs(TextField[] requiredTextFields, Label[] requiredLabels, TextField[] dateTextFields, Label[] dateLabels) {
        boolean goodInputs = true;
        for (int i = 0; i < requiredTextFields.length; i++) {
            // Only check for empty inputs, user can type gargebage as they see fit
            if (requiredTextFields[i].getText().isEmpty()) {
                requiredLabels[i].setTextFill(Color.color(1, 0, 0));
                goodInputs = false;
            } else {
                requiredLabels[i].setTextFill(Color.color(0, 0, 0));
            }
        }
        for (int i = 0; i < dateTextFields.length; i++) {
            String n = dateTextFields[i].getText();
            if (isInt(n)) {
                int intValue = Integer.parseInt(n);
                // Day must be <= 31, month <= 12
                if (i == 0 && intValue <= 31 && intValue > 0) {
                    dateLabels[i].setTextFill(Color.color(0, 0, 0));
                } else if (i == 1 && intValue <= 12 && intValue > 0) {
                    dateLabels[i].setTextFill(Color.color(0, 0, 0));
                } else if (i == 2 && intValue > 0) {
                    dateLabels[i].setTextFill(Color.color(0, 0, 0));
                } else {
                    goodInputs = false;
                    dateLabels[i].setTextFill(Color.color(1, 0, 0));
                }
            } else {
                dateLabels[i].setTextFill(Color.color(1, 0, 0));
                goodInputs = false;
            }
        }
        return goodInputs;
    }

    private static void addToGrid(int columnIndex, GridPane grid, Label[] labels, TextField[] textFields) {
        for (int i = 0; i < labels.length; i++) {
            grid.add(labels[i], columnIndex, i);
            grid.add(textFields[i], columnIndex + 1, i);
        }
    }

    // Only accept positive integer
    private static boolean isInt(String input) {
        final int maxIntLength = 10;
        if (input.isEmpty() || input.length() >= maxIntLength) {
            return false;
        }
        Boolean isNumber = true;
        for (int a = 0; a < input.length(); a++) {
            if (!Character.isDigit(input.charAt(a))) {
                isNumber = false;
            }
        }
        return isNumber;
    }

    private static void clearBP(BorderPane bp) {
        bp.setRight(null);
        bp.setBottom(null);
        bp.setCenter(null);
        bp.setLeft(null);
    }

    private void displayOutputBox(BorderPane root, TextArea outputBox) {
        clearBP(root);
        outputBox.setText(cm.viewAllContacts());
        root.setCenter(outputBox);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        cm = new ContactManager();
    }
}
