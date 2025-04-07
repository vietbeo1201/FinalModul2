package src2;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class informationManagement extends information implements IinformationManagement {
    public List<information> readDataFromFile() {
        List<information> informationArray = new ArrayList();
        File file = new File("bank_accounts.txt");
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //setId(Integer.parseInt(line));
                String[] dataLine = line.split(","); // split data from string to elements
                int id = Integer.parseInt(dataLine[0]);
                information eachInfor = new information(id ,dataLine[1],dataLine[2],dataLine[3]);
                informationArray.add(eachInfor);
            }
            br.close();
            fr.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return informationArray;
    }

    @Override
    public void display(){
        try {
            List<information> peopleCount = readDataFromFile();
            for (int i = 0; i < peopleCount.size(); i++) {
                System.out.println("nguoi thu " + (i+1) + " : " + peopleCount.get(i));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public int autoID(){
        List<information> listInformation = readDataFromFile();
        int  lastID = 1;
        if (!listInformation.isEmpty()) {
            lastID = listInformation.get(listInformation.size() - 1).getId();
            lastID ++;
        }
        return lastID;
    }


    public String validateDate(){
        System.out.println("Enter your created date or saving date: ");
        String createdDate = new Scanner(System.in).nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Date date = dateFormat.parse(createdDate);
        } catch (Exception e){
            System.out.println("Invalid date format");
            validateDate();
        }
        return createdDate;
    }

    @Override
    public void addInformation() {
        // input bank_accounts.txt
        int lastID = autoID();
        System.out.println("Enter your name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter your account code: ");
        String acountCode = new Scanner(System.in).nextLine();
        String createdDate = validateDate();
        ArrayList<information> informationArray = new ArrayList<>();

        informationArray.add(new information(lastID, name, acountCode, createdDate));

        // check File
        File informationFile = new File("bank_accounts.txt");

        if (!informationFile.exists()) {
            System.out.println("Information file does not exist");
        } else {
            if (!informationFile.canWrite()) {
                System.out.println("Cannot write to file");
            } else {
                try {
                    FileWriter fw = new FileWriter(informationFile, true);
                    fw.write(lastID+ ",");
                    fw.write(name+ ",");
                    fw.write(acountCode+ ",");
                    fw.write(createdDate+ ",");
                    fw.append("\n");
                    fw.close();
                } catch (IOException e){
                    System.out.println("Cannot write to file" + e.getMessage());
                }
            }
        }
    }


    @Override
    public void deleteInformation() {
        /// find the person
        File file = new File("bank_accounts.txt");
        System.out.println("Enter the id you want to delete: ");
        int delID = new Scanner(System.in).nextInt();
        ArrayList<String> updatelist = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataLine = line.split(",");
                int id = Integer.parseInt(dataLine[0]);
                /// if not found then add into new arraylist
                if (delID == id) {
                    System.out.println("Are you sure you want to delete the information?" + line);
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int choice = new Scanner(System.in).nextInt();
                    switch (choice) {
                        case 2:
                            System.exit(0);
                            break;
                        case 1:
                            break;
                    }

                } else {
                    updatelist.add(line);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            /// override all txt file with the infor in arraylist
            FileWriter fw = new FileWriter(file);
            fw.write("");
            fw.close();
            FileWriter fw1 = new FileWriter("bank_accounts.txt",true);
            for (int i = 0; i < updatelist.size(); i++) {
                fw1.write(updatelist.get(i) + "\n");
            }
            fw1.close();
        } catch (Exception e){
            System.out.println("Something went wrong while deleting the information");
            System.out.println("please try again");
            deleteInformation();
        }

    }


    @Override
    public void searchInformation() {
        File file = new File("bank_accounts.txt");
        System.out.println("Enter the id of the information you would like to search: ");
        int searchId = new Scanner(System.in).nextInt();
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] dataLine = line.split(",");
                int id = Integer.parseInt(dataLine[0]);
                information infor = new information(id, dataLine[1], dataLine[2], dataLine[3]);
                if (id == searchId) {
                    System.out.println("person number "+ id + " is " + infor);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e){
            System.out.println("Something went wrong while searching the information");
            System.out.println("please try again");
            searchInformation();
        }
    }


}
