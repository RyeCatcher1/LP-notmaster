# Define variables
SRC_DIR := src
BIN_DIR := bin
MAIN_CLASS := Ultrajava

# Define targets and dependencies
all: $(BIN_DIR)/$(MAIN_CLASS).class

$(BIN_DIR)/$(MAIN_CLASS).class: $(wildcard $(SRC_DIR)/*.java)
	javac -Xlint -d $(BIN_DIR) $^

run: all
	java -classpath $(BIN_DIR) $(MAIN_CLASS)

clean:
	rm -rf $(BIN_DIR)/*

.PHONY: all run clean
