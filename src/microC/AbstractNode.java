package microC;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public abstract class AbstractNode {

ArrayList<AbstractNode> children = new ArrayList<>();


    public ArrayList<AbstractNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<AbstractNode> children) {
        this.children = children;
    }
}
