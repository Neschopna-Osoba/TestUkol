/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukol0112;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author petrs
 */
public class MyHistoryTest {

    @Test
    public void initTest() throws FileNotFoundException {
        MyHistory h = new MyHistory("test.txt");
        h.addLine("ahoj");
        h.addLine("ahoj");

        assertEquals("ahoj", h.toString());
    }

    @Test
    public void readTest1() throws IOException {
        // init
        Path p = Files.createTempFile(null, null);
        ArrayList<String> arr = new ArrayList();
        arr.add("ahoj");
        arr.add("nazdar");
        arr.add("ahoj");
        Files.write(p, arr);

        // test
        MyHistory h = new MyHistory(p.toString());
        h.read();
        assertEquals("ahoj\nnazdar", h.toString());
    }

    @Test
    public void saveTest1() throws IOException {
        // init
        Path p = Files.createTempFile(null, null);
        ArrayList<String> arr = new ArrayList();
        arr.add("ahoj");
        arr.add("nazdar");
        arr.add("ahoj");
        Files.write(p, arr);

        // test
        MyHistory h = new MyHistory(p.toString());
        h.read();
        h.addLine("zdravim");
        h.save();

        h = new MyHistory(p.toString());
        h.read();
        assertEquals("ahoj\nnazdar\nzdravim", h.toString());
        
        
        //test pridani duplikatu
        h = new MyHistory(p.toString());
        h.read();
        h.addLine("cau");
        h.addLine("cau");
        h.save();
        
        h = new MyHistory(p.toString());
        h.read();
        assertEquals("ahoj\nnazdar\nzdravim\ncau", h.toString());
        
        //test chybneho souboru
        System.out.println("Chybny soubor");
        MyHistory n = new MyHistory("asdf1234");
        n.read();
        n.addLine("test");
        n.save();     
        
    }



}
