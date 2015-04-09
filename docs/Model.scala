/** DOMAIN MODEL */
case class Order(product: Product)

/** represents menu item */
case class Product(name: String,
                   baseProduct: Option[Product] = None)

/** modifier for product */
case class Attribute()


/** TEST CASES */

val pizza = Product("Pizza")
