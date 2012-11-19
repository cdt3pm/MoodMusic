/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.8
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.cs4720.moodmusic;

public final class sp_playlist_type {
  public final static sp_playlist_type SP_PLAYLIST_TYPE_PLAYLIST = new sp_playlist_type("SP_PLAYLIST_TYPE_PLAYLIST", spotifyJNI.SP_PLAYLIST_TYPE_PLAYLIST_get());
  public final static sp_playlist_type SP_PLAYLIST_TYPE_START_FOLDER = new sp_playlist_type("SP_PLAYLIST_TYPE_START_FOLDER", spotifyJNI.SP_PLAYLIST_TYPE_START_FOLDER_get());
  public final static sp_playlist_type SP_PLAYLIST_TYPE_END_FOLDER = new sp_playlist_type("SP_PLAYLIST_TYPE_END_FOLDER", spotifyJNI.SP_PLAYLIST_TYPE_END_FOLDER_get());
  public final static sp_playlist_type SP_PLAYLIST_TYPE_PLACEHOLDER = new sp_playlist_type("SP_PLAYLIST_TYPE_PLACEHOLDER", spotifyJNI.SP_PLAYLIST_TYPE_PLACEHOLDER_get());

  public final int swigValue() {
    return swigValue;
  }

  public String toString() {
    return swigName;
  }

  public static sp_playlist_type swigToEnum(int swigValue) {
    if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
      return swigValues[swigValue];
    for (int i = 0; i < swigValues.length; i++)
      if (swigValues[i].swigValue == swigValue)
        return swigValues[i];
    throw new IllegalArgumentException("No enum " + sp_playlist_type.class + " with value " + swigValue);
  }

  private sp_playlist_type(String swigName) {
    this.swigName = swigName;
    this.swigValue = swigNext++;
  }

  private sp_playlist_type(String swigName, int swigValue) {
    this.swigName = swigName;
    this.swigValue = swigValue;
    swigNext = swigValue+1;
  }

  private sp_playlist_type(String swigName, sp_playlist_type swigEnum) {
    this.swigName = swigName;
    this.swigValue = swigEnum.swigValue;
    swigNext = this.swigValue+1;
  }

  private static sp_playlist_type[] swigValues = { SP_PLAYLIST_TYPE_PLAYLIST, SP_PLAYLIST_TYPE_START_FOLDER, SP_PLAYLIST_TYPE_END_FOLDER, SP_PLAYLIST_TYPE_PLACEHOLDER };
  private static int swigNext = 0;
  private final int swigValue;
  private final String swigName;
}
