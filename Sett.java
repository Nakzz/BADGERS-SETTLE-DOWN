import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Sett {
  private Badger topBadger;

  /**
   * Constructs an empty Sett.
   */
  public Sett() {
    this.topBadger = null;
  }

  /**
   * Retrieve the top Badger within this Sett (the one that was settled first).
   * 
   * @return The Badger living on the top of the current Sett.
   */
  public Badger getTopBadger() {
    return this.topBadger;
  }

  /**
   * Checks whether this Sett is empty.
   * 
   * @return true if this Sett is empty, false otherwise.
   */
  public boolean isEmpty() {
    if (this.topBadger != null)
      return true;
    else
      return false;

  }

  /**
   * creates a new badger object with the specified size, and inserts them into this sett (bst). you
   * must implement the naive insert algorithm discussed in zybooks and lecture: which only preserves
   * the order property of each node, and is not guaranteed to result in balance.
   * 
   * Throws: java.lang.IllegalArgumentException - When a Badger with the specified size already exists
   * within this Sett. The message in this exception must read: "WARNING: failed to settle the badger
   * with size {size}, as there is already a badger with the same size in this sett", where {size}
   * needs to be replaced with the specified size parameter.
   * 
   * @param size - The size of the new Badger that will be settled.
   */
  public void settleBadger(int size) throws java.lang.IllegalArgumentException {

    boolean badgerFound =false;
    try {
      findBadger(size);
      badgerFound = true;
    } catch (NoSuchElementException e) {
      badgerFound = false;
    }
    
    
    if(badgerFound)  throw new java.lang.IllegalArgumentException("WARNING: failed to find a badger with size " + size + " in the sett");


    Badger newBadger = new Badger(size);

    if (this.topBadger != null) {

      settleHelper(this.topBadger, newBadger);
    } else {
      this.topBadger = newBadger;
    }
  }

  /**
   * This recursive helper method is used to help settle a new Badger within this Sett.
   * 
   * Throws: java.lang.IllegalArgumentException - When a Badger with the specified size already exists
   * within this Sett. The message in this exception must read: "WARNING: failed to settle the badger
   * with size {size}, as there is already a badger with the same size in this sett", where {size}
   * needs to be replaced with the specified size parameter.
   * 
   * @param current - The current Badger (previously settled within this Sett) that we are considering
   *        settling the newBadger beneath (either to its left or right).
   * @param newBadger - The new Badger that needs to be settled within this Sett.
   */

  private void settleHelper(Badger current, Badger newBadger)
    throws java.lang.IllegalArgumentException {
  // Pointless since base method already checks it but who cares about efficiency. 
    boolean badgerFound =false;
    try {
      findBadger(newBadger.getSize());
      badgerFound = true;
    } catch (NoSuchElementException e) {
      badgerFound = false;
    }
    
    
    if(badgerFound)  throw new java.lang.IllegalArgumentException("WARNING: failed to find a badger with size " + newBadger.getSize() + " in the sett");

    
    if (current.getSize() > newBadger.getSize()) {
      // enter left node
      if (current.getLeftLowerNeighbor() == null)
        current.setLeftLowerNeighbor(newBadger);
      else
        settleHelper(current.getLeftLowerNeighbor(), newBadger);
    } else {
      // enter right node
      if (current.getRightLowerNeighbor() == null)
        current.setRightLowerNeighbor(newBadger);
      else
        settleHelper(current.getRightLowerNeighbor(), newBadger);
    }
  }

  /**
   * Finds a Badger of a specified size in this Sett.
   *
   * Throws: java.util.NoSuchElementException - When there is no Badger in this Sett with the
   * specified size. The message within this exception must read "WARNING: failed to find a badger
   * with size {size} in the sett", where {size} needs to be replaced with the specified size
   * parameter.
   *
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   */
  public Badger findBadger(int size) throws java.util.NoSuchElementException {

    Badger searchedBadger = findHelper(this.topBadger, size);
    
//    try {
//    Badger searchedBadger = findHelper(this.topBadger, size);
//    return searchedBadger;
//    } catch (NoSuchElementException e) {
//      throw new java.util.NoSuchElementException(
//        "WARNING: failed to find a badger with size " + size + " in the sett");
//    }
//    
    //should catch already given error and handle that, correct?
    
    if (searchedBadger == null)
      throw new java.util.NoSuchElementException(
        "WARNING: failed to find a badger with size " + size + " in the sett");
    else
      return searchedBadger;

  }

  /**
   * This recursive helper method is used to help find a Badger within this Sett.
   * 
   * Throws: java.util.NoSuchElementException - When there is no Badger in this Sett with the
   * specified size. The message within this exception must read "WARNING: failed to find a badger
   * with size {size} in the sett", where {size} needs to be replaced with the specified size
   * parameter.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are searching for a
   *        Badger with the specified size within.
   * @param size - The size of the Badger object to search for and return.
   * @return The Badger found with the specified size.
   * @throws java.util.NoSuchElementException
   */

  private Badger findHelper(Badger current, int size) throws java.util.NoSuchElementException {
    
    if (current == null)
      throw new java.util.NoSuchElementException(
        "WARNING: failed to find a badger with size " + size + " in the sett");
    
    if (current.getSize() == size) {
      return current;
    } else if (current.getSize() > size) {
      // enter left node

      current = findHelper(current.getLeftLowerNeighbor(), size);
     
    } else {
      // enter right node
      current = findHelper(current.getRightLowerNeighbor(), size);
    }
    
    return current;

  }

  /**
   * Counts how many Badgers live in this Sett.
   * 
   * @return The number of Badgers living in this Sett.
   */
  public int countBadger() {
    if(this.topBadger != null)
    return countHelper(this.topBadger);
    else return 0;
  }

  /**
   * This recursive helper method is used to help count the number of Badgers in this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are counting the
   *        number of Badgers within.
   * @return the number of Badgers living in the Sett rooted at the current Badger.
   */
  private int countHelper(Badger current) {
    
    int count =0;
    
    if(current == null)
      return count; 
    
    count +=countHelper(current.getLeftLowerNeighbor());
    count +=countHelper(current.getRightLowerNeighbor());
    
    return count+1;

  }

  /**
   * Gets all Badgers living in the Sett as a list in ascending order of their size: smallest one in
   * the front (at index zero), through the largest one at the end (at index size-1).
   * 
   * @return A list of all Badgers living in the Sett in ascending order by size.
   */
  public java.util.List<Badger> getAllBadgers() {
    
    java.util.List<Badger> listOfBadgers = new ArrayList<Badger>();
    
    if(this.topBadger != null) {
      getAllHelper(this.topBadger, listOfBadgers);
    return listOfBadgers;
    } else {
      return null;
    }
  }

  /**
   * This recursive helper method is used to help collect the Badgers within this Sett into a List.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are collecting all
   *        contained Badgers within, into the allBadgers List.
   * @param allBadgers - The list of all Badgers living in the Sett that is rooted at the current
   *        Badger node. The contents of this list should be in ascending order by Badger size.
   */
  private void getAllHelper(Badger current, java.util.List<Badger> allBadgers) {
    
    
    if(current.getLeftLowerNeighbor() != null) {
      getAllHelper(current.getLeftLowerNeighbor(), allBadgers);
 } 
//    System.out.println("Adding another");
    allBadgers.add(current);
    
    if(current.getRightLowerNeighbor() != null) {
      getAllHelper(current.getRightLowerNeighbor(), allBadgers);
 } 
 }


  /**
   * Computes the height of the Sett, as the number of nodes from root to the deepest leaf Badger
   * node.
   * 
   * @return The depth of this Sett.
   */
  public int getHeight() {    
    
    if(this.topBadger != null)
      return getHeightHelper(this.topBadger);
    else return 0;
  }

  /**
   * This recursive helper method is used to help compute the height of this Sett.
   * 
   * @param current - The current Badger that is the root of a (sub) tree that we are calculating the
   *        height of.
   * @return The height of the (sub) tree that we are calculating.
   */
  private int getHeightHelper(Badger current) {

    int height = 0;
    if(current.getLeftLowerNeighbor()==null || current.getRightLowerNeighbor() == null) {
      return height+1;
    } else {
      if(current.getLeftLowerNeighbor()!=null ) {
        height += getHeightHelper(current.getLeftLowerNeighbor());
      }
      
      if(current.getRightLowerNeighbor() != null) {
        height += getHeightHelper(current.getRightLowerNeighbor());
      }     
    }

    return height;

  }

  /**
   * Retrieves the largest Badger living in this Sett.
   * 
   * @return The largest Badger living in this Sett.
   */
  public Badger getLargestBadger() {

    java.util.List<Badger> listOfBadgers = getAllBadgers();
    
    if(this.topBadger != null)
      return listOfBadgers.get(listOfBadgers.size() -1);
    else
      return null;

  }

  /**
   * Empties this Sett, to no longer contain any Badgers.
   * 
   */
  public void clear() {
    this.topBadger = null;
    this.topBadger.setLeftLowerNeighbor(null);
    this.topBadger.setRightLowerNeighbor(null);
  }

}
