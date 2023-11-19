/**
 * Author: Abdurozzaq Nurul Hadi
 * Email: abdurozzaq00@gmail.com
 */

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> model = new ArrayList<>();

    public static void main(String[] args) {
        showTodoList(false);
    }

    public static void clearConsole() {
        // This Function Only Works On Terminal Not In IDE Output
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void showHeaderView() {
        System.out.println("\n=======================================================");
        System.out.println("                     TODO LIST CLI");
        System.out.println("=======================================================");
    }

    public static void showTodoList(boolean isWrongInput) {
        showHeaderView();

        for (int i = 0; i < model.size(); i++) {
            if (model.get(i) != null) {
                System.out.println((i + 1) + ". " + model.get(i));
            }
        }

        if (model.isEmpty()) {
            System.out.println("Todo List Is Empty");
        }

        if (isWrongInput) {
            System.out.println("\n=======================================================");
            System.out.println("The menu you're choose is not exist. \nYour todo list is only " +  model.size() + ".");
            System.out.println("Please, try another index.");
            System.out.println("=======================================================");
        }
        showMenu();
    }

    public static void addNewTodoList() {
        clearConsole();
        showHeaderView();

        // Initialize Input Scanner
        Scanner inputScanner = new Scanner(System.in);

        // Get Input Data
        System.out.println("Add Todo - Enter your new todo here:");
        String todo = inputScanner.nextLine();

        // Save Input Data
        int getFirstNullIndex = model.indexOf(null);
        if (getFirstNullIndex == -1) {
            model.add(todo);
        } else {
            model.set(getFirstNullIndex, todo);
        }

        clearConsole();
        showTodoList(false);
    }

    public static void removeTodoList() {
        clearConsole();
        showHeaderView();

        // Initialize Input Scanner
        Scanner inputScanner = new Scanner(System.in);

        if (model.isEmpty()) {

            System.out.println("Remove Todo - Todo List Is Empty");
            System.out.println("Press enter to redirect back...");

            String input = inputScanner.nextLine();
            clearConsole();
            showTodoList(false);

        } else {

            // Get Input Data
            System.out.println("Remove Todo - Enter your todo index:");
            String inputTodoIndex = inputScanner.nextLine();
            int indexTodo = Integer.parseInt(inputTodoIndex);

            // Remove Index By Index
            var isValid = (indexTodo >= 1) && (indexTodo <= model.size());
            if (isValid) {
                model.remove(indexTodo - 1);
                clearConsole();
                showTodoList(false);
            } else {
                clearConsole();
                removeTodoList();
            }

        }
    }

    public static void showMenu() {
        // Initialize Input Scanner
        Scanner inputScanner = new Scanner(System.in);

        // Get Input Data
        System.out.println("\nTodo List Menu:");
        System.out.println("1. Add New Todo");
        System.out.println("2. Remove Todo\n");
        String menu = inputScanner.nextLine();

        if (Objects.equals(menu, "1")) {
            // Redirect To Add Menu
            addNewTodoList();
        } else if (Objects.equals(menu, "2")) {
            // Redirect To Delete Menu
            removeTodoList();
        } else {
            showTodoList(true);
        }
    }
}