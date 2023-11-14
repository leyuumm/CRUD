import java.util.*;
import java.io.*;

public class CRUD{

    public static void main(String[] args){
        ArrayList<String> data = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String fileName = "data.txt";

        try{
            FileInputStream FIS = new FileInputStream(fileName);
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            data = (ArrayList<String>) OIS.readObject();
            OIS.close();
            FIS.close();
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        boolean run = true;

    while(run)
    {
        System.out.println("1. Create");
        System.out.println("2. Read");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("5. Exit");
        int choice = sc.nextInt();
        sc.nextLine();

        switch(choice)
        {
            case 1: 
                System.out.print("Enter data: ");

                String input = sc.nextLine();
                data.add(input);
            break;

            case 2:
                for(int i = 0; i < data.size(); i++)
                {
                    System.out.println(i + " : " + data.get(i));
                }
            break;
            
            case 3:
                System.out.print("Enter index to update: ");
                int index = sc.nextInt();
                sc.nextLine();

                if(index >= 0 && index < data.size())
                {
                    System.out.print("Enter new data: ");
                    String newData = sc.nextLine();
                    data.set(index, newData);
                } else
                {
                    System.out.println("Invalid Index!");
                }
            break;

            case 4:
                System.out.print("Enter index to delete: ");
                int deleteIndex = sc.nextInt();
                sc.nextLine();

                if(deleteIndex >= 0 && deleteIndex < data.size())
                {
                    data.remove(deleteIndex);
                } else
                {
                    System.out.println("Invalid Index");
                }
            break;

            case 5:
                run = false;
            break;

            default:
                System.out.println("Invalid choice!");
            break;
        }
    }

        try{
            FileOutputStream FOS = new FileOutputStream(fileName);
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(data);
            OOS.close();
            FOS.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
}