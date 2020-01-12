package my.parsing.app.readCsv;

import com.opencsv.CSVReader;
import my.parsing.app.connection.WriteDbForFenoxPrice;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReaderForFenoxCsv {

    public static void readMapa(String link) {

        HashMap<Integer, Object> map = new HashMap<Integer, Object>();

        try {
            //csv file containing data
            String strFile = link;
            CSVReader reader = new CSVReader(new FileReader(strFile));
            String[] nextLine;
            int lineNumber = 0;
            while ((nextLine = reader.readNext()) != null) {
                lineNumber++;


                map.put(lineNumber, nextLine);

            }

        } catch (Exception e) {
            System.out.println(e);
        }


        for (Map.Entry<Integer, Object> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.getKey() + "   " + Arrays.toString((Object[]) mapEntry.getValue()));
            String arr[] = Arrays.toString((Object[]) mapEntry.getValue()).split(";");
            System.out.println((arr[1]).replaceAll("[\\[\\](){}]", ""));
        }


        WriteDbForFenoxPrice writeDbForFenoxPrice = new WriteDbForFenoxPrice();
        writeDbForFenoxPrice.writeInDB(map);


    }

}
