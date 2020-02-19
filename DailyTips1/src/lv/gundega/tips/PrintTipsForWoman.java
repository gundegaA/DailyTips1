package lv.gundega.tips;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PrintTipsForWoman {
	public String lineTo;

	// METHOD PRINTS TIP FOR WOMAN
	public void printRandomTipForWoman() {
		try {
			int totalLines = 0;
			File file = new File("tipsForWoman.txt");
			BufferedReader br = null;
			// count how much lines in text file
			br = new BufferedReader(new FileReader(file));
			while ((br.readLine()) != null) {
				totalLines++;
			}
			br.close();
			///////////// generate random number from counted lines (because min = 0, we
			///////////// count +1)
			Random random = new Random();
			int randomInt = random.nextInt(totalLines) + 1;

			// print out chosen random line, only way - go through all lines and print one
			// we need
			int counter = 0;
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				counter++;
				if (counter == randomInt) {
					System.out.println("Your tip for today is: " + line);
					this.lineTo =line;
				}
			}
			br.close();
		} catch (Exception ex) {
		}
	}
	// METHOD ADD TIPS FOR WOMAN
	public void addTipForWoman(String text) {
		try {
			File fileObj = new File("tipsForWoman.txt");
			FileWriter fw = new FileWriter(fileObj, true);
			BufferedWriter bw = new BufferedWriter((fw));
			bw.newLine();
			bw.write(text);
			bw.close();
		} catch (Exception ex) {
		}
	}

	// METHOD REMOVING TIP FOR WOMAN - no interneta panemts
	public void removeLineFromFile(String lineToRemove) {

		try {
			File file = new File("tipsForWoman.txt");
			File inFile = new File("tipsForWoman.txt");

			// Construct the new file that will later be renamed to the original filename.
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			String line = null;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null) {

				if (!line.trim().equals(lineToRemove)) {
					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			// Delete the original file
			if (!inFile.delete()) {
				System.out.println("Could not delete file");
				return;
			}

			// Rename the new file to the filename the original file had.
		if (!tempFile.renameTo(inFile))
				System.out.println("Could not rename file");

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//METHOD DELETING EMPTY LINES IN FILE
	public void removeEmptyLine() {
        Scanner file;
        PrintWriter writer;
        
        try {
            file = new Scanner(new File("tipsForWoman.txt"));
            writer = new PrintWriter("tipsForWoman1.txt");

            while (file.hasNext()) {
                String line = file.nextLine();
                if (!line.isEmpty()) {
                    writer.write(line);
                    writer.write("\n");
                }
            }
            file.close();
            writer.close();
            
            //tagad ir jaizdzes jaunizveidotais fails, kura nav tukso liniju.
            File file1 = new File("tipsForWoman.txt");
            File file2 = new File("tipsForWoman1.txt");
            file1.delete();
            file2.renameTo(file1);
            
        } catch (FileNotFoundException ex) {
        }
}

}
