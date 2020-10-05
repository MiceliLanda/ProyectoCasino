package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Button btnStopLeft;

    @FXML
    private Button btnStopCenter;

    @FXML
    private Button btnStopRight;

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
    }

	@FXML
    void stop(MouseEvent e) {
    	if(e.getSource() ==btnStopLeft) {
    		//if(StrImg.get(0) == img1.toString()||StrImg.get(1) == img1.toString()||StrImg.get(2) == img1.toString()) {
        		imagen1.exit(img1);
    		//}
    	}
    	if(e.getSource() ==btnStopRight) {
    		System.out.println("derecha");
    		imagen3.exit(img3);
    	}
    	if(e.getSource() ==btnStopCenter) {
    		System.out.println("centro");
    		imagen2.exit(img2);
    	}
    	if(e.getSource() ==btnStopAll) {
    		System.out.println("todos");
    		imagen1.exit(img1);
			imagen2.exit(img2);
			imagen3.exit(img3);
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		StrImg.add("img/pera.jpg");
		StrImg.add("img/pina.jpg");
		StrImg.add("img/sandia.jpg");	
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