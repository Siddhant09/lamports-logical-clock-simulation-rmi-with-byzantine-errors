JAVA = java
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
Server/Server.java\
Server/SimulationImpl.java\
Server/Processor.java\
Server/Event.java\
Server/Byzantine.java\
Client/Client.java\
Common/Simulation.java\

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) */*.class

startServer:
	$(JAVA) Server.Server

startClient:
	$(JAVA) Client.Client