package com.iadvize.vdm.scrapper

/**
  * Generates a unique ID for the [[VDMPost]] case class
  */
object VDMPostIdGenerator {

  private var currentId: Int = 0;

  def nextId: Int = {
    currentId += 1
    currentId
  }
}
