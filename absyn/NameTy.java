package absyn;

public class NameTy extends Absyn {
    public int typ;
    public static final int VOID = 0;
    public static final int INT = 1;

    public String toString(NameTy n) {
        if(n.typ == 0) {
            return "VOID";
        } else {
            return "INT";
        }
    }

    public NameTy(int pos, int typ) {
        this.pos = pos;
        this.typ = typ;
    }
}