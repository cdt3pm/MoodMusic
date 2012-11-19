LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE    := libspotify
LOCAL_SRC_FILES := libspotify.so

include $(PREBUILT_SHARED_LIBRARY)