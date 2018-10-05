package suagman;

import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MainController {

	private Main mainApp;

	@FXML
	private ListView<Integer> leftList;

	@FXML
	private Label leftLabel;

	@FXML
	private ListView<Integer> rightList;

	@FXML
	private Label rightLabel;

	@FXML
	private TextField maxAnzahl;

	@FXML
	private TextField jede;

	@FXML
	private TextField ab;

	@FXML
	private void handleExit() {
		System.exit(0);
	}

	@FXML
	private void handleGenerieren() {

		if (this.maxAnzahl.getText() != "") {

			Integer anzahl;

			try {
				anzahl = Integer.parseInt(this.maxAnzahl.getText());

				this.leftList.getItems().clear();
				refreshLabels();

				for (int i = 1; i <= anzahl; i++) {

					this.leftList.getItems().add(i);

				}
				refreshLabels();

			} catch (Exception e) {
				showMessage(AlertType.ERROR, "Fehler", "Angabe der maximale Anzahl ist keine Zahl.",
						"Bitte geben Sie eine Zahl ein.");
				return;
			}

		}

	}

	@FXML
	private void handleLeeren() {
		this.leftList.getItems().clear();
		this.rightList.getItems().clear();
		refreshLabels();
	}

	@FXML
	private void handleSchieben() {

		if (this.leftList.getItems().size() > 0) {
			this.rightList.getItems()
					.add(this.leftList.getItems().remove(this.leftList.getFocusModel().getFocusedIndex()));
			refreshLabels();
		} else {
			showMessage(AlertType.ERROR, "Keine Zahlen vorhanden", "Es sind keine Zahlen mehr vorhanden.",
					"Bitte neu generieren.");
		}
	}

	@FXML
	private void handleLoeschen() {

		if (this.leftList.getItems().size() > 0) {
			this.leftList.getItems().remove(this.leftList.getFocusModel().getFocusedIndex());
			refreshLabels();
		} else {
			showMessage(AlertType.ERROR, "Keine Zahlen vorhanden", "Es sind keine Zahlen mehr vorhanden.",
					"Bitte neu generieren.");
		}
	}

	@FXML
	private void handleZufall() {

		if (this.leftList.getItems().size() > 0) {

			int index = (int) (Math.random() * (this.leftList.getItems().size() - 1));

			Integer res = this.leftList.getItems().remove(index);

			this.rightList.getItems().add(res);
			refreshLabels();

			showMessage(AlertType.CONFIRMATION, "Der Zufall hat zugeschlagen",
					"Die zufällige Zahl ist: " + res.toString(), "Die Zahl wurde der rechten Liste hinzugefügt");

		} else {
			showMessage(AlertType.ERROR, "Keine Zahlen vorhanden", "Es sind keine Zahlen mehr vorhanden.",
					"Bitte neu generieren.");
		}

	}

	@FXML
	private void handleHilfe() {
		
		showMessage(AlertType.INFORMATION, "Schritte 4-Städte Turnier", "Vorbereitung", //
				"1. Schritt:\n"
				+ "* Lösche 1. Nummer\n"
				+ "* Jede 4. ab 0\n\n"
				+ "2. Schritt:\n"
				+ "* 2 Mal \"Jede 2. Nummer ab 0\" ausführen");
		
	}
	
		
		
	@FXML
	private void handleLoescheJede() {

		if (this.jede.getText() != "") {

			Integer anzahl;
			Integer ab;

			try {
				anzahl = Integer.parseInt(this.jede.getText());

				if (anzahl <= this.leftList.getItems().size()) {

					if (this.ab.getText() != "") {
						
						ab = Integer.parseInt(this.ab.getText());
						
						this.leftList.getItems()
						.removeAll(this.leftList.getItems().stream()
								.filter(i -> (((this.leftList.getItems().indexOf(i) + 1) + ab) % anzahl == 0 && (this.leftList.getItems().indexOf(i) + 1) > ab))
								.collect(Collectors.toList()));
						
					}else {
						
						this.leftList.getItems()
						.removeAll(this.leftList.getItems().stream()
								.filter(i -> (i % anzahl == 0))
								.collect(Collectors.toList()));
						
					}
					
					

					refreshLabels();

				} else {
					showMessage(AlertType.ERROR, "Fehler", "Zahl zu groß!",
							"Es kann nicht jede " + anzahl + ". Zahl gelöscht werden, wenn nur noch "
									+ this.leftList.getItems().size() + " Zahlen vorhanden sind.");
				}

			} catch (Exception e) {
				showMessage(AlertType.ERROR, "Fehler", "Angabe ist keine Zahl.", "Bitte geben Sie eine Zahl ein.");
				return;
			}

		}

	}

	private void refreshLabels() {
		this.leftLabel.setText("Anzahl Items: " + this.leftList.getItems().size());
		this.rightLabel.setText("Anzahl Items: " + this.rightList.getItems().size());
	}

	private void showMessage(AlertType type, String title, String headerText, String contentText) {

		Alert alert = new Alert(type);
		alert.initOwner(mainApp.getPrimaryStage());
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);

		alert.showAndWait();

	}

	public void setMainApp(Main main) {
		this.mainApp = main;

	}

}
