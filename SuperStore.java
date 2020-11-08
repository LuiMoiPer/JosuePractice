import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;


public class SuperStore extends Application {
    Scene scene, scene1, scene3;
    Stage window;
    TableView<products> table;
    Button addButton, deleteItem;
    TextField names, nameInput, priceInput, quantityInput,passInput,passLabel,loginButton;
    String userName,password,emailAddress,firstName,lastName;
    boolean grantAccess = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;


        window.setTitle("Welcome to JATTA Market ");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // email label
        Label nameLabel = new Label("Email:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //email input

        TextField names = new TextField("");
        names.setPromptText("@Yahoo.com");
        GridPane.setConstraints(names, 1, 0);
        //store email
        emailAddress = names.getText();

        // Set Password label
        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0, 1);

        //password Input
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput, 1, 1);
        //store userPassword
        password = passInput.getText();

        // log in button
        Button loginButton = new Button("Log in");
        GridPane.setConstraints(loginButton, 1, 3);


        // regiester your account
        Button Register = new Button("New Account??" );
        GridPane.setConstraints(Register, 1,2);
        Register.setOnAction(event -> window.setScene(scene3));


        loginButton.setOnAction(event -> window.setScene(scene1));

        // loginButton.setOnAction(e -> isInt(finalNameInput, finalNameInput1.getText(),passInput.getText

// attempt to check if password feild is empty before going foward
        //for (int i = 0 ; i < 10; i++) {
           // if (passInput.getText().isEmpty()) {
              //System.out.println("Please try again!");

          //  } else
          //      loginButton.setOnAction(event -> window.setScene(scene1));

   //     }
            //goes to grocies list


        // adding them to the screen
        grid.getChildren().addAll(nameLabel, names, passLabel, passInput, loginButton,Register);




        scene = new Scene(grid, 300, 200, Color.BLACK);
        scene.getStylesheets().addAll("colors");

        window.setScene(scene);

        window.show();
        // Register your account information
        // name label

        GridPane grids = new GridPane();
        grids.setPadding(new Insets(100, 100, 100, 100));
        grids.setVgap(10);
        grids.setHgap(10);
        Label EmailAccount = new Label("Email Address:");
        GridPane.setConstraints(EmailAccount, 0, 0);

        //name input

        TextField EmailAcc = new TextField("");
        EmailAcc.setPromptText("@Yahoo.com");
        GridPane.setConstraints(EmailAcc, 1, 0);

        // Set Password label
        Label Passwords = new Label("Password");
        GridPane.setConstraints(Passwords, 0, 1);

        //password Input
        TextField PasswordInput = new TextField();
       PasswordInput.setPromptText("Password");
        GridPane.setConstraints(PasswordInput, 1, 1);

        //Full Name
        Label firstNameAcc = new Label("First Name : ");
        GridPane.setConstraints(firstNameAcc, 2, 0);

        TextField NameAcc = new TextField("");
        NameAcc.setPromptText("First Name");
        GridPane.setConstraints(NameAcc, 3, 0);

        Label lastNameAcc = new Label(" Last Name : ");
        GridPane.setConstraints(lastNameAcc,2,1);

        TextField LastAcc = new TextField("");
        LastAcc.setPromptText("LastName");
        GridPane.setConstraints(LastAcc, 3, 1);

        Button Done = new Button("Done");
        GridPane.setConstraints(Done,0,5);
        Done.setOnAction(event -> window.setScene(scene));

        // customer address
        Label mailingAddress = new Label("Mailing Address");
        GridPane.setConstraints(mailingAddress,2,3);

        TextField mailadd = new TextField("");
        mailadd.setPromptText("Mailing Address");
        GridPane.setConstraints(mailadd,3,3);

        // customer zip code
        Label zipcode = new Label("Zip Code");
        GridPane.setConstraints(zipcode,0,3);

        TextField zip = new TextField("");
        zip.setPromptText("Zip Code");
        GridPane.setConstraints(zip,1,3);

        // customer phone
        Label phone = new Label("Phone#");
        GridPane.setConstraints(phone,0,4);

        TextField phonenum = new TextField("");
        phonenum.setPromptText("PhoneNumber");
        GridPane.setConstraints(phonenum,1,4);

        grids.getChildren().addAll(EmailAcc,Passwords,PasswordInput,NameAcc,firstNameAcc,lastNameAcc,EmailAccount,Done,LastAcc,mailadd,mailingAddress,zip,zipcode,phone,phonenum);
        //scene3.getStylesheets().add("colors");
        scene3 = new Scene(grids,800,400,Color.RED);



// second window
        // name Column
        TableColumn<products, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));

        // price Column
        TableColumn<products, Double> priceColumn = new TableColumn<>("Item price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        // quanity Column
        TableColumn<products, Integer> quantityColumn = new TableColumn<>("Amount we have");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        //name inputs

        nameInput = new TextField();
        nameInput.setPromptText("Name of Product");
        nameInput.setMinWidth(100);
        //price inputs
        priceInput = new TextField();
        priceInput.setPromptText("Price of Product");

        //quantity inputs
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity of you want");

        //buttons for this

        addButton = new Button("Add");
        addButton.setOnAction(event -> addButtonClicked());
        deleteItem = new Button("Delete");
        deleteItem.setOnAction(e -> deleteItemClicke());
        //box for add/delete
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteItem);
        //table view
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);
        scene1 = new Scene(vBox);
    }
    public void addButtonClicked() {
        products product = new products();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setAmount(Integer.parseInt(quantityInput.getText()));
        table.getItems().addAll(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public void deleteItemClicke() {

        ObservableList<products> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProducts::remove);

    }
// storing infromation


    // Get product information
    public ObservableList<products> getProduct() {
        ObservableList<products> products = FXCollections.observableArrayList();
        products.add(new products("Apples", 4.25, 20));
        products.add(new products("Bananas", 7.15, 155));
        products.add(new products("Steak", 20.25, 75));
        products.add(new products("oranges", 3.50, 62));
        products.add(new products("bread", 1.25, 12));
        products.add(new products("meats", 15.25, 57));
        return products;

    }
}
