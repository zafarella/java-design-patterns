package com.iluwatar.singleton;

import java.io.Serializable;

/**
 * The Initialize-on-demand-holder idiom is a secure way of creating lazy initialized singleton
 * object in Java. refer to "The CERT Oracle Secure Coding Standard for Java" By Dhruv Mohindra,
 * Robert C. Seacord p.378
 * <p/>
 * Singleton objects usually are heavy to create and sometimes need to serialize them. This class
 * also shows how to preserve singleton in serialized version of singleton.
 *
 * @author mortezaadi@gmail.com
 */
public class InitializingOnDemandHolderIdiom implements Serializable {

  private static final long serialVersionUID = 1L;

  private InitializingOnDemandHolderIdiom() {}

  public static InitializingOnDemandHolderIdiom getInstance() {
    return HelperHolder.INSTANCE;
  }

  protected Object readResolve() {
    return getInstance();
  }

  private static class HelperHolder {
    public static final InitializingOnDemandHolderIdiom INSTANCE =
        new InitializingOnDemandHolderIdiom();
  }

}
