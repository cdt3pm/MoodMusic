/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.cs4720.moodmusic;

public final class sp_connection_type {
  public final static sp_connection_type SP_CONNECTION_TYPE_UNKNOWN = new sp_connection_type("SP_CONNECTION_TYPE_UNKNOWN", spotifyJNI.SP_CONNECTION_TYPE_UNKNOWN_get());
  public final static sp_connection_type SP_CONNECTION_TYPE_NONE = new sp_connection_type("SP_CONNECTION_TYPE_NONE", spotifyJNI.SP_CONNECTION_TYPE_NONE_get());
  public final static sp_connection_type SP_CONNECTION_TYPE_MOBILE = new sp_connection_type("SP_CONNECTION_TYPE_MOBILE", spotifyJNI.SP_CONNECTION_TYPE_MOBILE_get());
  public final static sp_connection_type SP_CONNECTION_TYPE_MOBILE_ROAMING = new sp_connection_type("SP_CONNECTION_TYPE_MOBILE_ROAMING", spotifyJNI.SP_CONNECTION_TYPE_MOBILE_ROAMING_get());
  public final static sp_connection_type SP_CONNECTION_TYPE_WIFI = new sp_connection_type("SP_CONNECTION_TYPE_WIFI", spotifyJNI.SP_CONNECTION_TYPE_WIFI_get());
  public final static sp_connection_type SP_CONNECTION_TYPE_WIRED = new sp_connection_type("SP_CONNECTION_TYPE_WIRED", spotifyJNI.SP_CONNECTION_TYPE_WIRED_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static sp_connection_type swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + sp_connection_type.class + " with value " + swigValue);
  }

  private sp_connection_type(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private sp_connection_type(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private sp_connection_type(String swigName, sp_connection_type swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static sp_connection_type[] swigValues = { SP_CONNECTION_TYPE_UNKNOWN, SP_CONNECTION_TYPE_NONE, SP_CONNECTION_TYPE_MOBILE, SP_CONNECTION_TYPE_MOBILE_ROAMING, SP_CONNECTION_TYPE_WIFI, SP_CONNECTION_TYPE_WIRED };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}

