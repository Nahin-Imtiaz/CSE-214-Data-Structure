import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		
		/*Scanner reader = new Scanner(System.in);
		System.out.println("Enter: ");
		
		/*String s = read.nextLine();
		
		
		/*if(s.contains("</a>")) {
			String[] str= new String[3];
			String temp = s;
			int counter =0;
			while(temp.contains("</a>") && counter!=3) {
				
				str[counter] = temp.substring(temp.indexOf("<a href=")+9,temp.indexOf("</a>")+4);
				
				counter++;
				
				
				temp = temp.substring(temp.indexOf("</a>")+4);
			}
			for(int i=0;i<counter;i++) {
				String file,linkName;
			
				file= str[i].substring(0, str[i].indexOf(">")-1);
				linkName = str[i].substring(str[i].indexOf(">")+1, str[i].indexOf("</a>"));
				System.out.println(file);
				System.out.println(linkName);
			}
		}
		
		System.out.println();*/
		
		/*
		String data = reader.nextLine();
		HTMLLinkNode root = new HTMLLinkNode();
		
		int counter=0;
		String[] str= new String[3];
		while(data!=null) {
			
			if(data.contains("</title>")) {
				String title = data.substring(data.indexOf("<title>")+7, data.indexOf("</title>"));
				root.setPageTitle(title);
			}
			if(data.contains("</a>")) {
				
				String temp = data;
				while(temp.contains("</a>")&&counter<3) {
					
					str[counter] = temp.substring(temp.indexOf("<a href=")+9,temp.indexOf("</a>")+4);
					
					counter++;
				
					temp = temp.substring(temp.indexOf("</a>")+4);
					
				}
				for(int i=0;i<counter ;i++) {
				
					HTMLLinkNode newNode = new HTMLLinkNode();
					String file,linkName;
					
					file= str[i].substring(0, str[i].indexOf(">")-1);
					
					linkName = str[i].substring(str[i].indexOf(">")+1, str[i].indexOf("</a>"));
					newNode.setFilename(file);
					newNode.setLinkName(linkName);
					newNode.setParent(root);
					

					System.out.println(i);
					System.out.println(newNode.getLinkType()+"    "+newNode.getFileName());
					
					System.out.println();
					
					root.addLink(newNode);
					

				
				}
			}
			data = null;
		}
		
		*/
		WebTree webTree = new WebTree();
		webTree.crawlHTML("shapes.html");
		webTree.printWebTree();
	}

}
