package songLibrary.view;

import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import songLibrary.*;
import songLibrary.model.*;
import songLibrary.util.*;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class SongOverviewController {
    @FXML
    private TableView<Song> SongTable;
    @FXML
    private TableColumn<Song, String> SongNameColumn;
    @FXML
    private Label SongNameLabel;
    @FXML
    private Label ArtistLabel;
    @FXML
    private Label AlbumLabel;
    @FXML
    private Label ReleaseDateLabel;

    // Reference to the main application.
	private SongLib mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public SongOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        // Initialize the song table
        SongNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().SongNameProperty());

        // Clear person details.
        showSongDetails(null);

        // Listen for selection changes and show the person details when changed.
        SongTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showSongDetails(newValue));
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(SongLib mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        SongTable.setItems(mainApp.getSongData());
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified song is null, all text fields are cleared.
     * 
     * @param song the person or null
     */
    private void showSongDetails(Song song) {
        if (song != null) {
            // Fill the labels with info from the person object.
            SongNameLabel.setText(song.getSongName());
            ArtistLabel.setText(song.getArtist());
            AlbumLabel.setText(song.getAlbum());
            ReleaseDateLabel.setText(DateUtil.format(song.getReleaseDate()));
           

            // ReleaseDateLabel.setText(...);
        } else {
            // Song is null, remove all the text.
            SongNameLabel.setText("");
            ArtistLabel.setText("");
            AlbumLabel.setText("");
            ReleaseDateLabel.setText("");
        }
    }
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new Song.
     */
    @FXML
    private void handleNewSong() {
        Song tempSong = new Song();
        boolean okClicked = mainApp.showSongEditDialog(tempSong);
        if (okClicked) {
            mainApp.getSongData().add(tempSong);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected Song.
     */
    @FXML
    private void handleEditSong() {
        Song selectedSong = SongTable.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            boolean okClicked = mainApp.showSongEditDialog(selectedSong);
            if (okClicked) {
                showSongDetails(selectedSong);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Song Selected");
            alert.setContentText("Please select a Song in the table.");

            alert.showAndWait();
        }
    }
    

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeleteSong() {
        int selectedIndex = SongTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	Alert alert = new Alert(AlertType.CONFIRMATION);
        	alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Look, a Confirmation Dialog");
        	alert.setContentText("Are you ok with this?");

        	Optional<ButtonType> result = alert.showAndWait();
        	if (result.get() == ButtonType.OK){
        	    // ... user chose OK
        	    SongTable.getItems().remove(selectedIndex);
        	} else {
        	    // ... user chose CANCEL or closed the dialog
        	}
        
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Song Selected");
            alert.setContentText("Please select a Song in the table.");

            alert.showAndWait();
        }
    }
}

    



