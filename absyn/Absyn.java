package absyn;

abstract public class Absyn {
  public int pos;

  final static int SPACES = 4;

  static private void indent( int spaces ) {
    for( int i = 0; i < spaces; i++ ) System.out.print( " " );
  }

  // Abstract class Var
  static public void showTree( Var tree, int spaces ) {
    if( tree instanceof SimpleVar ) {
      indent( spaces );
      System.out.println( "SimpleVar:" );
    }
    else if( tree instanceof IndexVar ) {
      indent( spaces );
      System.out.println( "IndexVar:" );
    }
    else {
      indent( spaces );
      System.out.println( "Illegal expression at line " + tree.pos  );
    }
  }

  // Abstract class Exp
  static public void showTree( Exp tree, int spaces ) {
    if( tree instanceof NilExp )
      showTree( (NilExp)tree, spaces );
    else if( tree instanceof VarExp )
      showTree( (VarExp)tree, spaces );
    else if( tree instanceof IntExp )
      showTree( (IntExp)tree, spaces );
    else if( tree instanceof CallExp )
      showTree( (CallExp)tree, spaces );
    else if( tree instanceof OpExp )
      showTree( (OpExp)tree, spaces );
    else if( tree instanceof AssignExp )
      showTree( (AssignExp)tree, spaces );
    else if( tree instanceof IfExp )
      showTree( (IfExp)tree, spaces );
    else if( tree instanceof WhileExp )
      showTree( (WhileExp)tree, spaces );
    else if( tree instanceof ReturnExp )
      showTree( (ReturnExp)tree, spaces );
    else if( tree instanceof CompoundExp )
      showTree( (CompoundExp)tree, spaces );
    else {
      indent( spaces );
      System.out.println( "Illegal expression at line " + tree.pos  );
    }
  }

  static public void showTree( NilExp tree, int spaces ) {
    indent( spaces );
  }

  static public void showTree( VarExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "VarExp:" );
  }

  static public void showTree( IntExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "IntExp: " );
  }

  static public void showTree( CallExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "CallExp:" );
  }

  static public void showTree( OpExp tree, int spaces ) {
    indent( spaces );
    System.out.print( "OpExp:" );
    switch( tree.op ) {
      case OpExp.PLUS:
        System.out.println( " + " );
        break;
      case OpExp.MINUS:
        System.out.println( " - " );
        break;
      case OpExp.MUL:
        System.out.println( " * " );
        break;
      case OpExp.DIV:
        System.out.println( " / " );
        break;
      case OpExp.EQ:
        System.out.println( " = " );
        break;
      case OpExp.LT:
        System.out.println( " < " );
        break;
      case OpExp.GT:
        System.out.println( " > " );
        break;
      default:
        System.out.println( "Unrecognized operator at line " + tree.pos);
    }
    spaces += SPACES;
    showTree( tree.left, spaces );
    showTree( tree.right, spaces );
  }

  static public void showTree( AssignExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "AssignExp:" );
    spaces += SPACES;
    showTree( tree.lhs, spaces );
    showTree( tree.rhs, spaces );
  }

  static public void showTree( IfExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "IfExp:" );
    spaces += SPACES;
    showTree( tree.test, spaces );
    showTree( tree.thenpart, spaces );
    showTree( tree.elsepart, spaces );
  }

  static public void showTree( WhileExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "WhileExp: " );
  }

  static public void showTree( ReturnExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "ReturnExp: " );
  }

  static public void showTree( CompoundExp tree, int spaces ) {
    indent( spaces );
    System.out.println( "CompoundExp: "  );
  }

  // Abstract class Dec
  static public void showTree( Dec tree, int spaces ) {
    if( tree instanceof FunctionDec ) {
      indent( spaces );
      System.out.println( "FunctionDec:" );
    }
    else {
      indent( spaces );
      System.out.println( "Illegal expression at line " + tree.pos  );
    }
  }

  // Abstract class VarDec
  static public void showTree( VarDec tree, int spaces ) {
    if( tree instanceof SimpleDec ) {
      indent( spaces );
      System.out.println( "SimpleDec:" );
    }
    else if( tree instanceof ArrayDec ) {
      indent( spaces );
      System.out.println( "ArrayDec:" );
    }
    else {
      indent( spaces );
      System.out.println( "Illegal expression at line " + tree.pos  );
    }
  }

  // Miscellaneous classes (DecList, VarDecList, ExpList)
  static public void showTree( DecList tree, int spaces ) {
    while( tree != null ) {
      showTree( tree.head, spaces );
      tree = tree.tail;
    }
  }

  static public void showTree( VarDecList tree, int spaces ) {
    while( tree != null ) {
      showTree( tree.head, spaces );
      tree = tree.tail;
    }
  }

  static public void showTree( ExpList tree, int spaces ) {
    while( tree != null ) {
      showTree( tree.head, spaces );
      tree = tree.tail;
    }
  }

}
