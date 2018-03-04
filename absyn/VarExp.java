package absyn;

public class VarExp extends Exp {
  public String name;
  public Exp exp;
  public VarExp( int pos, String name, Exp exp) {
    this.pos = pos;
    this.name = name;
    this.exp = exp;
  }
}
