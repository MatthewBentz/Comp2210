import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * LinearSearch2Test.java
 * Illustrates JUnit tests for the LinearSearch2 class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-08-18
 *
 */
public class LinearSearch2Test {


   ///////////////////
   // Typical cases //
   ///////////////////

   /** Test with a.length > 2, target found at front */
   @Test
   public void testSearchTypical1() {
      int[] a = {2, 4, 6, 8, 10};
      int target = 2;
      int expected = 0;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length > 2, target found at rear */
   @Test
   public void testSearchTypical2() {
      int[] a = {2, 4, 6, 8, 10};
      int target = 10;
      int expected = 4;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length > 2, target found in middle */
   @Test
   public void testTypical3() {
      int[] a = {2, 4, 6, 8, 10};
      int target = 6;
      int expected = 2;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }


   ////////////////////
   // Boundary cases //
   ////////////////////

   /** Test with a.length = 1, target found */
   @Test
   public void testSearchBoundary1() {
      int[] a = {2};
      int target = 2;
      int expected = 0;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length = 1, target not found */
   @Test
   public void testSearchBoundary2() {
      int[] a = {2};
      int target = 1;
      int expected = -1;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length = 2, target found at front */
   @Test
   public void testSearchBoundary3() {
      int[] a = {2, 4};
      int target = 2;
      int expected = 0;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length = 2, target found at rear */
   @Test
   public void testSearchBoundary4() {
      int[] a = {2, 4};
      int target = 4;
      int expected = 1;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }


   ///////////////////
   // Special cases //
   ///////////////////

   /** Test with a.length = 2, duplicates, target found */
   @Test
   public void testSearchSpecial1() {
      int[] a = {2, 2};
      int target = 2;
      int expected = 0;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length = 2, duplicates, target not found */
   @Test
   public void testSearchSpecial2() {
      int[] a = {2, 2};
      int target = 4;
      int expected = -1;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length > 2, all duplicates, target found */
   @Test
   public void testTypicalSpecial3() {
      int[] a = {2, 2, 2, 2, 2, 2};
      int target = 2;
      int expected = 0;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length > 2, all duplicates, target not found */
   @Test
   public void testTypicalSpecial4() {
      int[] a = {2, 2, 2, 2, 2, 2};
      int target = 4;
      int expected = -1;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length > 2, some duplicates, target found */
   @Test
   public void testTypicalSpecial5() {
      int[] a = {4, 4, 2, 4, 6, 8, 4, 10, 4};
      int target = 4;
      int expected = 0;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }

   /** Test with a.length > 2, some duplicates, target not found */
   @Test
   public void testTypicalSpecial6() {
      int[] a = {4, 4, 2, 4, 6, 8, 4, 10, 4};
      int target = 5;
      int expected = -1;
      int actual = LinearSearch2.search(a, target);
      assertEquals(expected, actual);
   }


}

