import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main implements Runnable {
	
	public Main() {}

	public static void main(String[] args) {
		Main main = new Main();
		Thread mainThread = new Thread(main);
		mainThread.start();
	}

	@Override
	public void run() { 
		GUI gui = new GUI();
		Skimmer skim = new Skimmer();
		//CSVWriter csv = new CSVWriter(skim.getInfoList());
		//System.out.println("hello");
	}
}
