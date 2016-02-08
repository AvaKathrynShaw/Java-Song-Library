# Java-Song-Library

CS 213 Assingment 1

Requirements

Design and implement an application with a graphical user interface to manage a library of songs. A song is uniquely identified by name and artist (case insensitive). Your application should have a SINGLE WINDOW with three functions:

    Song list display, with the ability to select ONE song from the list. The list will display ONLY the names of the songs, in alphabetical order of names. Unless the list is empty, one song is always pre-selected, and its details shown - see the following item.

    Song detail, with name, artist, album, and year, of the song that is selected in the song list interface

    Song Add/Delete/Edit, for adding a new song, deleting a selected song, and editing a selected song information:

        Add: When a new song is added, the song name and artist should be entered at the very least. Year and album are optional. If the name and artist are the same as an existing song, the add should not be allowed - a message should be shown in a pop-up dialog.

        The newly added song should automatically be placed in the correct position in the alphabetical order in the list. Also, it should be automatically selected, replacing the previously selected song, and its details should be shown.

        Edit: ANY of the fields can be changed. Again, if name and artist conflict with those of an existing song, the edit should NOT be allowed. alog.

        Delete: Only the selected song in the list can be deleted. After deletion, the next song in the list should be selected, and the details displayed. If there is no next song, the previous song should be selected, and if there is no previous song either, then the list is empty and the detail info is all blanks. 

    For all of these actions, the user should be able to cancel on the action midstream if they change their mind. 

Note: If you use the song detail display area for add/delete/edit as well (instead of two separate areas), then make sure the interface is not confusing to the user, particularly if the edit is disallowed or aborted by the user.

When your program is started, it should show the current list of songs in the library, in the song list display, with the first song selected by default. (The first time the program is run, there should be nothing in the display, since there won't be any songs in the library.)

The data should be persistent across different sessions of your program. You can save the song list in a file in whatever format you like, and then read it into your program when it starts up.

Your application is NOT required to play a song when it is selected. In other words, there is no requirement to have audio playing functionality, and there will not be any extra credit if you choose to implement this functionality.

The application window need NOT be resizable. When the window is closed, the application should be terminated.

Most of the aspects of design (layouts and widgets) and implementation (event handling) you need to do this assignment have been covered in class. If there is any aspect you want to add that has not been covered in class, you are expected to discover these for yourself.

You MUST use Java FX 8 for all UI aspects. (No Swing stuff.) Also, all UI layout should be done in fxml. 
