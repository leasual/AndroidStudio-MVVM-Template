package ${packageName}.ui.${moduleName}

import ${packageName}.R
import ${packageName}.base.BaseActivity
import ${packageName}.databinding.Activity${underscoreToCamelCase(classToResource(activityClass))}Binding

class ${activityClass} : BaseActivity<${viewModelClass}, Activity${underscoreToCamelCase(classToResource(activityClass))}Binding>() {

    override fun getLayoutId(): Int = R.layout.${layoutName}

    override fun setupViews() {
       
    }

    override fun observeData() {

    }

}
