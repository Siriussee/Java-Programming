package address;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import address.model.Person;
import address.model.PersonListWrapper;
import address.view.BirthdayStatisticsController;
import address.view.PersonEditDialogController;
import address.view.PersonOverviewController;
import address.view.RootLayoutController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	private ObservableList<Person> personData = FXCollections.observableArrayList();

	public MainApp() {
		personData.add(new Person("Situ", "Wang")); // add some preset data
		personData.add(new Person("Liang", "Zhuge"));
		personData.add(new Person("8848", "Taijin-MobliePhone"));
		personData.add(new Person("Zuanfeng", "Xiao"));
		personData.add(new Person("Ping", "Ge"));
		personData.add(new Person("Shou", "Yuan"));
		personData.add(new Person("Jack", "Ma"));
		personData.add(new Person("Jun", "Lei"));
		personData.add(new Person("Jie", "Zhang"));
		personData.add(new Person("Daxian", "Huang"));
		personData.add(new Person("Zhaozhong", "Zhang"));
		personData.add(new Person("Bolan", "Bro"));
		personData.add(new Person("Gaoyin", "Bro"));
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");
		this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));
		initRootLayout();
		showPersonOverview();
	}

	public void initRootLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			RootLayoutController controller = loader.getController();
			controller.setMainApp(this);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace(); // auto add try-catch
		}

		File file = getPersonFilePath();
		if (file != null) {
			loadPersonDataFromFile(file);
		}
	}

	public void showPersonOverview() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			rootLayout.setCenter(personOverview);
			PersonOverviewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace(); // auto add try-catch
		}
	}

	public boolean showPersonEditDialog(Person person) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			PersonEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(person);
			dialogStage.showAndWait();
			return controller.isOkClicked();

		} catch (IOException e) {
			e.printStackTrace(); // auto add try-catch
			return false;
		}
	}

	public void showBirthdayStatistics() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/BirthdayStatistics.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Birthday Statistics");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);
			BirthdayStatisticsController controller = loader.getController();
			controller.setPersonData(personData); // pass person list to stat window
			dialogStage.show();

		} catch (IOException e) {
			e.printStackTrace(); // auto add try-catch
		}
	}

	public File getPersonFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);	
		String filePath = prefs.get("filePath", null);	//try get last file path from prefs
		if (filePath != null)
			return new File(filePath);
		else
			return null;

	}

	public void setPersonFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());
			primaryStage.setTitle("AddressApp - " + file.getName());
		} else {
			prefs.remove("filePath");
			primaryStage.setTitle("AddressApp");
		}
	}

	public void loadPersonDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			PersonListWrapper wrapper = (PersonListWrapper) um.unmarshal(file);

			personData.clear();
			personData.addAll(wrapper.getPersons());

			setPersonFilePath(file);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning alert");
			alert.setHeaderText("cannot load here");
			alert.setContentText(null);
			alert.showAndWait();
		}
	}

	public void savePersonDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			PersonListWrapper wrapper = new PersonListWrapper();
			wrapper.setPersons(personData);

			m.marshal(wrapper, file);

			setPersonFilePath(file);
		} catch (Exception e) { 
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning alert");
			alert.setHeaderText("cannot save here");
			alert.setContentText(null);
			alert.showAndWait();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public ObservableList<Person> getPersonData() {
		return personData;
	}

	public static void main(String[] args) {
		launch(args);
	}
}