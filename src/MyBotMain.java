/**
   WebRequestChatbot
   
   Purpose: This program deploys a chat robot to an IRC channel and makes API requests
   from various web sites to provide information to other users in the channel on command.

    @author Franco Lynn
    @version 1.00 8/03/2017
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
