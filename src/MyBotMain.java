//Author: Franco Lynn
//NetID: FXL161930
//Course: CS2336.0U2 (Khan)
//Title: Project 2: Chatbot, API Requests, JSON
//Date: 08/03/2017

/*Description: This program deploys a chat robot to an IRC channel and makes API requests
 * 			   from various web sites to provide information to other users in the channel
 * 			   on command.
 */


public class MyBotMain {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        MyBot bot = new MyBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.freenode.net");

        // Join the #pircbot channel.
        bot.joinChannel("#franco");
        
    }
    
}