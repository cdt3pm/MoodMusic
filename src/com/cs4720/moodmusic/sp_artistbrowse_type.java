/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.cs4720.moodmusic;

public final class sp_artistbrowse_type {
  public final static sp_artistbrowse_type SP_ARTISTBROWSE_FULL = new sp_artistbrowse_type("SP_ARTISTBROWSE_FULL");
  public final static sp_artistbrowse_type SP_ARTISTBROWSE_NO_TRACKS = new sp_artistbrowse_type("SP_ARTISTBROWSE_NO_TRACKS");
  public final static sp_artistbrowse_type SP_ARTISTBROWSE_NO_ALBUMS = new sp_artistbrowse_type("SP_ARTISTBROWSE_NO_ALBUMS");

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static sp_artistbrowse_type swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + sp_artistbrowse_type.class + " with value " + swigValue);
  }

  private sp_artistbrowse_type(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private sp_artistbrowse_type(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private sp_artistbrowse_type(String swigName, sp_artistbrowse_type swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static sp_artistbrowse_type[] swigValues = { SP_ARTISTBROWSE_FULL, SP_ARTISTBROWSE_NO_TRACKS, SP_ARTISTBROWSE_NO_ALBUMS };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
