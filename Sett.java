
public class Sett {
  private Badger topBadger;
  
  /**
   * Constructs an empty Sett.
   */
  public Sett() {
    
  }
  
  /**
   * Retrieve the top Badger within this Sett (the one that was settled first).
   * 
   * @return The Badger living on the top of the current Sett.
   */
  public Badger getTopBadger() {
    return topBadger;
    
  }
  
  /**
   * Checks whether this Sett is empty.
   * 
   * @return true if this Sett is empty, false otherwise.
   */
  public boolean isEmpty() {
    return false;
    
  }
  
  /**
   * creates a new badger object with the specified size, and inserts them into this sett (bst). you must implement the naive insert algorithm discussed in zybooks and lecture: which only preserves the order property of each node, and is not guaranteed to result in balance.
   * 
   * Throws: java.lang.IllegalArgumentException - When a Badger with the specified size already exists within this Sett. The message in this exception must read: "WARNING: failed to settle the badger with size {size}, as there is already a badger with the same size in this sett", where {size} needs to be replaced with the specified size parameter.
   * 
   * @param size - The size of the new Badger that will be settled.
   */
  public void settleBadger(int size)
    throws java.lang.IllegalArgumentException {

    
  }
  
  /**
   * This recursive helper method is used to help settle a new Badger within this Sett.
   * 
   * Throws: java.lang.IllegalArgumentException - When a Badger with the specified size already exists within this Sett. The message in this exception must read: "WARNING: failed to settle the badger with size {size}, as there is already a badger with the same size in this sett", where {size} needs to be replaced with the specified size parameter.
   * 
   * @param current - The current Badger (previously settled within this Sett) that we are considering settling the newBadger beneath (either to its left or right).
   * @param newBadger - The new Badger that needs to be settled within this Sett.
   */
 
  private void settleHelper(Badger current,
    Badger newBadger)
throws java.lang.IllegalArgumentException {
     ;
    
  }
  
  /**
   *Finds a Badger of a specified size in this Sett.
   *
   *Throws: java.util.NoSuchElementException - When there is no Badger in this Sett with the specified size. The message within this exception must read "WARNING: failed to find a badger with size {size} in the sett", where {size} needs to be replaced with the specified size parameter.
   *
   *@param size - The size of the Badger object to search for and return. 
   * @return The Badger found with the specified size.
   */
  public Badger findBadger(int size)
    throws java.util.NoSuchElementException{
    return topBadger;
    
  }
  
  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * 
   * Throws: 
   * java.util.NoSuchElementException - When there is no Badger in this Sett with the specified size. The message within this exception must read "WARNING: failed to find a badger with size {size} in the sett", where {size} needs to be replaced with the specified size parameter.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are searching for a Badger with the specified size within.
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws java.util.NoSuchElementException
   */
  
  private Badger findHelper(Badger current,
    int size)
throws java.util.NoSuchElementException{
  return current;
    
  }
  
  /**
   * Counts how many Badgers live in this Sett.
   * 
   * @return The number of Badgers living in this Sett.
   */
  public int countBadger() {
    return 0;
    
  }
  
  /**
   * This recursive helper method is used to help count the number of Badgers in this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are counting the number of Badgers within.
   * @return the number of Badgers living in the Sett rooted at the current Badger.
   */
  private int countHelper(Badger current) {
    return 0;
    
  }
  
  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their size: smallest one in the front (at index zero), through the largest one at the end (at index size-1).
   * 
   * @return A list of all Badgers living in the Sett in ascending order by size.
   */
  public java.util.List<Badger> getAllBadgers(){
    return null;
    
  }
  
  /**
   * This recursive helper method is used to help collect the Badgers within this Sett into a List.
   * 
   * @param current  - The current Badger that is the root of a (sub) tree that we are collecting all contained Badgers within, into the allBadgers List.
   * @param allBadgers  - The list of all Badgers living in the Sett that is rooted at the current Badger node. The contents of this list should be in ascending order by Badger size.
   */
  private void getAllHelper(Badger current,
    java.util.List<Badger> allBadgers) {
    
  }
  
  /**
   * Computes the height of the Sett, as the number of nodes from root to the deepest leaf Badger node.
   * 
   * @return The depth of this Sett.
   */
  public int getHeight() {
    return 0;
    
  }
  
  /**
   * This recursive helper method is used to help compute the height of this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are calculating the height of.
   * @return The height of the (sub) tree that we are calculating.
   */
  private int getHeightHelper(Badger current) {
    return 0;
    
  }
  
  /**
   * Retrieves the largest Badger living in this Sett.
   * 
   * @return The largest Badger living in this Sett.
   */
  public Badger getLargestBadger() {
    return null;
    
  }
  
  /**
   * Empties this Sett, to no longer contain any Badgers.
   * 
   */
  public void clear() {
    
  }
  
}
