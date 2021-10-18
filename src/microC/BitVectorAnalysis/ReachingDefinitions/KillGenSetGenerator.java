package microC.BitVectorAnalysis.ReachingDefinitions;

import MathOp.UniOp;
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
                var killGenSet = edge.getKillGenSetRD();
                killGenSet.setKillSetRD(getKillSet(edge));
                killGenSet.setGenSetRD(getGenSet(edge));
                killGenSets.add(killGenSet);
            }
        }
        return killGenSets;
    }

    public KillSetRD getKillSet(ProgramGraphEdge edge){
        var edgeInformation = edge.getEdgeInformation();
        if(edgeInformation != null) {
            if (edgeInformation.getVariableModified() != null) {
                // get modified object
                var modified = edgeInformation.getVariableModified();

                //object is of type Variable
                if (modified instanceof VariableIdentifierExpressionNode){
                    var variableModified = (VariableIdentifierExpressionNode) modified;
                    KillSetRD killSetRD = new KillSetRD(variableModified.getIdentifier());
                    killSetRD.setText(killGenSetPrinter.printKillSet(killSetRD));
                    return killSetRD;
                }

                //object is of type ArrayIdentifier
                if (modified instanceof ArrayIdentifierExpressionNode){
                    var arrayModified = (ArrayIdentifierExpressionNode) modified;
                    if (arrayModified.getIndex() == null && arrayModified.getIndexIdentifier() == null){
                        KillSetRD killSetRD = new KillSetRD(arrayModified.getIdentifier());
                        killSetRD.setText(killGenSetPrinter.printKillSet(killSetRD));
                        return killSetRD;
                    }
                }

                //object is of type RecordIdentifier
                if (modified instanceof RecordIdentifierExpressionNode){
                    var recordModified = (RecordIdentifierExpressionNode) modified;
                    if (recordModified.getFst() == null && recordModified.getSnd() == null){
                        KillSetRD killSetRD = new KillSetRD(recordModified.getIdentifier());
                        killSetRD.setText(killGenSetPrinter.printKillSet(killSetRD));
                        return killSetRD;
                    }
                }
            }
        }
        return null;
    }

    public GenSetRD getGenSet(ProgramGraphEdge edge){
        var edgeInformation = edge.getEdgeInformation();
        if(edgeInformation != null) {
            if (edgeInformation.getVariableModified() != null) {
                var modified = edgeInformation.getVariableModified();
                GenSetRD genSetRD = new GenSetRD(modified.getIdentifier(), edge.getOriginNode().toString(),
                        edge.getEndNode().toString());

                genSetRD.setText(killGenSetPrinter.printGenSet(genSetRD));
                return genSetRD;
            }
        }
        return null;
    }
}
