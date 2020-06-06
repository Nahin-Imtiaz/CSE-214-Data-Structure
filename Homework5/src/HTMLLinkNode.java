/**
 * @author Nahin Imtiaz
 *		email: nahin.imtiaz@stonybrook.edu
 *		Stony brook ID : 111214466
 *		Instructor : Juan Tarquino
 *		Section -06
 *
 *this class represents an HTMLLinkNode.it contains filename,pagetitle,linkName
 * and linkType of that node.it also contains link to the parent node.
 */
public class HTMLLinkNode {
	private HTMLLinkNode parent ;
	private HTMLLinkNode[] links;
	/**
	 * this  is default constructor to create an object of this class.This 
	 * method also declares the size of children for this node as well.
	 */
	public HTMLLinkNode() {
		links = new HTMLLinkNode[3];
	}
	private String fileName;
	private String pageTitle;
	private String linkName;
	private LinkType linkType;
	/**
	 * this method returns parent of this HTMLLinkNode
	 * @return
	 */
	public HTMLLinkNode getParent() {
		return parent;
	}
	/**
	 * this method sets the parent of this HTMLLinkNode
	 * @param parent
	 */
	public void setParent(HTMLLinkNode parent) {
		this.parent = parent;
	}
	/**
	 *this method sets the fileName of this HTMLLinkNode 
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * this method sets the fileName of this HTMLLinkNode
	 * @param fileName
	 */
	public void setFilename(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * this method returns the pageTitle of this HTMLLinkNode
	 * @return
	 */
	public String getPageTitle() {
		return pageTitle;
	}
	/**
	 *this method sets the pageTitle of this HTMLLinkNode 
	 * @param pageTitle
	 */
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	/**
	 * this method sets the linkName of this HTMLLinkNode
	 * @return
	 */
	public String getLinkName() {
		return linkName;
	}
	/**
	 * this method returns the linkName of this HTMLLinkNode
	 * @param linkName
	 */
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	/**
	 * this method returns the linkType of this HTMLLinkNode
	 * @return
	 */
	public LinkType getLinkType() {
		return linkType;
	}
	/**
	 * this method sets the linkType of this HTMLLinkNode 
	 * @param linkType
	 */
	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}
	/**
	 * this method returns the HTMLLinkNode array 
	 * @return
	 */
	public HTMLLinkNode[] getLinks() {
		return links;
	}
	/**
	 * this method sets the HTMLLinkNode array
	 * @param links
	 */
	public void setLinks(HTMLLinkNode[] links) {
		this.links = links;
	}
	/**
	 * this method checks if the link is dead or not
	 * @return
	 */
	public boolean isDeadLink() {
		return this.linkType==LinkType.DEAD;
	}
	/**
	 * this method checks if the link is circular or not
	 * @return
	 */
	public boolean isCircularLink() {
		return this.linkType==LinkType.CIRCULAR;
	}
	/**
	 * this method adds the newNode to the parent of this nde
	 * @param newLink
	 * this is the link to be added
	 * @throws FullNodeException
	 * throws exception if node is full
	 * @throws IllegalArgumentException
	 * throws exception if node is not valid
	 */
	public void addLink(HTMLLinkNode newLink) throws FullNodeException
	  , IllegalArgumentException{
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
			else throw new FullNodeException("All positions in the links array"
			  + " are currently full");
		}
		else throw new IllegalArgumentException(" newLink is not a valid "
		  + "reference to an HTMLLinkNode object.");
	}
	/**
	 *this method returns the HTMLLinkNode at a given index 
	 */
	public HTMLLinkNode getLinkAt(int index) throws IllegalArgumentException{
		if(index>=0 && index<=2) {
			if(this.links[index]!=null){
				return this.links[index];
			}
			else return null;
		}
		else throw new IllegalArgumentException("index is out of bounds of "
	      + "the links array");
	}
	/**
	 * this method checks if two nodes are equal or not
	 */
	public boolean equals(Object obj) {
		if (obj instanceof HTMLLinkNode) {
			HTMLLinkNode newLink=(HTMLLinkNode) obj;
			return (this.fileName.equals(newLink.fileName) && this.pageTitle
			  .equalsIgnoreCase(newLink.pageTitle));
		}
		else return false;
	}
	/**
	 * this is an string representation of a HTMLLinkNode object
	 */
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
