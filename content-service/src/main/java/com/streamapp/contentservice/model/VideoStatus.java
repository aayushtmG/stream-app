package com.streamapp.contentservice.model;

/**
* tracks the video processing Lifecycle
 *
 * FLOW:
 * PENDING -> UPLOADED -> ENCODING -> READY
 *                         FAILED
**/
 public enum VideoStatus {
    PENDING, //movie added but not yet uploaded
    UPLOADED, // raw video uploaded to s3
    ENCODING, //FFmpeg is encoding the video
    ENCODED, // Encoding complete
    READY, // HLS playlist ready
    FAILED,
}
