package microC.BitVectorAnalysis.ReachingDefinitions.KillGen;

import microC.Expressions.ArrayIdentifierExpressionNode;
import microC.Expressions.RecordIdentifierExpressionNode;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class KillGenSetGeneratorRD {
    private KillGenSetPrinterRD killGenSetPrinter;
    private ArrayList<KillGenSetRD> killGenSets;

    public KillGenSetGeneratorRD() {
        this.killGenSets = new ArrayList<>();
        this.killGenSetPrinter = new KillGenSetPrinterRD();
    }

    public ArrayList<KillGenSetRD> generateKillGenSets(ProgramGraph programGraph){
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
            if (edgeInformation.getDefined() != null) {
                // get modified object
                var modified = edgeInformation.getDefined();

                //object is of type Variable
                if (modified instanceof VariableIdentifierExpressionNode){
                    var variableModified = (VariableIdentifierExpressionNode) modified;
                    KillSetRD killSetRD = new KillSetRD(variableModified.toString());
                    killSetRD.setText(killGenSetPrinter.printKillSet(killSetRD));
                    return killSetRD;
                }

                //object is of type ArrayIdentifier
                if (modified instanceof ArrayIdentifierExpressionNode){
                    var arrayModified = (ArrayIdentifierExpressionNode) modified;
                    if (arrayModified.getIndex() == null && arrayModified.getIndexExpression() == null){
                        KillSetRD killSetRD = new KillSetRD(arrayModified.toString());
                        killSetRD.setText(killGenSetPrinter.printKillSet(killSetRD));
                        return killSetRD;
                    }
                }

                //object is of type RecordIdentifier
                if (modified instanceof RecordIdentifierExpressionNode){
                    var recordModified = (RecordIdentifierExpressionNode) modified;
                    if (recordModified.getFst() == null && recordModified.getSnd() == null){
                        KillSetRD killSetRD = new KillSetRD(recordModified.toString());
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
            if (edgeInformation.getDefined() != null) {
                var modified = edgeInformation.getDefined();
                GenSetRD genSetRD = new GenSetRD(modified.toString(), edge.getOriginNode(),
                        edge.getEndNode());

                genSetRD.setText(killGenSetPrinter.printGenSet(genSetRD));
                return genSetRD;
            }
        }
        return null;
    }
}
