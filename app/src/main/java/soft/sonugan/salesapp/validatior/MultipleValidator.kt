package soft.sonugan.salesapp.validatior

/**
 * Created by gaston on 07/01/2018.
 */
open class MultipleValidator(var validators: List<Validator>) {
/*
    open fun validate(value : String?):List<Validation>{
        return validators
                .map { v -> v.validate(value)}
                .reduce{ total, value ->
                    total + value
                }
    }*/
}