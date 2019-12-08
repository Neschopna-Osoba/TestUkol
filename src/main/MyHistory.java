/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author petrs
 */
public class MyHistory {

    ArrayList<String> arr = new ArrayList();
    File f;

    public MyHistory(String fileName) throws FileNotFoundException {
        f = new File(fileName);
    }

    public void read() throws IOException {
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                arr.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Soubor neexistuje, nebo je ve spatnem adresari.");
        }

    }

    public void save() throws IOException {
        try {
            ArrayList<String> duplicateCheck = new ArrayList();
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (int i = 0; i < arr.size(); i++) {
                if (!duplicateCheck.contains(arr.get(i))) {
                    bw.append(arr.get(i) + "\n");
                    duplicateCheck.add(arr.get(i));

                }
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Chyba v ukladani souboru.");
        }

    }

    public void addLine(String str) {
        if (arr == null) {
            arr = new ArrayList<String>();
        }
        arr.add(str);
    }

    public String toString() {
        String s = null;
        ArrayList<String> duplicateCheck = new ArrayList();
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) { //Pro první řádek, aby se vraceném řetězci neobjevil null;
                s = arr.get(i);
                duplicateCheck.add(arr.get(i));
            } else {
                if (!duplicateCheck.contains(arr.get(i))) {
                    s = s + "\n" + arr.get(i);
                    duplicateCheck.add(arr.get(i));
                }
            }
        }
        return s;
    }
    public static void main(String[] argv) {
        MyHistory h = new MyHistory("test.txt");
        h.read();
        h.addLine("neco");
        k.save();
        h.add(t2);
        System.out.println(h.toString());

    }
}
