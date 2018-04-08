package lesson2;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static java.lang.Class.forName;

public class App {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException {

        Object [] objects = getObjects("hwlevelupv2/src/main/java/lesson2");

    }

    private static Object [] getObjects (String basePackage)throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {

        ArrayList<String> pathsOfClasses = new ArrayList<>();
        ArrayList<String> namesOfClasses = new ArrayList<>();
        ArrayList<Object> listOfObjects = new ArrayList<>();

        String pathOfProject = "C:/Users/Алёна/IdeaProjects/";

        pathsOfClasses.addAll(getPathsOfFiles(pathOfProject + basePackage));

        String nameOfPackage = "lesson2";

        for (String string : pathsOfClasses) {
            ArrayList<String> tempList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(string, "\\" + ".");
            while (st.hasMoreTokens()) {
                String key = st.nextToken();
                tempList.add(key);
            }

            String fullPath = "";

            if ((tempList.get(tempList.size() - 1).equals("java"))) {

                tempList.remove(tempList.size()-1);

                int n = tempList.indexOf(nameOfPackage);

                StringBuffer buffer = new StringBuffer(fullPath);
                for (int i = n; i < tempList.size(); i++)  {
                    if (i != (tempList.size() - 1)) {
                        buffer.append(fullPath += tempList.get(i) + ".");
                    } else {
                        buffer.append(fullPath += tempList.get(i));
                    }
                }

                namesOfClasses.add(fullPath);
            }

        }

        try {
            for (String string : namesOfClasses) {
                Class aClass = forName(string);

                if (!(aClass.isInterface()) && aClass.getDeclaredFields().length > 0) {

                    Object object = aClass.newInstance();
                    RandomIntProcessor.process(object);
                    final Constructor constructor = aClass.getConstructor();
                    constructor.newInstance();
                    listOfObjects.add(object);
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Object [] obj = new Object[listOfObjects.size()];
        for (int i = 0; i <obj.length; i++){
            obj[i] = listOfObjects.get(i);
        }

        return obj;
    }

    private static ArrayList <String> getPathsOfFiles(String path){

        ArrayList <String> files = new ArrayList<>();

        File [] paths;

        try {


            File file = new File(path );

            paths = file.listFiles();

            for(File reachedPath : paths) {

                if (reachedPath.isDirectory()) {
                    files.addAll(getPathsOfFiles(reachedPath.toString()));


                }else {
                    files.add(reachedPath.toString());

                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return files;
    }

}