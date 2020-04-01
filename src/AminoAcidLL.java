class AminoAcidLL{
  private char aminoAcid; // the character representing the Amino Acid stored in this element
  private String[] codons; // the codons that represent this Amino Acid
  private int[] counts; // the count of the codon usage... codons.length will be equal to counts.length
  private AminoAcidLL next; // pointer to next node // the next element in the linked list, had the value NULL when the current element is the last

  AminoAcidLL(){

  }


  /********************************************************************************************/
  /* Creates a new node, with a given amino acid/codon 
   * pair and increments the codon counter for that codon.
   * NOTE: Does not check for repeats!! */
  AminoAcidLL(String inCodon){
      aminoAcid = AminoAcidResources.getAminoAcidFromCodon(inCodon); // looks at the AminoAcidResources and gets the amino acid frim the codons given
      codons = AminoAcidResources.getCodonListForAminoAcid(aminoAcid); // looks at the AminoAcidResources and gets the codons list from the amino acids given
      incrCodons(inCodon); //
      next = null;
  }

  /********************************************************************************************/
  /*
   * helperMethod will be used to count the number of codons that create the aminoAcid
   */ // use helper method to count the number of codons that create the aminoAcid
  private void incrCodons(String c){

  }
  /********************************************************************************************/
  /* Recursive method that increments the count for a specific codon:
   * If it should be at this node, increments it and stops, 
   * if not passes the task to the next node. 
   * If there is no next node, add a new node to the list that would contain the codon.
   * addCodon will use the helper method to look and compare through the string array
   */
  private void addCodon(String inCodon){
      // base case
      if(next == null){ // if aminoAcid is equal to aminoAcid node
        if(aminoAcid == AminoAcidResources.getAminoAcidFromCodon(inCodon)){ // if this node has this codon
          incrCodons(inCodon); // increments every time the node has the codon
        }else{
          next = new AminoAcidLL(); // if the node does not contain the codon, then start again with the next node
        }
      }
      if(aminoAcid == AminoAcidResources.getAminoAcidFromCodon(inCodon)){ // if the amino acid is equal to the aminoacid character from the amino acid resources class
        incrCodons(inCodon); // then increment the number of codons
      }else{
        if(next != null){ // if the next node does not equal to null
          next.addCodon(inCodon); // add another codon to check to see if it fits within the aminoacid
        }
      }
  }


  /********************************************************************************************/
  /* Shortcut to find the total number of instances of this amino acid */
  // how many codons does the amino acid have //
  // look at counts, and sum up the elements at counts //
  private int totalCount(){
    //the aminoAcid as a character
    //the codons which are 3-length Strings of the codons which can make up this amino acid
    //the counts which is a list of the same size as the number of possible codons which can make this amino acid -- it keeps count of how many of which codons made this amino acid --- hint this is what you'll focus on in the totalCount() method
    //the next node, which is a reference to the next element in this Linked List
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // first check from the amino acid resources under get codon list from aminio acid to see how many codons the certain amino acid conatains
    // for example, if the chosen amino acid is K, then the number of codons it would return is a 2, since there are two sets of codons that correspond to that particular amino acid
    if(aminoAcid == AminoAcidResources.getAminoAcidFromCodon(codons)){ // if the amino acid chosen equals to the same amino acid from the get amino acid from codon
      // then it will look at the codons from that specific amino acid.
      // after, it will the return the number of codons the amino acid has
    }
    // then look at the counts and add up the number of elements at the counts
    return 0;
    //then return sum
  }

  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
  *  must be matching, but this is not tracked */
  private int totalDiff(AminoAcidLL inList){
    return Math.abs(totalCount() - inList.totalCount());
  }


  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
  *  must be matching, but this is not tracked */
  private int codonDiff(AminoAcidLL inList){
    int diff = 0;
    for(int i=0; i<codons.length; i++){
      diff += Math.abs(counts[i] - inList.counts[i]);
    }
    return diff;
  }

  /********************************************************************************************/
  /* Recursive method that finds the differences in **Amino Acid** counts. 
   * the list *must* be sorted to use this method */
  public int aminoAcidCompare(AminoAcidLL inList){
    return 0;
  }

  /********************************************************************************************/
  /* Same as above, but counts the codon usage differences
   * Must be sorted. */
  public int codonCompare(AminoAcidLL inList){
    return 0;
  }


  /********************************************************************************************/
  /* Recursively returns the total list of amino acids in the order that they are in in the linked list. */
  // combination of loops and recursion //
  //
  public char[] aminoAcidList(){
    if(next == null){
      return new char[]{};
    }
    char[] a = next.aminoAcidList();
    char[] len = new char[a.length + 1]; // creating a new array with 1 size bigger than the other one

  }

  /********************************************************************************************/
  /* Recursively returns the total counts of amino acids in the order that they are in in the linked list. */
  public int[] aminoAcidCounts(){
    
    return new int[]{};
  }


  /********************************************************************************************/
  /* recursively determines if a linked list is sorted or not */
  public boolean isSorted(){

    return false;
  }


  /********************************************************************************************/
  /* Static method for generating a linked list from an RNA sequence */
  public static AminoAcidLL createFromRNASequence(String inSequence){
    AminoAcidLL list = new AminoAcidLL();
    for(int i = 0; i < inSequence.length(); i++){ // looks through the RNA string

    }
    return null;
  }


  /********************************************************************************************/
  /* sorts a list by amino acid character*/
  public static AminoAcidLL sort(AminoAcidLL inList){
    return null;
  }
}