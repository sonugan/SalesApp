package soft.sonugan.salesapp.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * Created by gaston on 02/01/2018.
 */
@Entity
class Product {
    @Id
    var id : Long = 0
    var code : String = ""
    var name : String = ""
}