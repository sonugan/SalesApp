package soft.sonugan.salesapp

import android.widget.EditText
import kotlinx.android.synthetic.main.activity_product_edit.*
import soft.sonugan.salesapp.validatior.Validator

/**
 * Created by gaston on 07/01/2018.
 */
class EditTextValidator(val editText: EditText, val validator: Validator){
    fun validate(){
        val validation = validator.validate(editText.text.toString())
        if(!validation.isValid){
            editText.setError(validation.message)
        }else{
            editText.setError(null)
        }
    }
}