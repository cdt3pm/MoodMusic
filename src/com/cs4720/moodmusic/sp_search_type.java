/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.cs4720.moodmusic;

public final class sp_search_type {
  public final static sp_search_type SP_SEARCH_STANDARD = new sp_search_type("SP_SEARCH_STANDARD", spotifyJNI.SP_SEARCH_STANDARD_get());
  public final static sp_search_type SP_SEARCH_SUGGEST = new sp_search_type("SP_SEARCH_SUGGEST", spotifyJNI.SP_SEARCH_SUGGEST_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static sp_search_type swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + sp_search_type.class + " with value " + swigValue);
  }

  private sp_search_type(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private sp_search_type(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private sp_search_type(String swigName, sp_search_type swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static sp_search_type[] swigValues = { SP_SEARCH_STANDARD, SP_SEARCH_SUGGEST };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

