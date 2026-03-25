Semester Assignment - JavaFX - Personal Form Application

Technical description

For the creation of the interface, a GridPane was used, in which Label, TextField, ComboBox, TextArea, and Button components were added.

Data validation is performed using if-else structures and regular expressions for the email and phone number. The data is stored in an ObservableList and displayed in a TableView when it is fully valid.

For storing the data, the Person class is used, and the savetocsv method of the CSV class receives a list of Person objects and writes the data to the data.csv file using FileWriter and PrintWriter.

The appearance of the application was implemented with CSS files, while there is also the ability to switch between Light / Dark mode by changing the stylesheet during runtime.

Technologies

Java 21

JavaFX

CSS (Light & Dark theme)

Execution

Open the project in the IDE

Make sure that JavaFX is properly configured

Run the Main class

Note

The application was created as part of an assignment from IEK and will be expanded in the future with more features.
