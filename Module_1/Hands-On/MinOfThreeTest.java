import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MinOfThreeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

  /////////////METHOD 1/////////////

   /** A test that tests method 1. **/
   @Test public void min1Test1() {
      int expected = 1;
      int actual = MinOfThree.min1(1,2,3);
      assertEquals(expected, actual);
   }
  
        /** A test that tests method 1. **/
   @Test public void min1Test2() {
      int expected = 1;
      int actual = MinOfThree.min1(2,1,3);
      assertEquals(expected, actual);
   }
   
         /** A test that tests method 1. **/
   @Test public void min1Test3() {
      int expected = 1;
      int actual = MinOfThree.min1(3,2,1);
      assertEquals(expected, actual);
   }
   
   /** A test that tests method 1. **/
   @Test public void min1Test4() {
      int expected = 1;
      int actual = MinOfThree.min1(2,3,1);
      assertEquals(expected, actual);
   }
   
   /** Two lows **/
   
               /** A test that tests method 1. **/
   @Test public void min1Test5() {
      int expected = 1;
      int actual = MinOfThree.min1(1,1,3);
      assertEquals(expected, actual);
   }
      
                        /** A test that tests method 1. **/
   @Test public void min1Test6() {
      int expected = 1;
      int actual = MinOfThree.min1(3,1,1);
      assertEquals(expected, actual);
   }
   
   
   /////////////METHOD 2/////////////
   
         /** A test that tests method 2. **/
   @Test public void min2Test1() {
      int expected = 1;
      int actual = MinOfThree.min2(1,2,3);
      assertEquals(expected, actual);
   }
  
        /** A test that tests method 2. **/
   @Test public void min2Test2() {
      int expected = 1;
      int actual = MinOfThree.min2(2,1,3);
      assertEquals(expected, actual);
   }
   
         /** A test that tests method 2. **/
   @Test public void min2Test3() {
      int expected = 1;
      int actual = MinOfThree.min2(3,2,1);
      assertEquals(expected, actual);
   }
   
   /** Two lows. **/
   
                     /** A test that tests method 1. **/
   @Test public void min2Test4() {
      int expected = 1;
      int actual = MinOfThree.min2(1,1,3);
      assertEquals(expected, actual);
   }
      
                        /** A test that tests method 1. **/
   @Test public void min2Test5() {
      int expected = 1;
      int actual = MinOfThree.min2(3,1,1);
      assertEquals(expected, actual);
   }
}
