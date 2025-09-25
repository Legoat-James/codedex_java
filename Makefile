# Makefile

# Compiler to use
CXX = g++

# Compiler flags (optional)
CXXFLAGS = -Wall -Wextra -std=c++17

# Target executable name
TARGET = testing

# Source files
SRC = testing.cpp

# Default rule (what happens when you just run 'make')
all: $(TARGET)

# How to build the executable from the source
$(TARGET): $(SRC)
	$(CXX) $(CXXFLAGS) -o $(TARGET) $(SRC)

# Clean up build artifacts
clean:
	rm -f $(TARGET)
