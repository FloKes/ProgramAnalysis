package microC;

import java.util.ArrayList;
import java.util.List;

public class Program {

    private List<Rexpression> expressions;


    public Program() {
        this.expressions = new ArrayList<>();
    }


    public void addExpression(Rexpression e) {
        expressions.add(e);
    }
}
