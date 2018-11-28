
public class Badger {
  
private Badger leftLowerneighbor;
private Badger rightLowerneighbor;
private final int size;

/**
 * Creates a new Badger with specified size.
 * 
 * @param size - The size of the newly constructed Badger object.
 */
public Badger (int size){
  this.size = size;
}

/**
 * Retrieves neighboring badger that is smaller than this one.
 * 
 * @param The left lower neighbor of current badger.
 */
public Badger getLeftLowerNeighbor() {
  return this.leftLowerneighbor;
  
}


/**
 * Changes this badger's lower left neighbor.
 * 
 * @param badger - The new left lower neighbor of current badger.
 */
public void setLeftLowerNeighbor(Badger badger) {
  this.leftLowerneighbor = badger;
}

/**
 * Retrieves neighboring badger that is larger  than this one.
 * 
 * @param The right lower neighbor of current badger.
 */

public Badger getRightLowerNeighbor() {
  return this.rightLowerneighbor; 
}

/**
 * Changes this badger's lower right  neighbor.
 * 
 * @param badger - The new right  lower neighbor of current badger.
 */
public void setRightLowerNeighbor(Badger badger) {
  this.rightLowerneighbor = badger;
}

/**
 * Retrieves the size of this badger.
 * 
 * @return The size of current badger.
 */
int getSize() {
  return this.size;
}

}


