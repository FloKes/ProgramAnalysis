// dot -Tpng input.dot -o output.png
// When in root of project run command below
// dot -Tpng src\main\java\graphviz/input.dot -o images\output.png

package graphviz;

import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOTFileGenerator {
    private String input_dot;

    public DOTFileGenerator() {
        input_dot = "./src/main/java/graphviz/input.dot";
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
    }

    public void GenerateFile(ArrayList<ProgramGraphNode> programGraphNodes) {
            //Write to the file
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(input_dot));
                writer.write("digraph ProgramGraph{\n");

                // For the new subset, print links to all supersets
                writeProgramGraph(programGraphNodes,writer);

                // write end of file
                writer.write("}");
                writer.close();}
            catch (IOException e){
                System.out.println("IO Exception");
        }
    }
    private static void writeProgramGraph(ArrayList<ProgramGraphNode> programGraphNodes, BufferedWriter writer) throws IOException {
        for (ProgramGraphNode programGraphNode: programGraphNodes) {
            if (!programGraphNode.isFinalNode()){
                List<ProgramGraphEdge> outGoingEdges = programGraphNode.getOutGoing();
                for (ProgramGraphEdge outGoingEdge: outGoingEdges){
                    String edgeValue = outGoingEdge.toString();
                    String qs = outGoingEdge.getOriginNode().toString();
                    String qe = outGoingEdge.getEndNode().toString();
                    String string = String.format("\"%s\" -> \"%s\" [label=\"  %s   \"] \n",qs, qe, edgeValue);
                    writer.write(string);
                }
            }
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
