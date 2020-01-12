package my.parsing.app.outFilesOnDosk;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilesOnDisk {

    public String[] outFilesOnDisk(HttpServletRequest request) {

        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("upload");
        File myFolder = new File(appPath);
        File[] files = myFolder.listFiles();

        Map<String, String> pathForFileUpdate = new HashMap<>();
        List<String> listNamesOfFiles = new ArrayList<>();

        try {
            for (int i = 0; i < files.length; i++) {

                String[] nameFile = files[i].toString().split("\\\\");

                for (int x = nameFile.length - 1; ; ) {

                    pathForFileUpdate.put(nameFile[x], files[i].toString());
                    listNamesOfFiles.add(nameFile[x]);

                    break;

                }

            }
        } catch (Exception e) {
            System.out.println("Ошибка вывода списка файлов в директории сервера!");
        }


        for (Map.Entry<String, String> entry : pathForFileUpdate.entrySet()) {
            System.out.println(entry.getKey() + "   " + entry.getValue());
        }

        String[] arrNamesOfFiles = listNamesOfFiles.toArray(new String[]{});


        return arrNamesOfFiles;
    }

}
