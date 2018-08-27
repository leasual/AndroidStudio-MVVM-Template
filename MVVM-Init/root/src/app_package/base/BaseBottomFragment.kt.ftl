package ${packageName}.base

import android.app.Dialog
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import android.view.*
import ${packageName}.R

/**
 * Created by james.li on 2018/8/21.
 */
abstract class BaseBottomFragment<T : ViewDataBinding> : DialogFragment() {
    lateinit var mBinding: T

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(activity!!, R.style.CustomBottomDialogFragment)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(getLayoutId())
        dialog.setCanceledOnTouchOutside(true)

        val window = dialog.window
        val wlp = window!!.attributes
        wlp.gravity = Gravity.BOTTOM
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT
        window.attributes = wlp

        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        setupViews()
        return mBinding.root
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun setupViews()
}