import java.io.*;
import java.util.*;

public class Tree {

    private QuestionNode overallRoot;
    private Scanner console;


    public Tree() {
        console = new Scanner(System.in);
        overallRoot = null;
    }

    public void read(Scanner input){
        overallRoot = readText(input);
    }

    private QuestionNode readText(Scanner input){
        String type = input.nextLine();
        String text = input.nextLine();

        if(type.equals("Q:")){
            return new QuestionNode(text, readText(input), readText(input));
        }else{
            return new QuestionNode(text);
        }
    }

    public void write(PrintStream printStream){
        overallRoot = write(overallRoot, printStream);
    }

    private QuestionNode write(QuestionNode root, PrintStream print){
        if(root != null){
            if (root.left != null && root.right != null){
                print.println("Question: " + root.data);
            }else{
                print.println("Answer: " + root.data);
            }
            root.left = write(root.left, print);
            root.right = write(root.right, print);
        }
        return root;
    }

    public QuestionNode ask(){
        return ask(overallRoot);
    }

    public QuestionNode ask(QuestionNode root){

        QuestionNode object = null;

        if(root.left != null && root.right != null){
            System.out.println("Is your vegetable: " + root.data);
            String answer = console.nextLine();

            if(answer.equalsIgnoreCase("yes")){
                System.out.println("game over");
            }else if(answer.equalsIgnoreCase("no")){
                System.out.println("what was your vegetable?");
                String vegetable = console.nextLine();
                object = new QuestionNode(vegetable);
                System.out.println("Additional Question for your object: ");
                String newQuestion = console.nextLine();
                System.out.println("Answer to Question: (yes/no) ");
                String newAnswer = console.nextLine();
            }
        }
        return root;

    }


}
