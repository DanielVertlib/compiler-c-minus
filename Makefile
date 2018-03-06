JAVA=java
JAVAC=javac
JFLEX=jflex
CLASSPATH=-classpath /usr/cup.jar:.
CUP=$(JAVA) $(CLASSPATH) java_cup.Main

all: Main.class

Main.class: absyn/*.java parser.java sym.java Lexer.java Scanner.java Main.java

%.class: %.java
	$(JAVAC) $(CLASSPATH)  $^

Lexer.java: cm.flex
	$(JFLEX) cm.flex

parser.java: cm.cup
	$(CUP) -dump -expect 3 cm.cup

clean:
	rm -f parser.java Lexer.java sym.java *.class absyn/*.class *~
