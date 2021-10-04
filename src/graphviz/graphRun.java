//C:\Users\giaco\IdeaProjects\Program-Analysis\src\graphviz>dot -Tpng input.dot > output.png

package graphviz;

import javax.swing.text.html.parser.Parser;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class graphRun {

    public static class DrawPowerSet {

        public static void main(String[] arg) throws IOException,
                InterruptedException {

            // This is the set of integers that we want to draw the powerset of
            String[] set = new String[] { "a", "b", "c", "d", "e" };

            // output file
            String output = "./input.dot";

            // create the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(output)); //TODO: create file inside graphviz package
            writer.write("digraph programGraph{");

            // We will enumerate all the subset
            for (long i = 0, max = 1 << set.length; i < max; i++) {
                // we create a new subset
                List newSet = new ArrayList();
                for (int j = 0; j < set.length; j++) {
                    // check if the j bit is set to 1
                    int isSet = (int) i & (1 << j);
                    if (isSet > 0) {
                        // if yes, add it to the set
                        newSet.add(set[j]);
                    }
                }
                // For the new subset, print links to all supersets
                if (newSet.size() != set.length) {
                    printLinksToImmediateSupersets(newSet, set, writer);
                }
            }
            // write end of file
            writer.write("}");
            writer.close();
        }


        private static void printLinksToImmediateSupersets(List subset,
                                                           String[] set, BufferedWriter writer) throws IOException {
            // For each integer in the set of all integers
            for (int i = 0; i < set.length; i++) {
                String value = set[i];
                // if it is not contained in the subset
                if (subset.contains(value) == false) {
                    // we add it to the set to make an immediate superset
                    // and write the link
                    List newSet = new ArrayList();
                    newSet.addAll(subset);
                    newSet.add(value);
                    writer.write(asString(subset) + " -> " + asString(newSet)
                            + " \n");
                }
            }
        }


        private static String asString(List set) {
            Collections.sort(set);
            // if the empty set, we will write "{}"
            if (set.size() == 0) {
                return "\"{}\"";
            }
            // otherwise we will write the set of integers
            StringBuffer buffer = new StringBuffer();
            buffer.append("\"{");
            // for each integer
            for (int i = 0; i < set.size(); i++) {
                String value = (String) set.get(i);
                buffer.append(value);
                if (i != set.size() - 1) {
                    buffer.append(",");
                }
            }
            buffer.append("}\"");
            return buffer.toString();
        }
    }
}
