package absyn;

public class CallExp extends Exp {
    public String id;
    public ExpList args;
    public CallExp(int pos, String id, ExpList args) {
        this.pos = pos;
        this.id = id;
        this.args = args;
    }
}