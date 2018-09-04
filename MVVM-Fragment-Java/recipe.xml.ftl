<?xml version="1.0"?>
<recipe>

    <#include "fragment_layout_recipe.xml.ftl" />
    

    <instantiate from="src/app_package/SimpleFragment.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${fragmentClass}.java" />

    <instantiate from="src/app_package/SimpleViewModel.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/ui/${slashedPackageName(moduleName)}/${viewModelClass}.java" />


    <instantiate from="src/app_package/SimpleRepository.java.ftl"
      to="${escapeXmlAttribute(srcOut)}/repository/${slashedPackageName(moduleName)}/${repositoryClass}.java" />

</recipe>
