package u04lab.ex02

import u04lab.code.*
case class WarehouseImpl() extends Warehouse {
  private var items: List[Item] = List.empty

  /**
   * Stores an item in the warehouse.
   *
   * @param item the item to store
   */
  override def store(item: Item): Unit =
    items = List.cons(item, items)

  /**
   * Searches for items with the given tag.
   *
   * @param tag the tag to search for
   * @return the list of items with the given tag
   */
  override def searchItems(tag: String): List[Item] =
    List.filter(items)(item => List.contains(item.tags, tag))

  /**
   * Retrieves an item from the warehouse.
   *
   * @param code the code of the item to retrieve
   * @return the item with the given code, if present
   */
  override def retrieve(code: Int): Option[Item] =
    List.find(items)(_.code == code)

  /**
   * Removes an item from the warehouse.
   *
   * @param item the item to remove
   */
  override def remove(item: Item): Unit =
    items = List.filter(items)(_ != item)

  /**
   * Checks if the warehouse contains an item with the given code.
   *
   * @param itemCode the code of the item to check
   * @return true if the warehouse contains an item with the given code, false otherwise
   */
  override def contains(itemCode: Int): Boolean =
    !Option.isEmpty(List.find(items)(_.code == itemCode))
}
