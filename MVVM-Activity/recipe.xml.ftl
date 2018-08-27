<?xml version="1.0"?>
<recipe>
    <#include "../common/recipe_manifest.xml.ftl" />

    <#include "activity_layout_recipe.xml.ftl" />
    

    <instantiate from="src/app_package/SimpleActivity.kt.ftl"
      to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${activityClass}.kt" />

    <instantiate from="src/app_package/SimpleViewModel.kt.ftl"
      to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${viewModelClass}.kt" />


    <instantiate from="src/app_package/SimpleRepository.kt.ftl"
      to="${escapeXmlAttribute(srcOut)}/repository/${slashedPackageName(moduleName)}/${repositoryClass}.kt" />

</recipe>
