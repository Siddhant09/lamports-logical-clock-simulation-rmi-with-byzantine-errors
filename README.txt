------------------------------------------------------
INSTRUCTIONS FOR COMPILING AND RUNNING THE APPLICATION
------------------------------------------------------

A make file has been created with the following commands:

make: To compile and create .class files

make clean: To delete old .class files

make startServer: To run the server

make startClient: To run the client

======================================================

--------------------------------------
INSTRUCTIONS FOR EXECUTING THE PROGRAM
--------------------------------------

1. Start RMI registry with the command: rmiregistry 1100 &
2. Start the server
3. Start the client
1. The client asks the user to enter the desired number of random events to be generated among the four process objects
2. The events are generated randomly on the server once a number is entered
3. The list of events generated will be displayed in the server terminal
4. The time stamps of all the process objects will be displayed in the server terminal
5. The user can continue to generate more random events or exit the application
