package microC.BitVectorAnalysis.LiveVariables.KillGen;

import microC.Expressions.ExpressionNode;
import microC.Expressions.VariableIdentifierExpressionNode;
import microC.PrintVisitor;
import microC.ProgramGraph.ProgramGraph;
import microC.ProgramGraph.ProgramGraphEdge;
import microC.ProgramGraph.ProgramGraphNode;

import java.util.ArrayList;

public class KillGenSetGeneratorLV {
    private ArrayList<KillGenSetLV> killGenSets;
    private KillGenSetPrinterLV killGenSetPrinter;
    private PrintVisitor printVisitor;

    public KillGenSetGeneratorLV() {
        killGenSets = new ArrayList<>();
        killGenSetPrinter = new KillGenSetPrinterLV();
        printVisitor = new PrintVisitor();
    }

    public ArrayList<KillGenSetLV> generateKillGenSets(ProgramGraph programGraph){
        for (ProgramGraphNode programGraphNode: programGraph.getProgramGraphNodes()) {
            for (ProgramGraphEdge edge: programGraphNode.getOutGoing()){
                var killGenSet = edge.getKillGenSetLV();
                killGenSet.setKillSetLV(getKillSet(edge));
                killGenSet.setGenSetLV(getGenSet(edge));
                killGenSets.add(killGenSet);
            }
        }
        return killGenSets;
    }

    public KillSetLV getKillSet(ProgramGraphEdge edge){
        var edgeInformation = edge.getEdgeInformation();
        if(edgeInformation != null) {
            if (edgeInformation.getDefined() != null) {
                // get modified object
                var modified = edgeInformation.getDefined();

                //object is of type Variable
                if (modified instanceof VariableIdentifierExpressionNode){
                    var variableModified = (VariableIdentifierExpressionNode) modified;
                    KillSetLV killSetLV = new KillSetLV(variableModified.toString());
                    killSetLV.setText(killGenSetPrinter.printKillSet(killSetLV));
                    return killSetLV;
                }

                //object is of type ArrayIdentifier
//                if (modified instanceof ArrayIdentifierExpressionNode){
//                    var arrayModified = (ArrayIdentifierExpressionNode) modified;
//                    if (arrayModified.getIndex() == null && arrayModified.getIndexIdentifier() == null){
//                        KillSetLV killSetLV = new KillSetLV(arrayModified.getIdentifier());
//                        killSetLV.setText(killGenSetPrinter.printKillSet(killSetLV));
//                        return killSetLV;
//                    }
//                }

                //object is of type RecordIdentifier
//                if (modified instanceof RecordIdentifierExpressionNode){
//                    var recordModified = (RecordIdentifierExpressionNode) modified;
//                    if (recordModified.getFst() == null && recordModified.getSnd() == null){
//                        KillSetLV killSetLV = new KillSetLV(recordModified.getIdentifier());
//                        killSetLV.setText(killGenSetPrinter.printKillSet(killSetLV));
//                        return killSetLV;
//                    }
//                }
            }
        }
        return null;
    }

    public GenSetLV getGenSet(ProgramGraphEdge edge){
        // TODO Generate killgen for boolOpB and other boolean and read, write, Records, arrrays
        var edgeInformation = edge.getEdgeInformation();
        if(edgeInformation == null){
            return null;
        }
        var edgeExpression = edgeInformation.getEdgeExpression();
        if(edgeExpression != null) {
            ArrayList<String> variableStrings = new ArrayList<>();
            var variablesUsed = edgeExpression.getVariablesUsed();
            for (ExpressionNode variableUsed: variablesUsed){
                variableStrings.add(variableUsed.accept(printVisitor));
            }
            GenSetLV genSetLV = new GenSetLV(variableStrings);
            genSetLV.setText(killGenSetPrinter.printGenSet(genSetLV));
            return genSetLV;
        }
        return null;
    }
}
