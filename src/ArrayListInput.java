import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayListInput
{
    private Scanner console;
    private ArrayList<String> myList;

    public ArrayListInput()
    {
        this.console = new Scanner(System.in);
        this.myList = new ArrayList<String>();
    }

    private void singleInput()
    {
        try
        {
            this.console = new Scanner(System.in);
            System.out.println("All inputs will be added to the list as " +
                    "strings");
            String input;
            do
            {
                System.out.print("Enter String input (-1 to quit): ");
                input = this.console.nextLine();
                if (!input.equals("-1"))
                    this.myList.add(input);
            }
            while (!input.equals("-1"));
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter a valid string");
            this.singleInput();
        }
    }

    private void doubleInput()
    {
        try
        {
            this.console = new Scanner(System.in);
            String item;
            int index;
            System.out.println("All new inputs will be handled as Strings");
            do
            {
                System.out.print("Enter Valid Index: ");
                index = this.console.nextInt();
                this.console.nextLine();
                System.out.print("Enter New String (-1 to quit): ");
                item = this.console.nextLine();
                if (!item.equals("-1"))
                {
                    try
                    {
                        this.myList.add(index, item);
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println(e.getMessage());
                        this.doubleInput();
                        return;
                    }
                }
            } while (!item.equals("-1"));
        }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input");
            this.doubleInput();
        }
    }

    private void set()
    {
        try
        {
            this.console = new Scanner(System.in);
            String item;
            int index;
            System.out.println("All new inputs will be handled as Strings");
            do
            {
                System.out.print("Enter Valid Index: ");
                index = this.console.nextInt();
                this.console.nextLine();
                System.out.print("Enter New String (-1 to quit): ");
                item = this.console.nextLine();
                if (!item.equals("-1"))
                {
                    try
                    {
                        this.myList.set(index, item);
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println(e.getMessage());
                        this.set();
                        return;
                    }
                }
            } while (!item.equals("-1"));
        }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input");
            this.set();
        }
    }

    private void printList()
    {
        for (int i = 0; i < this.myList.size(); i++)
        {
            System.out.println("Index " + i + ": " + this.myList.get(i));
        }
    }

    private void get()
    {
        try
        {
            this.console = new Scanner(System.in);
            int index;
            do
            {
                System.out.print("Enter input (-1 to quit): ");
                index = this.console.nextInt();
                if (index != -1)
                {
                    try
                    {
                        Object gotten = this.myList.get(index);
                        System.out.println("Object at index " + index + " is:" +
                                " " + gotten);
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            } while (index != -1);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input");
            this.get();
        }
    }

    private void remove()
    {
        try
        {
            this.console = new Scanner(System.in);
            int index;
            do
            {
                System.out.print("Enter input (-1 to quit): ");
                index = this.console.nextInt();
                if (index != -1)
                {
                    try
                    {
                        String removed = this.myList.remove(index);
                        System.out.println("Object \"" + removed + "\" at " + "index " + index + " has" + " " + "been removed.");
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            } while (index != -1);
        }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input");
            this.remove();
        }
    }

    public void mainMenu()
    {
        String choice;
        System.out.println("ArrayList Tester Has Been Initiated");
        do
        {
            System.out.println(" (1) Size");
            System.out.println(" (2) isEmpty");
            System.out.println(" (3) Add w/ 1 Parameter");
            System.out.println(" (4) Add w/ 2 Parameter");
            System.out.println(" (5) Set");
            System.out.println(" (6) Get");
            System.out.println(" (7) Remove");
            System.out.println(" (8) Print List");
            System.out.println(" (q) Quit\n");
            System.out.print("Choice ---> ");
            choice = this.console.next() + " ";
            System.out.println();

            if (('1' <= choice.charAt(0) && choice.charAt(0) <= '9'))
            {
                switch (choice.substring(0, 2))
                {
                    case "1 ":
                        System.out.println("List Size: " + this.myList.size());
                        break;

                    case "2 ":
                        if (this.myList.size() == 0)
                            System.out.println("List is Empty");
                        else
                            System.out.println("List is not Empty");
                        break;

                    case "3 ":
                        this.singleInput();
                        break;

                    case "4 ":
                        this.doubleInput();
                        break;

                    case "5 ":
                        this.set();
                        break;

                    case "6 ":
                        this.get();
                        break;

                    case "7 ":
                        this.remove();
                        break;

                    case "8 ":
                        this.printList();
                        break;

                }
            }
        }
        while (!choice.substring(0, 2).equalsIgnoreCase("q "));
    }
}