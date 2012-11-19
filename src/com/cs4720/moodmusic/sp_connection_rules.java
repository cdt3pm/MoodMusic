/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.cs4720.moodmusic;

public final class sp_connection_rules {
  public final static sp_connection_rules SP_CONNECTION_RULE_NETWORK = new sp_connection_rules("SP_CONNECTION_RULE_NETWORK", spotifyJNI.SP_CONNECTION_RULE_NETWORK_get());
  public final static sp_connection_rules SP_CONNECTION_RULE_NETWORK_IF_ROAMING = new sp_connection_rules("SP_CONNECTION_RULE_NETWORK_IF_ROAMING", spotifyJNI.SP_CONNECTION_RULE_NETWORK_IF_ROAMING_get());
  public final static sp_connection_rules SP_CONNECTION_RULE_ALLOW_SYNC_OVER_MOBILE = new sp_connection_rules("SP_CONNECTION_RULE_ALLOW_SYNC_OVER_MOBILE", spotifyJNI.SP_CONNECTION_RULE_ALLOW_SYNC_OVER_MOBILE_get());
  public final static sp_connection_rules SP_CONNECTION_RULE_ALLOW_SYNC_OVER_WIFI = new sp_connection_rules("SP_CONNECTION_RULE_ALLOW_SYNC_OVER_WIFI", spotifyJNI.SP_CONNECTION_RULE_ALLOW_SYNC_OVER_WIFI_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static sp_connection_rules swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + sp_connection_rules.class + " with value " + swigValue);
  }

  private sp_connection_rules(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private sp_connection_rules(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private sp_connection_rules(String swigName, sp_connection_rules swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static sp_connection_rules[] swigValues = { SP_CONNECTION_RULE_NETWORK, SP_CONNECTION_RULE_NETWORK_IF_ROAMING, SP_CONNECTION_RULE_ALLOW_SYNC_OVER_MOBILE, SP_CONNECTION_RULE_ALLOW_SYNC_OVER_WIFI };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
