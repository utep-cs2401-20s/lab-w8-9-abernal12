import jdk.nashorn.internal.objects.NativeString;

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
      aminoAcid = AminoAcidResources.getAminoAcidFromCodon(inCodon); // looks at the AminoAcidResources and gets the amino acid from the codons given
      codons = AminoAcidResources.getCodonListForAminoAcid(aminoAcid); // looks at the AminoAcidResources and gets the codons list from the amino acids given
      incrCodons(inCodon); //
      next = null;
  }

  /********************************************************************************************/
  /*
   * helperMethod will be used to count the number of codons that create the aminoAcid
   */ // use helper method to count the number of codons that create the aminoAcid
  private void incrCodons(String c){
    for(int i = 0; i < codons.length; i++){
      if(codons[i].equals(c.toUpperCase())){
        counts[i]++;
      }
    }
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
    if(AminoAcidResources.getAminoAcidFromCodon(inCodon) == aminoAcid){ // if this node has this codon
      incrCodons(inCodon); // increments every time the node has the codon
    }else if(next == null) {
      next.addCodon(inCodon);

    }else{
      next = new AminoAcidLL(inCodon); // if the node does not contain the codon, then start again with the next node
    }
  }


  /********************************************************************************************/
  /* Shortcut to find the total number of instances of this amino acid */
  // how many codons does the amino acid have //
  // look at counts, and sum up the elements at counts //
  private int totalCount(){
    int sum = 0;
    for(int i = 0; i < counts.length; i++){
      sum += counts[i];
    }
    return sum;
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
  // sort the list
  // this one doesnt have anything to compare to
  // check if the aminoacids are equal to each other
  ////////////////////////////////////////////////
  // what is the total counts of this(list) node vs the total counts on this node(inList).
  // return the sum of different over whole lists
  // for sure test this method
  public int aminoAcidCompare(AminoAcidLL inList) {
    if(!inList.isSorted()) {
      return -1;
    }
    int diff = 0;
    if(inList == null) {
      diff += totalCount(); // gets the count for the total list
    }
    if(next != null){ // checks to see if it has a pointer to another node and if so compare
      diff += next.aminoAcidCompare(inList.next);
    }
    else if(aminoAcid == inList.aminoAcid) { // total count of aminoAcid and totalCount of inList
      diff = Math.abs(totalCount() - inList.totalCount()); // to get the
      if (next != null) {
        diff += next.aminoAcidCompare(inList.next);
      }
      if (next == null && inList.next != null) {
        diff += aminoAcidCompare(inList.next);
      }
    }else if (next != null && aminoAcid < inList.aminoAcid) {
      diff += totalCount();
      if (next != null) { // if the list is not null, class list
        diff += next.aminoAcidCompare(inList.next);
      }
    }else if(next == null || aminoAcid > inList.aminoAcid){ // class we recieved
      diff += inList.totalCount();
      if(inList.next != null){
        diff += aminoAcidCompare(inList.next);
      }
    }
    return diff;
  }

  /********************************************************************************************/
  /* Same as above, but counts the codon usage differences
   * Must be sorted. */
  // not paying attention to the total counts
  // we use codon difference
  // return sum of differences over lists
  // for sure test this method
  public int codonCompare(AminoAcidLL inList){
    if(!inList.isSorted()) {
      return -1;
    }
    int diff = 0;
    if(inList == null) {
      diff += totalCount(); // gets the count for the total list
    }
    if(next != null){ // checks to see if it has a pointer to another node and if so compare
      diff += next.codonCompare(inList.next);
    }
    else if(aminoAcid == inList.aminoAcid) { // total count of aminoAcid and totalCount of inList
      diff = Math.abs(totalCount() - inList.totalCount()); // to get the
      if (next != null) {
        diff += next.codonCompare(inList.next);
      }
      if (next == null && inList.next != null) {
        diff += codonCompare(inList.next);
      }
    }else if (next != null && aminoAcid < inList.aminoAcid) {
      diff += totalCount();
      if (next != null) { // if the list is not null, class list
        diff += next.codonCompare(inList.next);
      }
    }else if(next == null || aminoAcid > inList.aminoAcid){ // class we recieved
      diff += inList.totalCount();
      if(inList.next != null){
        diff += codonCompare(inList.next);
      }
    }
    return diff;
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

    return a;
  }

  /********************************************************************************************/
  /* Recursively returns the total counts of amino acids in the order that they are in in the linked list. */
  public int[] aminoAcidCounts(){
    
    return new int[]{};
  }


  /********************************************************************************************/
  /* recursively determines if a linked list is sorted or not */
  public boolean isSorted(){
    if(aminoAcid < next.aminoAcid){
      return true; 
    }
    return false;
  }


  /********************************************************************************************/
  /* Static method for generating a linked list from an RNA sequence */
  // with the list created, you will have to use another method
  public static AminoAcidLL createFromRNASequence(String inSequence){
    AminoAcidLL list = null; // created a linked list from the AminoAcidLL
    if(inSequence.length() >= 3 && AminoAcidResources.getAminoAcidFromCodon(inSequence.substring(0,2)) != '*'){
      list = new AminoAcidLL(inSequence.substring(0,3));
      for(int i = 3; i < inSequence.length() - 2; i+=3){ // looks through the RNA string, start at index 3
        if (AminoAcidResources.getAminoAcidFromCodon(inSequence.substring(i, i + 3)) != '*') { //
          list.addCodon(inSequence.substring(i,i+3));
        }else{
          System.out.print("error"); // displays once star is detected
        }
      }
    }
    return list;
  }


  /********************************************************************************************/
  /* sorts a list by amino acid character*/
  public static AminoAcidLL sort(AminoAcidLL inList) {
    AminoAcidLL listSort = inList;
    for(listSort = inList; listSort != null; listSort = listSort.next){

      for(listSort node2 = node1; node2!= null; node2 = node2.next){
        if(min.value > node2.value){
          min = node2;
        }
      }
    }
    return listSort;
  }
}