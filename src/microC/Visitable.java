package microC;

public interface Visitable {
    <T> T accept(ASTBaseVisitor<? extends T> astBaseVisitor);
}
