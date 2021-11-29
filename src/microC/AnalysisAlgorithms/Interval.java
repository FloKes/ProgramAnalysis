package microC.AnalysisAlgorithms;

public class Interval {
    private String min, max; //Have them as Strings since we need to consider infinity symbols.
    private boolean isBottom = false, isMinInf = false, isMaxInf = false;

    public Interval(String min, String max) {
        this.min = min;
        this.max = max;
        this.isMinInf = min.equals("-inf");
        this.isMaxInf = max.equals("inf");
    }

    public Interval(boolean isBottom) {
        this.isBottom = isBottom;
    }

    public boolean isBottom() {
        return isBottom;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public void set(Interval interval){
        this.min = interval.getMin();
        this.max = interval.getMax();
        this.isMinInf = min.equals("-inf");
        this.isMaxInf = max.equals("inf");
    }

    public boolean isIn (Interval interval){
        //Bottom element is contained always.
        if(this.isBottom){
            return true;
        }

        // Check if this interval has inf bounds
        if(this.isMinInf){
            if(!interval.isMinInf){
                return false;
            }
        }
        if(this.isMaxInf){
            if(!interval.isMaxInf){
                return false;
            }
        }
        // Check min
        if(!interval.isMinInf){
            var min1 = this.getInt(this.min);
            var min2 = this.getInt(interval.getMin());

            if(min2 > min1){
                return false;
            }
        }
        // Check max
        if(!interval.isMaxInf){
            var max1 = this.getInt(this.max);
            var max2 = this.getInt(interval.getMax());

            if(max2 < max1){
                return false;
            }
        }

        return true;
    }

    private int getInt(String val){
        return Integer.parseInt(val);
    }

    public Interval join(Interval int2){
        //Page 98 in book
        //1 is bottom
        if(this.isBottom()){
            //both are bottom - not sure if this ever happens?
            if(int2.isBottom()){
                return new Interval(true);
            }
            //only 1 is bottom
            var ret = new Interval(false);
            ret.set(int2);
            return ret;
        }
        //2 is bottom
        //can only go when int1 isn't bottom.
        else if(int2.isBottom()){
            var ret = new Interval(false);
            ret.set(this);
            return ret;
        }
        //compare case
        else{
            return new Interval(
                    min(this.getMin(),int2.getMin()),
                    max(this.getMax(), int2.getMax())
            );
        }
    }

    private String min(String min1, String min2){
        if(min1.equals("-inf") || min2.equals("-inf")){
            return "-inf";
        }
        return String.valueOf(
                Integer.min(
                        Integer.parseInt(min1),
                        Integer.parseInt(min2)
                )
        );
    }

    private String max(String max1, String max2){
        if(max1.equals("inf") || max2.equals("inf")){
            return "inf";
        }
        return String.valueOf(
                Integer.max(
                        Integer.parseInt(max1),
                        Integer.parseInt(max2)
                )
        );
    }


}
