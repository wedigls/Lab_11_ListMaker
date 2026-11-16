import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        String cmd;

        boolean done = false;

        while(!done)
        {
            displayList(list);

            cmd = SafeInput.getRegExString(
                    in,
                    "A-Add D-Delete I-Insert P-Print Q-Quit",
                    "[AaDdIiPpQq]");

            cmd = cmd.toUpperCase();

            switch(cmd)
            {
                case "A":
                    addItem(in, list);
                    break;

                case "D":
                    deleteItem(in, list);
                    break;

                case "I":
                    insertItem(in, list);
                    break;

                case "P":
                    displayList(list);
                    break;

                case "Q":

                    if(SafeInput.getYNConfirm(
                            in,
                            "Are you sure you want to quit?"))
                    {
                        done = true;
                    }

                    break;
            }
        }

        System.out.println("Program terminated.");
    }
    private static void addItem(
            Scanner in,
            ArrayList<String> list)
    {
        System.out.print("Enter item: ");

        String item = in.nextLine();

        list.add(item);
    }
    private static void deleteItem(
            Scanner in,
            ArrayList<String> list)
    {
        if(list.size() == 0)
        {
            System.out.println(
                    "List is empty.");

            return;
        }

        displayNumberedList(list);

        int itemNum =
                SafeInput.getRangedInt(
                        in,
                        "Enter item number to delete",
                        1,
                        list.size());

        list.remove(itemNum - 1);
    }
    private static void insertItem(
            Scanner in,
            ArrayList<String> list)
    {
        int location;

        if(list.size() == 0)
        {
            location = 1;
        }
        else
        {
            location =
                    SafeInput.getRangedInt(
                            in,
                            "Enter insertion position",
                            1,
                            list.size() + 1);
        }

        System.out.print(
                "Enter item to insert: ");

        String item = in.nextLine();

        list.add(location - 1, item);
    }
    private static void displayList(
            ArrayList<String> list)
    {
        System.out.println();
        System.out.println("Current List");

        if(list.size() == 0)
        {
            System.out.println(
                    "[Empty]");
        }
        else
        {
            for(String item : list)
            {
                System.out.println(item);
            }
        }

        System.out.println();
    }
    private static void displayNumberedList(
            ArrayList<String> list)
    {
        System.out.println();

        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(
                    (i + 1)
                            + ". "
                            + list.get(i));
        }

        System.out.println();
    }
}