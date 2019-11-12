import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

//opennotify international space station

public class Test {

    public static void main(String[] args) {
//        Employee e1=new Employee("John", "Wayne");
//        Employee e2=new Employee("Maria", "Calas");
//
//        Employee[] database = {e1,e2};
//        ArrayList<Employee> database2=new ArrayList<>(Arrays.asList(database));
//
//        Gson gson=new GsonBuilder()
//                .setPrettyPrinting()
//                .create();
//
//        String test1=gson.toJson(e1);
//        System.out.println("Json: "+test1);
//
//        Employee e3=gson.fromJson(test1, Employee.class);
//        System.out.println("From Json: "+e3+'\n');
//
//        System.out.println("Konwersja tablicy obiektów do formatu JSON: ");
//        System.out.println(gson.toJson(database));
//
//        File file = new File("C:\\Users\\Student.DESKTOP-VNR47RU\\ZPO_Lab6_Gradle\\src\\main\\json1.json");
//        try (FileWriter fileWriter=new FileWriter(file)) {
//            gson.toJson(database,fileWriter);
//        } catch (IOException e) {
//            System.out.println("IO error");
//        }
//
//        Employee[] testDatabase=null;
//        try (BufferedReader bufferedReader=new BufferedReader(new FileReader(file))) {
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("From Json: "+Arrays.toString(testDatabase)+'\n');
//
//        //pokaż wszystkie atrybuty obiektu JSON
//        Map m=gson.fromJson(test1, Map.class);
//        System.out.println("Obiekt ma: "+m.size()+" atrybuty");
//
//        for (Object key:m.keySet()){
//            System.out.println("key: "+key);
//        }
//
//        //Odczytanie pól
//        System.out.println("firstName");
//        System.out.println("lastName");
//
        System.out.println("hello");
        Gson gson=new Gson();

        StringBuffer response=new StringBuffer();
        String url="http://api.open-notify.org/iss-now.json";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection=(HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            int responseCode=connection.getResponseCode();
            System.out.println("Response: "+responseCode);

            String inputLine;
            BufferedReader in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((inputLine=in.readLine())!=null){
                response.append(inputLine);
            }

            System.out.println(response);


        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //jak jest 200 to jest dobrze

        Map map=gson.fromJson(String.valueOf(response),Map.class);
//        System.out.println("Obiekt ma "+map.size()+" atrybuty");
//        for(Object key:map.keySet()){
//            System.out.println("key: "+key);
//        }
        System.out.println(map.get("iss_position"));

    }//end of main
}//end of class
