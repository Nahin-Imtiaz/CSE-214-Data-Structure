/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class represents an HTMLLinkNode.it contains filename,pagetitle,linkName and linkType of that node.it also contains link to the parent node.
 */
public class HTMLLinkNode {


	private HTMLLinkNode parent ;
	
	private HTMLLinkNode[] links;
	/**
	 * this 
	 */
	public HTMLLinkNode() {
		links = new HTMLLinkNode[3];
		
	}
	private String fileName;
	private String pageTitle;
	private String linkName;
	private LinkType linkType;
	
	
	
	
	
	public HTMLLinkNode getParent() {
		return parent;
	}
	public void setParent(HTMLLinkNode parent) {
		this.parent = parent;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFilename(String fileName) {
		this.fileName = fileName;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public LinkType getLinkType() {
		return linkType;
	}
	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}
   
	
	
	
	
	public HTMLLinkNode[] getLinks() {
		return links;
	}
	public void setLinks(HTMLLinkNode[] links) {
		this.links = links;
	}
	
	
	
	
	public boolean isDeadLink() {
		return this.linkType==LinkType.DEAD;
	}
	public boolean isCircularLink() {
		return this.linkType==LinkType.CIRCULAR;
	}
	
	
	public void addLink(HTMLLinkNode newLink) throws FullNodeException, IllegalArgumentException{
		if(newLink!=null ) {
			if(this.links[0]==null) {
				this.links[0]=newLink;
			}
			else if(this.links[1]==null) {
				this.links[1]=newLink;
			}
			else if(this.links[2]==null) {
				this.links[2]=newLink;
			}
			else throw new FullNodeException("All positions in the links array are currently full");
		}
		else throw new IllegalArgumentException(" newLink is not a valid reference to an HTMLLinkNode object.");
	}
	
	
	public HTMLLinkNode getLinkAt(int index) throws IllegalArgumentException{
		if(index>=0 && index<=2) {
			if(this.links[index]!=null){
				return this.links[index];
			}
			else return null;
		}
		else throw new IllegalArgumentException("index is out of bounds of the links array");
	}
	
	
	public boolean equals(Object obj) {
		if (obj instanceof HTMLLinkNode) {
			HTMLLinkNode newLink=(HTMLLinkNode) obj;
			return (this.fileName.equals(newLink.fileName) && this.pageTitle.equalsIgnoreCase(newLink.pageTitle));
		}
		else return false;
	}
	
	
	public String toString() {
		String str="" ;
		
		str+="|-"+this.fileName;
		if(this.linkType==LinkType.CIRCULAR) {
			str+="*";
		}
		if(this.linkName == null) {
			str+=" ";
		}
		else {
			str+=" ("+this.linkName+") ";
		}
	
		if(this.pageTitle==null) {
			str+="***";
		}
		else str+="[ "+this.pageTitle+" ]";
		return str;
	}
}
