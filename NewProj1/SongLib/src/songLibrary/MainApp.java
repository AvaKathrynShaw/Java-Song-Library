package songLibrary;


import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import songLibrary.model.Song;
import songLibrary.view.SongOverviewController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    
    /**
     * The data as an observable list of Songs.*/
     
    private ObservableList<Song> songData = FXCollections.observableArrayList();


    public MainApp() {
        // Add some sample data
        songData.add(new Song("Sun Models"));
        songData.add(new Song("You've Got A Friend in Me"));
        songData.add(new Song("Thats Life"));
        songData.add(new Song("Frosty The Snowman"));
        songData.add(new Song("Machine Gun Funk"));
        songData.add(new Song("Dirty Pop"));
        songData.add(new Song("Thriller"));
        songData.add(new Song("Sweet Home Alabama"));
        songData.add(new Song("Hello"));
    }

    
     /* Returns the data as an observable list of Songs. 
     * @return */
     
    public ObservableList<Song> getSongData() {
        return songData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

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
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   public void showSongOverview() {
        try {
            // Load Song overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SongOverview.fxml"));
            AnchorPane songOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(songOverview);

            // Give the controller access to the main app.
            SongOverviewController controller = loader.getController();
            controller.setMainApp(this);

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