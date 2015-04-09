/************** DOMAIN MODEL */
case class Order(product: Product)

/** represents menu item */
case class Product( name: String,
                    /** defines a list of products derived from this product */
                    products: List[Product] = None,
                    /** defines available toppings for this product */
                    toppings: List[Topping] = None,
                    attributeTypes: List[AttributeType] = None)

case class Topping(name: String)

/** modifier for product */
case class AttributeType(name: String, attributes: List[Attribute])
case class Attribute(name: String)

/************** TEST CASES */

/* ATTRIBUTES */
val size = AttributeType("size", List(Attribute("9"), Attribute("12")))
val cokeVolume = AttributeType("volume", List(Attribute("333ml"), Attribute("500ml")))
val beerVolume = AttributeType("volume", List(Attribute("HalfPint"), Attribute("Pint")))

/** TOPPINGS */
val beefTopping: Topping = Topping("beef")

val pizza = Product("Pizza",
                    products = List(
                      Product("Margherita",
                              toppings = List(beefTopping),
                              attributeTypes = List(size)),
                      Product("Bugagatto", attributeTypes = List(size))
                    )
)

val coke = Product("Coke", attributeTypes = List(size, cokeVolume))
