package soft.sonugan.salesapp.model
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*
/**
 * Created by gaston on 04/01/2018.
 */
@Entity
data class Provider(var code : String = "",
                    var name : String = ""){
    @Id var id : Long = 0
    var description : String = ""
    var dateCreated : Date? = null
    var lastEditedDate : Date? = null
}