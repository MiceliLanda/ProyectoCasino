package model;

import java.util.ArrayList;
import java.util.Observable;
import javafx.scene.image.ImageView;

public class img1 extends Observable implements Runnable{
	
	private int turno;
	private boolean exit =true;
	private String url ="";
	public String c ="";
	
	public String imagen(ArrayList<String> array) {
		if(exit ==false) {
			for (int i=0;i<array.size();i++){
					if(array.get(i).equals(url)){
						c = url;
						return array.get(i);
					}
			}
		}
		return array.get((int) Math.floor(Math.random()*array.size()));
	}

	public img1() {
		turno =1;
	}
	
	@Override
	public void run() {
		try{
			while(exit==true) {
				setChanged();
				this.notifyObservers(String.valueOf(turno));
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					System.out.println("error: "+e);
				}
				if(turno ==3) {
					turno=1;
				}
				else {
					turno++;
				}
			}
		}catch (Exception e){
			System.out.println("Error Al crear hilo"+e);
		}
	}
	
	public void exit(ImageView str) {
		//System.out.println("URL imagen "+str.getImage().getUrl().substring(43));
		url = str.getImage().getUrl().substring(40);
		exit = false;
	}
}
