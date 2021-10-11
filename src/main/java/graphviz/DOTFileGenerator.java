package graphviz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DOTFileGenerator {
    public DOTFileGenerator() {

    }

    public void GenerateFile(String[] set) {
            String input_dot = "./src/main/java/graphviz/input.dot";
            // create the file
            try {
                File myObj = new File(input_dot);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (
                    IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            //Write to the file
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(input_dot));
                writer.write("graph ASTGraph{");

                // For the new subset, print links to all supersets
                writeAST(set,writer);

                // write end of file
                writer.write("}");
                writer.close();}
            catch (IOException e){
                System.out.println("IO Exception");
        }
    }
    private static void writeAST(String[] set, BufferedWriter writer) throws IOException {
        // For each integer in the set of all integers
        for (int i = 0; i < set.length; i++) {
            String value = set[i];
            writer.write("\"Prog\"" + " -- " + asString(value)
                    + " \n");
        }
    }


    private static String asString(String s) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\"");
        buffer.append(s);
        buffer.append("\"");
        return buffer.toString();
    }
}
