package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Song;
import view.SongOverviewController;



public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Songs.
     */
    private ObservableList<Song> SongData = FXCollections.observableArrayList();


    public MainApp() {
        // Add some sample data
        SongData.add(new Song("Sun Models"));
        SongData.add(new Song("You've Got A Friend in Me"));
        SongData.add(new Song("Thats Life"));
        SongData.add(new Song("Frosty The Snowman"));
        SongData.add(new Song("Machine Gun Funk"));
        SongData.add(new Song("Dirty Pop"));
        SongData.add(new Song("Thriller"));
        SongData.add(new Song("Sweet Home Alabama"));
        SongData.add(new Song("Hello"));
    }

    /**
     * Returns the data as an observable list of Songs. 
     * @return
     */
    public ObservableList<Song> getSongData() {
        return SongData;
    }

    // ... THE REST OF THE CLASS ...


    

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SongApp");

        initRootLayout();

        showSongOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showSongOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/SongOverview.fxml"));
            AnchorPane SongOverview = (AnchorPane) loader.load();
            
            // Give the controller access to the main app.
            SongOverviewController controller = loader.getController();
            controller.setMainApp(this);

            // Set person overview into the center of root layout.
            rootLayout.setCenter(SongOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}