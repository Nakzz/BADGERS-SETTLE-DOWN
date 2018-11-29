//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Badgers Settle Down
// Course: CS300, Fall 2018
//
// Author: Ajmain Naqib
// Email: naqib@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __ Write-up states that pair programming is allowed for this assignment.
// __ We have both read and understand the course Pair Programming Policy.
// __ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: 
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * Badger class that contain's information of  size and nearby badgers.
 * 
 * @author Ajmain Naqib
 *
 */
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


