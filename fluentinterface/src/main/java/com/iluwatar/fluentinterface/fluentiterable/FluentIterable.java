package com.iluwatar.fluentinterface.fluentiterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * The FluentIterable is a more convenient implementation of the common iterable interface based on
 * the fluent interface design pattern. This interface defines common operations, but doesn't aim to
 * be complete. It was inspired by Guava's com.google.common.collect.FluentIterable.
 * 
 * @param <TYPE> is the class of objects the iterable contains
 */
public interface FluentIterable<TYPE> extends Iterable<TYPE> {

  /**
   * Filters the contents of Iterable using the given predicate, leaving only the ones which satisfy
   * the predicate.
   * 
   * @param predicate the condition to test with for the filtering. If the test is negative, the
   *        tested object is removed by the iterator.
   * @return a filtered FluentIterable
   */
  FluentIterable<TYPE> filter(Predicate<? super TYPE> predicate);

  /**
   * Returns an Optional containing the first element of this iterable if present, else returns
   * Optional.empty().
   * 
   * @return the first element after the iteration is evaluated
   */
  Optional<TYPE> first();

  /**
   * Evaluates the iteration and leaves only the count first elements.
   * 
   * @return the first count elements as an Iterable
   */
  FluentIterable<TYPE> first(int count);

  /**
   * Evaluates the iteration and returns the last element. This is a terminating operation.
   * 
   * @return the last element after the iteration is evaluated
   */
  Optional<TYPE> last();

  /**
   * Evaluates the iteration and leaves only the count last elements.
   * 
   * @return the last counts elements as an Iterable
   */
  FluentIterable<TYPE> last(int count);

  /**
   * Transforms this FluentIterable into a new one containing objects of the type NEW_TYPE.
   * 
   * @param function a function that transforms an instance of TYPE into an instance of NEW_TYPE
   * @param <NEW_TYPE> the target type of the transformation
   * @return a new FluentIterable of the new type
   */
  <NEW_TYPE> FluentIterable<NEW_TYPE> map(Function<? super TYPE, NEW_TYPE> function);

  /**
   * Returns the contents of this Iterable as a List.
   * 
   * @return a List representation of this Iterable
   */
  List<TYPE> asList();

  /**
   * Utility method that iterates over iterable and adds the contents to a list.
   * 
   * @param iterable the iterable to collect
   * @param <TYPE> the type of the objects to iterate
   * @return a list with all objects of the given iterator
   */
  static <TYPE> List<TYPE> copyToList(Iterable<TYPE> iterable) {
    ArrayList<TYPE> copy = new ArrayList<>();
    Iterator<TYPE> iterator = iterable.iterator();
    while (iterator.hasNext()) {
      copy.add(iterator.next());
    }
    return copy;
  }
}
