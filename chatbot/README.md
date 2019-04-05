# InteractiveConversationalAgent
## Tasha Kucher - 68482058 
**Purpose:**
The Interactive Conversational Agent allows an individual to hold a conversation of at least 30 turns. The agent is a celebrity, and the user can be anyone. The celebrity chosen is Kanye West. The conversation will be primarily question/answer based, but there may be certain specific responses for some non-question statements. The responses from the chat agent is a collection of tweets, song lyrics by Kanye West, and everyday conversational questions. Any grammar issues and strange formatting of sentences are from my interpretation of how Kanye would respond. Get to know this artificial celebrity.

## Class Organization

**Breakdown of the classes:**
* BDialog: This class is responsible to create a Graphical User Interface for the conversation between the user and the Chatbot. 
* Conversation: This class is responsible to communicate and transfer user inputs and chatbot outputs. 
* YeBot: YeBot is the main class for the interaction between a user and the chatbot. 

## How to Compile and Run the Code
**Enter the following code into command line to run Yebot:**
* javac BDialog.java Conversation.java YeBot.javajava YeBot

**Or run the yebot.java file**

**Needed to be downloaded before use:**
* WordNet - https://wordnet.princeton.edu/download/current-version

**Make sure to add external archives in buildpath**
* jaws-1.3.1.jar

## Built With

* [Java](https://www.java.com/) - Programming language 
* [AIML](https://www.tutorialspoint.com/aiml/) - AIML dialogue
* [WordNet](https://wordnet.princeton.edu/) - WordNet Synonym Recognition

## Features Added to this Program
**GUI:** 
We previously had built a GUI for assignment 2, so to make a difference I changed the colours of the chat window. The button is now orange, background of the window is gray, and the chat log is light gray. Font sizes were slightly adjusted.

**Extra topics:**
An extra topic to sports was implemented. Originally, he only talked about basketball. Now, if you are to ask him if he likes baseball, or if he likes other sports, he will respond. He also responds if you ask him whether he likes volleyball.

**5 Reasonable responses:** 
Kanye has 5 responses for when an user says something out of his scope such as, "Wish I could help. I dont know what that means," "Help me understand what you're trying to say," "You got good vibes, but I dont know what to say to that," "Yo man you gotta slow down.. maybe try saying that a different way," and "Not sure where you're going with that."

**Language toolkit:**
Synonym recognition was implemented with the use of WordNet and its libraries. Now when a user's response is unknown to Kanye's AIML knowledge, the user's input is split and saved into a string array, then searched in the WordNet database to find synonyms and antonyms and displayed. 

## References
* Princeton University "About WordNet." WordNet. Princeton University. 2010. 







