//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ASCII Art
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
 * Test class for ASCII Art program
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */
public class P9Tests {

  public static void main(String[] args) {

    int test = 3;

    if (badgerLeftTest())
      test--;
    else
      System.out.println("badgerLeftTest failed!");

    if (badgerRightTest())
      test--;
    else
      System.out.println("badgerRightTest failed!");
    
    if (settTest())
      test--;
    else
      System.out.println("settTest failed!");

    System.out.println(test + " tests failed!");

  }

  /**
   * This method checks functionality of Badger class's left Neighbor functionality
   * 
   * @return true if test passed, false if failed
   */
  public static boolean badgerLeftTest() {
    Badger topBadger = new Badger(5);
    
    int leftBadgerSize = 3;
    Badger leftBadger = new Badger(leftBadgerSize);
    
    topBadger.setLeftLowerNeighbor(leftBadger);
    
    if(topBadger.getLeftLowerNeighbor() == leftBadger)
    return true;
    else return false;
  }
  
  /**
   * This method checks functionality of Badger class's right Neighbor functionality
   * 
   * @return true if test passed, false if failed
   */
  public static boolean badgerRightTest() {
    Badger topBadger = new Badger(5);
    
    int rightBadgerSize = 3;
    Badger rightBadger = new Badger(rightBadgerSize);
    
    topBadger.setRightLowerNeighbor(rightBadger);
    
    if(topBadger.getRightLowerNeighbor() == rightBadger)
    return true;
    else return false;
  }
  
  

  /**
   * This method checks functionality of Sett class's functionality
   * 
   * @return true if test passed, false if failed
   */
  public static boolean settTest() {
    boolean testPassed = true;
    
   
    Sett testSett = new Sett();
    
    int topBadgerSize = 5;
    testSett.settleBadger(topBadgerSize);
    
    Badger topBadger = testSett.getTopBadger();
    
    if(topBadger.getSize() != topBadgerSize) {
      testPassed = false;
    }
    
    int leftBadgerSize = topBadgerSize-1;
    testSett.settleBadger(leftBadgerSize);
    
    if(topBadger.getLeftLowerNeighbor().getSize() != leftBadgerSize ) testPassed = false;

    int rightBadgerSize = topBadgerSize+1;
    testSett.settleBadger(rightBadgerSize);
    
    if(topBadger.getRightLowerNeighbor().getSize() != rightBadgerSize ) testPassed = false;
    
    int biggerBadgerSize = topBadgerSize+4;
    testSett.settleBadger(biggerBadgerSize);
    
    if(topBadger.getRightLowerNeighbor().getRightLowerNeighbor().getSize() != biggerBadgerSize ) {
      testPassed = false;
      System.out.println("topBadger.getRightLowerNeighbor().getsize: " + topBadger.getRightLowerNeighbor().getSize());
      System.out.println("topBadger.getRightLowerNeighbor().getRightLowerNeighbor().getsize: " + topBadger.getRightLowerNeighbor().getRightLowerNeighbor().getSize());
      System.out.println("Size didn't match. Expecting: "+biggerBadgerSize + " but got: " +topBadger.getRightLowerNeighbor().getRightLowerNeighbor().getSize() );
    } 
    
    Badger findBadger = testSett.findBadger(biggerBadgerSize);
    
    if(topBadger.getRightLowerNeighbor().getRightLowerNeighbor()!= findBadger ) testPassed = false;
    
    try{
      Badger findNonExistentBadger = testSett.findBadger(99);
    } catch(Exception e) {
      if (!e.getMessage().equalsIgnoreCase(
        "WARNING: failed to find a badger with size " + 99 + " in the sett"))
        return false;
    
    }
    
    
    
    
    return testPassed;
  }

}
