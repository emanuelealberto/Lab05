package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

	
public class AnagrammiController {
	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAnagrCorretti;

    @FXML
    private TextArea txtAnagrErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	model.clearParole();
    	txtAnagrCorretti.clear();
    	txtAnagrErrati.clear();
    	String parola=txtParola.getText();
    	if(parola.isEmpty()){
    		txtAnagrCorretti.setText("Inserisci una parola!!");
    		return;
    	}
    	model.anagramma("", txtParola.getText());
    	for(String s : model.parole()){
    		if(model.isCorrect( s)) {
    			txtAnagrCorretti.appendText(s+"\n");
    		}else{
    			txtAnagrErrati.appendText(s+"\n");
    	}}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtAnagrCorretti.clear();
    	txtAnagrErrati.clear();
    	txtParola.clear();
    	model.clearParole();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrCorretti != null : "fx:id=\"txtAnagrCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrErrati != null : "fx:id=\"txtAnagrErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
	}

	

}

