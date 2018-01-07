package soft.sonugan.salesapp.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne
import java.util.*

/**
 * Created by gaston on 02/01/2018.
 */
/*@Entity
class Order {
    @Id var id: Long = 0
}*/
@Entity
class Product(var code: String = "",
              var name: String = "") {
    @Id var id: Long = 0
    var description: String? = null
    var dateCreated: Date? = null
    var lastEditedDate: Date? = null
    var quotation: Float? = null
    var priceInCurrency: Float? = null
    var costRmb: Float? = null
    var costInner: Float? = null
    var costCbm: Float? = null
    var unitsPerPackage: Int? = null
    var grossWeight: Float? = null
    var netWeight: Float? = null
    var pending: Float? = null
    var barCode: String? = null
    var observations: String? = null
    //lateinit var provider: ToOne<Provider>
}