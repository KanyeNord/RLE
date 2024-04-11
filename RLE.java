package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;

public class RLE extends Application {

	Label ePesoNonCRis = new Label();
	Label ePesoCRis = new Label();
	Label eRateRis = new Label();
	Button pCalcola = new Button("calcola");

	char immagine[][] = new char[3][3];
	Hashtable<Integer, Integer> diz = new Hashtable<Integer, Integer>();
	public void start(Stage finestra) throws Exception {
		GridPane griglia = new GridPane();
		Label ePesoNonC = new Label("Peso non compresso");
		Label ePesoC = new Label("Peso compresso");
		Label eRate = new Label("Compression rate");
		

		griglia.add(ePesoC, 0, 0);
		griglia.add(ePesoNonC, 0, 1);
		griglia.add(eRate, 0, 2);
		griglia.add(ePesoCRis, 1, 0);
		griglia.add(ePesoNonCRis, 1, 1);
		griglia.add(eRateRis, 1, 2);
		griglia.add(pCalcola, 0, 3, 2, 1);

		immagine[0][0]='V';
		immagine[1][0]='B';
		immagine[2][0]='B';
		immagine[0][1]='G';
		immagine[1][1]='G';
		immagine[2][1]='G';
		immagine[0][2]='B';
		immagine[1][2]='V';
		immagine[2][2]='N';
		
		diz.put(1, 1);
		diz.put(2, 2);
		diz.put(3, 2);
		
		pCalcola.setMinWidth(200);
		pCalcola.setOnAction(e -> calcola());

		griglia.setPadding( new Insets(10,10,10,10));
		griglia.setHgap(5);
		griglia.setVgap(5);

		Scene scena = new Scene (griglia);
		finestra.setTitle("Conversioni Numeriche");
		finestra.setScene(scena);
		finestra.show();

	}
	
	public void calcola() {
		int contatore = 1;
		char colore = ' ';
		int peso = 0;
		float rate;
		int nCompresso=24*9;
		for (int y=0;y<immagine.length;y++) {
			for(int x=0;x<immagine.length-1;x++) {
					colore=immagine[x][y];	
				if(colore==immagine[x+1][y]) {
					contatore+=1;
				} else {
					peso+=24+diz.get(contatore);
					contatore=1;
				}
				if(x==immagine.length-2) {
					peso+=24+diz.get(contatore);
				}	
			}	
			System.out.println(peso);
			contatore=1;
		}
		rate=100-(peso/(float)nCompresso*100);
		ePesoNonCRis.setText(peso+"");
		ePesoCRis.setText(nCompresso+"");
		eRateRis.setText(rate+"%");
//		100-	compresso/non compresso *100
	}
	public static void main(String[] args) {
		launch(args);
	}
}
