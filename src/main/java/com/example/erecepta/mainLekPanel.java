package com.example.erecepta;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class mainLekPanel {

    String nazwisko;
    String imie;
    String login;
    String password;

    //Zmienne lewego panelu
    private final Button nowaRecepta = new Button("NOWA E-RECEPTA");
    private final Button historia = new Button("Historia Pacjentów");
    private final Button mojeRecepty = new Button("Moje Recepty");
    private final Button ustawienia = new Button("Ustawienia");
    private final Button pomoc = new Button("Pomoc");
    private final Button wyloguj = new Button("Wyloguj");

    //Zmienne środkowego panelu
    private Label title = new Label("Wystawianie E-Recepty");
    private Label imieINazwiskoLabel = new Label("Imię i nazwisko:");
    private Label imieINazwiskoPacjenta = new Label("Piotr Bujak");
    private Label PESELLabel = new Label("PESEL:");
    private Label PESELPacjenta = new Label("0123456789");
    private Label adresLabel = new Label("Adres:");
    private Label adresPacjenta = new Label("ul. Kwaitowa 5, Warszawa");
    private Label typReceptyLabel = new Label("Typ recepty");
    private Button wczytajBtn = new Button("Dodaj");
    private Button skalujBtn = new Button("Skaluj!");
    private Button dodajLekBtn = new Button("Dodaj Lek");
    private TextField searchField = new TextField();
    private TextField lekField = new TextField();

    //Zmienne prawej kolumny
    private Label alergieTitle = new Label("ALERGIE PACJENTA:");
    private Label alergia = new Label("Uczulenie na penicylinę!");
    private Label historiaTitle = new Label("Historia Recept Pacjenta:");
    private Button zobaczWszystko = new Button("Zobacz Wszystko");

    mainLekPanel(String login, String password, String imie, String nazwisko) {
        this.login = login;
        this.password = password;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public void start(Stage primaryStage) {

        /*
           LEWA KOLUMNA - MENU
        */
        VBox leftPanel = new VBox(15);
        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);
        Label doctorInfo = new Label("Lekarz: " + imie + " " + nazwisko + " \nPWZ: 1234567");

        VBox leftPanelButtons = new VBox(15);

        nowaRecepta.setMaxWidth(Double.MAX_VALUE);
        historia.setMaxWidth(Double.MAX_VALUE);
        mojeRecepty.setMaxWidth(Double.MAX_VALUE);;
        ustawienia.setMaxWidth(Double.MAX_VALUE);
        pomoc.setMaxWidth(Double.MAX_VALUE);
        wyloguj.setMaxWidth(Double.MAX_VALUE);

        doctorInfo.getStyleClass().add("doctor-info");
        wyloguj.getStyleClass().add("logout-btn");
        leftPanel.getStyleClass().add("left-panel");
        leftPanelButtons.getStyleClass().add("left-btn-panel");

        leftPanelButtons.getChildren().addAll(
                nowaRecepta,
                historia,
                mojeRecepty,
                ustawienia,
                pomoc
        );

        leftPanel.getChildren().addAll(
                doctorInfo, new Separator(),
                leftPanelButtons, new Separator(),
                spacer,
                wyloguj
        );


        /*
           ŚRODKOWA KOLUMNA - FORMULARZ
        */
        HBox titleBox = new HBox(10);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().addAll(
                title
        );


        Label searchIcon = new Label("\uD83D\uDD0D"); // 🔍
        searchIcon.getStyleClass().add("search-icon");

        HBox searchBox = new HBox(8);
        searchField.setPromptText("Wyszukaj Pacjenta (PESEL / Imię i Nazwisko)");
        searchBox.getChildren().addAll(searchIcon, searchField);
        searchBox.getStyleClass().add("search-box");
        searchBox.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(searchField, Priority.ALWAYS);
        searchField.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(searchBox, Priority.ALWAYS);
        searchField.setMaxWidth(Double.MAX_VALUE);

        HBox topBox = new HBox(10);
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(
                searchBox,
                wczytajBtn
        );
        //searchBox.setAlignment(Pos.CENTER);
        VBox centerPanel = new VBox(20);
        HBox lekBox = new HBox(10);

        /* Dane pacjenta */
        GridPane danePacjenta = new GridPane();
        danePacjenta.add(imieINazwiskoLabel, 0, 0);
        danePacjenta.add(imieINazwiskoPacjenta, 1, 0);
        danePacjenta.add(PESELLabel, 0, 1);
        danePacjenta.add(PESELPacjenta, 1, 1);
        danePacjenta.add(adresLabel, 0, 2);
        danePacjenta.add(adresPacjenta, 1, 2);

        lekField.setPromptText("Wyszukaj lek...");

        centerPanel.getStyleClass().add("center-panel");
        title.getStyleClass().add("center-title");
        wczytajBtn.getStyleClass().add("blue-btn");
        typReceptyLabel.getStyleClass().add("subtitle");
        danePacjenta.getStyleClass().add("dane-pacjenta");
        dodajLekBtn.getStyleClass().add("blue-btn");
        searchField.getStyleClass().add("search-field");

        centerPanel.getChildren().addAll(
                titleBox,
                topBox, new Separator(),
                danePacjenta, new Separator(),
                typReceptyLabel,
                lekBox
        );

        lekBox.getChildren().addAll(
                lekField,
                skalujBtn,
                dodajLekBtn
        );


        /*
           PRAWA KOLUMNA - INFORMACJE
        */
        VBox rightPanel = new VBox(20);
        rightPanel.getChildren().addAll(
                alergieTitle,
                alergia, new Separator(),
                historiaTitle,
                zobaczWszystko
        );
        rightPanel.getStyleClass().add("right-panel");
        alergieTitle.getStyleClass().add("subtitle");
        alergia.getStyleClass().add("alert-box");


        /*
           BORDERPANE — UŁOŻENIE 3 PANELI
        */
        BorderPane root = new BorderPane();
        root.setLeft(leftPanel);
        root.setCenter(centerPanel);
        root.setRight(rightPanel);

        /*
           SCENA
        */
        Scene scene = new Scene(root, 1300, 780); //1300, 780
        scene.getStylesheets().add(
                getClass().getResource("/css/mainPanels/styleLek.css").toExternalForm()
        );

        primaryStage.setTitle("E-Recepta");
        primaryStage.setScene(scene);
        primaryStage.show();

        wyloguj.setOnAction(e -> {
            logika mainPane = new logika();
            mainPane.start(primaryStage);
        });
    }
}
