package soft.sonugan.salesapp.validatior

/**
 * Created by gaston on 07/01/2018.
 */
abstract class Validator {

    abstract fun validate(value : String?):Validation
}