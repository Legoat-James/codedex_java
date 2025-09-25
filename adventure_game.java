import java.util.Scanner;
import static java.lang.System.out;

/*
i did the best using the very limited resources i was supposed to know at the time of making this project.
it would be far easier to make a map where the value of they key is journey_string and the
corresponding message to print is associated with the current journey_string. each value in the key value pair would be a
small class containing a string value (the message to print), and a boolean to decide if the game should be over
 */

public class adventure_game {
    private static String messages[] = {"you wake up in a forest filled with strange floating lights - press a to touch a nearby light, or press b to try to leave the forest first", //a
                            "after touching the light you hear a small voice call out to you, it tells you to follow the path of red mushrooms to leave the forest - press a to follow the path, press b to ignore the advice and wander on your own", //aa
                            "you follow the red mushrooms and find a small cottage just of the path - press a to explore the cottage, press b to continue on the path", //aaa
                            "you knock on the cottage door and are greeting by a kind looking man, he says he is a woodcutter, and chose to live near the path to warn travelers against following the wicked spirits plan, - press a to follow the new path the woodcutter gives you, press b to continue on the red mushroom path", //aaaa
                            "you continue on the red mushroom path and are led into an open field, a pack of abnormally large wolves chase you and eventually you tire and die by their claws. THE END", //aaab and aaaab
                            "you see the kindness in the mans heart and choose to follow his path, not long after traveling you see a small town through the treeline and realize he was telling the truth, you have made it to safety. THE END", //aaaaa
                            "you ingore the strange lights whispers and wander the forest, several hours later it is dawn and you grow very hungry. You come accross a bush filled with berries you have never seen before - press a to eat them, press b to continue wandering", //aab
                            "you  wander the forest, several hours later it is dawn and you grow very hungry. You come accross a bush filled with berries you have never seen before - press a to eat them, press b to continue wandering", //ab
                            "you eat the berries and feel an intensive but lingering pain in your stomach, your pained moans draw the attention to nocturnal predators who are far better suited to the utter lack of light. you fight valiantly but succumb to your wounds in the pitch black. THE END", //aaba aba
                            "you continue wandering aimlessly but notice  the sound of wood being split - press a to investigate and b to avoid the sound", //abb aabb
                            "you choose to ignore the sound and continue wandering, but once night falls nocturnal predators attack you and in your hunger are unable to resist. THE END", // abbb aabbb
                            "you approach and see a kind looking man cutting wood. He tells you he lives deep in the forest to help potential travelers, and shows you a path out. Figuring you have no better options you follow his advice and reach a village outside the forests treeline. you have made it to safety. THE END", //abba aabba
                        };
    public static void main(String[] args) {
        //wake up in a forest filled with strange floating lights - touch light or try to leave forest
        boolean game = true;
        Scanner scanner = new Scanner(System.in);
        String journey_string = "a";
        
        String choice;
        int num_choices = 0;
        out.println(messages[0]);
        while(game){
            choice = scanner.nextLine();
            if( !(choice.equals("a") || choice.equals("b"))) {
                out.println("choose either a or b");
                continue;
            }
            num_choices++;
            
            out.println(journey_string);
            out.println(num_choices);
            
            switch (num_choices) {
                case 1:
                    if (choice.equals("a")) { //aa
                        out.println(messages[1]);
                    } else { //ab
                        out.println(messages[6]);
                    }
                    break;
                case 2:
                    if (choice.equals("a") && journey_string.equals("aa")) { //aaa
                        out.println(messages[2]);
                    } else if(choice.equals("a") && journey_string.equals("ab")){ //aba
                        out.println(messages[8]);
                        game = false;
                    } else if(choice.equals("b") && journey_string.equals("ab")) { //abb
                        out.println(messages[9]);
                    } else if(choice.equals("b") && journey_string.equals("aa")){ //aab
                        out.println(messages[6]);
                    }
                    break;
                case 3:
                    if (choice.equals("a") && journey_string.equals("aaa")) { //aaaa
                        out.println(messages[3]);

                    } else if(choice.equals("b") && journey_string.equals("aaa")){ //aaab
                        out.println(messages[4]);
                        game = false;

                    } else if(choice.equals("a") && journey_string.equals("abb")){ //abba
                        out.println(messages[11]);
                        game = false;

                    } else if(choice.equals("b") && journey_string.equals("abb")) { //abbb
                        out.println(messages[10]);
                        game = false;

                    } else if(choice.equals("a") && journey_string.equals("aab")) { //aaba
                        out.println(messages[8]);
                        game = false;

                    } else if(choice.equals("b") && journey_string.equals("aab")) { //aabb
                        out.println(messages[9]);

                    }
                    break;
                case 4:
                    if (choice.equals("a") && journey_string.equals("aaaa")){ //aaaaa
                        out.println(messages[5]);
                        game = false;

                    } else if(choice.equals("b") && journey_string.equals("aaaa")) { //aaaab
                        out.println(messages[4]);
                        game = false;

                    } else if(choice.equals("a") && journey_string.equals("aabb")) { //aabba
                        out.println(messages[11]);
                        game = false;
                        
                    } else if(choice.equals("b") && journey_string.equals("aabb")) { //aabbb
                        out.println(messages[10]);
                        game = false;
                    }
                    break;
                default:
                    out.println("we hit the default case, this should never happen");
                    break;
            }
            journey_string += choice;
        }
        scanner.close();
            
    }

        
    
}
