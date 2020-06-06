import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class WebTree {
	private static HTMLLinkNode root;
	static WebTree webTree = new  WebTree();
	static int active,circular,dead,total;
	static boolean done=false;
	static boolean ok=false;
	

	public static WebTree crawlHTML(String fileName) throws IllegalArgumentException, IOException{
		root= new HTMLLinkNode();
		root.setFilename(fileName);
		root.setLinkType(LinkType.ACTIVE);
		
		FileInputStream fis =null;
		try {
		fis = new FileInputStream(fileName);
		}
		catch(Exception e) {
			
			System.out.println("No such file '"+fileName+"'.");
		}
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(inStream);
		
			String data ;
			
			int counter=0;
			String[] str= new String[3];
			
			while((data =reader.readLine())!=null) {
				
				if(data.contains("</title>")) {
					String title = data.substring(data.indexOf("<title>")+7, data.indexOf("</title>"));
					root.setPageTitle(title);
				}
				if(data.contains("</a>")) {
					
					String temp = data;
					counter = 0;
					while(temp.contains("</a>")&&counter<3) {
						
						str[counter] = temp.substring(temp.indexOf("<a href=")+9,temp.indexOf("</a>")+4);
						
						counter++;
					
						temp = temp.substring(temp.indexOf("</a>")+4);
						
					}
					for(int i=0;i<counter && i<3;i++) {
					
						HTMLLinkNode newNode = new HTMLLinkNode();
						String file,linkName;
						
						file= str[i].substring(0, str[i].indexOf(">")-1);
						
						linkName = str[i].substring(str[i].indexOf(">")+1, str[i].indexOf("</a>"));
						newNode.setFilename(file);
						newNode.setLinkName(linkName);
						newNode.setParent(root);
									
						try {
					
							root.addLink(newNode);
						}catch(FullNodeException e) {
							
						}finally {
							
							crawlHTMLHelper(newNode,newNode.getFileName());
							
						}
					
					}
				}
		
			}
			total=active+circular+dead;
			System.out.println("'"+fileName+"' successfully crawled.");
			System.out.println(active+" active links followed ");
			System.out.println(circular+" circular links found");
			System.out.println(dead+" dead links found");
			System.out.println(total+" total links found ");	
		return webTree;
	}
	public static void crawlHTMLHelper(HTMLLinkNode newRoot,String fileName) throws IllegalArgumentException, IOException {
			
		FileInputStream fis = null;
		try {
			
			fis = new FileInputStream(fileName);
			
		}
		catch(Exception e) {
			
			newRoot.setLinkType(LinkType.DEAD);
			dead++;
			return;
		}
		
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(inStream);
			
		String data =reader.readLine();
			
		int counter=0;
		String[] str= new String[3];
		
		
		
		while(data!=null) {
			if(data.contains("</title>")) {
				
				String title = data.substring(data.indexOf("<title>")+7, data.indexOf("</title>"));
				newRoot.setPageTitle(title);
			}
			data=reader.readLine();
		}
		
		fis = null;
		try {
			
			fis = new FileInputStream(fileName);
			
		}
		catch(Exception e) {
			
			newRoot.setLinkType(LinkType.DEAD);
			dead++;
			return;
		}
		inStream = new InputStreamReader(fis);
		reader = new BufferedReader(inStream);
			
		data =reader.readLine();
		
		
		while(data!=null) {
		
			
			
			
			if(existsAsAncestor(newRoot)) {
				
				newRoot.setLinkType(LinkType.CIRCULAR);
				circular++;
				return;
			}
			else {
				newRoot.setLinkType(LinkType.ACTIVE);
				active++;
			}
			 
			
			if(data.contains("</a>")) {
				
				String temp = data;
				counter = 0;
				while(temp.contains("</a>")&&counter<3) {
					str[counter] = temp.substring(temp.indexOf("<a href=")+9,temp.indexOf("</a>")+4);
					counter++;
					temp = temp.substring(temp.indexOf("</a>")+4);
				}
				
				for(int i=0;i<counter;i++) {
					HTMLLinkNode newNode = new HTMLLinkNode();
					String file,linkName;
				
					file= str[i].substring(0, str[i].indexOf(">")-1);
					newNode.setFilename(file);
					
					linkName = str[i].substring(str[i].indexOf(">")+1, str[i].indexOf("</a>"));
					
					newNode.setLinkName(linkName);
					newNode.setParent(newRoot);
						
					
					try {
						
						newRoot.addLink(newNode);
					}catch(FullNodeException e) {
					
					}finally {
					
						crawlHTMLHelper(newNode,newNode.getFileName());
					
					}
						
				}
				
			}
			
			data=reader.readLine();
		}
		
	}
	
	public static boolean existsAsAncestor(HTMLLinkNode node) {
		if(node.getParent() != null) {
			return existsAsAncestorHelper(node,node.getParent());
		}
		else return false;
	}
	public static boolean existsAsAncestorHelper(HTMLLinkNode node, HTMLLinkNode parent) {
		if(node != root && parent !=null) {	
			if(node.equals(parent)) {
				return true;
			}
			else return existsAsAncestorHelper(node,parent.getParent());
		}
		else return false;
	}
	
	
	public static void printWebTree() {
		if(root==null) {
			System.out.println("The tree is empty");
		}
		else {
			
			String str="";
			printWebTreeHelper(root,str);
			
		}
	}
	public static void printWebTreeHelper(HTMLLinkNode root,String str) {
		if(root==null) return;
		else {
			String newStr=str+"    ";
			
			System.out.print(str);
			System.out.println(root);
			if(root.getLinkAt(0)!=null) {
				printWebTreeHelper(root.getLinkAt(0),newStr);
			}
			if(root.getLinkAt(1)!=null) {
				printWebTreeHelper(root.getLinkAt(1),newStr);
			}
			if(root.getLinkAt(2)!=null) {
				printWebTreeHelper(root.getLinkAt(2),newStr);
			}
		}	
	}
	public static void printDeadLink(HTMLLinkNode node,String[] d,int i){
		if(printHelper(node,d,i)==false){
			System.out.println("");
			System.out.println("No dead link found.");
			ok=false;

		}
		else printHelper(node,d,i);
	}
	
	public static boolean printHelper(HTMLLinkNode node,String[] d,int i) {
		if(node != null && node.getLinkType() != LinkType.CIRCULAR) {
			d[i] = node.getFileName();
			i++;
			if(node.getLinkType() == LinkType.DEAD) {
				for(int j=0; j<i-2;j++) {
					System.out.print(d[j]+"->");
				}
				System.out.println(d[i-2]+" contains dead link '"+node.getLinkName()+"' with"
						+ " target '"+d[i-1]+"'");
				ok=true;
			}
			if(node.getLinkAt(0)!= null && node.getLinkType() != LinkType.DEAD) {
				printHelper(node.getLinkAt(0),d,i);
			}
			if(node.getLinkAt(1)!= null && node.getLinkType() != LinkType.DEAD) {
				printHelper(node.getLinkAt(1),d,i);
			}
			if(node.getLinkAt(2)!= null && node.getLinkType() != LinkType.DEAD) {
				printHelper(node.getLinkAt(2),d,i);
			}
			return ok;
		}
		else return ok;
	}
	public static HTMLLinkNode getRoot() {
		return root;
	}
	public static void search(String keyword,HTMLLinkNode node,String[] d,int i) throws IllegalArgumentException{
		searchHelper(keyword,node,d,i);
		if(done==false){
			System.out.println("");
			System.out.println("No page found with the keyword "+keyword+".");
			done=false;
		}
	}
	
	public static void searchHelper(String keyword,HTMLLinkNode node,String[] d,int i) throws IllegalArgumentException{
		if(node != null && node.getLinkType() != LinkType.DEAD&& node.getLinkType() != LinkType.CIRCULAR) {
			d[i] = node.getFileName();
			i++;
			String s = (node.getPageTitle()).toUpperCase();
			String t = keyword.toUpperCase();
			if(s.contains(t)) {
				for(int j=0; j<i-1;j++) {
					System.out.print(d[j]+"->");
				}
				System.out.println(d[i-1]);
				done=true;
			}
			if(node.getLinkAt(0)!= null && node.getLinkType() != LinkType.CIRCULAR) {
				searchHelper(keyword,node.getLinkAt(0),d,i);
			}
			if(node.getLinkAt(1)!= null && node.getLinkType() != LinkType.CIRCULAR) {
				searchHelper(keyword,node.getLinkAt(1),d,i);
			}
			if(node.getLinkAt(2)!= null && node.getLinkType() != LinkType.CIRCULAR) {
				searchHelper(keyword,node.getLinkAt(2),d,i);
			}
		}
		else return;
	}
	
	public static void resetTreeStructure() {
		active=0;
		dead=0;
		circular=0;
		total=0;
		root=null;
		
	}
}
