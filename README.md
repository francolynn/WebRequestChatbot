# WebRequestChatbot
This Java (1.8) program deploys a chatbot to an IRC channel, queries API's, parses JSON Data, and prints user-requested information back into the chatroom

Author: Franco Lynn  
Date:   08/03/17

GENERAL DESCRIPTION
-------------------

This program creates a chat bot (Jibble Pircbot) and sends it to a chat server (freenode.net in this case) to provide other's in the chatroom with information that can be extracted from various URLs. So far, the bot can pull weather information and the lat-long location of the International Space Station. The chatbot does so by continuously reading the chat room for keywords. Once it reads a keyword, such as "weather, Dallas," the bot will make a web request, query the appropriate API, parse the JSON information, and print it in a user-friendly format back to the chatroom.

HOW TO USE
----------
-To change the chat servers and channels, go to MyBotMain.java and edit lines 12 and 15  
- To add an API  
  -Get key (if an API requires one)  
  -Add block of code similar to the ones for "ISS" and "Weather" in the MyBOt.java file  
  -Create a class that maps to the JSON data to help parse the JSON object  
    -Use a JSON editor, such as http://www.jsoneditoronline.org/, to view the nested structure of the JSON Data  

LIBRARIES/DOCUMENTATION
-----------------------
- org.jibble.pircbot  
  http://www.jibble.org/pircbot.php  
- Apache Commons httpclient  
  http://hc.apache.org/httpclient-legacy/index.html  





