package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));

  }

    @Test
    public void testNonPrime(){
      Assert.assertFalse(Primes.isPrimeFast(Integer.MAX_VALUE-2));
  }


  @Test (enabled = false)
  public void testPrimeWhile() {
    long number = (long)Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimeWhile(number));

  }

  @Test (enabled = false)
  public void testNonPrimeWhile(){
    long number = (long)Integer.MAX_VALUE;
    Assert.assertFalse(Primes.isPrimeWhile((number-2)));
  }


}
