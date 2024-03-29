package domain

import adapter.UIAdapter

abstract class Questionable(val answer: String) {

  def question: String
  def yes(adapter: UIAdapter): Questionable
  def no(adapter: UIAdapter): Questionable

  def makeQuestion(adapter: UIAdapter) =
    if (adapter.makeQuestion(this)) yes(adapter) else no(adapter)

  override def toString() = getClass().getSimpleName() + " : " + answer

  override def equals(obj: scala.Any): Boolean =
    obj.getClass == getClass && obj.asInstanceOf[Questionable].answer == answer

}
