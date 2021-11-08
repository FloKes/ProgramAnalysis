package microC.BitVectorAnalysis.LiveVariables.ConstraintSolver;

import java.util.ArrayList;

public class SolutionSet {
    private ArrayList<String> solutionSet;

    public SolutionSet() {
        solutionSet = new ArrayList<>();
    }

    public void addElement(String s){
        solutionSet.add(s);
    }

    public void setSolutionSet(ArrayList<String> solutionSet) {
        this.solutionSet = solutionSet;
    }

    public ArrayList<String> getSolutionSet() {
        return solutionSet;
    }

    @Override
    public String toString(){
        String s = "{";
        for (int i = 0; i < solutionSet.size(); i++){
            if (i < solutionSet.size() -1){
                s += solutionSet.get(i) + ", ";
            }
            else {
                s += solutionSet.get(i);
            }
        }
        s += "}";
        return s;
    }
}
