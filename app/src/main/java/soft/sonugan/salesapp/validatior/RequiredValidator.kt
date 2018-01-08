package soft.sonugan.salesapp.validatior

import android.content.res.Resources
import soft.sonugan.salesapp.R
import soft.sonugan.salesapp.SalesApp

/**
 * Created by gaston on 07/01/2018.
 */
class RequiredValidator() : Validator(){
    override fun validate(value: String?):Validation{
        if(value == null || value.length <= 0){
            return Validation(false, SalesApp.resource.getString(R.string.required_validation))
        }
        return Validation(true, null)
    }
}