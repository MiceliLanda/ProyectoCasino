package model;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class img1 extends Observable implements Runnable{
	
	private int turno;
	private boolean exit =true;
	private String url;
	
	public String imagen(ArrayList<String> array) {
		if(exit ==false) {
			for (int i=0;i<array.size();i++){
				if(array.get(i).equals(url)){
					System.out.println("Array"+array.get(i));
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
		while(exit) {
			System.out.println("exit:"+exit);
			setChanged();
			this.notifyObservers(String.valueOf(turno));
			System.out.println(turno);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			if(turno ==3) {
				turno=1;
			}
			else {
				turno++;
			}
		}
	}
	
	public void exit(ImageView str) {
		//System.out.println("URL imagen "+str.getImage().getUrl().substring(43));
		url = str.getImage().getUrl().substring(40);
		System.out.println(url);
		exit = false;
	}
}