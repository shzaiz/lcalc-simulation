JAVAC = javac
SRC_DIR = ../src
OUT_DIR = ../out
LIBS = -cp "../lib/*"
SOURCES = $(shell find $(SRC_DIR) -name "*.java")
CLASSES = $(SOURCES:$(SRC_DIR)/%.java=$(OUT_DIR)/%.class)
MAIN_CLASS = Main


$(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	mkdir -p $(dir $@)
	$(JAVAC) $(LIBS) -d $(OUT_DIR) $<

antlr: LEval.g4
	java -jar ./lib/antlr-4.9.1-complete.jar -visitor -no-listener LEval.g4

clean:
	rm LEval.interp
	rm LEval.tokens
	rm LEvalBaseVisitor.java
	rm LEvalLexer.java
	rm LEvalLexer.interp
	rm LEvalLexer.tokens
	rm LEvalVisitor.java
	rm LEvalParser.java
