
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sileshi Haile Woldemariame
 * Date: 2020-10-09
 * Time: 12:32
 * Project:gym
 * Copyright: MIT
 */
public class ReadAndWrite {
    /**
     *
     * @param fileName
     * @return listOfData
     * @throws IOException
     */
    public List<String> readFile(String fileName) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            List<String> listOfData = new ArrayList<>();
            String d;
            while((d = br.readLine()) != null){
                listOfData.add(d);
            }
            return listOfData;
        }
    }

    public void writer(String path,String data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))) {
            bw.write(data);
            bw.newLine();
        }
    }

}
