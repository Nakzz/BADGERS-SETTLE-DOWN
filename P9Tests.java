import java.lang.reflect.Array;
import java.util.ArrayDeque;

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
// Online Sources: //
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * Test class for Badgers Settle Down
 * 
 * @author: Ajmain Naqib
 * @email: naqib@wisc.edu
 */
public class P9Tests {

  public static void main(String[] args) {

    int test = 2;

    if (runAllBadgerTests())
      test--;
    else
      System.out.println("runAllBadgerTests() failed!");

    if (runAllSettTests())
      test--;
    else
      System.out.println("settTest failed!");

    System.out.println(test + " tests failed!");
    
    Sett testSett = new Sett();
    
    testSett.settleBadger(10);
    testSett.settleBadger(11);
    testSett.settleBadger(12);
    testSett.settleBadger(13);
    testSett.settleBadger(8);
    testSett.settleBadger(7);
//    testSett.settleBadger(15);
//    testSett.settleBadger(14);
//    testSett.settleBadger(17);
    
    int expectedHeight = 4;

    // checking getHeight
     System.out.println(testSett.getHeight());
    if (expectedHeight != testSett.getHeight())
      System.out.println("WRONG!");

  }

  /**
   * This method runs all bagder class tests.
   * 
   * @return true if test passed, false if failed
   */
  public static boolean runAllBadgerTests() {
    if (badgerLeftTest() && badgerRightTest())
      return true;
    else
      return false;

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

    if (topBadger.getLeftLowerNeighbor() == leftBadger)
      return true;
    else
      return false;
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

    if (topBadger.getRightLowerNeighbor() == rightBadger)
      return true;
    else
      return false;
  }



  /**
   * This method checks functionality of Sett class's functionality
   * 
   * @return true if test passed, false if failed
   */
  public static boolean runAllSettTests() {
    boolean testPassed = true;

    // empty sett
    Sett testSett = new Sett();

    // new badger added
    int topBadgerSize = 5;
    testSett.settleBadger(topBadgerSize);

    Badger topBadger = testSett.getTopBadger();

    // confirming the only badger's size
    if (topBadger.getSize() != topBadgerSize) {
      testPassed = false;
    }

    // confirming smaller badger on left
    int leftBadgerSize = topBadgerSize - 1;
    testSett.settleBadger(leftBadgerSize);
    if (topBadger.getLeftLowerNeighbor().getSize() != leftBadgerSize)
      testPassed = false;

    // confrming larger badger on right
    int rightBadgerSize = topBadgerSize + 1;
    testSett.settleBadger(rightBadgerSize);
    if (topBadger.getRightLowerNeighbor().getSize() != rightBadgerSize)
      testPassed = false;

    // confirming proper implementation of BST
    int biggerBadgerSize = topBadgerSize + 4;
    testSett.settleBadger(biggerBadgerSize);

    if (topBadger.getRightLowerNeighbor().getRightLowerNeighbor().getSize() != biggerBadgerSize) {
      testPassed = false;
      System.out.println("topBadger.getRightLowerNeighbor().getsize: "
        + topBadger.getRightLowerNeighbor().getSize());
      System.out.println("topBadger.getRightLowerNeighbor().getRightLowerNeighbor().getsize: "
        + topBadger.getRightLowerNeighbor().getRightLowerNeighbor().getSize());
      System.out.println("Size didn't match. Expecting: " + biggerBadgerSize + " but got: "
        + topBadger.getRightLowerNeighbor().getRightLowerNeighbor().getSize());
    }

    // confirming findBadger functionality
    Badger findBadger = testSett.findBadger(biggerBadgerSize);
    if (topBadger.getRightLowerNeighbor().getRightLowerNeighbor() != findBadger)
      testPassed = false;

    // checking proper exceptiop handling
    try {
      Badger findNonExistentBadger = testSett.findBadger(99);
    } catch (Exception e) {
      if (!e.getMessage()
        .equalsIgnoreCase("WARNING: failed to find a badger with size " + 99 + " in the sett"))
        return false;

    }

    // checking count
    if (testSett.countBadger() != 4)
      testPassed = false;

    // checking getAllBadger
    java.util.List<Badger> listOfBadgers = testSett.getAllBadgers();

    int[] expectedSizes = {4, 5, 6, 9};

    for (int i = 0; i < listOfBadgers.size(); i++) {
      // System.out.println(listOfBadgers.get(i).getSize());
      if (listOfBadgers.get(i).getSize() != expectedSizes[i]) {
        testPassed = false;
      }
    }

    // checking largest badger
    if (testSett.getLargestBadger().getSize() != 9)
      testPassed = false;

    testSett.settleBadger(10);
    int expectedHeight = 4;

    // checking getHeight
     System.out.println(testSett.getHeight());
    if (expectedHeight != testSett.getHeight())
      testPassed = false;


    return testPassed;
  }

}
