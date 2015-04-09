/************** DOMAIN MODEL */
case class Order(product: Product)

case class ProductType(name: String)

/** represents menu item */
case class Product(name: String,
                   productType: ProductType,
                   price: Double = None,
                   /** defines available toppings for this product */
                   toppings: List[Topping] = None,
                   attributes: List[ProductAttribute] = None)

case class Ingredient(name: String)
case class Topping(name: String)

/** modifier for product */
case class AttributeGroup(name: String)
case class Attribute(name: String, group: AttributeGroup)
case class ProductAttribute(attribute: Attribute, price: Double)

/************** TEST CASES */

/* ATTRIBUTES */
val size = AttributeGroup("size")
val nineInchSize = Attribute("9 inch", size)
val twelveInchSize = Attribute("12 inch", size)

val volume = AttributeGroup("volume")
val _250MlVolume: Attribute = Attribute("250ml", volume)
val _333MlVolume: Attribute = Attribute("333ml", volume)
val _500MlVolume: Attribute = Attribute("500ml", volume)
val _1000MlVolume: Attribute = Attribute("1000ml", volume)

/* TOPPINGS && INGREDIENTS */
val beef = Ingredient("beef")
val pork = Ingredient("pork")
val cucumber = Ingredient("cucumber")

/* PRODUCT TYPES */
val pizzaProductType = ProductType("pizza")

val Product("Pizza Margherita",
  price = 10,
  toppings = List(
    Ingredient("beef", 2)
  ),
  attributes = List(
    ProductAttribute(nineInchSize, 11),
    ProductAttribute(twelveInchSize, 14)
  )
)

val coke = Product("Coke", attributes = List(ProductAttribute(_333MlVolume, 5), ProductAttribute(_500MlVolume, 7)))

