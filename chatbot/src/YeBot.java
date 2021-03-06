import java.util.*;
import org.alicebot.ab.*;
import java.io.File;
import edu.smu.tspell.wordnet.*;
import java.util.ArrayList;
/**
 * YeBot is the main class where the conversation is held.
 */
public class YeBot {

	static Conversation conversation;	
	public Bot kanye;
	public WordNetDatabase database;
	public ArrayList<String> unknown;

	public static void main(String[] args) {
		String dir = new File(".").getAbsolutePath();
		System.out.println(dir.substring(0,dir.length()-2));
		MagicBooleans.trace_mode = false;
		Bot kanye = new Bot("YeBot",dir.substring(0,dir.length()-2));
		kanye.writeAIMLFiles();
		String ans;
		
		//Initializes WordNet
		//Note: WordNet is required to be installed in the correct directory as below. Link for download will be in README
		System.setProperty("wordnet.database.dir", "C:\\Program Files (x86)\\WordNet\\2.1\\dict\\");
		WordNetDatabase database = WordNetDatabase.getFileInstance(); //import WordNet database
		//Array that contains Kanye's responses when a user enters something outside of his topics
		ArrayList<String> unknown = new ArrayList<String>();
		unknown.add("Wish I could help. I dont know what that means");
		unknown.add("Help me understand what you're trying to say");
		unknown.add("You got good vibes, but I dont know what to say to that");
		unknown.add("Yo man you gotta slow down.. maybe try saying that a different way");
		unknown.add("Not sure where you're going with that");

		Chat session = new Chat(kanye);
		conversation = new Conversation();

		String input = "test";
		String output;
		int i = 1;
			
		while(!conversation.isContained(input)){
			input = null;
			input = conversation.recieveInput();
			//System.out.println(input);
			
			if (input!=""&&input!=null&&input.length()>1||i==1) {
				if(input==""||input==null||input.length()<1) {
					//start conversation
					
					output = conversation.response("Ye is in the CHAT!");
					i=0;	
				}
				else if(conversation.isContained(input)) {
					//user calls for exiting the conversation
					try {
						Thread.sleep(500);
						
						output = conversation.response(session.multisentenceRespond(input));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
				else {
					//regular response
					String response = session.multisentenceRespond(input);
					//WordNet - Synonym Recognition	
					if(unknown.contains(response)) {
						String[] words = input.split(" ");
						outerloop:
							for(int n = 0; n<words.length; n++) {
								Synset[] syns = database.getSynsets(words[n]);
								if(syns.length > 0) {
									ArrayList<String> al = new ArrayList<String>();
									HashSet hs = new HashSet();
									for(int j = 0; j < syns.length; j++) {
										String[] wordForms = syns[j].getWordForms();
										for(int k = 0; k < wordForms.length; k++) {
											al.add(wordForms[k]);
											for(String r : wordForms) {
												String newInput = input.replaceAll(words[n]+" ", r+" ");
												response = session.multisentenceRespond(newInput);
												if(!unknown.contains(response)) {
													input = newInput;
													break outerloop;
												}
											}
										}
									}
									//removes duplicates
									hs.addAll(al);
									al.clear();
									al.addAll(hs);
									
									//display synsets
									for(int m = 0; m < al.size(); m++) {
										System.out.println(al.get(m));
									}
								}else {
									//If there are no synonyms/antonyms
									System.err.println("No synsets");
								}
							}
					}
					output = conversation.response(response);
					//System.out.println(output);
				}
			}	
		}
		System.exit(1); 	//This statement terminates the program	
		

	
	}
}
