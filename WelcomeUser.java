
import java.util.*;
public class WelcomeUser extends Infosec
{
    Scanner sc= new Scanner(System.in);
    public void main()
    {
        System.out.println("Welcome! Given here is a list of various cryptosystems.\nSelect to see what happens ;)");
        System.out.println("\n1.Encrypt using Caesar Cipher \n2.Decrypt using Caesar Cipher \n3.Encrypt using Substitution Cipher \n4.Decrypt using Substitution Cipher \n5.Generate secret key using Diffie-Hellman Encryption \n6.Exchange secret key using RSA Encryption \n7.Real-world Application of these Cryptosystems");

        System.out.println("\nEnter your choice 1-7, press any other key to Exit");

        int choice= sc.nextInt();
        String str="";
        int key=0;
        switch(choice)
        {
            case 1: str= CaesarEncrypt();
                System.out.println("Encrypted Text= "+str);break;

            case 2: str= CaesarDecrypt();
                System.out.println("Decrypted Text= "+str); break;

            case 3: str= SubstituteEncrypt();
                System.out.println("Encrypted Text= "+str);break;

            case 4: str= SubstituteDecrypt();
                System.out.println("Decrypted Text= "+str);break;

            case 5: Infosec person1 = new Infosec();
                System.out.println("Enter private key for person1 (in reality, it will be private to person1 only)");
                person1.inputKey();

                Infosec person2 = new Infosec();
                System.out.println("Enter private key for person2 (in reality, it will be private to person1 only)");
                person2.inputKey();

                DiffieHellman(person1,person2);

                System.out.println("Using these public keys, any third person will have to take much pain(almost impossible) to find the secret key\n");
                System.out.println("So, the secret key known to person1 and person2 only is: " + person1.KEY);
                break; 

            case 6: Infosec sender= new Infosec();
                Infosec receiver= new Infosec();

                System.out.println("Input the secret key which the sender will give secretly to the receiver");
                sender.inputRSAsender();

                receiver.RSA(sender);
                
                

                System.out.println("The secret key known to receiver and sender only is: "+receiver.RSAsecret);
                break;

            case 7: Infosec Suneo= new Infosec(), Gian= new Infosec();

                Suneo.privateMsg= "I have discovered a new hideout cave in the hill behind our school. There I have hidden a secret vault where we can keep our testpapers and other stuffs. do not ever tell anyone about this place. For the password of the vault, decrypt the public key using rsa encryption.";
                Suneo.msgKey= "zebras";//only known to Suneo, as of now

                System.out.println("\nGian and Suneo are constantly getting poor marks in their tests and they need to hide their papers somewhere so that none could find them.");
                System.out.println("But Nobita always tries to overhear whatever the two are conversing.");
                System.out.println("So Suneo thinks of a plan to avoid any intervention\n");

                String public_msg= SubstituteEncrypt(Suneo.privateMsg, Suneo.msgKey);
                //System.out.println(public_msg);

                System.out.println("So, once Suneo writes a code in Gian's notebook: \n"+public_msg);
                //String public_msg ="f dzua rfpbluaoar z kav dfraltq bzua fk qda dfii eadfkr lto pbdlli. qdaoa f dzua dfrrak z paboaq uztiq vdaoa va bzk haam lto qapqmzmaop zkr lqdao pqtssp. rl klq auao qaii zkxlka zeltq qdfp mizba. slo qda mzppvlor ls qda uztiq, raboxmq qda mteifb hax tpfkc opz akboxmqflk.";
                System.out.println("\nSuneo: 353 and 3 are the two parameters. Let us find the common key.");
                final int A=3, B=353;
                Suneo.privateKey= 97;//object ie Suneo is being called, so this information can only be revealed on Suneo's discretion
                Gian.privateKey= 233;

                int SuneoKey= function(A, Suneo.privateKey,B);//40
                int GianKey= function(A, Gian.privateKey,B);//248

                System.out.println("\nSuneo: Here is my key: "+SuneoKey);
                System.out.println("Gian: And here is mine: "+GianKey);

                Suneo.KEY = function(GianKey, Suneo.privateKey, B);//160
                Gian.KEY = function(SuneoKey, Gian.privateKey, B);//160

                String public_word=CaesarEncrypt(Suneo.msgKey,Suneo.KEY); //difvew

                //System.out.println(public_word);

                System.out.println("\nSuneo: Now use it to decrypt \""+public_word+"\". Use what you get here to decrypt the code I wrote in your notebook");


                Gian.msgKey= CaesarDecrypt(public_word, Gian.KEY);

                //System.out.println(Gian.msgKey);

                Gian.privateMsg = SubstituteDecrypt(public_msg, Gian.msgKey);

                //System.out.println(Gian.privateMsg);

                System.out.println("Gian: Hmm, okay, done");

                
                System.out.println("\nSuneo: Good, I want you to generate a key publicly so that I can give you the ciphertext which contains the password");

                Suneo.RSAsecret= 719;

                final int N= A*B, Z = (A-1)*(B-1);

                int public_key = 17;//available publicly
                

                System.out.println("Gian: Here you go: "+public_key);

                Gian.RSAprivate= 497; //known only to Gian

                int ciphertext  =function(Suneo.RSAsecret, public_key, N);//ciphertext is available publicly
                //System.out.println(ciphertext);
                System.out.println("Suneo: And here's mine: "+ciphertext);
                Gian.RSAsecret = function(ciphertext, Gian.RSAprivate, N);//only known to Gian and Suneo
                //System.out.println(Gian.RSAsecret);
                System.out.println("\nGian: Okay, I got you, let us go there after the school");
                System.out.println("Suneo: Perfect! See you there");

                System.out.println("\nMeanwhile, Nobita has heard the whole conversation, but everything just flew over his head.");
                System.out.println("So, after the school, he rushed to his home and insisted Doraemon to decipher the secret code which Gian and Suneo were using.");
                System.out.println("As usual, Doraemon used a gadget which showed what actually happened:\n");
                
                System.out.println("The two parameters are in the form of "+A+"mod"+B);
                System.out.println("Suneo has formed his secret key: "+Suneo.privateKey+" and Gian his: "+Gian.privateKey);
                System.out.println("Using A^key mod B format, they generated a public key each: "+SuneoKey+" and "+GianKey+" respectively");
                System.out.println("Then Suneo used Gian's public key and Gian used Suneo's to mutually get a secret key: "+ Suneo.KEY);
                System.out.println("In fact, both of them used the Diffie-Hellman Encryption\n");
                
                System.out.println("Now, Suneo had given an encrypted text \""+public_word+"\", which is actually shifted by their secret key, "+Suneo.KEY);
                System.out.println("Hence, they have used Caesar Cipher. So, the original text is: "+ Gian.msgKey);
                
                System.out.println("\nThis text is used as another key for the simple Substituion Cipher, which ultimately deciphers the unknown code Suneo wrote in Gian's notebook");
                System.out.println("It says: "+ Gian.privateMsg);
                
                System.out.println("\nUsing the same two public paremeters, Gian produces a public key: "+public_key);
                System.out.println("Using RSA technique [(ie secret key)^(public key) mod N] , Suneo also releases a ciphertext publicly: "+ciphertext);
                System.out.println("Gian uses his another secret key: "+Gian.RSAprivate+" to decrypt the ciphertext");
                System.out.println("\nThe ciphertext, or the password to the vault, hence generated is: "+Gian.RSAsecret);
                
                System.out.println("\nNobita, after knowing this, went back, like always to tease the two!!!");

                

                break;
            default: System.out.println("Exitting........");
                break;
        }
    }

}
