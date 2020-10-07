package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.*;

public class CasinoController implements Initializable,Observer{

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnStopAll;
    
    ArrayList<String> StrImg = new ArrayList<String>();

    img1 imagen1 = new img1();
    img2 imagen2 = new img2();
    img3 imagen3 = new img3();
    Thread hiloSemaforo;
    Thread hiloSemaforo2;
    Thread hiloSemaforo3;
    
    @FXML
    void start(ActionEvent event) {
    	try {

			btnStopAll.setVisible(true);

			img1 hilo = new img1();
			img2 hilo2 = new img2();
			img3 hilo3 = new img3();

			hilo.addObserver(this);
			hilo2.addObserver(this);
			hilo3.addObserver(this);

			hiloSemaforo = new Thread(hilo);
			hiloSemaforo2 = new Thread(hilo2);
			hiloSemaforo3 = new Thread(hilo3);

			hiloSemaforo.setDaemon(true);
			hiloSemaforo2.setDaemon(true);
			hiloSemaforo3.setDaemon(true);
			hiloSemaforo.start();
			hiloSemaforo2.start();
			hiloSemaforo3.start();
			hiloSemaforo.resume();
			hiloSemaforo2.resume();
			hiloSemaforo3.resume();
		}catch (IllegalThreadStateException ex){
			System.out.println("Error al iniciar Hilos"+ex);
		}
    }

	@FXML
    void stop(MouseEvent e) {
    	try {
			if(e.getSource() ==btnStopAll) {
				imagen1.exit(img1);
				imagen2.exit(img2);
				imagen3.exit(img3);
				System.out.println(imagen2.c);
				System.out.println(imagen3.c);
				System.out.println(imagen1.c);
				System.out.println("\n");

				if(imagen1.c.equals("Resource/sandia.png") && imagen2.c.equals("Resource/sandia.png") && imagen3.c.equals("Resource/sandia.png")){
					System.out.println("son iguales todas"+imagen1.imagen(StrImg)+imagen2.imagen(StrImg)+imagen3.imagen(StrImg));
					hiloSemaforo3.suspend();
					hiloSemaforo.suspend();
					hiloSemaforo2.suspend();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Felicidades");
					alert.setHeaderText(null);
					alert.setContentText("Ganaste");

					alert.showAndWait();
				}else if(imagen1.c.equals("Resource/pera.png") && imagen2.c.equals("Resource/pera.png") && imagen3.c.equals("Resource/pera.png")){
						System.out.println("son iguales todas"+imagen1.imagen(StrImg)+imagen2.imagen(StrImg)+imagen3.imagen(StrImg));
					hiloSemaforo3.suspend();
					hiloSemaforo.suspend();
					hiloSemaforo2.suspend();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Felicidades");
					alert.setHeaderText(null);
					alert.setContentText("Ganaste");

					alert.showAndWait();
				}else if(imagen1.c.equals("Resource/pina.png") && imagen2.c.equals("Resource/pina.png") && imagen3.c.equals("Resource/pina.png")){
						System.out.println("son iguales todas"+imagen1.imagen(StrImg)+imagen2.imagen(StrImg)+imagen3.imagen(StrImg));
					hiloSemaforo3.suspend();
					hiloSemaforo.suspend();
					hiloSemaforo2.suspend();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Felicidades");
					alert.setHeaderText(null);
					alert.setContentText("Ganaste");

					alert.showAndWait();
				}else{
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Sigue intentando");
					alert.setHeaderText(null);
					alert.setContentText(":(");
				}

			}
		}catch (Exception ex){
			System.out.println("Stop");
		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		StrImg.add("Resource/sandia.png");
		StrImg.add("Resource/pina.png");
		StrImg.add("Resource/pera.png");
		btnStopAll.setVisible(false);
	}

	@Override
	public void update(Observable o, Object arg) {
        int turno;
        turno = Integer.parseInt(arg.toString());
        if(turno == 1){
        	img1.setImage(new Image(imagen1.imagen(StrImg)));
        	img2.setImage(new Image(imagen2.imagen(StrImg)));
        	img3.setImage(new Image(imagen3.imagen(StrImg)));
        }
        if(turno == 2){
        	img1.setImage(new Image(imagen1.imagen(StrImg)));
        	img2.setImage(new Image(imagen2.imagen(StrImg)));
        	img3.setImage(new Image(imagen3.imagen(StrImg)));
        }
        if(turno == 3){
        	img1.setImage(new Image(imagen1.imagen(StrImg)));
        	img2.setImage(new Image(imagen2.imagen(StrImg)));
        	img3.setImage(new Image(imagen3.imagen(StrImg)));
        }
	}

}