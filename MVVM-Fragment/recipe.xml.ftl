<?xml version="1.0"?>
<recipe>

    <#include "fragment_layout_recipe.xml.ftl" />
    

    <instantiate from="src/app_package/SimpleFragment.kt.ftl"
      to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${fragmentClass}.kt" />

    <instantiate from="src/app_package/SimpleViewModel.kt.ftl"
      to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${viewModelClass}.kt" />


    <instantiate from="src/app_package/SimpleRepository.kt.ftl"
      to="${escapeXmlAttribute(srcOut)}/repository/${slashedPackageName(moduleName)}/${repositoryClass}.kt" />

</recipe>
