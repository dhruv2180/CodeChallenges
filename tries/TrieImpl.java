//Trie  (Prefix tree implementation)
class TrieNode{
	char val;
    HashMap<Character,TrieNode> child;
    boolean isWord;
    String Word;

    public TrieNode(){
    	this.child=new HashMap<>();
    	this.isWord=false;
    }
    public TrieNode(char val){
    	this.val=val;
    	this.child=new HashMap<>();
    	this.isWord=false;
    }
    public boolean setWord(String word){
    	this.Word=word;
    	isWord=true;
    	return true;
    }
}

class Trie{

	TrieNode root;

	public Trie(TrieNode root){
		this.root=root;
	}
	public void addWord(String word){
		TrieNode temp=root;
		char tempChar;
		for(int i=0;i<word.length();i++){
			tempChar=word.charAt(i);
			if(temp.child.containsKey(tempChar)){
				temp=temp.child.get(tempChar);
			}else{
				TrieNode temp2=new TrieNode(tempChar);
				temp.child.put(tempChar, temp2);
				temp=temp2;
			}
		}
		temp.Word=word;
		temp.isWord=true;
	}

	public boolean isWord(String word){
		char tempChar;
		TrieNode temp=root;
		for(int i=0;i<word.length();i++){
			tempChar=word.charAt(i);
			if(temp.child.containsKey(tempChar)){
				temp=temp.child.get(tempChar);
			}else{
				return false;
			}
		}
		if(temp.isWord && temp.Word.equals(word)){
			return true;
		}
		else{
			return false;
		}
	}
}


public class TrieImpl {

	public static void main(String[] args) {

		TrieNode root=new TrieNode();
		Trie trie=new Trie(root);

    //add word test cases
		trie.addWord("cricket");
		trie.addWord("cricketer");

    //test cases
    System.out.println(trie.isWord("cricket"));
		System.out.println(trie.isWord("crick"));
		System.out.println(trie.isWord("cricketer"));
		System.out.println(trie.isWord("cricketers"));
	}
}
