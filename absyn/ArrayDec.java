package absyn;

public class ArrayDec extends VarDec {
    public int pos;
    public NameTy typ;
    public String name;
    public IntExp size;
    public ArrayDec(int pos, NameTy typ, String name, IntExp size) {
        this.pos = pos;
        this.typ = typ;
        this.name = name;
        this.size = size;
    }
}