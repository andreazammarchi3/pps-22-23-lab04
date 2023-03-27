package u04lab.ex02

import u04lab.code.{Item, List}

case class ItemImpl(override val code: Int,
                    override val name: String,
                    override val tags: List[String]) extends Item {
}
