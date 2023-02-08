package com.game.companies;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Pattern;

class FilesGenerator implements Runnable{

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        System.out.println("Thread started:::"+Thread.currentThread().getName());

//            Thread.sleep(4000);
            //Files creation code
        String baseLocation = "D:\\workspace\\intellij\\DataStructures\\src\\main\\java\\com\\game\\companies\\files\\";
        String fileName = "myFile";
        String[] fileFormats = {".txt",".json",".csv"};
        String[] mailOrPhone = {"riyapatil@gmail.com","9421820040"};

        //Creating Random non-repeating number
        Integer[] filesNumber = new Integer[50];
        for (int i = 0; i < filesNumber.length; i++) {
            filesNumber[i] = i;
        }

        //Mail and Phone number generator (Random)
        //Creating Random non-repeating number
        boolean[] mailOrNumber = {true,false};

        Collections.shuffle(Arrays.asList(filesNumber));
        System.out.println(Arrays.toString(filesNumber));
        Random random = new Random();
        boolean folderCreation = false;
        for(int i=1,j=0 ; i<=50;i++){
            String completeFile;
            if(j<5){
                completeFile = baseLocation +"\\folder_"+j+"\\";
                //+ fileName +filesNumber[i-1]+ fileFormats[random.nextInt(3)]
                File tempFile = new File(completeFile);
                if(!tempFile.exists()){
                    if(tempFile.mkdir()) System.out.println("Folder created successfully");
                }
                completeFile = completeFile+ fileName +filesNumber[i-1]+ fileFormats[random.nextInt(3)];
                j++;
            }else {
                completeFile = baseLocation + fileName + filesNumber[i - 1] + fileFormats[random.nextInt(3)];
            }
            System.out.println(completeFile);
            File file = new File(completeFile);
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                if(mailOrNumber[random.nextInt(2)])
                fileWriter.write(mailOrPhone[random.nextInt(2)]);
                BufferedWriter s=new BufferedWriter(fileWriter);
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //FileReader fileReader=new FileReader();

//            System.out.println("File is created");
        }



        System.out.println("Thread ended:::"+Thread.currentThread().getName());
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Total time taken for execution "+Thread.currentThread().getName()+": "+totalTime);
    }

}
class FileScanner implements Runnable{

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        System.out.println("Reading the file");
        try {
            Files.walk(Paths.get("D:\\workspace\\intellij\\DataStructures\\src\\main\\java\\com\\game\\companies\\files\\"))
                    .filter(Files::isRegularFile)
                    .forEach(s -> {
                        boolean isMoved = false;
                        try {
                            FileReader fileReader=new FileReader(s.toFile());
                            BufferedReader bufferedReader=new BufferedReader(fileReader);
                            String line;
                            while((line=bufferedReader.readLine())!= null){
                                String regexIndianMobile = "\\d{10}";
                                String regexEmail = "^(.+)@(.+)$";

//                                Pattern pattern = Pattern.compile(regex);
                                //Matching the given phone number with regular expression
                                if(line.matches(regexIndianMobile) || line.matches(regexEmail)){
                                    isMoved = true;
                                }
                            }
                            bufferedReader.close();
                            fileReader.close();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
//                        System.out.println(s);
                        if(isMoved){

                            String[] files = s.toString().split(Pattern.quote(File.separator));
                            String tempPath = "";
                            String filename = files[files.length-1];
                            for(int i =0 ;i<files.length-1;i++){
                                tempPath += files[i]+"\\";
                            }
                            tempPath += "qurantine_folder";
                            File tempFile = new File(tempPath);
                            if(!tempFile.exists()){
                                tempFile.mkdir();
                            }
                            try {
                                Files.move(Paths.get(s.toString()), Paths.get(tempPath+"\\"+filename));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Quarantined");

                        }
                    });


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Total time taken for execution "+Thread.currentThread().getName()+": "+totalTime);
    }
}
public class NFS {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Threads execution
        FilesGenerator filesGeneratorRunnable = new FilesGenerator();
        Thread thread = new Thread(filesGeneratorRunnable);


        thread.start();
        thread.join();

        FileScanner fileScanner = new FileScanner();
        Thread thread2 = new Thread(fileScanner);
        thread2.join();
        thread2.start();


    }
}
