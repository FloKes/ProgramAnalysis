package microC.AnalysisAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;

public class IntervalSet {
    private HashSet<Integer> set;

    public IntervalSet(HashSet<Integer> set) {
        this.set = set;
    }

    public HashSet<Integer> getSet() {
        return set;
    }

    public String sup(int n){
        var hasSet = false;
        var greatest = 0;
        for (int i: set) {
            if(i <= n && (!hasSet || i > greatest)){
                hasSet = true;
                greatest = i;
            }
        }
        if(!hasSet){
            return "-inf";
        }
        return String.valueOf(greatest);
    }

    public String inf(int n){
        var hasSet = false;
        var smallest = 0;
        for (int i: set) {
            if(i >= n && (!hasSet || i < smallest)){
                hasSet = true;
                smallest = i;
            }
        }
        if(!hasSet){
            return "inf";
        }
        return String.valueOf(smallest);

    }

    private int getMin(){
        boolean first = true;
        int min = 0; // has to be set to a default val / defaults to 0, so we need the flag
        //declare outside loop
        for(int i : this.set){
            if(first){
                first = false;
                min = i;
            }else if(i < min){
                min = i;
            }
        }
        if(first){
            throw new RuntimeException("Interval set must not be empty");
        }

        return min;
    }

    private int getMax(){
        boolean first = true;
        int max = 1; // has to be set to a default val / defaults to 0, so we need the flag
        //declare outside loop
        for(int i : this.set){
            if(first){
                first = false;
                max = i;
            }else if(i > max){
                max = i;
            }
        }
        if(first){
            throw new RuntimeException("Interval set must not be empty");
        }

        return max;
    }

    private boolean cond(int min, int max){
        for (int i : set){
            if(min < i && i < max){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Interval> base(){
        var list = new ArrayList<Interval>();
        //Find all intervals that fulfill the
        //Base constraints, i.e. min <= max, min + 1 neq max,
        // and min < k <  must not hold for any k in K
        for (int i : set){
            for (int j : set){
                if(i <= j && i + 1 != j && cond(i,j)){
                    list.add(new Interval(
                            String.valueOf(i),
                            String.valueOf(j)));
                }
            }
        }
        return list;
    }
}
