package ${packageName}.ui.${moduleName}

import ${packageName}.R
import ${packageName}.base.BaseFragment
import ${packageName}.databinding.Fragment${underscoreToCamelCase(classToResource(fragmentClass))}Binding

/**
 * Created by james on 2018/8/24.
 */
 
class ${fragmentClass} : BaseFragment<${viewModelClass}, Fragment${underscoreToCamelCase(classToResource(fragmentClass))}Binding>() {

    override fun getLayoutId(): Int = R.layout.${layoutName}

    companion object {
        fun newInstance(): ${fragmentClass} {
            return ${fragmentClass}()
        }
    }

    override fun setupViews() {

    }

    override fun observeData() {

    }
}