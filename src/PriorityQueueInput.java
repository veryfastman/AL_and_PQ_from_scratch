import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class PriorityQueueInput
{
    private Scanner console;
    private PriorityQueue<Item> queue;

    public PriorityQueueInput()
    {
        this.console = new Scanner(System.in);
        this.queue = new PriorityQueue<Item>();
    }

    private void loadFile(String fileName)
    {
        Scanner inputFile;
        int id, inv;
        try
        {
            inputFile = new Scanner(new File(fileName));

            int howMany = inputFile.nextInt();
            for (int k = 1; k <= howMany; k++)
            {
                id = inputFile.nextInt();
                inv = inputFile.nextInt();
                this.queue.add(new Item(id, inv));
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addInput()
    {
        try
        {
            boolean run = true;
            this.console = new Scanner(System.in);
            while (run)
            {
                System.out.print("\nId of item to add: ");
                int id = this.console.nextInt();
                System.out.print("Inventory of item to add: ");
                int inv = this.console.nextInt();
                Item it = new Item(id, inv);
                this.console.nextLine(); //flush newline
                this.queue.add(it);
                System.out.println("Item added\n");
                System.out.print("Continue (Y/N): ");
                String answer = this.console.nextLine();
                run = answer.equalsIgnoreCase("Y");
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please type in a valid 32-bit integer.");
            this.addInput();
        }
    }

    public void mainMenu()
    {
        String choice;
        System.out.println("PriorityQueue Menu");
        do
        {
            System.out.println(" (1) Size");
            System.out.println(" (2) isEmpty");
            System.out.println(" (3) Add");
            System.out.println(" (4) Peek");
            System.out.println(" (5) Remove");
            System.out.println(" (q) Quit\n");
            System.out.print("Choice ---> ");
            choice = this.console.next() + " ";
            System.out.println();

            if (('1' <= choice.charAt(0) && choice.charAt(0) <= '9'))
            {
                switch (choice.substring(0, 2))
                {
                    case "1 ":
                        System.out.println("List size: ");
                        break;
                    case "2 ":
                        if (this.queue.isEmpty())
                        {
                            System.out.println("List is empty");
                        }
                        else
                        {
                            System.out.println("List is not empty");
                        }
                        break;
                    case "3 ":
                        this.addInput();
                        break;
                    case "4 ":
                        System.out.println(this.queue.peek());
                        break;
                    case "5 ":
                        try {
                            System.out.println("Value removed: " + this.queue.remove());
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                }
            }
        }
        while (!choice.substring(0, 2).equalsIgnoreCase("q "));
    }
}
