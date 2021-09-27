package microC;

public class RecAccessNode extends AbstractNode {

    private RecAccessEnum accessEnum;
    private String Id;

    public RecAccessEnum getAccessEnum() {
        return accessEnum;
    }

    public String getId() {
        return Id;
    }

    public RecAccessNode(RecAccessEnum accessEnum, String Id) {
        this.accessEnum = accessEnum;
        this.Id = Id;
    }
}
