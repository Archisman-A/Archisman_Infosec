
import java.util.*;

public class Infosec
{
    Scanner sc= new Scanner(System.in);
    
    String CaesarEncrypt()
    {
        //required inputs
        System.out.println("Enter original text");
        String str= sc.next()+sc.nextLine();
        System.out.println("Enter how much shift is desired");
        int shift= sc.nextInt();
        
        shift= shift%26;//as alphabets shifting is cyclic
        String newstr="";
        
        //performs the letter shifting operation
        for(int i=0;i<str.length();i++)
        {
            char ch= str.charAt(i);
            char newch=' ';
            
            if(ch>='A' && ch<='Z')
            {
                int k= ch+shift;
                if(k>90)
                {
                    k-=90;
                    k+=64;
                }
                newch= (char)k;
                
            }
            else if(ch>='a' && ch<='z')
            {
                int k= ch+shift;
                if(k>122)
                {
                    k-=122;
                    k+=96;
                }
                newch= (char)k;
            }
            else 
            {
                newch=ch;
            }
            
            newstr += newch;
        }
        return newstr;
    }
    String CaesarEncrypt(String str, int shift)
    {
        str=str.toLowerCase();      
        shift= shift%26;//as alphabets shifting is cyclic
        String newstr="";
        
        //performs the letter shifting operation
        for(int i=0;i<str.length();i++)
        {
            char ch= str.charAt(i);
            char newch=' ';
            
            if(ch>='A' && ch<='Z')
            {
                int k= ch+shift;
                if(k>90)
                {
                    k-=90;
                    k+=64;
                }
                newch= (char)k;
                
            }
            else if(ch>='a' && ch<='z')
            {
                int k= ch+shift;
                if(k>122)
                {
                    k-=122;
                    k+=96;
                }
                newch= (char)k;
            }
            else 
            {
                newch=ch;
            }
            
            newstr += newch;
        }
        return newstr;
    }
    String CaesarDecrypt()
    {
        //required inputs
        System.out.println("Enter text to be decrypted");
        String str= sc.next()+sc.nextLine();
        System.out.println("Enter how much shift is desired");
        int shift= sc.nextInt();
        shift= shift%26;
        String newstr="";
        
        //loop performs backshifting of letters
        for(int i=0;i<str.length();i++)
        {
            char ch= str.charAt(i);
            char newch=' ';
            
            if(ch>='A' && ch<='Z')
            {
                int k= ch-shift;
                if(k<65)
                {
                    k=65-k;
                    k=91-k;
                }
                newch= (char)k;
                
            }
            else if(ch>='a' && ch<='z')
            {
                int k= ch-shift;
                if(k<97)
                {
                    k=97-k;
                    k=123-k;
                }
                newch= (char)k;
            }
            else 
            {
                newch=ch;
            }
            
            newstr += newch;
        }
        return newstr;
    }
    String CaesarDecrypt(String str, int shift)
    {
        str=str.toLowerCase();
        shift= shift%26;
        String newstr="";
        
        //loop performs backshifting of letters
        for(int i=0;i<str.length();i++)
        {
            char ch= str.charAt(i);
            char newch=' ';
            
            if(ch>='A' && ch<='Z')
            {
                int k= ch-shift;
                if(k<65)
                {
                    k=65-k;
                    k=91-k;
                }
                newch= (char)k;
                
            }
            else if(ch>='a' && ch<='z')
            {
                int k= ch-shift;
                if(k<97)
                {
                    k=97-k;
                    k=123-k;
                }
                newch= (char)k;
            }
            else 
            {
                newch=ch;
            }
            
            newstr += newch;
        }
        return newstr;
    }
    
    public String remDuplicate(String str)//removes duplicate character in a string, eg. REDEEM => REDM
    {
        String newstr="";
        for(int i=0;i<str.length();i++)
        {
            char ch= str.charAt(i);
            if(newstr.indexOf(ch) == -1)//if character doesn't repeat
            newstr+=ch;
        }
        return newstr;
    }
    public String arrayToStr(char ch[], int startIndex)//a recursive function to convert a character array to string 
    {
        if(startIndex==ch.length)//termination condition
        return "";
        else 
        return ""+ ch[startIndex] + arrayToStr(ch, startIndex+1); 
    }
    public int FindIndex(char arr[], char ch)//to find index of a character in an array
    {
        for(int i=0;i<arr.length;i++)
        if(ch==arr[i]) return i;
        return -1;//if character is not present
    }
    String SubstituteEncrypt()
    {
        //required inputs
        System.out.println("Enter your original message");
        String str= sc.next()+sc.nextLine();
        str=str.toLowerCase();
        System.out.println("Enter your key for substitution cipher");
        String key= sc.next()+sc.nextLine();
        key=key.toLowerCase();
        
        String key_mod= remDuplicate(key);
        
        char plain[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char cipher[]= new char[26];
        
        for(int i=0;i<26;i++)//forms the cipher text using the key
        {
            int k=0;
            for(int j=0;j<key_mod.length();j++)
            {
                char ch= key_mod.charAt(k++);
                cipher[j]=ch;
            }
            for(int j=0;j<26;j++)
            {
                char ch= plain[j];
                if(key_mod.indexOf(ch) == -1)
                cipher[k++]= ch;
            }
        }
        
        String plainstr = arrayToStr(plain,0);
        String cipherstr = arrayToStr(cipher,0);
        System.out.println("plain-text: "+plainstr +"\ncipher-text: "+ cipherstr);
        
        String newstr="";
        
        for(int i=0;i<str.length();i++)//performs encryption
        {
            char ch= str.charAt(i);
            if(Character.isLetter(ch) == false)
            {
                newstr+=ch;
                continue;
            }
            int k= FindIndex(plain,ch);
            ch= cipher[k];
            newstr+=ch;
            
        }
        
        return newstr;
        
    }
    String SubstituteEncrypt(String str, String key)
    {
        
        str=str.toLowerCase();key=key.toLowerCase();
        String key_mod= remDuplicate(key);
        
        char plain[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char cipher[]= new char[26];
        
        for(int i=0;i<26;i++)//forms the cipher text using the key
        {
            int k=0;
            for(int j=0;j<key_mod.length();j++)
            {
                char ch= key_mod.charAt(k++);
                cipher[j]=ch;
            }
            for(int j=0;j<26;j++)
            {
                char ch= plain[j];
                if(key_mod.indexOf(ch) == -1)
                cipher[k++]= ch;
            }
        }
        
        String plainstr = arrayToStr(plain,0);
        String cipherstr = arrayToStr(cipher,0);
        //System.out.println("plain-text: "+plainstr +"\ncipher-text: "+ cipherstr);
        
        String newstr="";
        
        for(int i=0;i<str.length();i++)//performs encryption
        {
            char ch= str.charAt(i);
            if(Character.isLetter(ch) == false)
            {
                newstr+=ch;
                continue;
            }
            int k= FindIndex(plain,ch);
            ch= cipher[k];
            newstr+=ch;
            
        }
        
        return newstr;
        
    }
    String SubstituteDecrypt()
    {
        //required inputs
        System.out.println("Enter the encrypted message");
        String str= sc.next()+sc.nextLine();
        str=str.toLowerCase();
        System.out.println("Enter your key to decrypt it");
        String key= sc.next()+sc.nextLine();
        key=key.toLowerCase();
        
        String key_mod= remDuplicate(key);
        
        
        char plain[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char cipher[]= new char[26];
        
        for(int i=0;i<26;i++)//forms the cipher text using the key
        {
            int k=0;
            for(int j=0;j<key_mod.length();j++)
            {
                char ch= key_mod.charAt(k++);
                cipher[j]=ch;
            }
            for(int j=0;j<26;j++)
            {
                char ch= plain[j];
                if(key_mod.indexOf(ch) == -1)
                cipher[k++]= ch;
            }
        }
        
        String plainstr = arrayToStr(plain,0);
        String cipherstr = arrayToStr(cipher,0);
        System.out.println("plain-text: "+plainstr +"\ncipher-text: "+ cipherstr);
        
        String newstr="";
        
        for(int i=0;i<str.length();i++)//performs decryption 
        {
            char ch= str.charAt(i);
            if(Character.isLetter(ch) == false)
            {
                newstr+=ch;
                continue;
            }
            int k= FindIndex(cipher,ch);
            ch= plain[k];
            newstr+=ch;
            
        }
        
        return newstr;
        
    }
    String SubstituteDecrypt(String str, String key)
    {
        
        str=str.toLowerCase();key=key.toLowerCase();
        String key_mod= remDuplicate(key);
        
        
        char plain[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char cipher[]= new char[26];
        
        for(int i=0;i<26;i++)//forms the cipher text using the key
        {
            int k=0;
            for(int j=0;j<key_mod.length();j++)
            {
                char ch= key_mod.charAt(k++);
                cipher[j]=ch;
            }
            for(int j=0;j<26;j++)
            {
                char ch= plain[j];
                if(key_mod.indexOf(ch) == -1)
                cipher[k++]= ch;
            }
        }
        
        String plainstr = arrayToStr(plain,0);
        String cipherstr = arrayToStr(cipher,0);
        //System.out.println("plain-text: "+plainstr +"\ncipher-text: "+ cipherstr);
        
        String newstr="";
        
        for(int i=0;i<str.length();i++)//performs decryption 
        {
            char ch= str.charAt(i);
            if(Character.isLetter(ch) == false)
            {
                newstr+=ch;
                continue;
            }
            int k= FindIndex(cipher,ch);
            ch= plain[k];
            newstr+=ch;
            
        }
        
        return newstr;
        
    }
    
    boolean isPrime(int n)//checks a no is prime or not
    {
        int c=0;
        for(int i=1;i<=n;i++)
        if(n%i==0) c++;
        return c==2;//if only 2 factors exist, it will return true
    }
    
    //private attributes
    int privateKey, KEY;
    String privateMsg, msgKey;
    int RSAprivate, RSApublic, RSAsecret;
    
    void inputKey()
    {
        privateKey= sc.nextInt();
    }
    boolean isPrimitiveRoot(int A, int B)
    {
        String str="";
        
        for(int i=1;i<B;i++)//notes down all its remainder values
        {
            int q= function(A,i,B);
            str+= q+" ";
        }
        
        for(int i=1;i<B;i++)//checks if all nu=os are present
        {
            String s= ""+i;
            if(str.indexOf(s) == -1)
            return false;
        }
        return true;
    }
    void DiffieHellman(Infosec person1, Infosec person2)
    {
        //required inputs
        System.out.println("For the condition A mod B,");
        System.out.print("Enter a prime no (if possible, a large no), B: ");
        int B= sc.nextInt();
        System.out.print("\nAnd, enter its primitive root, A: ");
        int A= sc.nextInt();
        System.out.println();
        
        if(isPrime(B)==false || isPrimitiveRoot(A,B) == false)//required condition for A and B
        {
            System.out.println("Please redo, as A is not a primitive root of B");
            return ;
        }
        
        
        int public_key1, public_key2;//these values are open to all
        
        
        
        public_key1= function(A, person1.privateKey,B);
        public_key2= function(A,person2.privateKey,B);
        
        person1.KEY= function(public_key2, person1.privateKey, B);
        person2.KEY= function(public_key1, person2.privateKey, B);
        
        System.out.println("The public keys are: "+public_key1+" and "+public_key2);
        
        return ;
    }
    void inputRSAreceiver()
    {
        RSAprivate= sc.nextInt();
    }
    void inputRSAsender()
    {
        RSAsecret= sc.nextInt();
    }
    void RSA(Infosec sender)
    {
        System.out.println("Enter two numbers");
        Scanner sc= new Scanner(System.in);
        //public parameters
        int p= sc.nextInt();
        System.out.println("and");
        int q= sc.nextInt();
        
        int n= p*q, z= (p-1)*(q-1);
        
        System.out.println("Enter public key within 1 and "+z);
        this.RSApublic = sender.RSApublic = sc.nextInt();//public key
        
        if(this.RSApublic<=1 || this.RSApublic>=z)//if out of required range
        {
            System.out.println("Incorrect public key");
            return ;
        }
        
        System.out.println("Enter private key of the receiver");
        
        while (true)
        {
            this.inputRSAreceiver();
            
            if( (this.RSAprivate*this.RSApublic)%z ==1)
            break;
            else
            System.out.println("Private key doesn't match required conditions; try again");//(required condition: public key)*(private key) = 1 mod z
        }
        
        
        
        int ciphertext  =function(sender.RSAsecret, sender.RSApublic, n);//ciphertext is available publicly
        this.RSAsecret = function(ciphertext, this.RSAprivate, n);//only known to receiver and the sender of this ciphertext
         
    }
    
    int function(int a, int b, int c) //performs a^b mod c (for large powers)
    {
        int copy=a%c;
        for(int i=1;i<b;i++)
        {
            copy*=a;
            copy %= c;
        }
        return copy;
    }
    
    
}
