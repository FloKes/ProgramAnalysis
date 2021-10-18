package microC.BitVectorAnalysis.ReachingDefinitions;

import microC.Expressions.ArrayIdentifierExpressionNode;
import microC.Expressions.RecordIdentifierExpressionNode;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class KillGenSetGenerator {
    private KillGenSetPrinter killGenSetPrinter;
    private ArrayList<KillGenSetRD> killGenSets;

    public KillGenSetGenerator() {
        this.killGenSets = new ArrayList<>();
        this.killGenSetPrinter = new KillGenSetPrinter();
    }

    public ArrayList<KillGenSetRD> getKillGenSets(ProgramGraph programGraph){
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()) {
            for (ProgramGraphEdge edge: programGraphNode.getOutGoing()){
                KillSetRD killSet = new KillSetRD(killGenSetPrinter.getKillSet(edge));
                GenSetRD genSet = new GenSetRD(killGenSetPrinter.getGenSet(edge));
                KillGenSetRD killGenSet = new KillGenSetRD(killSet,genSet,edge);
                edge.setKillGenSetRD(killGenSet);
                killGenSets.add(killGenSet);
            }
        }
        return killGenSets;
    }

    public String getKillSet(ProgramGraphEdge edge){
        var edgeInformation = edge.getEdgeInformation();
        if(edgeInformation != null) {
            if (edgeInformation.getVariableModified() != null) {
                // get modified object
                var modified = edgeInformation.getVariableModified();

                //object is of type Variable
                if (modified instanceof VariableIdentifierExpressionNode){
                    var variableModified = (VariableIdentifierExpressionNode) modified;
                    KillSetRD killSetRD = new KillSetRD(variableModified.getIdentifier());
                    String s = "{" + killSetRD.text + "}" + " x {?, qs, q1, ..., qe} x {qs, q1, ..., qe}";
                    return s;
                }

                //object is of type ArrayIdentifier
                if (modified instanceof ArrayIdentifierExpressionNode){
                    var arrayModified = (ArrayIdentifierExpressionNode) modified;
                    if (arrayModified.getIndex() == null && arrayModified.getIndexIdentifier() == null){
                        KillSetRD killSetRD = new KillSetRD(arrayModified.getIdentifier());
                        String s = "{" + killSetRD.text + "}" + " x {?, qs, q1, ..., qe} x {qs, q1, ..., qe}";
                        return s;
                    }
                }

                //object is of type RecordIdentifier
                if (modified instanceof RecordIdentifierExpressionNode){
                    var recordModified = (RecordIdentifierExpressionNode) modified;
                    if (recordModified.getFst() == null && recordModified.getSnd() == null){
                        KillSetRD killSetRD = new KillSetRD(recordModified.getIdentifier());
                        String s = "{" + killSetRD.text + "}" + " x {?, qs, q1, ..., qe} x {qs, q1, ..., qe}";
                        return s;
                    }
                }
            }
        }
        return "{ }";
    }

    public String getGenSet(ProgramGraphEdge edge){
        var edgeInformation = edge.getEdgeInformation();
        if(edgeInformation != null) {
            if (edgeInformation.getVariableModified() != null) {
                var modified = edgeInformation.getVariableModified();

                GenSetRD genSetRD = new GenSetRD(modified.getIdentifier(), edge.getOriginNode().toString(),
                        edge.getEndNode().toString());
                String s = "{(" + genSetRD.identifier + ", " + genSetRD.originNode + ", " + genSetRD.endNode + ")}";
                return s;
            }
        }
        return "{ }";
    }
}
