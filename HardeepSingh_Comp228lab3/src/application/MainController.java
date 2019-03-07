package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleGroupBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class MainController {

	@FXML private TextField _nameTextBox;
	@FXML private TextField _addreessTextBox;
	@FXML private TextField _provinceTextBox;
	@FXML private TextField _cityTextBox;
	@FXML private TextField _postalCodeTextBox;
	@FXML private TextField _phoneNumberTextBox;
	@FXML private TextField _emailTextBox;
	@FXML private TextArea _summaryTextArea;
	@FXML private TextArea _courseTextArea ;
	@FXML private Button _displayBtn;
	@FXML private RadioButton _compSciRadioBtn;
	@FXML private RadioButton _businessRadioBtn;
	@FXML private CheckBox _studentCouncilRadioBtn;
	@FXML private CheckBox _volunteerWorkRadioBtn;
	@FXML private ComboBox _courseComboBox;
	@FXML ToggleGroup radioGroup = new ToggleGroup();
	@FXML private ListView _courseList;





	 @FXML
	    public void initialize() {
		 _compSciRadioBtn.setToggleGroup(radioGroup);
		 _compSciRadioBtn.setOnAction(new ProgramHandler());
		 _businessRadioBtn.setToggleGroup(radioGroup);
		 _businessRadioBtn.setOnAction(new ProgramHandler());
		 _courseComboBox.getItems().addAll("java","oops", "C", "C++");
		 _courseComboBox.setOnAction(new ComboHandler());
		 _courseComboBox.setValue("java");
		 _compSciRadioBtn.setSelected(true);
		 _displayBtn.setOnAction(new DisplayHandler());

	    }
	// an inner class to handle the click of the OK button
			private class DisplayHandler implements EventHandler<ActionEvent> {
				@Override
				public void handle(ActionEvent e) {
					onDisplayBtnClicked();
				}

			}


			// an inner class to handle the click of the OK button
			private class ComboHandler implements EventHandler<ActionEvent> {
				@Override
				public void handle(ActionEvent e) {
					onComboChange();
				}

			}


			// an inner class to handle the click of the OK button
						private class ProgramHandler implements EventHandler<ActionEvent> {
							@Override
							public void handle(ActionEvent e) {
								onRadioChange();
							}

						}


	@FXML private void onExitClicked()
	{
		// ends the application
		System.exit(0);
	}


	 private void onDisplayBtnClicked()
	{
		String output  ="" ;

				output = "Name: "+_nameTextBox.getText() +
				"\nAddress: "+ _addreessTextBox.getText() +
				"\nProvince: " +_provinceTextBox.getText() +
				"\nCity: "+_cityTextBox.getText() +
				"\nPostal Code: "+_postalCodeTextBox.getText()+
				"\nPhone Number: "+_phoneNumberTextBox.getText()+
				"\nEmail"+_emailTextBox.getText()+
				"\nJoined Studen Council. :"+ _studentCouncilRadioBtn.isSelected()+
				"\nDid Volunteer Work. : "+ _volunteerWorkRadioBtn.isSelected()+
				"\nCourses Taken :" + _courseList.getItems().toString().substring(1,_courseList.getItems().toString().length()-1) +
				"\n";
			if(_compSciRadioBtn.isSelected() ){
				output += "Program : Computer Science";
			}
			else{
				output += "Program : Business";
			}
			_summaryTextArea.setText(output);


	}

	 	private void onRadioChange(){
		if(_compSciRadioBtn.isSelected() ){
			_courseComboBox.getItems().clear();
			_courseComboBox.getItems().addAll("java","oops", "C", "C++");
			_courseComboBox.setValue("java");

		}
		else{
			_courseComboBox.getItems().clear();
			_courseComboBox.getItems().addAll("Business1","business2", "Business", "business4");
			_courseComboBox.setValue("Business1");
		}
		//_courseTextArea.setText("");
		_courseList.getItems().clear();
	}

	@FXML private void onComboChange(){
		//System.out.println("hello-->"+_courseTextArea.getText());

		if( _courseComboBox.getValue()!=null && !_courseList.getItems().toString().contains( _courseComboBox.getValue().toString()  )){
		_courseList.getItems().add( _courseComboBox.getValue().toString());
		System.out.println("value in combobox" + _courseComboBox.getValue());
		}
		//_courseComboBox.getItems().remove(_courseComboBox.getValue());
//System.out.println("---------->"+_courseList.getItems().toString());



		//if( _courseComboBox.getValue()!=null && !_courseList.getItems().toString().contains( _courseComboBox.getValue().toString()  )){
		//	_courseList.getItems().add( _courseComboBox.getValue().toString());
			//_courseTextArea.setText(_courseTextArea.getText() +"\n"+ _courseComboBox.getValue());
		//}
	}
}
