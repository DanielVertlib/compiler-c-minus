package absyn;

public class NameTy extends Absyn {
    public int typ;
    public static final int VOID = 0;
    public static final int INT = 1;

    public NameTy(int pos, int typ) {
        this.pos = pos;
        this.typ = typ;
    }
}